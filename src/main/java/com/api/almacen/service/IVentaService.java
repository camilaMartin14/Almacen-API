package com.api.almacen.service;

import com.api.almacen.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    
    public List <Venta> getVentas();
    
    public Venta findVenta(Long id);
    
    public void saveVenta(Venta cli);
    
    public void deleteVenta(Long id);

    public void editVenta(Long codigoVentaOriginal,
                            Long nuevoCodigoVenta,
                            LocalDate nuevaFechaVenta, 
                            double nuevoTotal);
}

