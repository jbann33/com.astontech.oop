package com.astontech.bo;

import java.util.Date;
import java.util.Scanner;

public class Vehicle implements Comparable {

    //region PROPERTIES
    private int VehicleId;
    private int Year;
    private String LicensePlate;
    private String VIN;
    private String Color;
    private boolean IsPurchase;
    private int PurchasePrice;
    private Date PurchaseDate;
    private VehicleMake VehicleMakeName;
    private VehicleModel VehicleModelName;
    //endregion


    //region CONSTRUCTORS
    public Vehicle() {
        this.setVehicleMakeName(new VehicleMake());
        this.setVehicleModelName(new VehicleModel());
        this.setPurchaseDate(new Date());
    }

    public Vehicle(int vehicleId, int year, String licensePlate, String vin, String color,
                   boolean isPurchase, int purchasePrice, Date purchaseDate,
                   VehicleMake vehicleMakeName, VehicleModel vehicleModelName) {
        this.setVehicleId(vehicleId);
        this.setYear(year);
        this.setLicensePlate(licensePlate);
        this.setVIN(vin);
        this.setColor(color);
        this.setPurchase(isPurchase);
        this.setPurchasePrice(purchasePrice);
        this.setPurchaseDate(purchaseDate);
        this.setVehicleMakeName(vehicleMakeName);
        this.setVehicleModelName(vehicleModelName);
    }
    //endregion


    //region GETTERS / SETTERS
    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public boolean isPurchase() {
        return IsPurchase;
    }

    public void setPurchase(boolean purchase) {
        IsPurchase = purchase;
    }

    public int getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public VehicleMake getVehicleMakeName() { return VehicleMakeName; }

    public void setVehicleMakeName(VehicleMake vehicleMakeName) { VehicleMakeName = vehicleMakeName; }

    public VehicleModel getVehicleModelName() { return VehicleModelName; }

    public void setVehicleModelName(VehicleModel vehicleModelName) { VehicleModelName = vehicleModelName; }
    //endregion

    //region CUSTOM METHODS
    public String GetLicensePlate() {
        Scanner VehicleId = new Scanner(System.in);
        System.out.println("Please enter VehicleId: ");
        int input = VehicleId.nextInt();
        return this.LicensePlate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "VehicleId=" + VehicleId +
                ", Year=" + Year +
                ", LicensePlate='" + LicensePlate + '\'' +
                ", VIN='" + VIN + '\'' +
                ", Color='" + Color + '\'' +
                ", IsPurchase=" + IsPurchase +
                ", PurchasePrice=" + PurchasePrice +
                ", PurchaseDate=" + PurchaseDate +
                ", VehicleMakeName=" + getVehicleMakeName().toString() +
                ", VehicleModelName=" + getVehicleModelName().toString() +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    //endregion
}

