package br.com.senai.sistema_de_biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.senai.sistema_de_biblioteca.entity.Autor;
import br.com.senai.sistema_de_biblioteca.exception.Response;
import br.com.senai.sistema_de_biblioteca.repository.AutorRepository;


@RestController
@RequestMapping("/Autores")
public class AutorController {
    
    @Autowired
    private AutorRepository repository;

    @PostMapping
    public Response criaAutor(@RequestBody Autor autor) {
        repository.save(autor);
        return new Response(201, "Autor criado com sucesso");
    }
    
    @GetMapping
    public List<Autor> retornaTodos() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizaAutor(@PathVariable Long id, @RequestBody Autor entity) {
        if (!repository.existsById(id)) {
            return new Response(404, "Autor não encontrado");
        }
        
        Autor autorAntigo = repository.findById(id).get();

        
        if (entity.getNome() != null) {
            autorAntigo.setNome(entity.getNome());
        }

        if (entity.getNacionalidade() != null) {
            autorAntigo.setNacionalidade(entity.getNacionalidade());
        }

        repository.save(autorAntigo);

        return new Response(200, "Autor atualizado!");
    }

    @DeleteMapping("/{id}")
    public Response deleteAutor(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Autor não encontrado");
        }

        repository.deleteById(id);

        return new Response(204, "Autor deletado");
    }

}