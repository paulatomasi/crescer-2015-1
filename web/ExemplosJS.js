var allBacon = (function (array){
	var concatenarBacon = function(i, indice){
			if (indice % 2 == 0){
				return i + " Bacon";
			}else{
				return i;
			}
	}
	return array.map(concatenarBacon);
});

allBacon(['João', 'Maria', 'Bruxa']);


var arr = [1, 2, 3];
var count = arr.reduce(function(a,b) {
	return a + b;
});
count;


var obj = {nome: "Pessoa 1", idade: 15};
var obj2 = {nome: "Pessoa 2", idade: 15};
var pessoas = [obj, obj2];
var count = pessoas.map(function(i){return i;}).reduce(function(a, b) {return a.idade + b.idade;});