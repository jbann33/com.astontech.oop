package com.astontech.bo;

import java.util.Date;

public class Training extends BaseBO {

    //region PROPERTIES
    private int TrainingId;
    private String TrainingName;
    private Date CreateDate;
    private Employee EmployeeId;
    //endregion


    //region CONSTRUCTORS
    public Training() {
        this.setEmployeeId(new Employee());
    }

    public Training(int trainingId, String trainingName) {
        this.setTrainingId(trainingId);
        this.setTrainingName(trainingName);
    }
    //endregion

    //region GETTERS / SETTERS
    public int getTrainingId() {
        return TrainingId;
    }

    public void setTrainingId(int trainingId) {
        TrainingId = trainingId;
    }

    public String getTrainingName() {
        return TrainingName;
    }

    public void setTrainingName(String trainingName) {
        TrainingName = trainingName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public Employee getEmployeeId() { return EmployeeId; }

    public void setEmployeeId(Employee employeeId) { EmployeeId = employeeId; }
    //endregion
}
