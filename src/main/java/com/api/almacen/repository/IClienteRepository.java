package com.api.almacen.repository;

import com.api.almacen.model.Cliente;
//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
    
    //public List<Cliente> findAll();
}
