package br.com.senai.sistema_de_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.sistema_de_biblioteca.entity.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Long>{
    
}