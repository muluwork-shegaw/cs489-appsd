package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.Reservation;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);
    Reservation getReservationById(Long id);
    void deleteReservation(Long id);
}
