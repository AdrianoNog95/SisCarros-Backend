package app.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;



import app.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByUsername(String username);
	
}



