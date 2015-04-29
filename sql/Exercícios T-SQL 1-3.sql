--1 Imprima qual produto é o mais vendido, considere a quantidade (PedidoItem).
select top 1 with ties PedidoItem.IDProduto,
					   Produto.Nome,
					   SUM(quantidade) as Total
from PedidoItem
join Produto on PedidoItem.IDProduto = Produto.IDProduto
group by PedidoItem.IDProduto,
		 Produto.Nome
order by Total desc

-- CURSORES -- 
begin
	declare @IDPedido integer,
			@Nome varchar(100),
			@Total integer
select top 1 @IDPedido = PedidoItem.IDProduto,
	         @Nome = Produto.Nome,
			 @Total = SUM(quantidade)
from PedidoItem
join Produto on PedidoItem.IDProduto = Produto.IDProduto
group by PedidoItem.IDProduto,
		 Produto.Nome
order by SUM(quantidade) desc
print 'Produto: ' + @Nome + ' Total vendido: ' + cast(@Total as varchar(10))
end

--2 Liste as cidades com nome e UF duplicados que tenham clientes relacionados.
select Nome,
	   UF,
	   COUNT(1) as [Total de cidades]
from Cidade
group by Nome, 
		 UF
having count(1) > 1

-- CURSORES -- 
begin
	declare ListaCidade cursor
	for select Cidade.Nome,
			   Cidade.UF
	from Cidade
	group by Cidade.Nome,
			 Cidade.UF
	having count(1) > 1;
	declare @Nome varchar(50),
			@UF varchar(2),
			@Total integer;

	open ListaCidade;
	fetch next from ListaCidade into @Nome, @UF
	while (@@fetch_status = 0) begin
		select @total = count(1)
		from Cliente
		where EXISTS (select 1
		from Cidade
		where  Cidade.IDCidade = Cliente.IDCidade
		and Cidade.Nome = @Nome
		and Cidade.UF = @UF);
	if @Total > 0
	print @Nome + '/' + @UF + ' - Total de clientes: ' + cast(@Total as varchar(10));
	fetch next from ListaCidade into @Nome, @UF
	end
	close ListaCidade;
	deallocate ListaCidade;
end

--3 Identifique qual o material é utilizado por mais produtos e em seguida liste a quantidade de pedidos realizados,
--com produtos compostos por este material, liste também o valor total de vendas dos últimos 60 dias.
--- CRIAÇÃO INDEX ---
create index IX_Pedido_DataPedido on Pedido (DataPedido)

--- CRIAÇÃO VIEW ---
create view vw_Materiais_Mais_Utilizados as 
select top 1 with ties Material.IDMaterial,
					   Material.Descricao,
					   count(distinct ProdutoMaterial.IDProduto) as Total
from Material
join ProdutoMaterial on ProdutoMaterial.IDMaterial = Material.IDMaterial
join Produto on Produto.IDProduto = ProdutoMaterial.IDProduto
group by Material.IDMaterial, Material.Descricao
order by Total desc 

--- JUNÇÃO ---
select count(distinct Pedido.IDPedido) as [Total de pedidos],
	   count(1) as [Total de itens] 
from Pedido
join PedidoItem on PedidoItem.IDPedido = Pedido.IDPedido
where exists (select 1
			  from ProdutoMaterial
			  where ProdutoMaterial.IDProduto = PedidoItem.IDProduto
			  and ProdutoMaterial.IDMaterial in (select IDMaterial from vw_Materiais_Mais_Utilizados))

select Pedido.IDPedido,
	   PedidoItem.IDPedidoItem,
	   Produto.IDProduto,
	   Produto.Nome,
	   PedidoItem.Quantidade
from Pedido 
join PedidoItem on PedidoItem.IDPedido = Pedido.IDPedido
join Produto on Produto.IDProduto = PedidoItem.IDProduto
where Pedido.DataPedido between dateadd(day, -60, getdate()) and  getdate()
