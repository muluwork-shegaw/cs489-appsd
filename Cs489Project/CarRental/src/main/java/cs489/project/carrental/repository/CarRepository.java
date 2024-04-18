package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    // Custom methods to fetch car-specific data can be added here.
}
