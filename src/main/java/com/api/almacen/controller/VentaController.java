package com.api.almacen.controller;

import com.api.almacen.model.Cliente;
import com.api.almacen.model.Producto;
import com.api.almacen.model.Venta;
import com.api.almacen.service.IVentaService;
import com.api.almacen.service.VentaService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    
    @Autowired
    private VentaService ventaService;
    
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
    
    //modificar, pudiendo cambiar id original
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
    
    //modificar, considerando que el id original es intocable
    @PutMapping("/ventas/editar")
    public Venta editVenta(@RequestBody Venta ven){
        venServ.editVenta(ven);
        
        return venServ.findVenta(ven.getCodigo_venta());
    }
    
    //encontrar venta más alta en un día específico y el cliente de esa venta
    @GetMapping("/ventas/mayor_venta")
    public String obtenerVentaMasAltaEnFecha(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        Venta ventaMasAlta = ventaService.obtenerVentaMasAltaEnFecha(fecha);
        Cliente clienteDeVentaMasAlta = ventaService.obtenerClienteDeVentaMasAltaEnFecha(fecha);

        if (ventaMasAlta != null && clienteDeVentaMasAlta != null) {
            // Aquí puedes devolver los datos como necesites
            return "La venta más alta fue de: " + ventaMasAlta +
                            ". El cliente con la compra más alta fue: " + 
                            clienteDeVentaMasAlta + ".";
        } else {
            return "No se  encontró la venta más alta de ese día";
        }
    }
    
    //listar productos de una venta
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> findProductosVenta(@PathVariable Long codigo_venta) {
        List<Producto> productosVenta = new ArrayList<>();
        venServ.findProductosVenta(codigo_venta, productosVenta);
        return productosVenta;
    }
}
