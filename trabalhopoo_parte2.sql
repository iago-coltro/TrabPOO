create database trabalhoPOO_parte2;

use trabalhoPOO_parte2;

create table alimentos
(
	id_alimento int unsigned not null auto_increment,
    nome varchar(45) default null,
    carboidrato decimal(10,2) DEFAULT NULL,
	proteina decimal(10,2) DEFAULT NULL,
	gordura decimal(10,2) DEFAULT NULL,
	calorias decimal(10,2) DEFAULT NULL,
	porcao decimal(10,2) DEFAULT NULL,
	createDate datetime DEFAULT NULL,
	modifyDate datetime DEFAULT NULL,
  PRIMARY KEY (id_alimento)
);

INSERT INTO alimentos VALUES 
(1,'Arroz Branco',25.80,2.60,1.00,120.60,100.00,'2023-12-12 00:00:00',NULL),
(2,'Feijão Carioca',13.60,4.80,0.50,77.10,100.00,'2023-12-12 00:00:00',NULL),        
(3,'Peito de Frango Grelhado',0.00,28.00,7.50,164.50,100.00,'2023-12-12 00:00:00',NULL),
(4,'Ovo cozido',0.60,13.30,9.50,122.10,100.00,'2023-12-12 00:00:00',NULL),
(5,'Pão',49.90,9.40,3.70,263.10,100.00,'2023-12-12 00:00:00',NULL),
(6,'Banana',26.00,1.30,0.10,109.90,100.00,'2023-12-12 00:00:00',NULL),
(7,'Aveia',66.60,13.90,8.50,381.50,100.00,'2023-12-12 00:00:00',NULL);

create table pessoa
(
	id_pessoa int not null auto_increment,
    nome varchar(45) default null,
    sexo varchar(15) default null,
    dt_nascimento datetime default null,
    login varchar(45) default null,
    senha varchar(45) default null,
    createDate datetime DEFAULT NULL,
	modifyDate datetime DEFAULT NULL,
    primary key(id_pessoa)
);

INSERT INTO pessoa VALUES 
(1,'Iago','Masculino','2001-10-18 00:00:00','teste','123','2023-12-12 00:00:00',NULL),
(2,'Diego','Masculino','2000-04-06 00:00:00','teste2','123','2023-12-12 00:00:00',NULL);

create table avaliacao_fisica
(
	id_avaliacao int unsigned not null auto_increment,
    peso decimal(10,2) DEFAULT NULL,
	altura decimal(10,2) DEFAULT NULL,
    idade int DEFAULT NULL,
	pescoco decimal(10,2) DEFAULT NULL,
	cintura decimal(10,2) DEFAULT NULL,
	tx_atividade decimal(10,2) DEFAULT NULL,
    quadril decimal(10,2) DEFAULT NULL,
    tmb decimal(10,2) DEFAULT NULL,
    imc decimal(10,2) DEFAULT NULL,
    bf decimal(10,2) DEFAULT NULL,    
	createDate datetime DEFAULT NULL,
	modifyDate datetime DEFAULT NULL,
    pessoa_idpessoa int not null,
  PRIMARY KEY (id_avaliacao, pessoa_idpessoa),
  constraint fk_avaliacaopessoa_idpessoa foreign key (pessoa_idpessoa) references pessoa (id_pessoa)
);

INSERT INTO avaliacao_fisica VALUES 
(1,73.00,172.00,22,30.00,68.00,1.55,70.00,2750.50,24.60,9.80,'2023-12-12 00:00:00',NULL,1),
(2,68.00,168.00,22,25.00,66.00,1.37,68.00,2321.0,24.09,13.19,'2023-12-12 00:00:00',NULL,2);


create table mensagem
( 
	id_mensagem int NOT NULL AUTO_INCREMENT,
	conteudo varchar(200) DEFAULT NULL,
	createDate datetime DEFAULT NULL,
	modifyDate datetime DEFAULT NULL,
	Pessoa_idPessoaRemetente int NOT NULL,
	Pessoa_idPessoaDestinatario int NOT NULL,
	PRIMARY KEY (id_mensagem, Pessoa_idPessoaRemetente, Pessoa_idPessoaDestinatario),
	CONSTRAINT fk_idPessoaRemetente_idpessoa FOREIGN KEY (Pessoa_idPessoaRemetente) REFERENCES pessoa (id_Pessoa),
	CONSTRAINT fk_idPessoaDestinatario_idpessoa FOREIGN KEY (Pessoa_idPessoaDestinatario) REFERENCES pessoa (id_Pessoa)
);

INSERT INTO mensagem VALUES 
(1,'Opa, beleza ?','2023-12-12 00:00:00',NULL,1,2),
(2,'Joiaa!','2023-12-12 00:00:00',NULL,2,1);

create table post
(
	id_mensagem int NOT NULL AUTO_INCREMENT,
	conteudo varchar(200) DEFAULT NULL,
	createDate datetime DEFAULT NULL,
	modifyDate datetime DEFAULT NULL,
	Pessoa_idPessoa int NOT NULL,
	PRIMARY KEY (id_mensagem, Pessoa_idPessoa),
	CONSTRAINT fk_post_idpessoa FOREIGN KEY (Pessoa_idPessoa) REFERENCES pessoa (id_Pessoa)
);

INSERT INTO post VALUES 
(1,'Esse é o meu primeiro post!','2023-12-12 00:00:00',NULL,1),
(2,'Trabalho de POO','2023-12-12 00:00:00',NULL,2);

