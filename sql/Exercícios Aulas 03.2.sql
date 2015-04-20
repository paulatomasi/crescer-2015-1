select Substring(Nome, 1, Charindex(' ', Nome) - 1) as Nome
from Associado;

select Nome,
	   Datediff(year, DataNascimento, getdate()) as Idade
from Associado;

select NomeEmpregado as Nome,
	   Datediff(month, DataAdmissao, '31/12/2000') as MesesTrabalho
from Empregado
where DataAdmissao between '01/05/1980' and '20/01/1982';

select top 1 Cargo
from Empregado;

select top 1 Nome
from Associado
order by len(Nome) desc;