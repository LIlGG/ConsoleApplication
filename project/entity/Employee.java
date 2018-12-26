package project.entity;

import java.io.Serializable;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author  mail@lixingyong.com
 * @Date 2018/12/26 14:37
 * @Version 1.0
 */
public class Employee extends BasicPeople implements Serializable {
    private long employeeId;

    private String employeeName;

    private String post;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "工号：" + this.getEmployeeId() + "\n" +
                "姓名：" + this.getEmployeeName() + "\n" +
                "职务：" + this.getPost() + "\n" +
                "修改日期：" + this.getUpdateTime();
    }
}
