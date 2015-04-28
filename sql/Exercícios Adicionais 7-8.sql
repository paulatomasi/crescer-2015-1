--7 Dentro da atual estrutura, cada produto é composto por 1 ou vários materiais (tabela ProdutoMaterial).
--Identifique se existe algum produto sem material relacionado
select Produto.IDProduto, Produto.Nome
from Produto 
where not exists (select 1
				  from ProdutoMaterial
				  where ProdutoMaterial.IDProduto = Produto.IDProduto)

--8 Liste os produtos, com seu preço de custo, e relacione com seus os materiais (ProdutoMaterial), e liste também
-- o somatório do PrecoCusto de todos seus materiais. Veja um exemplo abaixo: 
--IDProduto  Produto              Preco Custo R$  Preco Custo Materiais R$
--1589       Chin Palm 3940       883,74          1.092,02
--2253       Salg Plops Presunto  370,88          823,03
--3581       Garrafa Madri Rolha  872,43          1.469,31

select Produto.IDProduto,
	   Produto.Nome,
	   Produto.PrecoCusto,
	   SUM(Material.PrecoCusto * isnull(ProdutoMaterial.Quantidade, 1)) as [Preço de custo]
from Produto
join ProdutoMaterial on ProdutoMaterial.IDProduto = Produto.IDProduto
join Material on Material.IDMaterial = ProdutoMaterial.IDMaterial
group by Produto.IDProduto,
		 Produto.Nome,
		 Produto.PrecoCusto