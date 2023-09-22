package project.pawsconnect.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.pawsconnect.Modelo.Mascota;
import project.pawsconnect.servicios.ServiciosMascotas;

@RestController
@RequestMapping("/api/pets")
public class ControladorMascota {
    @Autowired
    private ServiciosMascotas.PetService petService;

    // Endpoint para crear una nueva mascota
    @PostMapping("/create")
    public ResponseEntity<?> createPet(@RequestBody Mascota mascota) {
        try {
            // Llama al servicio para guardar la nueva mascota en la base de datos
            Mascota createdPet = petService.createPet(pet);
            return new ResponseEntity<>(createdPet, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la mascota: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para buscar mascotas por raza
    @GetMapping("/search")
    public ResponseEntity<?> searchPets(@RequestParam("breed") String breed) {
        try {
            // Llama al servicio para buscar mascotas por raza
            List<Mascota> pets = petService.findPetsByBreed(breed);
            return new ResponseEntity<>(pets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al buscar mascotas: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Otros endpoints para actualizar, eliminar y obtener mascotas

    // Endpoint para obtener todas las mascotas
    @GetMapping("/all")
    public ResponseEntity<?> getAllPets() {
        try {
            // Llama al servicio para obtener todas las mascotas
            List<Mascota> pets = petService.getAllPets();
            return new ResponseEntity<>(pets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener todas las mascotas: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

