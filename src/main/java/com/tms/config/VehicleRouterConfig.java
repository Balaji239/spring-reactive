package com.tms.config;

import com.tms.handler.HighwayHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class VehicleRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(HighwayHandler highwayHandler){
        return RouterFunctions.route(
                GET("/vehicles").and(accept(MediaType.APPLICATION_STREAM_JSON)), highwayHandler::vehiclesDetected);
    }
}
