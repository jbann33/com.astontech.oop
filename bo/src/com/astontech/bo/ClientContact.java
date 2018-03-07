package com.astontech.bo;

public class ClientContact extends BaseBO {


    //region PROPERTIES
    private int ClientContactId;
    private Client ClientId;
    private EntityType ClientContactType;
    private Person ClientName;
    //endregion

    //region CONSTRUCTORS
    public ClientContact() {
        this.setClientId(new Client());
        this.setClientContactType(new EntityType());
        this.setClientName(new Person());
    }

    public ClientContact(int clientContactId) {
        this.setClientContactId(clientContactId);
    }
    //endregion


    //region GETTERS / SETTERS
    public int getClientContactId() {
        return ClientContactId;
    }

    public void setClientContactId(int clientContactId) {
        ClientContactId = clientContactId;
    }

    public Client getClientId() {
        return ClientId;
    }

    public void setClientId(Client clientId) {
        ClientId = clientId;
    }

    public EntityType getClientContactType() {
        return ClientContactType;
    }

    public void setClientContactType(EntityType clientContactType) {
        ClientContactType = clientContactType;
    }

    public Person getClientName() {
        return ClientName;
    }

    public void setClientName(Person clientName) {
        ClientName = clientName;
    }

    //endregion
}
