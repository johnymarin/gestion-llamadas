package edu.udea.estadoSolicitud.repository;

import edu.udea.estadoSolicitud.entity.Solicitud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudRepository extends CrudRepository<Solicitud ,Long> {
}
