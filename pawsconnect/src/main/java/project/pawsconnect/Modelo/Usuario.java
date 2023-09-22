package project.pawsconnect.Modelo;

import org.springframework.data.annotation.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    }

}
