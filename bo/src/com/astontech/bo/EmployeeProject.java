package com.astontech.bo;

import java.util.Date;

public class EmployeeProject extends BaseBO {

    //region PROPERTIES
    private int EmployeeProjectId;
    private Date StartDate;
    private Date EndDate;
    private String Notes;
    //endregion

    //region CONSTRUCTORS
    public EmployeeProject() {}

    public EmployeeProject(int employeeProjectId, Date startDate, Date endDate) {
        this.setEmployeeProjectId(employeeProjectId);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }
    //endregion


    //region GETTERS / SETTERS
    public int getEmployeeProjectId() {
        return EmployeeProjectId;
    }

    public void setEmployeeProjectId(int employeeProjectId) {
        EmployeeProjectId = employeeProjectId;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
    //endregion
}
