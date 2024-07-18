package com.api.almacen.controller;

import com.api.almacen.model.Cliente;
import com.api.almacen.model.Producto;
import com.api.almacen.model.Venta;
import com.api.almacen.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {
        
    @Autowired
    private IVentaService venServ;
    
    //listar
    @GetMapping ("/ventas")
    public List <Venta> getVentas(){
        return venServ.getVentas();
    }
    
    //crear
    @PostMapping ("/ventas/crear")
    public String saveVenta(@RequestBody Venta ven){
        venServ.saveVenta(ven);
        
        return "La venta se creó correctamente";
    }
    //eliminar
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        venServ.deleteVenta(codigo_venta);
        
        return "La venta se borró correctamente";
    }
    
    //modificar
    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editVenta (@PathVariable Long codigo_venta,
            @RequestParam(required = false, name= "codigo_venta") Long nuevoCodigoVenta,
            @RequestParam(required = false, name= "fecha_venta") LocalDate nuevaFechaVenta,
            @RequestParam(required = false, name= "total") double nuevoTotal,
            @RequestParam(required = false, name= "lista_productos") List<Producto> nuevaListaProductos,
            @RequestParam(required = false, name= "ciente") Cliente nuevoCliente){
    
        venServ.editVenta(codigo_venta, 
                            nuevoCodigoVenta,
                            nuevaFechaVenta, 
                            nuevoTotal, 
                            nuevaListaProductos, 
                            nuevoCliente);
        
        Venta ven = venServ.findVenta(nuevoCodigoVenta);
        
        return ven;
    }
    
}

