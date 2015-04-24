--7 Liste a diferença que representará o reajuste aplicado no item anterior no somatório dos salários de todos os empregados.
select SUM(Salario*0145) as Soma
from Empregado
where IDDepartamento IN (10)

--8 Liste o departamento que possui o empregado de maior salário.
Select top 1 Empregado.IDDepartamento,
			 Departamento.NomeDepartamento
from Empregado
inner join departamento on Departamento.IDDepartamento = Empregado.IDDepartamento
order by (Salario) desc

--9 Faça uma consulta para exibir o nome de cada associado e sua cidade e juntamente com os empregados
--(nome) e a cidade (localidade) de seu departamento, isto deve ser exibido em uma consulta.
select Associado.Nome as [Nome Associado],
	   Cidade.Nome as Cidade
from Associado
left join Cidade on Associado.IDCidade = Cidade.IDCidade
UNION
select Empregado.NomeEmpregado,
	   Departamento.Localizacao
from Empregado
left join Departamento on Empregado.IDDepartamento = Departamento.IDDepartamento

--10 Lista as cidades que tenham associado relacionado.
select Cidade.Nome,
	   COUNT(1) as [Quantia de cidades]
from Cidade
left join Associado on Associado.IDCidade = Cidade.IDCidade
group by Cidade.Nome