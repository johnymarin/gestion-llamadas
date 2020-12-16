package edu.udea.estadoSolicitud.service;

import edu.udea.estadoSolicitud.dto.SolicitudDto;
import edu.udea.estadoSolicitud.entity.Solicitud;
import edu.udea.estadoSolicitud.repository.SolicitudRepository;
import edu.udea.gestionllamadas.dto.ClienteDto;
import edu.udea.gestionllamadas.entity.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;


@Service
public class SolicitudService {
    private SolicitudRepository solicitudRepository;
    private ModelMapper modelMapper;


    public SolicitudService( SolicitudRepository solicitudpository, ModelMapper modelMapper){
        this.solicitudRepository = solicitudpository;
        this.modelMapper = modelMapper;
    }

    public SolicitudDto create(SolicitudDto nuevaSolicitud){
        Solicitud nueva = modelMapper.map(nuevaSolicitud, Solicitud.class);
        Solicitud resultado = solicitudRepository.save(nueva);// ANTES ERA ASI
        SolicitudDto resultadoDTO = modelMapper.map(resultado,  SolicitudDto.class);

        return  resultadoDTO;
    }



    public SolicitudDto findById(Long numerodeRadicado)
    {
        Optional<Solicitud> encuentra = solicitudRepository.findById(numerodeRadicado);
        Solicitud encuentraSolicitud = encuentra.orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(encuentraSolicitud, SolicitudDto.class);
    }



    // ToDo: ask what does this update with the find and create
    public SolicitudDto update(SolicitudDto SolicitudDto){
        findById(SolicitudDto.getNumerodeRadicado());
        return create(SolicitudDto);
    }

}
