package pro.sky.homework26.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.homework26.Employee;
import pro.sky.homework26.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
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
    public Employee findEmployee(String name, String surname) {
        Employee tmpEmpl = new Employee(name,surname);
        for(Employee employee: EmployeeStorage){
            if(employee.equals(tmpEmpl)){
                System.out.println("найден");
                return employee;
            }
        }
        return null;
    }//TODO
    public Employee removeEmployee(String name, String surname) {
        Employee tmpEmpl = new Employee(name,surname);
        for(Employee employee: EmployeeStorage){
            if(employee.equals(tmpEmpl)){
                EmployeeStorage.remove(employee);
                System.out.println("Удалён");
                return employee;
            }
        }
        return null;
    }
}
