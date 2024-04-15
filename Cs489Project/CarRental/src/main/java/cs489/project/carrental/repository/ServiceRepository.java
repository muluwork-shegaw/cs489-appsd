package cs489.project.carrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    // Define methods to fetch service data as needed.
}
