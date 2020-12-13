package edu.udea.estadoSolicitudes.repositories;

import edu.udea.estadoSolicitudes.service.Solicitud;
import org.springframework.data.repository.CrudRepository;

public interface SolicitudRepository extends CrudRepository<Solicitud,Long> {
}
