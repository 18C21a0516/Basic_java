package com.skillogic.controler;


import com.skillogic.model.Employee;
import com.skillogic.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/hii")
    public String getMessage(@RequestParam("custname") int custname, @RequestParam("loc") int custage){
        return "helloWorld" + custname +" custage "+custage;
    }

    @GetMapping("/hi")
    public String greet(){
        return "hi how are you";
    }

    @GetMapping("/getEmployee")
    public Employee fetchEmployee(){
        return employeeService.getEmployee();
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/addEmployee")
    public String  addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/updateEmployee/{empId}")
    public String updateEmployee(@PathVariable("empId") Integer empId){
        return "hii"+empId;
    }

    @DeleteMapping("/deleteEmployee/{empId}")
    public String deleteEmployee(@PathVariable("empId") Integer empId){
        employeeService.deleteEmployee(empId);
        return "deleted";
    }


    @GetMapping("/getEmps")
    public List<Employee> getEmps(){
        return employeeService.getEmps();
    }

    @PostMapping("/addEmp")
    public int insertEmployee(@RequestBody Employee employee){
        return employeeService.addEmp(employee);
    }

    @DeleteMapping("/removeEmployee/{empId}")
    public ResponseEntity deleteEmployee(@PathVariable("empId") int id){
        if(employeeService.deletEmp(id)!=0){
            return new ResponseEntity<>("delete operation successfull", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("delete operation failed",HttpStatus.BAD_REQUEST);
        }
    }
}
