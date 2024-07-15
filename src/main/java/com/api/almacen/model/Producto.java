package com.api.almacen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Producto {
    @Id
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private double precio;
    private double cantidad_disponible;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, double precio, double cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.cantidad_disponible = cantidad_disponible;
    }
    
}
