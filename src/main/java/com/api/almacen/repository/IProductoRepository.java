package com.api.almacen.repository;

import com.api.almacen.model.Producto;
import java.util.List;

public interface IProductoRepository {

    public List<Producto> findAll();
    
}
