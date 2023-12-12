package pro.sky.homework26.EmployeeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework26.Employee;
import pro.sky.homework26.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/add")
    public Employee add(String name, String surname){
       return employeeService.addEmployee(name,surname);
    }
    @GetMapping("/list")
    public String list(){
        return employeeService.listEmployee().toString();
    }
}
