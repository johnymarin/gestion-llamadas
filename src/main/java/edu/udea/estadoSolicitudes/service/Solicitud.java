package edu.udea.estadoSolicitudes.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solicitud {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long numeroRadicado;

    private String motivo;
    private String descripcion;
    private String estado;
    private String tiempoMaximoDerespuesta;
    private String evento;

    public Solicitud(Long numeroRadicado, String motivo, String descripcion, String estado,  String evento) {
        this.numeroRadicado = numeroRadicado;
        this.motivo = motivo;
        this.descripcion = descripcion;
        this.estado = estado;

        this.evento = evento;
    }

    public Long getNumeroRadicado() {
        return numeroRadicado;
    }

    public void setNumeroRadicado(Long numeroRadicado) {
        this.numeroRadicado = numeroRadicado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }





    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    @java.lang.Override//JUST TO DISPLAY DE OBJECT
    public java.lang.String toString() {
        return "Solicitud{" +
                "numeroRadicado=" + numeroRadicado +
                ", motivo='" + motivo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", tiempoMaximoDerespuesta=" + tiempoMaximoDerespuesta +
                ", evento='" + evento + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Solicitud solicitud = (Solicitud) object;
        return numeroRadicado == solicitud.numeroRadicado;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), numeroRadicado);
    }
}
