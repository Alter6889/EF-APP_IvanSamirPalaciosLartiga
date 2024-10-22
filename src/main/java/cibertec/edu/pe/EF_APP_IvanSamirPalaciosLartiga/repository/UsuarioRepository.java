package cibertec.edu.pe.EF_APP_IvanSamirPalaciosLartiga.repository;
import cibertec.edu.pe.EF_APP_IvanSamirPalaciosLartiga.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByCodigo(String codigo);
}
