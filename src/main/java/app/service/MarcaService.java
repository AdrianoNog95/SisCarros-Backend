package app.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import app.entity.Marca;
import app.repository.MarcaRepository;


@Service
public class MarcaService {
    
    @Autowired
    private MarcaRepository marcaRepository;
    
    public String save(Marca marca) {
        this.marcaRepository.save(marca);        
        return marca.getNome()+ " salvo com sucesso!";
    }
    
    
    public String update(Integer id, Marca marca) {
        marca.setId(id);
        this.marcaRepository.save(marca);        
        return marca.getNome()+ " atualizado com sucesso!";
    }
    
    
    public List<Marca> listAll(){
        return this.marcaRepository.findAll();
    }
    
    
    public Marca findById(Integer idMarca) {
        Marca marca = this.marcaRepository.findById(idMarca).get();
        return marca;
    }
    
        
    public String delete(Integer idMarca) {
        this.marcaRepository.deleteById(idMarca);        
        return " deletado com sucesso!";
    }    
    
    
     
      
    
}
