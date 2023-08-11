-- V1__criar_tabela_contato.sql

CREATE TABLE contato
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome          VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL,
    celular       VARCHAR(20)  NOT NULL,
    grupo         VARCHAR(20),
    criado_em     TIMESTAMP,
    atualizado_em TIMESTAMP
);
