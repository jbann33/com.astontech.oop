package com.astontech.bo;

public class LoyaltyCompany extends BaseBO {

    //region PROPERTIES
    private int LoyaltyCompanyId;
    private String CompanyName;
    private EntityType CompanyType;
    //endregion

    //region CONSTRUCTORS
    public LoyaltyCompany() {
        this.setCompanyType(new EntityType());
    }

    public LoyaltyCompany(int loyaltyCompanyId, String companyName) {
        this.setLoyaltyCompanyId(loyaltyCompanyId);
        this.setCompanyName(companyName);
    }
    //endregion


    //region GETTERS / SETTERS
    public int getLoyaltyCompanyId() {
        return LoyaltyCompanyId;
    }

    public void setLoyaltyCompanyId(int loyaltyCompanyId) {
        LoyaltyCompanyId = loyaltyCompanyId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public EntityType getCompanyType() { return CompanyType; }

    public void setCompanyType(EntityType companyType) { CompanyType = companyType; }
    //endregion
}
