package com.api.almacen.repository;

import com.api.almacen.model.Venta;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

    public static ArrayList<Venta> findByFecha_venta(ArrayList<Venta> listaVentas, LocalDate fechaBusqueda) {
        ArrayList<Venta> ventasFiltradas = new ArrayList<>();
        
        for (Venta venta : listaVentas) {
            // Compara las fechas usando el método equals de la clase Date
            if (venta.getFecha_venta().equals(fechaBusqueda)) {
                ventasFiltradas.add(venta);
            }
        }
        
        return ventasFiltradas;
    }  
    
}
