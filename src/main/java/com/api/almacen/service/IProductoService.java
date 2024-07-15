package com.api.almacen.service;

import com.api.almacen.model.Producto;
import java.util.List;

public interface IProductoService {
    
    //lectura de todos los productos
    public List <Producto> getProductos();
    
    //lectura de un producto puntual
    public Producto findProducto(Long id); 
    
    //alta
    public void saveProducto (Producto prod);
    
    //baja
    public void deleteProducto(Long id);
    
    //modificación
    public void editProducto(Long codigoOriginal, 
                            Long nuevoCodigo,
                            String nuevoNombre, 
                            String nuevaMarca, 
                            double nuevoPrecio,
                            double nuevaCantidad);
}
