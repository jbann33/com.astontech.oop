package com.astontech.bo;

import java.util.Date;

public class Employee extends Person {

    //region PROPERTIES
    private int EmployeeId;
    private Date HireDate;
    private Date TermDate;
    //endregion

    //CONSTRUCTORS
    public Employee() {}

    public Employee(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public Employee(int employeeId, String firstName) {
        this.setFirstName(firstName);
    }

    public Employee(String lastName) {
        this.setLastName(lastName);
    }

    //region GETTERS / SETTERS
    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setHireDate(Date hireDate) {
        HireDate = hireDate;
    }

    public Date getHireDate() {
        return HireDate;
    }

    public void setTermDate(Date termDate) {
        TermDate = termDate;
    }

    public Date getTermDate() {
        return TermDate;
    }
    //endregion
}
