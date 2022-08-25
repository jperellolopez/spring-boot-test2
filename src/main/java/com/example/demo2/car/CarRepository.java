package com.example.demo2.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//la interfaz JpaRepository que se está implementando ya contiene los métodos necesarios para obtener la lista de elementos de la DB
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    // la query que hace para encontrar el objeto coche con el mail introducido
    @Query("SELECT c FROM Car c WHERE c.sellerEmail = ?1")
    Optional<Car> findCarByEmail(String email);

}
