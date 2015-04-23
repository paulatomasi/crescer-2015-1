--5 Liste o nome do empregado, o nome do gerente, e o departamento de cada um
select e.NomeEmpregado as [Nome Empregado],
	   e.IDDepartamento as [Departamento Empregado],
	   g.NomeEmpregado as [Nome Gerente],
	   g.IDDepartamento as [Departamento Empregado]
from Empregado e
INNER JOIN Empregado g ON e.IDGerente = g.IDEmpregado
INNER JOIN Departamento ON e.IDDepartamento = Departamento.IDDepartamento AND g.IDDepartamento = Departamento.IDDepartamento

--6 Faça uma cópia da tabela Empregado e altere o salário de todos os empregados
--que o departamento fique na localidade de SAO PAULO, faça um reajuste de 14,5%
select * into EmpregadoAux from Empregado
begin transaction
go
update Empregado
set Salario = Salario + (Salario*0.145)
where IDDepartamento IN (10)