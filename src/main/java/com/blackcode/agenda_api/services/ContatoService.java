package com.blackcode.agenda_api.services;

import com.blackcode.agenda_api.dtos.ContatoRequestDTO;
import com.blackcode.agenda_api.dtos.ContatoResponseDTO;
import com.blackcode.agenda_api.models.Contato;
import com.blackcode.agenda_api.models.enums.Grupo;
import com.blackcode.agenda_api.repositories.ContatoRepository;
import com.blackcode.agenda_api.services.exceptions.RecursoNotFound;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class ContatoService {

    private final ContatoRepository repository;

    @Transactional
    public ContatoResponseDTO create(ContatoRequestDTO dto) {
        var contato = dto.toContato();
        contato = repository.save(contato);

        return new ContatoResponseDTO(contato);
    }

    @Transactional(readOnly = true)
    public List<ContatoResponseDTO> findAll() {
        var contatos = repository.findAll();

        return contatos.stream().map(ContatoResponseDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ContatoResponseDTO findById(Long id) {
        var contato = repository.findById(id)
                .orElseThrow(() -> new RecursoNotFound("Não existe contato com o id " + id));

        return new ContatoResponseDTO(contato);
    }

    @Transactional
    public ContatoResponseDTO update(Long id, ContatoRequestDTO dto) {
        var contato = repository.findById(id)
                .orElseThrow(() -> new RecursoNotFound("Não existe contato com o id " + id));
        BeanUtils.copyProperties(dto, contato, "id");
        contato = repository.save(contato);

        return new ContatoResponseDTO(contato);
    }

    public void delete(Long id) {
        var contato = repository.findById(id)
                .orElseThrow(() -> new RecursoNotFound("Não existe contato com o id " + id));
        repository.delete(contato);
    }

    @Transactional(readOnly = true)
    public List<ContatoResponseDTO> findByGrupo(String grupoValor){
        Grupo grupo = Grupo.valueOf(grupoValor.toUpperCase());

        List<Contato> contatos = repository.findAllByGrupo(grupo);

        return contatos.stream().map(ContatoResponseDTO::new).toList();
    }

}
