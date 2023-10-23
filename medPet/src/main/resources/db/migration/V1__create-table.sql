CREATE TABLE medicos (
  id bigint AUTO_INCREMENT primary key,
  nome varchar(255) not null,
  email varchar(255) not null unique,
  telefone varchar(19)not null,
  crmv varchar(6) not null unique,
  especialidade varchar(100) not null,
  ativo bit(1) DEFAULT 1 not null,
  cep varchar(11) not null,
  uf varchar(50) not null,
  cidade varchar(50)not null,
  bairro varchar(50)not null,
  logradouro varchar(255)not null,
  numero varchar(255),
  complemento varchar(255)
);

CREATE TABLE responsavel_animal (
  id bigint AUTO_INCREMENT primary key,
  nome varchar(255) not null,
  cpf varchar(14) unique not null,
  telefone varchar(19),
  email varchar(255) not null unique,
  ativo bit(1) DEFAULT 1 not null,
  cep varchar(11) not null,
  uf varchar(50) not null,
  cidade varchar(50)not null,
  bairro varchar(50)not null,
  logradouro varchar(255)not null,
  numero varchar(255),
  complemento varchar(255)
);
CREATE TABLE usuarios (
  id bigint primary key auto_increment,
  login varchar(255) not null,
  senha varchar(30) not null
);

CREATE TABLE animal (
  id bigint AUTO_INCREMENT primary key,
  nome varchar(255) not null,
  ativo bit(1) DEFAULT 1,
  rga varchar(12) unique,
  especie varchar(100) not null,
  raca varchar(100) not null,
  sexo varchar(100) not null,
  cor varchar(100) not null,
  nascimento date,
  responsavel_animal_id bigint not null,
 FOREIGN KEY (responsavel_animal_id) REFERENCES responsavel_animal (id)
) ;
create table consultas(
    id bigint auto_increment primary key,
    medico_id bigint not null,
    animal_id bigint not null,
    data datetime not null,
    motivo_cancelamento varchar(100),
    foreign key(medico_id) references medicos(id),
    foreign key(animal_id) references animal(id)
);