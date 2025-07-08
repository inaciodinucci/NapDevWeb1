package br.ufra.edu.napdevweb.controller;

import br.ufra.edu.napdevweb.model.Disciplina;
import br.ufra.edu.napdevweb.repository.DisciplinaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaRepository repository;

    @GetMapping
    public List<Disciplina> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Disciplina> criar(@Valid @RequestBody Disciplina disciplina) {
        Disciplina salva = repository.save(disciplina);
        return ResponseEntity.status(201).body(salva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizar(@PathVariable Long id, @Valid @RequestBody Disciplina nova) {
        return repository.findById(id)
                .map(d -> {
                    d.setNome(nova.getNome());
                    d.setProfessor(nova.getProfessor());
                    d.setIndice(nova.getIndice());
                    d.setCodigo(nova.getCodigo());
                    repository.save(d);
                    return ResponseEntity.ok(d);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
} 