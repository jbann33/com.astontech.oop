package com.astontech.bo;

import java.util.Date;

public class Project extends BaseBO {

    //region PROPERTIES
    private int ProjectId;
    private String ProjectName;
    private int Rate;
    private Date StartDate;
    private Date EndDate;
    private Client ClientName;
    //endregion

    //region CONSTRUCTORS
    public Project() {
        this.setClientName(new Client());
    }

    public Project(int projectId, String projectName, Date startDate) {
        this.setProjectId(projectId);
        this.setProjectName(projectName);
        this.setStartDate(startDate);
    }
    //endregion


    //region GETTERS / SETTERS
    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
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

    public Client getClientName() { return ClientName; }

    public void setClientName(Client clientName) { ClientName = clientName; }
    //endregion
}
