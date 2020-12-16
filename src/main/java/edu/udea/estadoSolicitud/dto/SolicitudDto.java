package edu.udea.estadoSolicitud.dto;

import lombok.Getter;
import lombok.Setter;

// ToDo: Add Validators to DTO.

public class SolicitudDto {

    @Getter @Setter private Long numerodeRadicado;
    @Getter @Setter  private String motivo;
    @Getter @Setter  private String descripcion;
    @Getter @Setter   private String estado;
    @Getter @Setter   private String tiempoMaximoDerespuesta;
    @Getter @Setter  private String evento;
}
