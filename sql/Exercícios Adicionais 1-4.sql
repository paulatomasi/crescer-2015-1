--1 Identifique e liste quantos valores diferentes estão definidos para a coluna Situacao da tabela Produto.
select Situacao,
	   COUNT (1)
from Produto
group by Situacao

--2 Liste todos os clientes que tenham o LTDA no nome ou razao social.
select Nome
from Cliente
where Nome like '%Ltda%'
	  or RazaoSocial like '%Ltda%'

--3 Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
insert into Produto (Nome, PrecoCusto, PrecoVenda, Situacao)
values ('Galocha Maragato', 35.67, 77.95, 'A')

--4 Identifique e liste os produtos que não tiveram nenhum pedido, considere os relacionamentos no modelo de dados, 
--pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
select IDProduto, Nome
from Produto
where not exists (select 1
				  from PedidoItem
				  where PedidoItem.IDProduto = Produto.IDProduto)
