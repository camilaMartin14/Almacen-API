package com.api.almacen.model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Venta {
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private double total;
    
}
