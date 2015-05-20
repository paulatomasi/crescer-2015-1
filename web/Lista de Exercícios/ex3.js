//3A Faca uma instrucao JavaScript + jQuery que adicione cinco novos itens de lista no fim da lista nao ordenada #myList. 
//Os itens devem seguir o padrao de texto dos itens já existentes na lista e devem continuar a contagem (que parou em 7).
var list = $('#myList');
for (var i = 8; i < 13; i++) {
  $('<li/>').text('List item ' + i).appendTo(list);
}

//3B Faca uma instrucao jQuery que remova os itens com texto par da lista #myList.
$('#myList li:odd').remove();

//3C Faca uma instrucao jQuery que:
//. Adicione uma nova div.module à página depois da última (última div module antes da execucao)
//. Coloque uma cópia da primeira imagem existentes dentro dela.
$('div.module').last().after($('<div/>').addClass('module').append($('img:eq(0)').clone()));
