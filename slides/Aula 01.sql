Create table Cliente(
	IDCliente int IDENTITY NOT NULL,
	Nome varchar(30) NOT NULL,
	Endereco varchar (35),
	Bairro varchar(35),
	IDCidade int
);

INSERT INTO Cliente (Nome, Endereco, Bairro) VALUES ('Maria', 'Rua Bento Gon�alves, 123', 'Centro');

SELECT * FROM Cliente;

Create table Cidade(
	IDCidade int NOT NULL,
	Nome varchar(30)NOT NULL,
	UF varchar(2)NOT NULL,
	constraint PK_Cidade Primary Key (IDCidade),
	constraint UK_Cidade_Nome Unique (Nome)
);

Create table Empregado(
	IDEmpregado int NOT NULL,
	Nome varchar(50) NOT NULL,
	Sexo char(1) NOT NULL,
	IDCidade int NOT NULL,
	constraint PK_Empregado Primary Key (IDEmpregado),
	constraint CC_Empregado_Sexo Check (Sexo in('F','M')),
	constraint FK_Empregado_Cidade Foreign Key (IDCidade)
	References Cidade (IDCidade)
);

