--Criando a tabela alunos
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