create table tipo_dieta
(
	id_tipoDieta int NOT NULL AUTO_INCREMENT,
	nome varchar(45) DEFAULT NULL,
	carboidrato decimal(10,2) DEFAULT NULL,
	proteina decimal(10,2) DEFAULT NULL,
	gordura decimal(10,2) DEFAULT NULL,
	createDate datetime DEFAULT NULL,
	modifyDate datetime DEFAULT NULL,
	PRIMARY KEY (id_tipoDieta)
);

INSERT INTO tipo_dieta VALUES 
(1,'Equilibrada',40.00,30.00,30.00,'2023-12-12 00:00:00',NULL),
(2,'EQUILIBRADA',40.00,30.00,30.00,'2023-12-12 00:00:00',NULL);

create table refeicoes
(
	id_refeicoes int NOT NULL AUTO_INCREMENT,
	carboidrato decimal(10,2) DEFAULT NULL,
	proteina decimal(10,2) DEFAULT NULL,
	gordura decimal(10,2) DEFAULT NULL,
	caloria decimal(10,2) DEFAULT NULL,
	nome varchar(45) DEFAULT NULL,
	createDate datetime DEFAULT NULL,
	modifyDate datetime DEFAULT NULL,
	TipoDieta_idTipoDieta int NOT NULL,
	PRIMARY KEY (id_refeicoes, TipoDieta_idTipoDieta),
	CONSTRAINT fk_Refeicoes_TipoDieta FOREIGN KEY (TipoDieta_idTipoDieta) REFERENCES tipo_dieta (id_tipoDieta)
);

INSERT INTO refeicoes VALUES 
(1,56.34,42.25,18.78,563.38,'Cafe da Manhã','2023-12-12 00:00:00',NULL,1),
(2,56.34,42.25,18.78,563.38,'Almoço','2023-12-12 00:00:00',NULL,1),
(3,56.34,42.25,18.78,563.38,'Lanche da tarde','2023-12-12 00:00:00',NULL,1),
(4,56.34,42.25,18.78,563.38,'Janta','2023-12-12 00:00:00',NULL,1);

create table seguidor
(
	Pessoa_idPessoa int NOT NULL,
	Pessoa_idPessoaSeguindo int NOT NULL,
	PRIMARY KEY (Pessoa_idPessoa, Pessoa_idPessoaSeguindo),
	CONSTRAINT fk_Pessoa_idPessoa FOREIGN KEY (Pessoa_idPessoa) REFERENCES pessoa (id_pessoa),
	CONSTRAINT fk_Seguindo_idPessoa FOREIGN KEY (Pessoa_idPessoaSeguindo) REFERENCES pessoa (id_pessoa)
);

INSERT INTO seguidor VALUES 
(2,1),
(1,2);

create table dieta 
(
	idRegistroDieta int NOT NULL AUTO_INCREMENT,
	objetivo int DEFAULT NULL,
	calorias decimal(10,2) DEFAULT NULL,
	numRefeicoes int DEFAULT NULL,
	modifyDate datetime DEFAULT NULL,
	createDate datetime DEFAULT NULL,
	TipoDieta_idTipoDieta int NOT NULL,
	Pessoa_idPessoa int NOT NULL,
	Avaliacao_idAvaliacao int NOT NULL,
	Avaliacao_Pessoa_idPessoa int NOT NULL,
	PRIMARY KEY (idRegistroDieta, TipoDieta_idTipoDieta,Pessoa_idPessoa,Avaliacao_idAvaliacao,Avaliacao_Pessoa_idPessoa),
	CONSTRAINT fk_RegistroDieta_Avaliacao FOREIGN KEY (Avaliacao_idAvaliacao, Avaliacao_Pessoa_idPessoa) REFERENCES avaliacao_fisica (id_avaliacao, pessoa_idpessoa),
	CONSTRAINT fk_RegistroDieta_Pessoa FOREIGN KEY (Pessoa_idPessoa) REFERENCES pessoa (id_pessoa),
	CONSTRAINT fk_RegistroDieta_TipoDieta FOREIGN KEY (TipoDieta_idTipoDieta) REFERENCES tipo_dieta (id_tipoDieta)
);

create table alimento_refeicao
(
	Refeicoes_idRefeicoes int NOT NULL,
	Refeicoes_TipoDieta_idTipoDieta int NOT NULL,
	Alimento_idAlimento int NOT NULL,
	Pessoa_idPessoa int NOT NULL,
	Porcao decimal(10,2) DEFAULT NULL,
	PRIMARY KEY (Refeicoes_idRefeicoes, Refeicoes_TipoDieta_idTipoDieta, Alimento_idAlimento, Pessoa_idPessoa),
	CONSTRAINT fk_AlimentoRefeicao_idAlimento FOREIGN KEY (Alimento_idAlimento) REFERENCES alimentos (id_alimento),
	CONSTRAINT fk_AlimentoRefeicao_idPessoa FOREIGN KEY (Pessoa_idPessoa) REFERENCES pessoa (id_pessoa),
	CONSTRAINT fk_AlimentoRefeicao_idRefeicoes FOREIGN KEY (Refeicoes_idRefeicoes, Refeicoes_TipoDieta_idTipoDieta) REFERENCES refeicoes (id_refeicoes, TipoDieta_idTipoDieta)
);