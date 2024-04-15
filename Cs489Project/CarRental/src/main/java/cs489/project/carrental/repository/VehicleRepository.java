package cs489.project.carrental.repository;

import cs489.project.carrental.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // Define methods to fetch vehicle data as needed.
}
