--1 Selecione o nome do empregado e nome do departamento que cada um está associado.
select Empregado.IDEmpregado,
	   Empregado.NomeEmpregado,
  	   Departamento.IDDepartamento
from Empregado
LEFT JOIN Departamento on Departamento.IDDepartamento = Empregado.IDDepartamento;

--2 Exibir o nome do associado e sua cidade, exibir também associados sem Cidade relacionada.
select Associado.Nome,
	   Cidade.Nome as [Nome da cidade]
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

--4 Faça uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique
--se a cidade é da região SUL (RS, SC, PR), se for imprimir *** (3 asteriscos), senão imprimir nulo.
create view vw_Cidade_Regiao as 
select Associado.Nome,
	   Cidade.Nome as Cidade,
	   case Cidade.UF
		    when 'RS' then '***'
			when 'SC' then '***'
			when 'PR' then '***'
			else null
		end [Região Sul]
from Associado
LEFT JOIN Cidade on Associado.IDCidade = Cidade.IDCidade;

-- utilizar a view
select * from vw_Cidade_Regiao 