package com.api.almacen.controller;

import com.api.almacen.model.Producto;
import com.api.almacen.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService prodServ;
    
    //listar
    @GetMapping ("/productos")
    public List <Producto> getProductos(){
        return prodServ.getProductos();
    }
    
    //crear
    @PostMapping ("/productos/crear")
    public String saveProducto (@RequestBody Producto prod){
        prodServ.saveProducto(prod);
        
        return "El producto se creó correctamente";
    }
    //eliminar
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        prodServ.deleteProducto(codigo_producto);
        
        return "El producto se borró correctamente";
    }
    
    //modificar
    @PutMapping("/productos/editar/{codigoOriginal}")
    public Producto editProducto (@PathVariable Long codigoOriginal,
            @RequestParam(required = false, name= "codigo_producto") Long nuevoCodigo,
            @RequestParam(required = false, name= "nombre") String nuevoNombre,
            @RequestParam(required = false, name= "marca") String nuevaMarca,
            @RequestParam(required = false, name= "precio") double nuevoPrecio,
            @RequestParam(required = false, name= "cantidad_disponible") double nuevaCantidad){
    
        prodServ.editProducto(codigoOriginal, 
                                nuevoCodigo, 
                                nuevoNombre, 
                                nuevaMarca, 
                                nuevoPrecio, 
                                nuevaCantidad);
        
        Producto prod = prodServ.findProducto(nuevoCodigo);
        
        return prod;
    }
    
    //modificar, considerando que el id original es intocable
    @PutMapping("/productos/editar")
    public Producto editProducto(@RequestBody Producto prod){
        prodServ.editProducto(prod);
        
        return prodServ.findProducto(prod.getCodigo_producto());
    }
    
}
