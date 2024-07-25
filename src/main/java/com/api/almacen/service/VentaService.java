package com.api.almacen.service;

import com.api.almacen.model.Cliente;
import com.api.almacen.model.Producto;
import com.api.almacen.model.Venta;
import com.api.almacen.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    @Autowired
    private IVentaRepository venRepo;

    @Override
    public List<Venta> getVentas() {
        List <Venta> listaVentas= venRepo.findAll();
        return listaVentas;
    }

    @Override
    public Venta findVenta(Long id) {
        Venta ven = venRepo.findById(id).orElse(null);
        return ven;
    }

    @Override
    public void saveVenta(Venta ven) {
        venRepo.save(ven);
    }

    @Override
    public void deleteVenta(Long id) {
        venRepo.deleteById(id);
    }

    @Override
    public void editVenta(Long codigoVentaOriginal,
                            Long nuevoCodigoVenta, 
                            LocalDate nuevaFechaVenta, 
                            double nuevoTotal, 
                            List<Producto> nuevaListaProductos,
                            Cliente nuevoCliente) {

    Venta ven = this.findVenta(codigoVentaOriginal);

        ven.setCodigo_venta(nuevoCodigoVenta);
        ven.setFecha_venta(nuevaFechaVenta);
        ven.setTotal(nuevoTotal);
        ven.setListaProductos(nuevaListaProductos);
        ven.setUnCliente(nuevoCliente);

       this.saveVenta(ven);
    }

    @Override
    public void editVenta(Venta ven) {
        this.saveVenta(ven);
    }
    
    @Override
    public void findProductosVenta(Long codigoVenta, List<Producto> listaProductos) {
        Venta venta = findVenta(codigoVenta);
        if (venta != null) {
            listaProductos.addAll(venta.getListaProductos());
        }
    }
    
    
    @Override
    public double getTotalMontoVentasEnFecha(LocalDate fecha_venta) {
        List <Venta> listaVentas= venRepo.findAll();
        ArrayList<Venta> ventasEnFecha = IVentaRepository.findByFecha_venta(new ArrayList<>(listaVentas), fecha_venta);
        
        double totalMonto = 0.0;
        for (Venta venta : ventasEnFecha) {
            totalMonto += venta.getTotal();
        }
    
        return totalMonto;
    }

    @Override
    public int getCantidadVentasEnFecha(LocalDate fecha_venta) {
        List <Venta> listaVentas= venRepo.findAll();
        ArrayList<Venta> ventasEnFecha = IVentaRepository.findByFecha_venta(new ArrayList<>(listaVentas), fecha_venta);
        
        return ventasEnFecha.size();     
    }
    
}
