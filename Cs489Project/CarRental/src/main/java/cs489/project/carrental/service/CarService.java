package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.Car;

public interface CarService {
    Car saveCar(Car car);
    Car getCarById(Long id);
    void deleteCar(Long id);
}
