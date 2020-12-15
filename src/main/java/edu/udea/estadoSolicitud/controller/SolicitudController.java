package edu.udea.estadoSolicitud.controller;

import com.sun.istack.NotNull;
import edu.udea.estadoSolicitud.dto.SolicitudDto;
import edu.udea.estadoSolicitud.service.SolicitudService;
import edu.udea.gestionllamadas.dto.ClienteDto;
import edu.udea.gestionllamadas.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin (origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping(path= "/solicitudes")
//ToDo: validations on controller
public class SolicitudController {

    private SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService){
        this.solicitudService= solicitudService;
    }

   /* @PostMapping(consumes = {"application/JSON", "application/XML"})
    public ResponseEntity<SolicitudDto> create(@RequestBody SolicitudDto SolicitudDTO){
        SolicitudDto clienteACrear = clienteService.create(clienteDTO);
        return new ResponseEntity<SolicitudDto>(clienteACrear, null, HttpStatus.CREATED);
    }*/
   @CrossOrigin (origins = "http://localhost:8080", maxAge = 3600)
    @PutMapping
    public ResponseEntity<SolicitudDto> update(@RequestBody SolicitudDto solicitudDTO){
        return ResponseEntity.ok(solicitudService.update(solicitudDTO));
    }



    @CrossOrigin (origins = "http://localhost:8080", maxAge = 3600)
    @GetMapping("/{id}")
    public ResponseEntity<SolicitudDto> findById(
            @PathVariable @NotNull Long numerodeRadicado
    ){
        return ResponseEntity.ok(solicitudService.findById(numerodeRadicado));
    }



}
