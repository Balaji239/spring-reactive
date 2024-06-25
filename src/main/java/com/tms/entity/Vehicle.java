package com.tms.entity;

import com.tms.constants.Fuel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Vehicles")
public record Vehicle(@Id String number, double weight, double speed, String color,
                      String model, short year, Fuel fuelType) {
}
