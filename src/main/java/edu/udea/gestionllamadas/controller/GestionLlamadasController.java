package edu.udea.gestionllamadas.controller;

import edu.udea.gestionllamadas.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GestionLlamadasController {

    @Autowired
    private Cliente clienteEntity;

    @RequestMapping (path = "/cliente")
    public Cliente showCliente(@RequestParam(value = "clienteid") Long clienteNumeroDocumento,
                               @RequestParam(value = "cliente", defaultValue = "pepito perez") String cliente){
        clienteEntity.setNumeroDocumento(clienteNumeroDocumento);
        clienteEntity.setNombre(String.format( "el nombre es: %s", cliente));
        return clienteEntity;
    }


}
