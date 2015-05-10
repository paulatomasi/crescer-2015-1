var arsenal = {
  nome: 'Arsenal Football Club',
  titulos: [
    {nacionais: 'Nacionais', qtd: 13 },
    {continentais: 'Continentais ', qtd: 0 },
    {mundiais: 'Mundiais', qtd: 0 }
  ]
};

var chelsea = {
  nome: 'Chelsea Football Club',
  titulos: [
    {nacionais: 'Nacionais', qtd: 5 },
    {continentais: 'Continentais', qtd: 1 },
    {mundiais: 'Mundiais', qtd: 0 }
  ]
};

var liverpool = {
  nome: 'Liverpool Football Club',
  titulos: [
    {nacionais: 'Nacionais', qtd: 18 },
    {continentais: 'Continentais', qtd: 5 },
    {desc: 'Mundiais', qtd: 0 }
  ]
};
var manchester = {
  nome: 'Manchester United Football Club',
  titulos: [
	{nacionais: 'Nacionais', qtd: 20 },
    {continentais: 'Continentais', qtd: 3 },
    {desc: 'Mundiais', qtd: 1 }
  ]
};

var times = [arsenal, chelsea, liverpool, manchester];

/*2A*/
var ordenaClubes = function(array, indice){
	return(array.sort(function(a, b){
		return a.titulos[indice].qtd < b.titulos[indice].qtd;
	}));
}	

var ordenaPorNacionais = function(array){			
	return ordenaClubes(array, 0);
};

var ordenaPorContinentais = function(array){			
	return ordenaClubes(array, 1);		
};	
	
var ordenaPorMundiais = function(array){			
	return ordenaClubes(array, 2);
};

/*3*/
var somarTitulos = function(array, indice){		
	var total = 0;
	array.map(function(a) {
		total += parseInt(a.titulos[indice].qtd);
	});	
	return total;
};
	
var somarPorNacionais = function(array){
	return somarTitulos(array, 0);
};
	
var somarPorContinentais = function(array){
	return somarTitulos(array,1);
};
	
var somarPorTodosTitulos = function(array){
	return somarTitulos(array,0) +  somarTitulos(array, 1) + somarTitulos(array, 2) ;
};

/*4*/
var apenasOsMelhores = function (array){
	return array.filter(function(a){
		return a.titulos[0].qtd > 18;
	});
};

/*5*/
var apenasOsMelhoresParaJSON = function(array){
	return JSON.stringify(apenasOsMelhores(array));	;	 
};

var apenasOsMelhoresRecebendoJSON = function(string){
	return JSON.parse(string);	
};