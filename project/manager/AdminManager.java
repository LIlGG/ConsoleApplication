package project.manager;

import javafx.scene.control.Pagination;
import project.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author lixingyong
 * @Date 2018/12/26 14:13
 * @Version 1.0
 */
public class AdminManager {
    Employee employees;

    private AdminManager(){
        employees = new Employee();
    }

    public void setEmplpyee(Employee employee) {
        this.employees = employee;
    }

    public void updateEmployee(Employee employee) {
        this.employees = employee;
    }

    private static class AdminControllerInstance {
        private static final AdminManager ADMIN_MANAGER = new AdminManager();
    }

    public static AdminManager getAdminManager(){
        return AdminControllerInstance.ADMIN_MANAGER;
    }

    public boolean  isEmployees(){
        if(null != employees.getEmployeeName()){
            return true;
        }
        return false;
    }

    public Employee getEmployees() {
        return employees;
    }
}
