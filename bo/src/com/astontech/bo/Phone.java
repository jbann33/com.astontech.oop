package com.astontech.bo;

public class Phone extends BaseBO {

    //region PROPERTIES
    private int PhoneId;
    private int AreaCode;
    private int PhoneNumber;
    private int PhoneNumberPost;
    private EntityType PhoneType;
    private Person PersonId;
    //endregion

    //region CONSTRUCTORS
    public Phone() {
        this.setPhoneType(new EntityType());
        this.setPersonId(new Person());
    }

    public Phone(int phoneId, int areaCode, int phoneNumber) {
        this.setPhoneId(phoneId);
        this.setAreaCode(areaCode);
        this.setPhoneNumber(phoneNumber);
    }
    //endregion

    //region GETTERS / SETTERS
    public int getPhoneId() {
        return PhoneId;
    }

    public void setPhoneId(int phoneId) {
        PhoneId = phoneId;
    }

    public int getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(int areaCode) {
        AreaCode = areaCode;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getPhoneNumberPost() {
        return PhoneNumberPost;
    }

    public void setPhoneNumberPost(int phoneNumberPost) {
        PhoneNumberPost = phoneNumberPost;
    }

    public EntityType getPhoneType() { return PhoneType; }

    public void setPhoneType(EntityType phoneType) { PhoneType = phoneType; }

    public Person getPersonId() { return PersonId; }

    public void setPersonId(Person personId) { PersonId = personId; }
    //endregion

    //region CUSTOM METHODS
    public static boolean isNullOrEmpty(int i) {
        return i == 0;
    }

    public String InvalidPhoneNumber() {
        if (isNullOrEmpty(this.AreaCode));
            return "Phone number not valid: Area code not found.";

    }
    //endregion


}
