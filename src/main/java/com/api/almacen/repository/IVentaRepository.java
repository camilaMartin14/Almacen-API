package com.api.almacen.repository;

import com.api.almacen.model.Venta;
//import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

    public List<Venta> findAll();

    //public List<Venta> findByFecha_venta(LocalDate fecha_venta);
}
