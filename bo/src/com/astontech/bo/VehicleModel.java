package com.astontech.bo;

public class VehicleModel extends VehicleMake {

    //region PROPERTIES
    private int VehicleModelId;
    private String VehicleModelName;
    //endregion


    //region CONSTRUCTORS
    public VehicleModel() {}

    public VehicleModel(int vehicleModelId, String vehicleModelName) {
        this.setVehicleModelId(vehicleModelId);
        this.setVehicleModelName(vehicleModelName);
    }
    //endregion


    //region GETTERS / SETTERS
    public int getVehicleModelId() {
        return VehicleModelId;
    }

    public void setVehicleModelId(int vehicleModelId) {
        VehicleModelId = vehicleModelId;
    }

    public String getVehicleModelName() {
        return VehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        VehicleModelName = vehicleModelName;
    }
    //endregion

    //region CUSTOM METHODS

    @Override
    public String toString() {
        return "VehicleModel{" +
                "VehicleModelId=" + VehicleModelId +
                ", VehicleModelName='" + VehicleModelName + '\'' +
                '}';
    }

    //endregion
}
