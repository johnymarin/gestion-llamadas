package edu.udea.gestionllamadas.service;


import edu.udea.gestionllamadas.dto.ClienteDto;
import edu.udea.gestionllamadas.entity.Cliente;
import edu.udea.gestionllamadas.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private ModelMapper modelMapper;


    public ClienteService( ClienteRepository clienteRepository, ModelMapper modelMapper){
        this.clienteRepository = clienteRepository;
        this.modelMapper = modelMapper;
    }

    public ClienteDto create(ClienteDto clienteACrearDto){

        Cliente clienteACrear = modelMapper.map(clienteACrearDto, Cliente.class);
        Cliente resultado = clienteRepository.save(clienteACrear);
        ClienteDto resultadoDTO = modelMapper.map(resultado, ClienteDto.class);

        return  resultadoDTO;
    }

    public List<ClienteDto> findAll(){
        List<Cliente> listaCliente = (List<Cliente>) clienteRepository.findAll();
        return listaCliente.stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDto.class))
                .collect(Collectors.toList());
    }

    public ClienteDto findById(Long numeroDocumento) {
        Optional<Cliente> encuentraClienteOpcional = clienteRepository.findById(numeroDocumento);
        Cliente encuentraCliente = encuentraClienteOpcional.orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(encuentraCliente, ClienteDto.class);
    }

    public void delete (Long numeroDocumento){
        ClienteDto clienteEnBD = findById(numeroDocumento);
        Cliente clienteABorrar = modelMapper.map(clienteEnBD, Cliente.class);
        clienteRepository.delete(clienteABorrar);
    }

    // ToDo: ask what does this update with the find and create
    public ClienteDto update(ClienteDto clienteDto){
        findById(clienteDto.getNumeroDocumento());
        return create(clienteDto);
    }

}
