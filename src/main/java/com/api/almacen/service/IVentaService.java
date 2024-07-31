package com.api.almacen.service;

import com.api.almacen.model.Cliente;
import com.api.almacen.model.Producto;
import com.api.almacen.model.Venta;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface IVentaService {
    
    public List <Venta> getVentas();
    
    public Venta findVenta(Long id);
    
    public void saveVenta(Venta cli);
    
    public void deleteVenta(Long id);

    public void editVenta(Long codigoVentaOriginal,
                            Long nuevoCodigoVenta,
                            LocalDate nuevaFechaVenta, 
                            double nuevoTotal,
                            List<Producto> nuevaListaProductos,
                            Cliente nuevoCliente);

    public void editVenta(Venta ven);
   
    public void findProductosVenta(Long codigoVenta, List<Producto> listaProductos);
    
    public double getTotalMontoVentasEnFecha(LocalDate fecha);

    public int getCantidadVentasEnFecha(LocalDate fecha);

    public ArrayList<Venta> findByFecha_venta(ArrayList<Venta> listaVentas, LocalDate fechaBusqueda);
}

