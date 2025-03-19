package com.example.RentACar;

import com.example.RentACar.Car;
import com.example.RentACar.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> listAvailableCars() {
        return carService.getAvailableCars();
    }

    @GetMapping("/{plateNumber}")
    public ResponseEntity<Car> getCar(@PathVariable("plateNumber") String plateNumber) {
        return carService.getCarByPlate(plateNumber)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{plateNumber}")  
    public ResponseEntity<String> rentOrReturnCar(
        @PathVariable("plateNumber") String plateNumber, 
        @RequestParam("rent") boolean rent) {

    if (carService.getCarByPlate(plateNumber).isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found.");
    }

    boolean success = rent ? carService.rentCar(plateNumber) : carService.returnCar(plateNumber);
    if (success) {
        return ResponseEntity.ok("Car " + (rent ? "rented" : "returned") + " successfully.");
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Action not possible. Car may already be rented or not found.");
}

}
