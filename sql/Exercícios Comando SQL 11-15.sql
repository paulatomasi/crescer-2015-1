--11 
begin transaction
go
update Cidade
set Nome = '*' + Nome
where Nome IN (select Nome
				from Cidade
				group by Nome, UF
				having count(1)>1)

select * from Cidade order by Nome

--12
select Nome,
	   case Sexo
		    when 'M' then 'Masculino'
			when 'F' then 'Feminino'
			else 'Outro'
		end Gênero
from Associado

--13
--Até R$ 1.164,00 = 0%
--De R$ 1.164,00 a R$ 2.326,00 = 15%
--Acima de R$ 2.326,00 = 27,5%.
select NomeEmpregado,
	   Salario,
	   case when Salario between 1164.01 and 2326 then  (Salario*0.15)
			when Salario > 2326 then (Salario*0.275)
			else 0
	   end [Desconto Imposto de Renda]
from Empregado

--14
begin transaction
go
delete from Cidade
where IDCidade in (select MAX(IDCidade)
				   from Cidade
				   group by Nome, UF
				   having count(1)>1)

select * from Cidade order by Nome

--15
alter table Cidade add constraint UK_Cidade_NomeUF unique (Nome, UF);