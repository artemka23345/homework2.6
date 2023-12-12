package pro.sky.homework26.service;

import pro.sky.homework26.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String name, String surname);
    Employee findEmployee(String name, String surname);
    Employee removeEmployee(String name, String surname);
    List<Employee> listEmployee();

}
