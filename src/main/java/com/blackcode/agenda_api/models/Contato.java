package com.blackcode.agenda_api.models;

import com.blackcode.agenda_api.models.enums.Grupo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Contato {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String celular;

    @Enumerated(EnumType.STRING)
    private Grupo grupo;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Contato(String nome, String email, String celular, Grupo grupo) {
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.grupo = grupo;
    }

    @PrePersist
    public void prePersist() {
        this.criadoEm = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.atualizadoEm = LocalDateTime.now();
    }

}
