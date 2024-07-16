package com.api.almacen.service;

import com.api.almacen.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    public interface IClienteService {
    
    //leer todos los clientes
    public List <Venta> getVentas();
    
    //leer un cliente
    public Venta findVenta(Long id);
    
    //alta
    public void saveVenta(Venta cli);
    
    //baja
    public void deleteVenta(Long id);
    
    //modificación
    public void editVenta(Long codigoVentaOriginal,
                            Long nuevoCodigoVenta,
                            LocalDate nuevaFechaVenta, 
                            double nuevoTotal);
    }
}
