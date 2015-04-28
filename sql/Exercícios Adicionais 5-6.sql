--5 Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero de clientes (tabela Cliente),
--liste tamb�m qual o Estado possu� o menor n�mero de clientes
select top 1 Cidade.UF as [Estado com maior n�mero de clientes],
			(select top 1 Cidade.UF
			 from Cidade
			 join Cliente on Cliente.IDCidade = Cidade.IDCidade
			 group by UF
			 order by count(1) asc) as [Estado com menor n�mero de clientes]
from Cidade
join Cliente on Cliente.IDCidade = Cidade.IDCidade
group by UF
order by count(1) desc

--6 Liste o total de cidades (distintas) que possuem clientes que realizaram algum pedido.
--Dica: ser� preciso relacionar Cidade com Cliente, e Cliente com Pedido
select count (distinct Nome) as [Total de cidades]
from Cidade
where exists (select 1
			  from Cliente 
			  join Pedido on Pedido.IDCliente = Cliente.IDCliente
			  where Cliente.IDCidade = Cidade.IDCidade)