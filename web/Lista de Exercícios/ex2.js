//2A Faca uma instrucao jQuery que selecione todos elementos `img` da página que possuem `alt` e imprima-mos no log do console.
$('img[alt]').each(function(i, elem){
	console.log(elem.alt);
});

//2B Faca uma instrucao jQuery que selecione o input text pelo atributo, depois navegue até seu elemento pai e adicione a classe `template` nele.
//Nao utilize pseudo-seletores e nao selecione diretamente o pai do input text.
$('input[type=text]').parent().addClass('template');

//2C Faca uma instrucao jQuery que selecione o item de lista dentro de #myList que possui uma classe "current" e:
//1. Remova esta classe dele.
//2. Adicione uma classe "current" no próximo item de lista.
cls = 'current', $('#myList li .current').removeClass(cls).next().addClass(cls);

//2D Faca uma instrucao jQuery que selecione o elemento h2 dentro de #specials, altere seu texto para 
//"Promocoes", depois atravesse e altere o texto da opcao "Friday" para "Dimitri".
$('#specials h2').text('PromoÃ§Ãµes').siblings().find('[value=friday]').text('Dimitri');

//2E Faca uma instrucao jQuery que selecione o primeiro item de lista no elemento #slideshow; adicione a classe "current"
//a ele e entao adicione a classe "disabled" para seus elementos sibling.
$('#slideshow li').first().addClass('current').siblings().addClass('disabled');