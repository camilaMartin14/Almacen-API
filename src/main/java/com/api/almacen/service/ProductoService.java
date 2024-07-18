package com.api.almacen.service;

import com.api.almacen.model.Producto;
import com.api.almacen.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private IProductoRepository produRepo;

    @Override
    public List<Producto> getProductos() {
        //obtener lista de Productos y devolverla al controlador
        List <Producto> listaProductos = produRepo.findAll();
        return listaProductos;
    }
    
    @Override
    public Producto findProducto(Long id) {
        Producto prod = produRepo.findById(id).orElse(null);
        return prod;
    }

    @Override
    public void saveProducto(Producto prod) {
        produRepo.save(prod);
    }

    @Override
    public void deleteProducto(Long id) {
        produRepo.deleteById(id);
    }

    @Override
    public void editProducto(Long codigoOriginal, 
                            Long nuevoCodigo,
                            String nuevoNombre, 
                            String nuevaMarca, 
                            double nuevoPrecio, 
                            double nuevaCantidad) {
    
    //Busco objeto original
    Producto prod = this.findProducto(codigoOriginal);

    //modificación a nivel lógico
    prod.setCodigo_producto(nuevoCodigo);
    prod.setCantidad_disponible(nuevaCantidad);
    prod.setMarca(nuevaMarca);
    prod.setNombre(nuevoNombre);
    prod.setPrecio(nuevoPrecio);
    
    //guardar cambios
    this.saveProducto(prod);
    }

    @Override
    public void editProducto(Producto prod) {
        this.saveProducto(prod);
    }
}
