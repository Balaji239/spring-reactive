package com.tms.handler;

import com.tms.entity.Vehicle;
import com.tms.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class HighwayHandler {

    private final VehicleRepository vehicleRepository;
    private final WebClient webClient;

    @Autowired
    public HighwayHandler(VehicleRepository vehicleRepository, WebClient webClient){
        this.vehicleRepository = vehicleRepository;
        this.webClient = webClient;
    }

    public Mono<ServerResponse> vehiclesDetected(ServerRequest request) {
        Flux<Vehicle> vehicleFlux = webClient
                .get()
                .uri("http://localhost:8080/simulateTraffic")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(Vehicle.class);

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(vehicleFlux, Vehicle.class);
    }

}
