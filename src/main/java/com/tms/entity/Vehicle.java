package com.tms.entity;

import com.tms.constant.Fuel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Vehicles")
public class Vehicle{

    @Id
    private String number;

    private double weight;

    private int speed;

    private String color;

    private String model;

    private short year;

    private Fuel fuelType;

    public Vehicle(String number, double weight, int speed, String color, String model, short year, Fuel fuelType) {
        this.number = number;
        this.weight = weight;
        this.speed = speed;
        this.color = color;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public Fuel getFuelType() {
        return fuelType;
    }

    public void setFuelType(Fuel fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "number='" + number + '\'' +
                ", weight=" + weight +
                ", speed=" + speed +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", fuelType=" + fuelType +
                '}';
    }
}
