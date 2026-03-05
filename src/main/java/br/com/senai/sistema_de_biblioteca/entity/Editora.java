package br.com.senai.sistema_de_biblioteca.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Editora {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "O nome fantasia deve ser obrigatorio")
    @Size(max = 150, message = "O nome deve ter no máximo 150 caracteres")
    private String nome_fantasia;

    @NotBlank(message = "O nome da cidade deve ser obrigatorio")
    @Size(max = 100, message = "O nome da cidade deve ter no máximo 100 caracteres")
    private String cidade;

    @OneToMany(mappedBy = "editora")
    private List<Livro> livro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}