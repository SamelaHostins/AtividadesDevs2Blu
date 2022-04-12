use Escola;

CREATE TABLE Aluno (
     codaluno integer auto_increment NOT NULL,
     nomaluno varchar(40) NOT NULL,
     nompai varchar(40),
     nommae varchar(40),
     datanasc Date NOT NULL,
     medaluno decimal (4,2),
     sitaluno char (01),
     PRIMARY KEY (codaluno)
);

CREATE TABLE Disciplina (
     coddisciplina integer auto_increment NOT NULL,
     nomdisciplina varchar(30) NOT NULL,
     nomprofessor varchar(40) NOT NULL,
	 qtdavaliacoes integer NOT NULL,
     PRIMARY KEY (coddisciplina)
);


CREATE TABLE Matricula (
	 codaluno integer NOT NULL,
     coddisciplina integer NOT NULL,
     dtmatricula Date NOT NULL,
     statusmatricula char (01) NOT NULL,
     PRIMARY KEY (codaluno, coddisciplina)
);

CREATE TABLE Avaliacao (
	 codaluno integer NOT NULL,
     coddisciplina integer NOT NULL,
     nravaliacao integer NOT NULL,
     vlrnota decimal (4,2) NOT NULL,
     PRIMARY KEY (codaluno, coddisciplina, nravaliacao)
);