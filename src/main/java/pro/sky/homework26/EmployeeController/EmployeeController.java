package pro.sky.homework26.EmployeeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework26.Employee;
import pro.sky.homework26.service.EmployeeService;
import pro.sky.homework26.service.impl.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/add")
    public Employee add(String name, String surname){
       return employeeService.addEmployee(name,surname);
    }
    @GetMapping("/remove")
    public Employee remove(String name, String surname){return employeeService.removeEmployee(name, surname);
    }
    @GetMapping("/find")
    public Employee find(String name, String surname){return employeeService.findEmployee(name, surname);
    }
    @GetMapping("/list")
    public List<Employee> list(){
        return employeeService.listEmployee();
    }

}
