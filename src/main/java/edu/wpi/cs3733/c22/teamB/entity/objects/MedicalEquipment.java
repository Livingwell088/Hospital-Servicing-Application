package edu.wpi.cs3733.c22.teamB.entity.objects;

import edu.wpi.cs3733.c22.teamB.entity.DatabaseWrapper;
import edu.wpi.cs3733.c22.teamB.entity.objects.Location;

import java.util.List;

public class MedicalEquipment {

    public static String[] EquipmentStatus = {"CLEAN", "IN USE", "DIRTY"};

    private String equipmentID; //
    private String equipmentName;
    private String equipmentType;
    private String manufacturer;
    private Location location; // foreign key, connect to location table
    private String status;
    private String color;
    private String size;
    private String description;
    private int amount;

    // constructors

    public MedicalEquipment() {
        this.equipmentID = null;
        this.equipmentName = null;
        this.equipmentType = null;
        this.manufacturer = null;
        this.location = null;
        this.status = null;
        this.color = null;
        this.size = null;
        this.description = null;
        this.amount = -1;
    }

    private String getUniqueID(){
        DatabaseWrapper db = DatabaseWrapper.getInstance();
        List<MedicalEquipment> medicalEquipmentList = db.getAllMedicalEquipment();
        int equipmentCount = 0;
        for (MedicalEquipment medicalEquipment : medicalEquipmentList) {
            if(medicalEquipment.getEquipmentType().equals(this.equipmentType)) {
                equipmentCount++;
            }
        }
        return "b" + equipmentType.toUpperCase() +  String.format("%03d",equipmentCount+ 1) + String.format("%02d", amount);
    }

    public MedicalEquipment(
            String equipmentID,
            String equipmentName,
            String equipmentType,
            String manufacturer,
            Location location,
            String status,
            String color,
            String size,
            String description,
            int amount) {

        this.equipmentID = equipmentID;
        this.equipmentName = equipmentName;
        this.equipmentType = equipmentType;
        this.manufacturer = manufacturer;
        this.location = location;
        if (!validateStatus(status)) {
            this.status = "WAITING";
        }
        else this.status = status;
        this.color = color;
        this.size = size;
        this.description = description;
        this.amount = amount;
    }

    public MedicalEquipment(
            String equipmentName,
            String equipmentType,
            String manufacturer,
            Location location,
            String status,
            String color,
            String size,
            String description,
            int amount) {

        this.equipmentName = equipmentName;
        this.equipmentType = equipmentType;
        this.manufacturer = manufacturer;
        this.location = location;
        if (!validateStatus(status)) {
            this.status = "WAITING";
        }
        else this.status = status;
        this.color = color;
        this.size = size;
        this.description = description;
        this.amount = amount;
        this.equipmentID = getUniqueID();
    }
    private boolean validateStatus(String st) {
        for (String s : EquipmentStatus)
            if (st.equals(s)) return true;
        return false;
    }

    // getters and setters

    public static String[] getEquipmentStatus() {
        return EquipmentStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // to string


    @Override
    public String toString() {
        return "MedicalEquipment{" +
                "equipmentID='" + equipmentID + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", location=" + location +
                ", status='" + status + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String toStringFields() {

        return equipmentID
                + ","
                + equipmentName
                + ","
                + equipmentType
                + ","
                + manufacturer
                + ","
                + location.getNodeID()
                + ","
                + status
                + ","
                + color
                + ","
                + size
                + ","
                + description
                + ","
                + amount;
    }

    public static String toStringHeader() {
        return "equipmentID,equipmentName,equipmentType,manufacturer,locationID,status,color,size,description,amount";
    }
}
