package com.api.almacen.service;

import com.api.almacen.model.Cliente;
import java.util.List;

public interface IClienteService {
    
    //leer todos los clientes
    public List <Cliente> getClientes();
    
    //leer un cliente
    public Cliente findCliente(Long id);
    
    //alta
    public void saveCliente(Cliente cli);
    
    //baja
    public void deleteCliente(Long id);
    
    //modificación
    public void editCliente(Long idOriginal,
                            Long nuevaId,
                            String nuevoNombre, 
                            String nuevoApellido, 
                            String nuevoDni);

    public void editCliente(Cliente cli);
}
