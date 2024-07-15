package com.api.almacen.repository;

import com.api.almacen.model.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{

    public List<Producto> findAll();
    
}
