

CREATE TABLE Carro (
	id serial,
    placa varchar(15) NOT NULL,
    marca varchar(15) NOT NULL,
    modelo varchar(15) NOT NULL,
    PRIMARY KEY (id)
);

select * from carro;