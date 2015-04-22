--6
select Nome,
	   convert(varchar(30), dateadd(year, 50, DataNascimento), 103) as [Cinquenta anos],
	   datename(weekday, (dateadd(year, 50, DataNascimento))) as [Dia da semana]
from Associado;

--7
select UF,
	   count(1) as Cidades
from Cidade
group by UF;

--8
select Nome
from Cidade
group by Nome, UF
having count(1)> 1;

--9
select ISNULL(max(IDAssociado), 0)+1 as [Próximo ID]
from Associado;

--10
insert into CidadeAux (IDCidade, Nome, UF)
select min(IDCidade) as [Menor ID],
	   Nome,
	   UF
from Cidade
group by Nome, UF;