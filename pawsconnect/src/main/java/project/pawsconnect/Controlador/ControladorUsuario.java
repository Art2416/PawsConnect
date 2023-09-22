package project.pawsconnect.Controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.pawsconnect.Modelo.Mascota;
import project.pawsconnect.Modelo.Usuario;
import project.pawsconnect.servicios.ServiciosMascotas;
@RestController
@RequestMapping("/api/users")
public class ControladorUsuario {
    @Autowired
    private UserService userService;

    // Endpoint para registrar un nuevo usuario
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Usuario user) {
        try {
            // Llama al servicio para registrar un nuevo usuario
            Usuario registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar usuario: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para iniciar sesión de un usuario
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Usuario user) {
        try {
            // Llama al servicio para verificar las credenciales del usuario y generar un token JWT
            String jwtToken = userService.loginUser(user.getUsername(), user.getPassword());

            // Devuelve el token JWT como respuesta
            return new ResponseEntity<>(Collections.singletonMap("token", jwtToken), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al iniciar sesión: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    // Otros endpoints para actualizar, eliminar y obtener información de usuarios

    // Endpoint para obtener información de un usuario por su ID
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        try {
            // Llama al servicio para obtener información del usuario por su ID
            Usuario user = userService.getUserById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener información del usuario: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
