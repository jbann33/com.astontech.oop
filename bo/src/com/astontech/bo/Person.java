package com.astontech.bo;

import common.helpers.StringHelper;

import java.util.ArrayList;
import java.util.List;

public class Person implements Comparable{

    //region PROPERTIES
    // PersonId
    private int PersonId;
    // Title
    private String Title;
    // First Name
    private String FirstName;
    // Last Name
    private String LastName;
    // DisplayFirstName
    private String DisplayFirstName;
    // Gender
    private String Gender;
    // List of Email objects
    private List<Email> Emails;
    // List of Phone objects
    private List<Phone> PhoneNumbers;
    //endregion

    //region CONSTRUCTORS

    public Person() {
        this.setEmails(new ArrayList<>());
        this.setPhoneNumbers(new ArrayList<>());
    }
    //endregion

    //region GETTERS / SETTERS
    public void setPersonId(int personId) {
        this.PersonId = personId;
    }

    public int getPersonId() {
        return this.PersonId;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setDisplayFirstName(String displayFirstName) {
        this.DisplayFirstName = displayFirstName;
    }

    public String getDisplayFirstName() {
        return this.DisplayFirstName;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public String getGender() {
        return this.Gender;
    }

    public List<Phone> getPhoneNumbers() { return PhoneNumbers; }

    public void setPhoneNumbers(List<Phone> phoneNumbers) { PhoneNumbers = phoneNumbers; }


    //endregion

    //region CUSTOM METHODS
    //notes: this will become an extension method


    public String GetFullName() {
        if(StringHelper.isNullOrEmpty(this.FirstName) && StringHelper.isNullOrEmpty(this.LastName))
            return "No Name Set";
        else
        {
            if(StringHelper.isNullOrEmpty(this.FirstName))
                return this.LastName;
            else if(StringHelper.isNullOrEmpty(this.LastName))
                return this.FirstName;
            else
                return this.FirstName + " " + this.LastName;
        }

    }

    public List<Email> getEmails() {
        return Emails;
    }

    public void setEmails(List<Email> emails) {
        Emails = emails;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    //endregion
}
