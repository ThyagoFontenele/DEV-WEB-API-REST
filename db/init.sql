insert into usuario values (null, 'Thyago Fontenele', 'thyago@gmail.com', '123456', 'adms', 1);
insert into usuario values (null, 'Lucca Franca', 'lucca@gmail.com', '123456', 'adms', 1);
insert into usuario values (null, 'Patrick Sasso', 'patrick@gmail.com', '123456', 'adms', 0);
insert into usuario values (null, 'Daniel Carvalho', 'daniel@gmail.com', '123456', 'adms', 0);

INSERT INTO eventoapi_db.evento (nome, descricao, sigla) VALUES
('Evento A', 'Descrição do Evento A', 'EA'),
('Evento B', 'Descrição do Evento B', 'EB');

INSERT INTO eventoapi_db.edicao (ano, data_inicial, data_final, cidade, evento_id, usuario_id) VALUES
(2022, '2022-01-01 00:00:00', '2022-01-10 23:59:59', 'Cidade A', 1, 1),
(2023, '2023-02-01 00:00:00', '2023-02-10 23:59:59', 'Cidade B', 2, 2);

INSERT INTO eventoapi_db.espaco (nome, localizacao, capacidade, edicao_id) VALUES
('Salão Principal', 'Local A', 200, 1),
('Sala de Conferências', 'Local B', 100, 2);

INSERT INTO eventoapi_db.atividade (tipo, nome, descricao, data, horario_inicio, horario_fim, edicao_id, espaco_id) VALUES
(1, 'Palestra 1', 'Descrição da Palestra 1', '2022-01-05', '09:00:00', '11:00:00', 1, 1),
(2, 'Oficina 1', 'Descrição da Oficina 1', '2023-02-05', '14:00:00', '16:00:00', 2, 2);

INSERT INTO eventoapi_db.atividade (tipo, nome, descricao, data, horario_inicio, horario_fim, edicao_id, espaco_id) VALUES
(1, 'Palestra 1', 'Descrição da Palestra 1', '2022-01-05', '09:00:00', '11:00:00', 1, 1),
(2, 'Oficina 1', 'Descrição da Oficina 1', '2023-02-05', '14:00:00', '16:00:00', 2, 2);

INSERT INTO eventoapi_db.usuarios_atividades_favoritas (usuario_id, atividade_id) VALUES
(1, 1),
(2, 2),
(3, 1),
(4, 2);

INSERT INTO eventoapi_db.espaco_recursos (descricao, espaco_id) VALUES
('Projetor', 1),
('Mesas e Cadeiras', 2);
