Select NomeEmpregado as Nome 
From Empregado
Order by DataAdmissao;

Select NomeEmpregado as Nome,
	   (Salario*12) as Sal�rioAnual
From Empregado
Where cargo = 'Atendente'
OR Salario  < 18500;

Select IDCidade
From Cidade
Where Nome = 'Uberl�ndia'

Select IDCidade, Nome
From Cidade
Where UF = 'RS'