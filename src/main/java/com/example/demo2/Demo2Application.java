package com.example.demo2;

/*
--- Directorios de la aplicación
Carpeta resources > static y templates = contienen la parte de frontend ( JS, CSS, HTML, etc).
Archivo application.properties = Contiene la configuración de la aplicación
Carpeta Java = contiene el código de Java
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Con RestController indicamos que la clase se tiene que tratar como un controlador
@SpringBootApplication
@RestController
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

	/* Muestra un mensaje en la página principal (localhost:8080) mientras la aplicación se esté ejecutando. GetMapping hace referencia a la ruta principal, sin añadir ningún endpoint (se añaden en la clase CarController mediante RequestMapping)
	 */
	@GetMapping
	public String hello() {
	    return "Bienvenid@ a este servicio de venta de coches de segunda mano";
	}

}
