package com.blackcode.agenda_api.dtos;

import com.blackcode.agenda_api.models.Contato;
import com.blackcode.agenda_api.models.enums.Grupo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ContatoResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String celular;
    private String grupo;
    private LocalDateTime criadoEm;

    public ContatoResponseDTO(Contato contato) {
        this.id = contato.getId();
        this.nome = contato.getNome();
        this.email = contato.getEmail();
        this.celular = contato.getCelular();
        this.grupo = contato.getGrupo().getDescricao();
        this.criadoEm = contato.getCriadoEm();
    }

}
