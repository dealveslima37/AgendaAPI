package com.blackcode.agenda_api.controllers;

import com.blackcode.agenda_api.dtos.ContatoRequestDTO;
import com.blackcode.agenda_api.dtos.ContatoResponseDTO;
import com.blackcode.agenda_api.services.ContatoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoService service;

    @PostMapping
    public ResponseEntity<ContatoResponseDTO> create(@RequestBody ContatoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ContatoResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoResponseDTO> update(@PathVariable Long id, @RequestBody ContatoRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/grupos/{grupo}")
    public ResponseEntity<List<ContatoResponseDTO>> findByGroup(@PathVariable String grupo) {
        return ResponseEntity.ok(service.findByGrupo(grupo.toLowerCase()));
    }
}
