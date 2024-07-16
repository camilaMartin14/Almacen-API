package com.api.almacen.service;

import com.api.almacen.model.Cliente;
import com.api.almacen.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    private IClienteRepository cliRepo;

    @Override
    public List<Cliente> getClientes() {
        List <Cliente> listaClientes= cliRepo.findAll();
        return listaClientes;
    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente cli = cliRepo.findById(id).orElse(null);
        return cli;
    }

    @Override
    public void saveCliente(Cliente cli) {
        cliRepo.save(cli);

    }

    @Override
    public void deleteCliente(Long id) {
        cliRepo.deleteById(id);

    }

    @Override
    public void editCliente(Long idOriginal, 
                            Long nuevaId, 
                            String nuevoNombre, 
                            String nuevoApellido, 
                            String nuevoDni) {
        
        Cliente cli= this.findCliente(idOriginal);
        
        cli.setId_cliente(nuevaId);
        cli.setNombre(nuevoNombre);
        cli.setApellido(nuevoApellido);
        cli.setDni(nuevoDni);
        
        this.saveCliente(cli);
    }
    
}
