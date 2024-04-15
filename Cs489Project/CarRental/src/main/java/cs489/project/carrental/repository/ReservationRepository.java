package cs489.project.carrental.repository;

import cs489.project.carrental.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Here, you can define custom methods to handle reservation-specific queries.
}
