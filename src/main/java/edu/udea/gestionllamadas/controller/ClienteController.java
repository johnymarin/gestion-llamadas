package edu.udea.gestionllamadas.controller;

import com.sun.istack.NotNull;
import edu.udea.gestionllamadas.dto.ClienteDto;
import edu.udea.gestionllamadas.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping(path= "/apiclientes")
//ToDo: validations on controller
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @CrossOrigin (origins = "http://localhost:8080", maxAge = 3600)
    @PostMapping(consumes = {"application/JSON", "application/XML"})
    public ResponseEntity<ClienteDto> create(@RequestBody ClienteDto clienteDTO){
        ClienteDto clienteACrear = clienteService.create(clienteDTO);
        return new ResponseEntity<ClienteDto>(clienteACrear, null, HttpStatus.CREATED);
    }

    @CrossOrigin (origins = "http://localhost:8080", maxAge = 3600)
    @PutMapping
    public ResponseEntity<ClienteDto> update(@RequestBody ClienteDto clienteDTO){
        return ResponseEntity.ok(clienteService.update(clienteDTO));
    }

    @CrossOrigin (origins = "http://localhost:8080", maxAge = 3600)
    @GetMapping
    public ResponseEntity<List<ClienteDto>> findAll(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @CrossOrigin (origins = "http://localhost:8080", maxAge = 3600)
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findById(
            @PathVariable @NotNull Long numeroDocumento
    ){
        return ResponseEntity.ok(clienteService.findById(numeroDocumento));
    }

    @CrossOrigin (origins = "http://localhost:8080", maxAge = 3600)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long numeroDocumento){
        clienteService.delete(numeroDocumento);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
