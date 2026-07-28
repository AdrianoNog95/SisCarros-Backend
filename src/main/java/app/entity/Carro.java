package app.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ForeignKey;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carro")

public class Carro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "Nome do carro não pode ser nulo")
    @Column(length = 20)
    private String nome;
        
     
    //Relacionamento
    @ManyToOne
    @JoinColumn(
	name = "id_marca",
	foreignKey = @ForeignKey(name = "fk_carro_marca"))	
    private Marca marca;
    
       
    @ManyToMany
    @JoinTable(
        name = "carro_acessorio",
        joinColumns = @JoinColumn(
            name = "id_carro",
            foreignKey = @ForeignKey(name = "fk_carro_acessorio_carro")
        ),
        inverseJoinColumns = @JoinColumn(
            name = "id_acessorio",
            foreignKey = @ForeignKey(name = "fk_carro_acessorio_acessorio")
        )
    )
    private List<Acessorio> acessorios;


    //Getters e Setters
    public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public List<Acessorio> getAcessorios() {
		return acessorios;
	}


	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
    
    
 
	
	
	
    
	
	
	
        
   
    
}    