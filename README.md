# Agenda API

A **Agenda API** é uma aplicação de gerenciamento de contatos, desenvolvida em Java com Spring Boot. Ela oferece endpoints REST para criar, recuperar, atualizar e deletar contatos na agenda.

## Tecnologias Utilizadas

- Java
- Spring Boot
    - Spring Data JPA
- H2 Database
- Gradle

## Estrutura do Projeto

O projeto segue uma estrutura de pacotes padrão, organizado em diferentes camadas:

- `src/main/java/com/agenda_api/`
    - `controller/`: Contém os controladores responsáveis por lidar com as requisições HTTP.
    - `dto/`: Data Transfer Objects para modelar as informações trafegadas entre as camadas.
    - `model/`: Define as entidades de domínio da aplicação.
    - `repository/`: Interfaces de repositório para acesso aos dados.
    - `service/`: Lógica de negócio e intermediação entre os controladores e os repositórios.
    - `AgendaApiApplication.java`: Classe de inicialização da aplicação.

## Pré-requisitos

Certifique-se de ter o Java e o Gradle instalados em sua máquina.

## Configuração do Banco de Dados

O projeto utiliza o banco de dados H2 para fins de desenvolvimento. As configurações de conexão podem ser encontradas no arquivo `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:h2:mem:agenda
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
