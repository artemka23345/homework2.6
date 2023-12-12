package pro.sky.homework26.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.homework26.Employee;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl {
    final int MAX_EMPLOYEE = 5;
    List<Employee> EmployeeStorage = new ArrayList<>();

    public Employee addEmployee(String name, String surname) {
        if (EmployeeStorage.size() < MAX_EMPLOYEE) {
            Employee newEmployee = new Employee(name, surname);
            EmployeeStorage.add(newEmployee);
            return newEmployee;
        }
      return null;
    }//TODO

    public List<Employee> listEmployee() {
        System.out.println("Сработало");
        return EmployeeStorage;
    }
}
