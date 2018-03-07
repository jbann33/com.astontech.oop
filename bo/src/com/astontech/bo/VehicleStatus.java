package com.astontech.bo;

import java.util.Date;

public class VehicleStatus extends BaseBO {

    //region PROPERTIES
    private int VehicleStatusId;
    private String Notes;
    private Date CreateDate;
    private Vehicle VehicleId;
    //endregion


    //region CONSTRUCTORS
    public VehicleStatus() {
        this.setVehicleId(new Vehicle());
    }

    public VehicleStatus(int vehicleStatusId, String notes) {
        this.setVehicleStatusId(vehicleStatusId);
        this.setNotes(notes);
    }
    //endregion


    //region GETTERS / SETTERS
    public int getVehicleStatusId() {
        return VehicleStatusId;
    }

    public void setVehicleStatusId(int vehicleStatusId) {
        VehicleStatusId = vehicleStatusId;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public Vehicle getVehicleId() { return VehicleId; }

    public void setVehicleId(Vehicle vehicleId) { VehicleId = vehicleId; }
    //endregion
}
