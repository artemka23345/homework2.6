package pro.sky.homework26.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.homework26.Employee;
import pro.sky.homework26.Exeption.EmployeeAlreadyAddedException;
import pro.sky.homework26.Exeption.EmployeeNotFoundException;
import pro.sky.homework26.Exeption.EmployeeStorageIsFullException;
import pro.sky.homework26.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final int MAX_EMPLOYEE = 5;
    List<Employee> EmployeeStorage = new ArrayList<>(MAX_EMPLOYEE);

    public Employee addEmployee(String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee newEmployee = new Employee(firstName, lastName);
        if (EmployeeStorage.size() >= MAX_EMPLOYEE) {
            throw new EmployeeStorageIsFullException("Хранилище заполнено");
        }
        for (Employee employee : EmployeeStorage) {
            if (employee.equals(newEmployee)) {
                throw new EmployeeAlreadyAddedException("Уже есть такой сотруудник");
            }
        }
        if (EmployeeStorage.size() < MAX_EMPLOYEE) {
            EmployeeStorage.add(newEmployee);
        }

        return newEmployee;
    }

    public List<Employee> listEmployee() {
        return EmployeeStorage;
    }

    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee tmpEmpl = new Employee(firstName, lastName);
        for (Employee employee : EmployeeStorage) {
            if (employee.equals(tmpEmpl)) {
                return employee;
            } else {
                throw new EmployeeNotFoundException("Не найдено");
            }
        }
        return tmpEmpl;
    }

    public Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee tmpEmpl = new Employee(firstName, lastName);
        for (Employee employee : EmployeeStorage) {
            if (employee.equals(tmpEmpl)) {
                EmployeeStorage.remove(employee);
                return employee;
            }
            if (!employee.equals(tmpEmpl)) {
                throw new EmployeeNotFoundException("Удаляемый сотрудник не найден");
            }
        }
        return tmpEmpl;
    }
}
