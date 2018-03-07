package com.astontech.bo;

import java.util.Date;


public class Address extends BaseBO {

    //region PROPERTIES
    private int AddressId;
    private int AddressNumber;
    private String Street;
    private String Street02;
    private String City;
    private int StateId;
    private int CountryId;
    private Date DateCreate;
    private Person AddressOwner;
    private EntityType AddressType;
    //endregion

    //region CONSTRUCTORS
    public Address() {
        this.setAddressType(new EntityType());
        this.setAddressOwner(new Person());
    }


    public Address(int addressNumber, String street, String street02) {
        this.setAddressNumber(addressNumber);
        this.setStreet(street);
        this.setStreet02(street02);
    }
    //endregion

    //region GETTERS / SETTERS
    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int addressId) {
        AddressId = addressId;
    }

    public int getAddressNumber() {
        return AddressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        AddressNumber = addressNumber;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getStreet02() {
        return Street02;
    }

    public void setStreet02(String street02) {
        Street02 = street02;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getStateId() {
        return StateId;
    }

    public void setStateId(int stateId) {
        StateId = stateId;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        DateCreate = dateCreate;
    }

    public Person getAddressOwner() { return AddressOwner; }

    public void setAddressOwner(Person addressOwner) { AddressOwner = addressOwner; }

    public EntityType getAddressType() { return AddressType; }

    public void setAddressType(EntityType addressType) { AddressType = addressType; }
    //endregion
}
