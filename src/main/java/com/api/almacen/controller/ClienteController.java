package com.api.almacen.controller;

import com.api.almacen.model.Cliente;
import com.api.almacen.service.IClienteService;
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
public class ClienteController {
    @Autowired
    private IClienteService cliServ;
    
    //listar
    @GetMapping ("/clientes")
    public List <Cliente> getClientes(){
        return cliServ.getClientes();
    }
    
    //crear
    @PostMapping ("/clientes/crear")
    public String saveCliente (@RequestBody Cliente cli){
        cliServ.saveCliente(cli);
        
        return "El cliente se creó correctamente";
    }
    
    //eliminar
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        cliServ.deleteCliente(id_cliente);
        
        return "El cliente se borró correctamente";
    }

    //modificar
    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editCliente (@PathVariable Long id_cliente,
            @RequestParam(required = false, name= "codigo_producto") Long nuevaId,
            @RequestParam(required = false, name= "nombre") String nuevoNombre,
            @RequestParam(required = false, name= "marca") String nuevoApellido,
            @RequestParam(required = false, name= "precio") String nuevoDni){
            
        cliServ.editCliente(id_cliente, 
                            nuevaId, 
                            nuevoNombre, 
                            nuevoApellido, 
                            nuevoDni);
        
        Cliente cli = cliServ.findCliente(nuevaId);
        
        return cli;
    }
}
