package com.blackcode.agenda_api.dtos;

import com.blackcode.agenda_api.models.Contato;
import com.blackcode.agenda_api.models.enums.Grupo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContatoRequestDTO {
    private String nome;
    private String email;
    private String celular;
    private Grupo grupo;

    public Contato toContato() {
        var contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setCelular(celular);
        contato.setGrupo(grupo);

        return contato;
    }

}
