package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scannerDigit = new Scanner(System.in);
    private Scanner scannerLine = new Scanner(System.in);

    private void init(){
        dealership = DealershipFileManager.getDealership();
    }

    public UserInterface(){
        init();
    }

    public void display(){

        System.out.println("Welcome to the dealership program");

        int mainMenuCommand;

        do{
            System.out.println("1) Get by Price");
            System.out.println("2) Get by Make & Model");
            System.out.println("3) Get by Year");
            System.out.println("4) Get by color");
            System.out.println("5) Get by mileage");
            System.out.println("6) Get by type");
            System.out.println("7) Get by all");
            System.out.println("8) Add vehicle");
            System.out.println("9) Remove vehicle");
            System.out.println("0) Exit");

            System.out.print("Command: ");
            mainMenuCommand = scannerDigit.nextInt();

            switch (mainMenuCommand){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Command not fount, try again");
            }

        }while(mainMenuCommand != 0);
    }

    private void processGetByPriceRequest(){
        System.out.println("----Display Vehicle by Price----");

        System.out.print("Enter Min: ");
        double min = scannerDigit.nextDouble();

        System.out.print("Enter Max: ");
        double max = scannerDigit.nextDouble();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(filteredVehicles);

    }

    private void processGetByMakeModelRequest(){
        System.out.println("----Display Vehicle by Make/Model Request----");

        System.out.print("Enter Make: ");
        String make = scannerLine.nextLine().trim();

        System.out.print("Enter Model: ");
        String model = scannerLine.nextLine().trim();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehicleByMakeModel(make, model);
        displayVehicles(filteredVehicles);

    }

    private void processGetByYearRequest(){
        System.out.println("----Display Vehicle by Year----");

        System.out.print("Enter Start Year: ");
        int min = scannerDigit.nextInt();

        System.out.print("Enter End Year: ");
        int max = scannerDigit.nextInt();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehicleByYear(min, max);
        displayVehicles(filteredVehicles);

    }

    private void processGetByColorRequest(){
        System.out.println("----Display Vehicle by Color----");

        System.out.print("Enter Color: ");
        String color = scannerLine.nextLine().trim();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehicleByColor(color);
        displayVehicles(filteredVehicles);

    }

    private void processGetByMileageRequest(){
        System.out.println("----Display Vehicle by Mileage----");

        System.out.print("Enter Min: ");
        int min = scannerDigit.nextInt();

        System.out.print("Enter Max: ");
        int max = scannerDigit.nextInt();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehicleByMileage(min, max);
        displayVehicles(filteredVehicles);

    }

    private void processGetByVehicleTypeRequest(){
        System.out.println("----Display Vehicle by Vehicle Type----");

        System.out.print("Enter Vehicle Type: ");
        String vehicleType = scannerLine.nextLine().trim();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehicleByType(vehicleType);
        displayVehicles(filteredVehicles);

    }

    private void processGetAllVehiclesRequest(){
        System.out.println("------Printing All Vehicles------");

        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);

    }

    private void processAddVehicleRequest(){
        System.out.println("----Add Vehicle----");

        System.out.print("Enter Vin: ");
        int vin = scannerDigit.nextInt();

        System.out.print("Enter Year: ");
        int year = scannerDigit.nextInt();

        System.out.print("Enter Make: ");
        String make = scannerLine.nextLine().trim();

        System.out.print("Enter model: ");
        String model = scannerLine.nextLine().trim();

        System.out.print("Enter Vehicle Type: ");
        String vehicleType = scannerLine.nextLine().trim();

        System.out.print("Enter color: ");
        String color = scannerLine.nextLine().trim();

        System.out.print("Enter Mileage: ");
        int odometer = scannerDigit.nextInt();

        System.out.print("Enter Price: ");
        double price = scannerDigit.nextDouble();

        Vehicle vehicle = new Vehicle(vin,year,make,model, vehicleType,color,odometer,price);
        dealership.addVehicle(vehicle);

        DealershipFileManager.saveDealership(dealership);


    }

    private void processRemoveVehicleRequest(){
        System.out.println("----Remove Vehicle----");

        System.out.print("Enter Vin: ");
        int vin = scannerDigit.nextInt();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();

        for(int i= 0; i < vehicles.size(); i++){
            if( vin == vehicles.get(i).getVin()){
                dealership.removeVehicle(vehicles.get(i));
            }
        }

        DealershipFileManager.saveDealership(dealership);

    }

    public static void displayVehicles(ArrayList<Vehicle> vehicles){

        System.out.printf("\n%-10s %-10s %-10s %-10s %-15s %-10s %-10s %-10s%n",
                "Vin",
                "Year",
                "Make",
                "Model",
                "Vehicle Type",
                "Color", "Odometer",
                "Price");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

        for(Vehicle vehicle: vehicles){
            System.out.print(vehicle);
        }
    }






}
