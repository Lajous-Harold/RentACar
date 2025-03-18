package com.example.RentACar;

import com.example.RentACar.Car;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final List<Car> cars = new ArrayList<>();

    public CarService() {
        // Initialize some cars
        cars.add(new Car("11AA22", "Ferrari", 100));
        cars.add(new Car("33BB44", "Toyota", 50));
        cars.add(new Car("55CC66", "BMW", 80));
    }

    public List<Car> getAvailableCars() {
        return cars.stream().filter(car -> !car.isRented()).toList();
    }

    public Optional<Car> getCarByPlate(String plateNumber) {
        return cars.stream().filter(car -> car.getPlateNumber().equals(plateNumber)).findFirst();
    }

    public boolean rentCar(String plateNumber) {
        Optional<Car> car = getCarByPlate(plateNumber);
        if (car.isPresent() && !car.get().isRented()) {
            car.get().setRented(true);
            return true;
        }
        return false;
    }

    public boolean returnCar(String plateNumber) {
        Optional<Car> car = getCarByPlate(plateNumber);
        if (car.isPresent() && car.get().isRented()) {
            car.get().setRented(false);
            return true;
        }
        return false;
    }
}
