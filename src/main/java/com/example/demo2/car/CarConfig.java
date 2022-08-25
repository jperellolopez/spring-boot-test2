package com.example.demo2.car;

/*
Usando esta clase añadiremos registros de coches a la tabla Car de la DB
 */

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Year;
import java.util.List;

@Configuration
public class CarConfig {

    @Bean
    CommandLineRunner commandLineRunner(CarRepository repository) {
        return args -> {
            Car coche1 = new Car(
                    "Seat",
                    "Ibiza",
                    "Interior impecable. Exterior con pequeños roces.",
                    "jordi@gmail.com",
                    Year.of(2003),
                    2000
            );

            Car coche2 = new Car(
                    "Seat",
                    "León",
                    "Modelo FR amarillo. Bien cuidado, siempre duerme en garaje",
                    "er_ninio_rasing@gmail.com",
                    Year.of(2006),
                    4000
            );

            Car coche3 = new Car(
                    "Ford",
                    "GT",
                    "Supercoche único, ven y pruébalo",
                    "venta_supercoches_lopez@gmail.com",
                    Year.of(2005),
                    340000
            );

            //inserta en la tabla Car la lista de objetos que elijamos.
            repository.saveAll(
                    List.of(coche1, coche2, coche3)
            );
        };
    }
}
