package project.manager;

import static project.utils.Print.*;
import project.entity.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author  mail@lixingyong.com
 * @Date 2018/12/26 14:48
 * @Version 1.0
 */
public class StudentInfoManager implements Serializable {
    private List<Student> students;

    private StudentInfoManager(){
        students = new ArrayList<>();
    }

    public Student getStudent(int id) {
        return students.get(id);
    }

    public int size() {
        return students.size();
    }

    private static class StudentControllerInstance {
        private static final StudentInfoManager INFO_MANAGER = new StudentInfoManager();
    }

    public static StudentInfoManager getStudentManager(){
        return StudentControllerInstance.INFO_MANAGER;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean addStudent(Student student){
        for(Student s : students){
            if(s.getId() == student.getId()){
                println("该学生已经存在！");
                return false;
            }
        }
        students.add(student);
        return true;
    }

    public boolean updateStudent(Student student){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId() == student.getId()){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean delStudent(Student student){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId() == student.getId()){
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean isStudent(){
        if(students.size() > 0){
            return true;
        }
        return false;
    }

    public int containsStudent(long studentId){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId() == studentId){
                return i;
            }
        }
        return -1;
    }
}
