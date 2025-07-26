package app.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import app.entity.Carro;
import app.entity.Marca;
import app.repository.CarroRepository;


@Service
public class CarroService {
    
    @Autowired
    private CarroRepository carroRepository;
    
    public String save(Carro carro) {
        this.carroRepository.save(carro);        
        return carro.getNome()+ " salvo com sucesso!";
    }
    
    
    public String update(long id, Carro carro) {
        carro.setId(id);
        this.carroRepository.save(carro);        
        return carro.getNome()+ " atualizado com sucesso!";
    }
    
    
    public String delete(long idCarro) {
        this.carroRepository.deleteById(idCarro);        
        return "Carro deletado com sucesso!";
    }
    
    
    public List<Carro> findAll(){
        List<Carro> lista = this.carroRepository.findAll();
        return lista;
    }
        
    
    public Carro findById(long idCarro) {
        Carro carro = this.carroRepository.findById(idCarro).get();
        return carro;
    }
    
    
    public List<Carro> findByNome(String nome) {
        return this.carroRepository.findByNome(nome);
    }
    
    
    public List<Carro> findByMarca(long idMarca) {
        Marca marca = new Marca();
        marca.setId(idMarca);
	  	return this.carroRepository.findByMarca(marca);
    }
    
    
    public List<Carro> findAcimaAno(int ano){
    	return this.carroRepository.findAcimaAno(ano);
    }
    
    
    
    
    
    
    
    
    
    
}
