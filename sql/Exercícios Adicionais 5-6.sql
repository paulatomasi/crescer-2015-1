--5 Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de clientes (tabela Cliente),
--liste também qual o Estado possuí o menor número de clientes
select top 1 Cidade.UF as [Estado com maior número de clientes],
			(select top 1 Cidade.UF
			 from Cidade
			 join Cliente on Cliente.IDCidade = Cidade.IDCidade
			 group by UF
			 order by count(1) asc) as [Estado com menor número de clientes]
from Cidade
join Cliente on Cliente.IDCidade = Cidade.IDCidade
group by UF
order by count(1) desc

--6 Liste o total de cidades (distintas) que possuem clientes que realizaram algum pedido.
--Dica: será preciso relacionar Cidade com Cliente, e Cliente com Pedido
select count (distinct Nome) as [Total de cidades]
from Cidade
where exists (select 1
			  from Cliente 
			  join Pedido on Pedido.IDCliente = Cliente.IDCliente
			  where Cliente.IDCidade = Cidade.IDCidade)