package com.api.almacen.service;

import com.api.almacen.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VentaService implements IVentaService{
    
    @Autowired
    private IVentaRepository venRepo;
}
