package com.astontech.bo;

import java.util.Date;

public class Review extends BaseBO{

    //region PROPERTIES
    private int ReviewId;
    private String ReviewName;
    private Date ReviewDate;
    private Employee EmployeeId;
    //endregion

    //region CONSTRUCTORS
    public Review() {
        this.setEmployeeId(new Employee());
    }

    public Review(int reviewId, String reviewName, Date reviewDate) {
        this.setReviewId(reviewId);
        this.setReviewName(reviewName);
        this.setReviewDate(reviewDate);
    }
    //endregion

    //region GETTERS / SETTERS
    public int getReviewId() {
        return ReviewId;
    }

    public void setReviewId(int reviewId) {
        ReviewId = reviewId;
    }

    public String getReviewName() {
        return ReviewName;
    }

    public void setReviewName(String reviewName) {
        ReviewName = reviewName;
    }

    public Date getReviewDate() {
        return ReviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        ReviewDate = reviewDate;
    }

    public Employee getEmployeeId() { return EmployeeId; }

    public void setEmployeeId(Employee employeeId) { EmployeeId = employeeId; }
    //endregion
}
