package edu.udea.gestionllamadas.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
//FixMe: cannot resolve table clientes why? must i do execute dirty sqlcode? :(
@Table(name="clientes")
@Component
public class Cliente {
    @Id
    @Getter @Setter private Long numeroDocumento;

    @Column
    @Getter @Setter private String nombre;

    @Column
    @Getter @Setter private String tipoDocumento;

    @Column
    @Getter @Setter private String correo;

    @Column
    @Getter @Setter private String direccion;

    @Column
    @Getter @Setter private int telefonoFijo;

    @Column
    @Getter @Setter private int celular;


    // ToDo: Ask about the  public boolean object o


}
