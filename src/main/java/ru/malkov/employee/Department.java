package ru.malkov.employee;

import java.util.ArrayList;
import java.util.List;

public class Department {
    final String name;
    Employee boss;
    List<Employee> employees;

    public Department(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be null or empty");
        }
        this.name = name;
        this.boss = null;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        if (boss == null) {
            throw new IllegalArgumentException("Boss cannot be null");
        }
        if (!employees.contains(boss)) {
            employees.add(boss);
        }
        this.boss = boss;
    }

    public void addEmployee(Employee newEmployee) {
        if (newEmployee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        this.employees.add(newEmployee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getEmployeesNames() {
        StringBuilder result = new StringBuilder();
        for (Employee employee : employees) {
            if (employee != null) {
                result.append(employee.getName()).append("\n");
            }
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "Department name: " + name + " with boss: " + boss + ".";
    }
}