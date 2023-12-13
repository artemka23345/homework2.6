package pro.sky.homework26.EmployeeController;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework26.Employee;
import pro.sky.homework26.Exeption.EmployeeAlreadyAddedException;
import pro.sky.homework26.Exeption.EmployeeNotFoundException;
import pro.sky.homework26.Exeption.EmployeeStorageIsFullException;
import pro.sky.homework26.service.EmployeeService;


import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/add")
    public String add(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {

        try {
            return employeeService.addEmployee(firstName, lastName).toString();
        } catch (EmployeeStorageIsFullException e) {
            return e.getMessage();
        } catch (EmployeeAlreadyAddedException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/remove")
    public String remove(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        try {
            return employeeService.removeEmployee(firstName, lastName).toString();
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/find")
    public String find(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        try {
            return employeeService.findEmployee(firstName, lastName).toString();
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/list")
    public List<Employee> list() {
        return employeeService.listEmployee();
    }


}
