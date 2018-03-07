package com.astontech.bo;

import java.util.Date;

public class ReviewData extends BaseBO {

    private int ReviewDataId;
    private String ReviewDataValue;
    private Date CreateDate;


    public ReviewData() {}

    public ReviewData(int reviewDataId, String reviewDataValue) {
        this.setReviewDataId(reviewDataId);
        this.setReviewDataValue(reviewDataValue);
    }


    public int getReviewDataId() {
        return ReviewDataId;
    }

    public void setReviewDataId(int reviewDataId) {
        ReviewDataId = reviewDataId;
    }

    public String getReviewDataValue() {
        return ReviewDataValue;
    }

    public void setReviewDataValue(String reviewDataValue) {
        ReviewDataValue = reviewDataValue;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
