/*--Criando a tabela alunos
drop table ALUNOS;
create table alunos (
codAluno serial,
nomAluno varchar(30) not null,
medAluno decimal(4,2),
primary key (codaluno));

--Criando um índice para buscar por nome e melhorar a performance
create index ix_nome on alunos (nomaluno);

--Criando a tabela notass
create table notas (
codaluno integer not null,
numavaliacao integer not null,
vlrnota decimal (4,2) not null,
primary key (codaluno, numavaliacao));

--Criando a integridade Referencial Foreign Key
alter table notas 
add constraint fk_alunos_notas
foreign key (codaluno) references alunos (codAluno);

--Usando comandos DML (Insert, Update e Delete)
INSERT INTO alunos (nomaluno, medaluno) VALUES('SÂMELA HOSTINS', null);
INSERT INTO alunos (nomaluno, medaluno) VALUES('MARIA DA SILVA', null);
INSERT INTO alunos (nomaluno, medaluno) VALUES('CAIO CASTRO', null);
INSERT INTO alunos (nomaluno, medaluno) VALUES('NOAH SANTINEO',null);
INSERT INTO alunos (nomaluno, medaluno) VALUES('CHRIS PRATT',null);

--Faz com que seja possível ver a informação no banco
select * from ALUNOS;

--Populando a tabela = inserir um registro
INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(1, 1, 8.5);
INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(1, 2, 5.0);
INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(1, 3, 7.0);

INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(2, 1, 9.0);
INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(2, 2, 6.9);
INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(2, 3, 7.0);

INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(3, 1, 8.5);
INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(3, 2, 5.0);
INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(3, 3, 9.0);

INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(4, 1, 9.3);
INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(4, 2, 8.0);
INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(4, 3, 9.0);

INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(5, 1, 8.5);
INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(5, 2, 4.0);
INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(5, 3, 7.0);

INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(6, 1, 9.5);
INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(6, 2, 5.0);
INSERT INTO notas (codaluno, numavaliacao, vlrnota) VALUES(6, 3, 7.0);

select * from notas;

--Alterando uma nota de um aluno e avaliação específica
update notas
set vlrnota = 9
where codaluno = 1
and numavaliacao = 2;

--Fazendo aparecer os registros bonitinhos na ordem por número de código e de avaliação 
--O padrão de ordenação é ascendente (ASC)
select
n.codaluno,
n.numavaliacao,
n.vlrnota
from notas n order by n.codaluno, n.numavaliacao;

--Clonando uma tabela
create table notas_bkp as (select * from notas);
select * from notas_bkp;

select
n.codaluno,
n.numavaliacao,
n.vlrnota
from notas_bkp n order by n.codaluno, n.numavaliacao;

*/
/*DROP TABLE Caminhão CASCADE CONSTRAINTS;
DROP TABLE Motorista CASCADE CONSTRAINTS;
DROP TABLE NotaFiscal CASCADE CONSTRAINTS;
DROP TABLE ManifestoCarga CASCADE CONSTRAINTS;
DROP TABLE Balança CASCADE CONSTRAINTS;
*/

CREATE TABLE Caminhão (
    placa varchar(09) NOT NULL,
    dataManut Date NOT NULL,
    dataProxManut Date NOT NULL,
    PRIMARY KEY (placa)
);

CREATE TABLE Motorista (
    nrCnh integer NOT NULL,
    nomeMotorista varchar(30) NOT NULL,
    PRIMARY KEY (nrCnh)
);

CREATE TABLE NotaFiscal (
    nrNota integer NOT NULL,
    dataEmissao date NOT NULL,
    pesoTotal decimal(7,2) NOT NULL,
    vlrTotal decimal(9,2) NOT NULL,
    PRIMARY KEY (nrNota)
); 

CREATE TABLE ManifestoCarga (
    nmrManifesto integer NOT NULL,
    nrNota integer NOT NULL,
    pesoTotal decimal(7,2) NOT NULL,
    qtdVolumes integer NOT NULL,
    vlrTotal decimal(10,2) NOT NULL,
    indSituacao char(01) NOT NULL,
    dataEmbarque Date,
    dataSaida Date,
    PRIMARY KEY (nmrManifesto, nrNota)
);

CREATE TABLE Balanca (
    regBalanca serial NOT NULL,
    placa varchar(09) NOT NULL,
    nrCnh integer NOT NULL,
    dataHrEntrada Date NOT NULL,
    dataHrSaida timestamp,
    pesoEntrada integer NOT NULL,
    pesoSaida integer,
    PRIMARY KEY (regBalanca)
);

CREATE TABLE ManifestoSaida (
    regBalanca integer NOT NULL,
    nmrManifesto integer NOT NULL,
    PRIMARY KEY (regBalanca, nmrManifesto)
);

ALTER TABLE Balanca ADD FOREIGN KEY (placa) REFERENCES Caminhao(placa);
ALTER TABLE Balanca ADD FOREIGN KEY (nrCnh) REFERENCES Motorista(nrCnh);
ALTER TABLE ManifestoSaida ADD FOREIGN KEY (regBalanca) REFERENCES Balanca(regBalanca);
ALTER TABLE ManifestoSaida ADD FOREIGN KEY (nmrManifesto) REFERENCES ManifestoCarga(nmrManifesto);

