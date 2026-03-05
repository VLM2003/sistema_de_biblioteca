package br.com.senai.sistema_de_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.sistema_de_biblioteca.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
    
}