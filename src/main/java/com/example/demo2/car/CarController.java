package com.example.demo2.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;

//RequestMapping = ruta en la que se ejecutan los métodos de la clase
@RestController
@RequestMapping(path = "api/car")
public class CarController {

    // Referencia a la clase CarService. con Autowired se creará una instancia y se inyectará al constructor de abajo. Para que Spring sepa qué clase CarService debe instanciar, hay que usar la anotación Service en la clase CarService.
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    // Llama al método getCars de la clase CarService.
    // Devuelve un array de objetos Car, que saldrán en el navegador al ejecutar la aplicación en localhost:8080/api/car.

    @GetMapping
    public List<Car> getCars() {
        return carService.getCars();
    }

    // método que hace una POST request para añadir datos nuevos. Si el email del vendedor ya existe, dará un error. Si no, lo guardará en la BD. Está lógica se hace en la clase CarService. Esto permite insertar nuevos registros desde el cliente (postman). Por ej:
    /*
    {
        "brand": "Ferrari",
            "model": "F50",
            "description": "Color rojo",
            "sellerEmail": "ferrari@hotmail.com",
            "manufacturingYear": "1999",
            "price": 200000
    }
     */
    // requestBody coge el body que se le ha pasado y lo mapea a un objeto Car
    @PostMapping
    public void registerNewCar(@RequestBody Car car) {
        carService.addNewCar(car);
    }

    //método para borrar coches por una id. Si se le envía una DELETE request desde Postman con el id 2 (http://localhost:8080/api/car/2) borraría el coche núm 2
    @DeleteMapping(path = "{carId}")
    public void deleteCar(@PathVariable ("carId") Long carId) {
        carService.deleteCar(carId);
    }

    //método para editar los campos de descripción y precio de un coche con una PUT request
    // los cambios se los podemos pasar como parámetros en la url, por ej para cambiar el precio del coche con id 2 de 4000 a 3500: "api/car/2?price=3500"
    @PutMapping(path = "{carId}")
    public void updateCar(@PathVariable("carId") Long carId, @RequestParam(required = false) String description, @RequestParam(required = false) int price) {
        carService.updateCar(carId, description, price);
    }


}
