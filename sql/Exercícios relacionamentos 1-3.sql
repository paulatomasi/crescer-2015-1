--1 Selecione o nome do empregado e nome do departamento que cada um está associado.
select Empregado.IDEmpregado,
	   Empregado.NomeEmpregado,
  	   Departamento.IDDepartamento
from Empregado
LEFT JOIN Departamento on Departamento.IDDepartamento = Empregado.IDDepartamento;

--2 Exibir o nome do associado e sua cidade, exibir também associados sem Cidade relacionada.
select Associado.Nome,
	   Cidade.Nome
from Associado
LEFT JOIN Cidade on Associado.IDCidade = Cidade.IDCidade;

--3 Lista os estados (UF) e total de cidades que não possuem associados relacionados
--(dica: pode ser utilizado count + group by + exists).
select UF, 
	   count(1) as [Cidades sem associados]
from Cidade
where not exists(Select 1
				 From Associado
				 Where Associado.IDCidade = Cidade.IDCidade)
group by UF;