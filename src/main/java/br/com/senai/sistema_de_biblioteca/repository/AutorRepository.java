package br.com.senai.sistema_de_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.sistema_de_biblioteca.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
    
}