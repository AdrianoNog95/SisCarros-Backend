package app.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import app.entity.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

	public List<Carro> findByNome(String nome);
	
}



