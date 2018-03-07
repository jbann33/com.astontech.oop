package com.astontech.bo;

import java.util.Date;
import java.util.Scanner;

public class VehicleMake extends BaseBO{

    //region PROPERTIES
    private int VehicleMakeId;
    private String VehicleMakeName;
    private Date CreateDate;
    //endregion


    //region CONSTRUCTORS
    public VehicleMake () {}

    public VehicleMake(int vehicleMakeId, String vehicleMakeName) {
        this.setVehicleMakeId(vehicleMakeId);
        this.setVehicleMakeName(vehicleMakeName);
    }
    //endregion


    //region GETTERS / SETTERS
    public int getVehicleMakeId() {
        return VehicleMakeId;
    }

    public void setVehicleMakeId(int vehicleMakeId) {
        VehicleMakeId = vehicleMakeId;
    }

    public String getVehicleMakeName() {
        return VehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        VehicleMakeName = vehicleMakeName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
    //endregion

    //region CUSTOM METHODS
    public String GetVehicleMake() {
        Scanner VehicleMakeId = new Scanner(System.in);
        System.out.println("Please enter VehicleMakeId: ");
        int input = VehicleMakeId.nextInt();
        return this.VehicleMakeName;
    }

    public void PrintVehicleMakeName() {
        getVehicleMakeName();
        System.out.println();
    }
    //endregion


    @Override
    public String toString() {
        return "VehicleMake{" +
                "VehicleMakeId=" + VehicleMakeId +
                ", VehicleMakeName='" + VehicleMakeName + '\'' +
                ", CreateDate=" + CreateDate +
                '}';
    }
}
