package com.ps;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){

        ArrayList<Vehicle> getByPrice = new ArrayList<>();

        for(Vehicle vehicle: inventory){
            if( min <= vehicle.getPrice() || max >= vehicle.getPrice() ){
                getByPrice.add(vehicle);
            }
        }
        return getByPrice;

    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model){

        ArrayList<Vehicle> getByMakeModel = new ArrayList<>();

        for(Vehicle vehicle: inventory){
            if( make.equalsIgnoreCase(vehicle.getMake()) && model.equalsIgnoreCase(vehicle.getModel()) ){
                getByMakeModel.add(vehicle);
            }
        }
        return getByMakeModel;

    }

    public ArrayList<Vehicle> getVehicleByYear(int min, int max){

        ArrayList<Vehicle> getByYear = new ArrayList<>();

        for(Vehicle vehicle: inventory){
            if( min <= vehicle.getYear() || max >= vehicle.getYear() ){
                getByYear.add(vehicle);
            }
        }
        return getByYear;
    }

    public ArrayList<Vehicle> getVehicleByColor(String Color){
        return null;

    }

    public ArrayList<Vehicle> getVehicleByMileage(int min, int max){
        return null;

    }

    public ArrayList<Vehicle> getVehicleByType(String vehicleType){
        return null;

    }

    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
