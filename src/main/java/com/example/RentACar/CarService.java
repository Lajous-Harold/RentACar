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
        cars.add(new Car("11AA22", "Ferrari", 145000));
        cars.add(new Car("33BB44", "Toyota", 12000));
        cars.add(new Car("55CC66", "BMW", 42000));
    }

    public List<Car> getAvailableCars() {
        return cars.stream().filter(car -> !car.isRented()).toList();
    }

    public Optional<Car> getCarByPlate(String plateNumber) {
        System.out.println("🔍 Recherche de la voiture avec plaque : " + plateNumber);
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
