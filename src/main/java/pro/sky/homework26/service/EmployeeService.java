package pro.sky.homework26.service;

import pro.sky.homework26.Employee;
import pro.sky.homework26.Exeption.EmployeeAlreadyAddedException;
import pro.sky.homework26.Exeption.EmployeeNotFoundException;
import pro.sky.homework26.Exeption.EmployeeStorageIsFullException;
import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;

    Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    List<Employee> listEmployee();

}
