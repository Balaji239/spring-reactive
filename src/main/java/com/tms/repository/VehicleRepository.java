package com.tms.repository;

import com.tms.entity.Vehicle;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends ReactiveMongoRepository<Vehicle, String> {
}
