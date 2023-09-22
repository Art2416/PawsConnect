package project.pawsconnect.seguridad;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class Configuracion extends WebSecurityConfigurerAdapter {
    // Configuración de seguridad con JWT
}
