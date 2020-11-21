package edu.udea.gestionllamadas.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class Cliente {
    @Getter @Setter private int numeroDocumento;
    @Getter @Setter private String nombre;
    @Getter @Setter private String tipoDocumento;
    @Getter @Setter private String correo;
    @Getter @Setter private String direccion;
    @Getter @Setter private int telefonoFijo;
    @Getter @Setter private int celular;


}
