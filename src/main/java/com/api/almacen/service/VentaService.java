package com.api.almacen.service;

import com.api.almacen.model.Cliente;
import com.api.almacen.model.Producto;
import com.api.almacen.model.Venta;
import com.api.almacen.repository.IVentaRepository;
import java.time.LocalDate;
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
    
    //Método para obtener venta más alta en un día
    public Venta obtenerVentaMasAltaEnFecha(LocalDate fecha) {
        List<Venta> ventasEnFecha = venRepo.findByFechaVenta(fecha);
        Venta ventaMasAlta = null;
        double maxTotal = Double.MIN_VALUE;

        for (Venta venta : ventasEnFecha) {
            if (venta.getTotal() > maxTotal) {
                maxTotal = venta.getTotal();
                ventaMasAlta = venta;
            }
        }

        return ventaMasAlta;
    }

    public Cliente obtenerClienteDeVentaMasAltaEnFecha(LocalDate fecha) {
        Venta ventaMasAlta = obtenerVentaMasAltaEnFecha(fecha);
        if (ventaMasAlta != null) {
            return ventaMasAlta.getUnCliente();
        }
        return null;
    }

    @Override
    public void findProductosVenta(Long codigoVenta, List<Producto> listaProductos) {
        Venta venta = findVenta(codigoVenta);
        if (venta != null) {
            listaProductos.addAll(venta.getListaProductos());
        }
    }

}
