package project.controller;

import static project.utils.Print.*;

import project.entity.Employee;
import project.entity.Student;
import project.service.EmployeeService;
import project.service.StudentService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName InfoController
 * @Description TODO
 * @Author lixingyong
 * @Date 2018/12/26 11:44
 * @Version 1.0
 */
public class InfoController {
    StudentService studentService;
    EmployeeService employeeService;
    Scanner sb;
    public InfoController(){
        studentService = new StudentService();
        employeeService = new EmployeeService();
        sb = new Scanner(System.in);
    }

    public void addStudentInfo() {
        do{
            println("**** 新增学生信息 ****");
            print("请输入学生学号(数字)：");
            try {
                Student student = new Student();
                student.setId(sb.nextLong());
                sb.nextLine();
                print("请输入学生姓名（字符串）：");
                student.setName(sb.nextLine());
                print("请输入学生年龄（数字）：");
                student.setAge(sb.nextInt());
                sb.nextLine();
                print("请输入学生专业班级（字符串）：");
                student.setProfessionalClass(sb.nextLine());
                if(studentService.create(student)){
                    println("新增学生成功");
                }else{
                    println("新增学生失败");
                }
            }catch (Exception e){
                sb.nextLine();
                println("输入有误，重新输入！");
            }

            print("输入0退出，输入1继续新增: ");
            if(sb.hasNextInt()){
                if(sb.nextInt() == 0){
                    sb.nextLine();
                    return;
                }
            }
            sb.nextLine();
        }while (true);
    }

    public void showStudentInfo() {
        List<Student> students = studentService.getStudentList();
        if(null != students){
            for(Student s : students){
                println("学生信息：");
                println(s.toString());
                println("--------------------");
            }
        }
    }

    public void updateStudentInfo() {
        Long studentId = 0l;
        Student student = null;
        println("**** 检测管理员账号中 ****");
        if(!employeeService.isLogin()){
            print("管理员账号不存在，是否使用新增默认账号？(Y/OR):");
            if(sb.hasNext("Y")){
                sb.nextLine();
                if(employeeService.create()){
                    println("默认管理员账号创建成功!");
                }else{
                    println("默认管理员账号创建失败，请稍候再试!");
                    return;
                }
            }else{
                sb.nextLine();
                Employee employee = new Employee();
                do{
                    println("*** 新建管理员信息 ***");
                    print("请输入管理员工号(数字)：");
                    try {
                        employee.setEmployeeId(sb.nextLong());
                        sb.nextLine();
                        print("请输入管理员姓名（字符串）：");
                        employee.setEmployeeName(sb.nextLine());
                        print("请输入管理员职务（字符串）：");
                        employee.setPost(sb.nextLine());
                    }catch (Exception e){
                        println("输入有误，重新输入！");
                        sb.nextLine();
                        continue;
                    }
                    if(employeeService.create(employee)){
                        println("新增管理员账号成功");
                        break;
                    }else{
                        println("新增管理员账号失败");
                    }
                    print("输入0返回主菜单，输入其他整数重新新增");
                    if(sb.nextInt() == 0){
                        return;
                    }
                }while(true);
            }

        }
        println("**** 管理员账号已登录 ****");
        Employee employee = employeeService.getEmployee();
        do{
            print("请输入学生学号进行修改(输入0返回主菜单）：");
            if(sb.hasNextLong()){
                studentId = sb.nextLong();
                sb.nextLine();
                if(studentId == 0){
                    return;
                }
                int id = studentService.isStudent(studentId);
                if(id >= 0){
                    student = studentService.getStudent(id);
                    println("查询到学生信息为：");
                    println(student.toString());
                    print("输入Y，确定对学生信息进行修改：");
                    if(sb.hasNext("Y")){
                        sb.nextLine();
                        if(student.getState() != 0){
                            println("该名学生成绩已修改过，无法进行修改！");
                            continue;
                        }
                        print("请输入数据库成绩：");
                        if(sb.hasNextInt()){
                            student.setSQLGrade(sb.nextInt());
                            sb.nextLine();
                        }else {
                            println("输入有误！");
                            sb.nextLine();
                            continue;
                        }
                        print("请输入Java成绩：");
                        if(sb.hasNextInt()){
                            student.setJavaGrade(sb.nextInt());
                            sb.nextLine();
                        }else {
                            println("输入有误！");
                            sb.nextLine();
                            continue;
                        }
                        student.setState(1);
                        employee.setUpdateTime(new Date().toString());
                        studentService.update(student);
                        employeeService.update(employee);
                        println("修改后的学生信息为：");
                        println(student.toString());
                        println("-----------------");
                        println("修改人信息为:");
                        println(employee.toString());
                        println("修改完成，返回主菜单！");
                        return;
                    }else {
                        sb.nextLine();
                        continue;
                    }

                }
                println("未查找到当前学号的学生");
                continue;
            }
            sb.nextLine();
            println("格式不正确!");
        }while (true);

    }

    public void exportStudentInfo() {
        println("**** 检测信息是否存在 ****");
        if(!studentService.isStudents()){
            println("暂无数据，请新增数据后再导出！");
            return;
        }
        print("存在"+studentService.getStudentListNum()+"份学生数据。是否导出（Y/N)：");
        List<Student> students = studentService.getStudentList();
        if(!sb.hasNext("Y")){
            sb.nextLine();
            println("用户放弃操作，返回主菜单");
        }
        sb.nextLine();
        print("请输入导入文件名，如(zhangsan.txt):");
        String fileName = sb.nextLine();
        PrintStream out = System.out;
        try {
            FileOutputStream bos = new FileOutputStream(fileName);
            System.setOut(new PrintStream(bos));
            for(Student s : students){
                println(s.toString());
            }
            System.setOut(out);
        } catch (FileNotFoundException e) {
            System.setOut(out);
            println("导出错误！返回主菜单！");
            return;
        }
        println("导出成功！返回主菜单");
        return;
    }
}
