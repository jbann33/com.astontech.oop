package com.astontech.bo;

import java.util.Date;

public class Client extends Person {

    //region PROPERTIES
    private int ClientId;
    private String ClientName;
    private Date CreateDate;
    //endregion

    //region CONSTRUCTORS
    public Client() {}

    public Client(int clientId, String clientName) {
        this.setClientId(clientId);
        this.setClientName(clientName);
    }
    //endregion

    //region GETTERS / SETTERS
    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
    //endregion

    //region CUSTOM METHODS
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public String GetClientName() {
        if(isNullOrEmpty(this.ClientName))
            return "No Client Name";
        else
            return this.ClientName;
    }
    //endregion
}
