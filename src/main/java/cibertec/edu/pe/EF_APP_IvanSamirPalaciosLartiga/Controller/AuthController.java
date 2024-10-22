package cibertec.edu.pe.EF_APP_IvanSamirPalaciosLartiga.Controller;
import cibertec.edu.pe.EF_APP_IvanSamirPalaciosLartiga.model.Usuario;
import cibertec.edu.pe.EF_APP_IvanSamirPalaciosLartiga.util.JwtUtil;
import cibertec.edu.pe.EF_APP_IvanSamirPalaciosLartiga.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder; // Para manejar la encriptación de contraseñas

    @Autowired
    public AuthController(JwtUtil jwtUtil, UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        if (validarCredenciales(usuario)) {
            return jwtUtil.generateToken(usuario.getCodigo());
        } else {
            throw new RuntimeException("Credenciales inválidas"); // Manejar adecuadamente
        }
    }

    private boolean validarCredenciales(Usuario usuario) {
        // Busca el usuario en la base de datos
        Usuario usuarioEncontrado = usuarioRepository.findByCodigo(usuario.getCodigo());

        // Comprueba si el usuario fue encontrado
        if (usuarioEncontrado != null) {
            // Verifica la contraseña
            return passwordEncoder.matches(usuario.getContraseña(), usuarioEncontrado.getContraseña());
        }
        return false; // Si no se encuentra el usuario o las contraseñas no coinciden
    }
}