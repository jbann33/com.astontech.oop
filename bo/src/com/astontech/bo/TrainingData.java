package com.astontech.bo;

import java.util.Date;

public class TrainingData extends BaseBO {

    private int TrainingDataId;
    private String TrainingDataValue;
    private Date CreateDate;



    public TrainingData() {}

    public TrainingData(int trainingDataId, String trainingDataValue) {
        this.setTrainingDataId(trainingDataId);
        this.setTrainingDataValue(trainingDataValue);
    }



    public int getTrainingDataId() {
        return TrainingDataId;
    }

    public void setTrainingDataId(int trainingDataId) {
        TrainingDataId = trainingDataId;
    }

    public String getTrainingDataValue() {
        return TrainingDataValue;
    }

    public void setTrainingDataValue(String trainingDataValue) {
        TrainingDataValue = trainingDataValue;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
