package project.pawsconnect.servicios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import project.pawsconnect.Modelo.Mascota;

public class ServiciosMascotas {
    @Service
    public class PetService {
        // Lógica de negocio para mascotas
    }

    @Repository
    public interface PetRepository extends MongoRepository<Mascota, String> {
        // Métodos personalizados para acceso a datos
    }

}
