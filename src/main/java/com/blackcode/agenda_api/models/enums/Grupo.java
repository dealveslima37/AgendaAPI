package com.blackcode.agenda_api.models.enums;

public enum Grupo {

    AMIGOS("Amigos"),
    FAMILIA("Família"),
    TRABALHO("Trabalho"),
    ESCOLA("Escola"),
    INTERNET("Internet"),
    IGREJA("Igreja");

    private final String descricao;

    Grupo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
