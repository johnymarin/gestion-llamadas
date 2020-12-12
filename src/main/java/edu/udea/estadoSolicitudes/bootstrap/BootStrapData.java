package edu.udea.estadoSolicitudes.bootstrap;

import edu.udea.estadoSolicitudes.repositories.SolicitudRepository;
import edu.udea.estadoSolicitudes.service.Solicitud;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final SolicitudRepository solicitudRepository;//INJECTION DE DEPENDENCIAS

    public BootStrapData(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    @java.lang.Override
    public void run(java.lang.String... args) throws Exception {



        Solicitud solicitud=new Solicitud(878L,"una intermitencia","se presento una intermitencia en la linea por unos cuantos dias para el serviciox.","aprobado","09/09/2021","Se efectuo primera llamada");
    }
}
