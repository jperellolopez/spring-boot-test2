package com.example.demo2.car;

import javax.persistence.*;
import java.time.Year;

/*
Listado de coches de 2da mano a la venta.
Los coches tienen: un id único, una marca, un modelo, un email asociado al vendedor, un año de fabricación, un precio de venta y una pequeña descripción.
 */

// las anotaciones Entity y Table indican que se quiere crear una tabla en la BD a partir de esta definición de objetos Car
@Entity
@Table
public class Car {
    //generador de secuencias
    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )
    private Long id;
    private String brand;
    private String model;
    private String description;
    private String sellerEmail;
    private Year manufacturingYear;
    private Integer price;

    //constructor vacío
    public Car() {
    }

    //constructor sin el id, ya que la BD lo genera
    public Car(String brand, String model, String description, String sellerEmail, Year manufacturingYear, Integer price) {
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.sellerEmail = sellerEmail;
        this.manufacturingYear = manufacturingYear;
        this.price = price;
    }

    //constructor completo
    public Car(Long id, String brand, String model, String description, String sellerEmail, Year manufacturingYear, Integer price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.sellerEmail = sellerEmail;
        this.manufacturingYear = manufacturingYear;
        this.price = price;
    }

    //getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public Year getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(Year manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    // método toString
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", sellerEmail='" + sellerEmail + '\'' +
                ", manufacturingYear=" + manufacturingYear +
                ", price=" + price +
                '}';
    }
}
