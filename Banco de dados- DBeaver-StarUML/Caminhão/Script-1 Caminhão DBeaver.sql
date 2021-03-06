-- CRIAÇÃO DAS TABELAS A PARTIR DO CRUD CRIADO NO STARUML
*/
/*DROP TABLE Caminhão CASCADE CONSTRAINTS;
DROP TABLE Motorista CASCADE CONSTRAINTS;
DROP TABLE NotaFiscal CASCADE CONSTRAINTS;
DROP TABLE ManifestoCarga CASCADE CONSTRAINTS;
DROP TABLE Balança CASCADE CONSTRAINTS;
*/

CREATE TABLE Caminhao (
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

