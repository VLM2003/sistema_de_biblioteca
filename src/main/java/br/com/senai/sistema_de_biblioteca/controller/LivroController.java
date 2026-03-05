package br.com.senai.sistema_de_biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.sistema_de_biblioteca.entity.Livro;
import br.com.senai.sistema_de_biblioteca.exception.Response;
import br.com.senai.sistema_de_biblioteca.repository.LivroRepository;

@RestController
@RequestMapping("/Livros")
public class LivroController {
    
    @Autowired
    private LivroRepository repository;

    @PostMapping
    public Response criaAutor(@RequestBody Livro livro) {
        repository.save(livro);
        return new Response(201, "Livro criado com sucesso");
    }
    
    @GetMapping
    public List<Livro> retornaTodos() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizaLivro(@PathVariable Long id, @RequestBody Livro entity) {
        if (!repository.existsById(id)) {
            return new Response(404, "Livro não encontrado");
        }
        
        Livro livroAntigo = repository.findById(id).get();

        
        if (entity.getTitulo() != null) {
            livroAntigo.setTitulo(entity.getTitulo());
        }

        if (entity.getAno_de_publicacao() != null) {
            livroAntigo.setAno_de_publicacao(entity.getAno_de_publicacao());
        }

        repository.save(livroAntigo);

        return new Response(200, "Livro atualizado!");
    }

    @DeleteMapping("/{id}")
    public Response deleteLivro(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Livro não encontrado");
        }

        repository.deleteById(id);

        return new Response(204, "Livro deletado");
    }

}
