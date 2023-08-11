package com.blackcode.agenda_api.repositories;

import com.blackcode.agenda_api.models.Contato;
import com.blackcode.agenda_api.models.enums.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    List<Contato> findAllByGrupo(Grupo grupo);

}
