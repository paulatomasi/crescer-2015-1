//1A Faca uma instrucao jQuery que selecione todos elementos com a classe module.
$('.module');

//1B Faca uma instrucao jQuery que selecione o terceiro elemento da lista nao ordenada myList.
//$('#myList li:nth-child(3)');
$('#myList li:eq(2)');

//1C Faca uma instrucao jQuery que selecione o label para o input de busca usando um seletor de atributo.
//$('#search label[for=q]');
$('label[for=q]');

//1D Escreva uma instrucao jQuery que encontre quantos elementos na paina tem um atributo `alt`.
$('[alt]').size();

//1E Faca uma instrucao jQuery que selecione todas as linhas pares da tabela com exceto do cabecalho.
$('#fruits tr:even:not(:first-child)');

//1F Faca uma instrucao jQuery que encontre quantos elementos h2 possuem as letras "B", "e" NO MESMO texto.
$('h2:contains("B"):contains("e")').size();

//1G Faca uma instrucao jQuery que selecione todos os `li` dentro de `#myList` que nao estao vermelhos.
v$('#myList li:not(.current)');

//1H Faca uma instrucao jQuery que selecione todos os elementos que sao os últimos filhos no HTML do tipo img
// **OU** que sao os últimos filhos no HTML do tipo h3 
//$('li:last-of-type img, li:last-of-type h3')
$('img:last, h3:last');

//1I Faca uma instrucao jQuery que conte o número de caracteres somados dos textos de todos `li` que estao APOS o `li`
//com fonte vermelha, dentro de #myList. Ex:
//html
//		<ul id='myList'>
//			<li class='current bar'>vermelho</li>
//			<li>Azul</li>
//			<li>Verde</li>
//		</ul>
//javascript
//'Azul'.length + 'Verde'.length => 9
//$('#myList .current ~ li').text().length;
$('#myList .current').nextAll().text().length;