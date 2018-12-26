package project.service;

import project.entity.Employee;
import project.manager.AdminManager;

/**
 * @ClassName
 * @Description TODO
 * @Author  mail@lixingyong.com
 * @Date 2018/12/26 14:18
 * @Version 1.0
 */
public class EmployeeService {
    AdminManager adminManager;

    public EmployeeService(){
        adminManager = AdminManager.getAdminManager();
    }

    public boolean isLogin() {
        if(adminManager.isEmployees()){
            return true;
        }
        return false;
    }

    public boolean create() {
        Employee employee = new Employee();
        employee.setEmployeeId(000001L);
        employee.setEmployeeName("admin");
        employee.setPost("管理员");
        adminManager.setEmplpyee(employee);
        return this.isLogin();
    }

    public boolean create(Employee employee) {
        adminManager.setEmplpyee(employee);
        return this.isLogin();
    }

    public Employee getEmployee() {
        return adminManager.getEmployees();
    }

    public void update(Employee employee) {
        adminManager.updateEmployee(employee);
    }
}
