package edu.udea.gestionllamadas.dto;

import lombok.Getter;
import lombok.Setter;



public class ClienteDto {
    @Getter @Setter private int numeroDocumento;
    @Getter @Setter private String nombre;
    @Getter @Setter private String tipoDocumento;
    @Getter @Setter private String correo;
    @Getter @Setter private String direccion;
    @Getter @Setter private int telefonoFijo;
    @Getter @Setter private int celular;
}
