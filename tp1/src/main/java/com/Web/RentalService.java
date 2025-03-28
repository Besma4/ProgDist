package com.Web;

import org.springframework.web.bind.annotation.RestController;

import com.Data.Car;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/cars")
public class RentalService {

Logger logger = LoggerFactory.getLogger(RentalService.class);

List<Car> cars = new ArrayList<Car>();


public RentalService() {
    Car car = new Car("11AA22", "Ferrari", 100);
    Car car2 = new Car("11BB44", "Ferrari", 250);
    cars.add(car);cars.add(car2);
}

@GetMapping()
public List <Car> getCars() {
    return cars;
}

//Get cars details 
@GetMapping("/{plateNumber}")
public void getCar(
    @PathVariable ("plate Number") String plateNumber,
    @RequestParam (value = "Rent") boolean rent,
    @RequestBody Dates dates) {

    
    logger.info("Plate Number :" + plateNumber);
    logger.info("Rent :" + rent);
    logger.info("Dates :" + dates);
}

//Rent a Car
@PutMapping("/{plateNumber}")
public void RentGet(            
    @PathVariable("plate Number") String plateNumber,
    @RequestParam(value = "Rent", required = true) boolean rent,
    @RequestBody Dates dates) {

        logger.info("Plate Number :" + plateNumber);
        logger.info("Rent :" + rent);
        logger.info("Dates :" + dates);

        Car targetCar = null;
        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                targetCar = car;
                break;
            }
        }
    
        if (targetCar != null) {
            logger.info("Car found: " + targetCar.getPlateNumber());
            targetCar.setRented(rent);
        } else {
            logger.info("Plate Number " + plateNumber + " doesn't exist.");
        }
        }

        
}


