package com.tms.handler;

import com.tms.entity.Vehicle;
import com.tms.repository.VehicleRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class HighwayHandler {

    private final VehicleRepository vehicleRepository;

    public HighwayHandler(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    public Mono<ServerResponse> vehiclesDetected(ServerRequest request){
        Flux<Vehicle> vehicles = vehicleRepository.findAll();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(
                        vehicleRepository.findAll(), Vehicle.class
                );
    }

//    protected Flux<Vehicle> vehicleDetected(){
//
//    }
}
