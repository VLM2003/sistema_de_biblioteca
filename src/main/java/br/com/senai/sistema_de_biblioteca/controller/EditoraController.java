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

import br.com.senai.sistema_de_biblioteca.entity.Editora;
import br.com.senai.sistema_de_biblioteca.exception.Response;
import br.com.senai.sistema_de_biblioteca.repository.EditoraRepository;

@RestController
@RequestMapping("/Editores")
public class EditoraController {
    
    @Autowired
    private EditoraRepository repository;

    @PostMapping
    public Response criaAutor(@RequestBody Editora editora) {
        repository.save(editora);
        return new Response(201, "Editora criado com sucesso");
    }
    
    @GetMapping
    public List<Editora> retornaTodos() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizaEditora(@PathVariable Long id, @RequestBody Editora entity) {
        if (!repository.existsById(id)) {
            return new Response(404, "Editora não encontrado");
        }
        
        Editora editoraAntigo = repository.findById(id).get();

        
        if (entity.getNome_fantasia() != null) {
            editoraAntigo.setNome_fantasia(entity.getNome_fantasia());
        }

        if (entity.getCidade() != null) {
            editoraAntigo.setCidade(entity.getCidade());
        }

        repository.save(editoraAntigo);

        return new Response(200, "Editora atualizado!");
    }

    @DeleteMapping("/{id}")
    public Response deleteEditora(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Editora não encontrado");
        }

        repository.deleteById(id);

        return new Response(204, "Editora deletado");
    }

}