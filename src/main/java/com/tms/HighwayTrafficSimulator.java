package com.tms;

import com.tms.constant.Fuel;
import com.tms.entity.Vehicle;
import com.tms.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class HighwayTrafficSimulator {

    public Mono<ServerResponse> trafficFlow(ServerRequest request) {
        List<Vehicle> vehicles = Arrays.asList(
                new Vehicle("EGH 9927", 1000.87, 100, "Black", "Sedan", (short) 2012, Fuel.ELECTRIC),
                new Vehicle("TYH 4561", 980.80, 70, "Blue", "Hatchback", (short) 2010, Fuel.PETROL),
                new Vehicle("FDV 4902", 1200.00, 95, "Red", "Truck", (short) 2009, Fuel.PETROL),
                new Vehicle("EDR 7894", 1400.50, 110, "Orange", "Bus", (short) 2015, Fuel.DIESEL),
                new Vehicle("WSX 1234", 1000.15, 125, "White", "SUV", (short) 2021, Fuel.ELECTRIC),
                new Vehicle("RGT 3421", 990.55, 140, "Black", "Sedan", (short) 2022, Fuel.PETROL),
                new Vehicle("IJK 5723", 880.56, 100, "Yellow", "Convertible", (short) 2019, Fuel.PETROL),
                new Vehicle("YUN 4578", 1300.80, 80, "Blue", "Minivan", (short) 2012, Fuel.DIESEL),
                new Vehicle("TGB 9076", 2500.50, 95, "Brown", "Sports car", (short) 2000, Fuel.PETROL),
                new Vehicle("CVB 3098", 1700.67, 110, "Red", "Truck", (short) 2015, Fuel.GASOLINE)
        );

        //Flux<Vehicle> vehicleFlux = Flux.fromIterable(vehicles).flatMap(Flux::just);

        int noOFVehicles = vehicles.size();
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(Flux.interval(Duration.ofSeconds(1))
                .flatMap(index -> {
                    int randomIndex = ThreadLocalRandom.current().nextInt(noOFVehicles);
                    Vehicle item = vehicles.get(randomIndex);
                    return Flux.just(item).delayElements(Duration.ofMillis(ThreadLocalRandom.current().nextInt(500, 3000))); // Emit the item
                }), Vehicle.class);

      //return ServerResponse.ok()
      //    .contentType(MediaType.TEXT_EVENT_STREAM)
      //    .body(vehicleFlux.delayElements(Duration.ofSeconds(1)), Vehicle.class);

    }
}