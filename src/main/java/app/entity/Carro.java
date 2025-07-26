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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinTable;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carro")

public class Carro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id") //Nome do campo no banco de dados
    private long id;
    
    @NotNull(message = "Nome não pode ser nulo")
    @Column(length = 20)
    private String nome;
    
    @NotNull(message = "Modelo não pode ser nulo")
    @Column(length = 20)
    private String modelo;
    
    private int ano;
    
    
    //Relacionamento
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("carros")
    private Marca marca;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="carro_proprietario")
    private List<Proprietario> proprietarios;
    
    
    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Proprietario> getProprietarios() {
        return proprietarios;
    }

    public void setProprietarios(List<Proprietario> proprietarios) {
        this.proprietarios = proprietarios;
    }

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
    
    
    
    
   
    
}    