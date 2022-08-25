package com.example.demo2.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Year;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Con la anotación Service, Spring Boot sabrá que debe iniciar una instancia de esta clase donde se use un autowired.
@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // método que obtiene una lista de coches a partir de los datos de la DB
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    //método que añade un nuevo coche sólo si el email no está usado previamente
    public void addNewCar(Car car) {
        Optional<Car> carByEmail = carRepository.findCarByEmail(car.getSellerEmail());
        if (carByEmail.isPresent()) {
            throw new IllegalStateException("Email ya usado");
        } else {
            carRepository.save(car);
        }
    }

    // método para borrar un coche pasándole el id por DELETE request. el método existsById ya viene implementado en Spring.
    public void deleteCar(Long carId) {
        boolean exists = carRepository.existsById(carId);
        if(!exists) {
            throw new IllegalStateException("Coche con el id " + carId + " no existe");
        } else {
            carRepository.deleteById(carId);
        }
    }

    //método para poder cambiar los campos de descripción y precio de un coche con ID determinado. Transactional permite hacer esto sin hacer una query
    @Transactional
    public void updateCar(Long carId, String description, int price) {
        //primero se asegura de que el id que se le pasa exista
        Car car = carRepository.findById(carId).orElseThrow(()->new IllegalStateException("El coche con id " + carId + " no existe"));

        // si la descripción no se deja vacía, no tiene espacios en blanco, tiene algo escrito y no es la misma que antes, se guarda la nueva descripción
        if (description != null &&
                description.length() > 0 &&
                !Objects.equals(car.getDescription(), description)) {
            car.setDescription(description);
        }
        // si el precio es mayor que 0 y no es el mismo que antes, se guarda
        if (price > 0 && !Objects.equals(car.getPrice(), price)) {
            car.setPrice(price);
        }

    }
}
