package edu.udea.gestionllamadas.controller;

import com.sun.istack.NotNull;
import edu.udea.gestionllamadas.dto.ClienteDto;
import edu.udea.gestionllamadas.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/apiclientes")
//ToDo: validations on controller
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping(consumes = {"application/JSON", "application/XML"})
    public ResponseEntity<ClienteDto> create(@RequestBody ClienteDto clienteDTO){
        ClienteDto clienteACrear = clienteService.create(clienteDTO);
        return new ResponseEntity<ClienteDto>(clienteACrear, null, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClienteDto> update(@RequestBody ClienteDto clienteDTO){
        return ResponseEntity.ok(clienteService.update(clienteDTO));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> findAll(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findById(
            @PathVariable @NotNull Long numeroDocumento
    ){
        return ResponseEntity.ok(clienteService.findById(numeroDocumento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long numeroDocumento){
        clienteService.delete(numeroDocumento);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
