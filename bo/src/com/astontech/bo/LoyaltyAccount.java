package com.astontech.bo;

public class LoyaltyAccount extends BaseBO{

    //region PROPERTIES
    private int LoyaltyAccountId;
    private String MemberNumber;
    private Employee EmployeeId;
    //endregion


    //region CONSTRUCTORS
    public LoyaltyAccount() {
        this.setEmployeeId(new Employee());
    }

    public LoyaltyAccount(int loyaltyAccountId, String memberNumber) {
        this.setLoyaltyAccountId(loyaltyAccountId);
        this.setMemberNumber(memberNumber);
    }
    //endregion


    //region GETTERS / SETTERS
    public int getLoyaltyAccountId() {
        return LoyaltyAccountId;
    }

    public void setLoyaltyAccountId(int loyaltyAccountId) {
        LoyaltyAccountId = loyaltyAccountId;
    }

    public String getMemberNumber() {
        return MemberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        MemberNumber = memberNumber;
    }

    public Employee getEmployeeId() { return EmployeeId; }

    public void setEmployeeId(Employee employeeId) { EmployeeId = employeeId; }
    //endregion
}
