package project.service;

import project.entity.Student;
import project.manager.StudentInfoManager;

import java.util.List;

/**
 * @ClassName StudentService
 * @Description TODO
 * @Author lixingyong
 * @Date 2018/12/26 13:34
 * @Version 1.0
 */
public class StudentService {
    StudentInfoManager studentInfoManager;

    public StudentService(){
        studentInfoManager = StudentInfoManager.getStudentManager();
    }

    public boolean create(Student student) {
        if(studentInfoManager.addStudent(student)){
            return true;
        }
        return false;
    }

    public List<Student> getStudentList() {
        if(studentInfoManager.isStudent()){
            return studentInfoManager.getStudents();
        }
        return null;
    }

    public int isStudent(Long studentId) {
        return studentInfoManager.containsStudent(studentId);
    }

    public Student getStudent(int id) {
        return studentInfoManager.getStudent(id);
    }

    public void update(Student student) {
        studentInfoManager.updateStudent(student);
    }

    public boolean isStudents() {
        return studentInfoManager.isStudent();
    }

    public int getStudentListNum() {
        return studentInfoManager.size();
    }
}
