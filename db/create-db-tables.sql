CREATE DATABASE EventoApi;

CREATE TABLE EventoApi.Evento (
    id int NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL, 
    descricao VARCHAR(200) NOT NULL,
    sigla VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE EventoApi.Usuario (
    id int NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    afiliacao VARCHAR(100) NOT NULL,
    administrador tinyint(1) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE EventoApi.Edicao (
    id int NOT NULL AUTO_INCREMENT,
    ano SMALLINT NOT NULL, 
    dataInicial datetime NOT NULL,
    dataFinal datetime NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    eventoId int NOT NULL,
    organizadorId int NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (eventoId) REFERENCES EventoApi.Evento(id),
    FOREIGN KEY (organizadorId) REFERENCES EventoApi.Usuario(id)
);

CREATE TABLE EventoApi.Atividade (
    id int NOT NULL AUTO_INCREMENT,
    tipo SMALLINT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    [local] VARCHAR(100) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    [data] date NOT NULL,
    horarioInicial time NOT NULL,
    horarioFinal time NOT NULL,
    edicaoId int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (edicaoId) REFERENCES EventoApi.Edicao(id)
);

CREATE TABLE EventoApi.Espaco (
    id int NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    [localizacao] VARCHAR(100) NOT NULL,
    capacidade int NOT NULL,
    edicaoId int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (edicaoId) REFERENCES EventoApi.Edicao(id)
);

CREATE TABLE EventoApi.UsuariosAtividadesFavoritas (
  usuarioId int NOT NULL,
  atividadeId int NOT NULL,
  PRIMARY KEY (usuarioId, atividadeId),
  FOREIGN KEY (usuarioId) REFERENCES EventoApi.Usuario(id),
  FOREIGN KEY (atividadeId) REFERENCES EventoApi.Atividade(id)
);

CREATE TABLE EventoApi.EspacoRecursos (
    id int NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(100) NOT NULL,
    espacoId int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (espacoId) REFERENCES EventoApi.Espaco(id)
);