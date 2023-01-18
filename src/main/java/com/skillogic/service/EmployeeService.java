package com.skillogic.service;

import com.skillogic.dao.EmployeeDao;
import com.skillogic.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    List<Employee> emps=new ArrayList<>();
    public  EmployeeService(){
        emps.add(new Employee(100,"rahul","nlg"));
        emps.add(new Employee(101,"ravi","hyd"));
        emps.add(new Employee(102,"suresh","viz"));
        emps.add(new Employee(103,"santhosh","gnt"));
    }
    public Employee getEmployee(){
        Employee employee=new Employee(100,"rahul","nlg");
        return employee;
    }

    public List<Employee> getEmployees(){
        return emps;
    }

    public String addEmployee(Employee employee){
        emps.add(employee);
        return "added successfully";
    }

    public void deleteEmployee(Integer empId) {
        for (int i=0;i<emps.size();i++){
            if(emps.get(i).getId()==empId){
                emps.remove(i);
            }
        }
    }

    public List<Employee> getEmps(){
        return employeeDao.getEmps();
    }

    public int addEmp(Employee employee) {
        return employeeDao.insertEmployee(employee);
    }

    public int deletEmp(int id) {
        return employeeDao.deleteEmploee(id);
    }
}
