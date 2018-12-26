package project.entity;

import java.io.Serializable;

/**
 * @ClassName Student
 * @Description TODO
 * @Author lixingyong
 * @Date 2018/12/26 10:35
 * @Version 1.0
 */
public class Student extends BasicPeople implements Serializable {
    private long id;

    private String name;

    private int age;

    private String professionalClass;

    private int SQLGrade;

    private int JavaGrade;

    {
        this.SQLGrade = 0;
        this.JavaGrade = 0;
        super.setState(0);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfessionalClass() {
        return professionalClass;
    }

    public void setProfessionalClass(String professionalClass) {
        this.professionalClass = professionalClass;
    }

    public int getSQLGrade() {
        return SQLGrade;
    }

    public void setSQLGrade(int SQLGrade) {
        this.SQLGrade = SQLGrade;
    }

    public int getJavaGrade() {
        return JavaGrade;
    }

    public void setJavaGrade(int javaGrade) {
        JavaGrade = javaGrade;
    }

    @Override
    public String toString(){
        return "学号：" + this.getId() + "\n" +
                "姓名：" + this.getName() + "\n" +
                "年龄：" + this.getAge() + "\n" +
                "专业班级：" + this.getProfessionalClass() + "\n" +
                "数据库成绩：" + this.getSQLGrade() + "\n" +
                "Java成绩：" + this.getJavaGrade();
    }
}
