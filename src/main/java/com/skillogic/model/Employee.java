package com.skillogic.model;

public class Employee {
    private int custid;
    private String custname;
    private String custage;

    public Employee(){

    }
    public Employee(int id, String name, String location) {
        this.custid = custid;
        this.custname = custname;

        this.custage = custage;
    }

    public int getCustid() {

        return custid;
    }

    public String getCustame() {

        return custname;
    }

    public String getCustage() {

        return custage;
    }
}
