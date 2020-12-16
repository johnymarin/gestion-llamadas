package edu.udea.estadoSolicitud.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
//FixMe: cannot resolve table clientes why? must i do execute dirty sqlcode? :(
@Table(name="SOLICITUDES")
@Component
public class Solicitud {
    /*private String motivo;
   private String descripcion;
   private String estado;
   private String tiempoMaximoDerespuesta;;
   private String evento;*/
    @Id
    @Getter @Setter private Long numerodeRadicado;
//AQUI SE MAPEA A LA BASE DE DATOS
    @Column
    @Getter @Setter private String motivo;

    @Column
    @Getter @Setter private String descripcion;

    @Column
    @Getter @Setter private String estado;

    @Column
    @Getter @Setter private String tiempoMaximoDerespuesta;

    @Column
    @Getter @Setter private String evento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitud solicitud = (Solicitud) o;
        return numerodeRadicado.equals(solicitud.numerodeRadicado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerodeRadicado);
    }

// ToDo: Ask about the  public boolean object o




}
