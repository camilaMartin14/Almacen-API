package com.api.almacen.model;

import jakarta.persistence.Entity;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Venta {
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private double total;
    
}
