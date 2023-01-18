package com.skillogic.dao;

import com.skillogic.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Employee> getEmps(){
        return jdbcTemplate.query("select * from customer",(rs, rowNum) ->
                new Employee(
                        rs.getInt("custid"),
                        rs.getString("custname"),
                        rs.getString("custname")
                ));
    }

    public int insertEmployee(Employee emp){

        return jdbcTemplate.update("insert into customer(custid,custname,custage) values(?,?,?)",

                emp.getId(),emp.getName(),20);
    }


    public int deleteEmploee(int id){
        return jdbcTemplate.update("delete from Employee where empid=?",id);
    }
}
