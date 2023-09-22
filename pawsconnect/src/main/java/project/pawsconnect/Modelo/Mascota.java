package project.pawsconnect.Modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pets")
public class Mascota {
    @Id
    private String id;
    private String name;
    private String breed;
    private int age;
    // Otros campos y métodos de acceso
}
