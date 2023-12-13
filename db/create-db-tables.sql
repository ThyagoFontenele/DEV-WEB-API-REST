CREATE TABLE eventoapi_db.usuario (
    id int NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    afiliacao VARCHAR(100) NOT NULL,
    administrador tinyint(1) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE eventoapi_db.evento (
    id int NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL, 
    descricao VARCHAR(200) NOT NULL,
    sigla VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE eventoapi_db.edicao (
    id int NOT NULL AUTO_INCREMENT,
    ano SMALLINT NOT NULL, 
    data_inicial datetime NOT NULL,
    data_final datetime NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    evento_id int NOT NULL,
    usuario_id int NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (evento_id) REFERENCES eventoapi_db.evento(id),
    FOREIGN KEY (usuario_id) REFERENCES eventoapi_db.usuario(id)
);

CREATE TABLE eventoapi_db.espaco (
    id int NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    localizacao VARCHAR(100) NOT NULL,
    capacidade int NOT NULL,
    edicao_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (edicao_id) REFERENCES eventoapi_db.edicao(id)
);

CREATE TABLE eventoapi_db.atividade (
    id int NOT NULL AUTO_INCREMENT,
    tipo SMALLINT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    data date NOT NULL,
    horario_inicio time NOT NULL,
    horario_fim time NOT NULL,
    edicao_id int NOT NULL,
    espaco_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (edicao_id) REFERENCES eventoapi_db.edicao(id),
    FOREIGN KEY (espaco_id) REFERENCES eventoapi_db.espaco(id)
);

CREATE TABLE eventoapi_db.usuarios_atividades_favoritas (
  usuario_id int NOT NULL,
  atividade_id int NOT NULL,
  PRIMARY KEY (usuario_id, atividade_id),
  FOREIGN KEY (usuario_id) REFERENCES eventoapi_db.usuario(id),
  FOREIGN KEY (atividade_id) REFERENCES eventoapi_db.atividade(id)
);

CREATE TABLE eventoapi_db.espaco_recursos (
    id int NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(100) NOT NULL,
    espaco_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (espaco_id) REFERENCES eventoapi_db.espaco(id)
);