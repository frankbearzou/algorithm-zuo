package a8;

import java.util.List;

public class MaxHappy {
    public int maxHappy(Employee employee) {
        YN yn = find(employee);
        return Math.max(yn.yes, yn.no);
    }

    private YN find(Employee employee) {
        if (employee.employees == null || employee.employees.isEmpty()) {
            return new YN(employee.happy, 0);
        }
        int yes = employee.happy;
        int no = 0;
        for (Employee emp : employee.employees) {
            YN yn = find(emp);
            yes += yn.no;
            no += Math.max(yn.yes, yn.no);
        }
        return new YN(yes, no);
    }
}

class Employee {
    int happy;
    List<Employee> employees;
}

class YN {
    int yes;
    int no;

    YN(int yes, int no) {
        this.yes = yes;
        this.no = no;
    }
}