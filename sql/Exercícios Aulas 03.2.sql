select Substring(Nome, 1, Charindex(' ', Nome) - 1) as Nome
from Associado;

select Nome,
	   Datediff(year, DataNascimento, getdate()) as Idade
from Associado;

select NomeEmpregado as Nome,
	   Datediff(month, DataAdmissao, '31/12/2000') as MesesTrabalho
from Empregado
where DataAdmissao between convert(DateTime, '01/05/1980', 103) and convert(DateTime, '20/01/1982', 103);

select top 1 with ties Cargo,
	   count(1) as Total
from Empregado
group by Cargo
order by Total desc;

select top 1 Nome
from Associado
order by len(Nome) desc;