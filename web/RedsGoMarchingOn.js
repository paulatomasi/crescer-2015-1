var arsenal = {
  nome: 'Arsenal Football Club',
  titulos: [
    { nacionais: 'Nacionais', qtd: 13 },
    { continentais: 'Continentais ', qtd: 0 },
    { mundiais: 'Mundiais', qtd: 0 }
  ]
};

var chelsea = {
  nome: 'Chelsea Football Club',
  titulos: [
    { nacionais: 'Nacionais', qtd: 5 },
    { continentais: 'Continentais', qtd: 1 },
    { mundiais: 'Mundiais', qtd: 0 }
  ]
};

var liverpool = {
  nome: 'Liverpool Football Club',
  titulos: [
    { nacionais: 'Nacionais', qtd: 18 },
    { continentais: 'Continentais', qtd: 5 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};
var manchester = {
  nome: 'Manchester United Football Club',
  titulos: [
	{ nacionais: 'Nacionais', qtd: 20 },
    { continentais: 'Continentais', qtd: 3 },
    { desc: 'Mundiais', qtd: 1 }
  ]
};

var times = [arsenal, chelsea, liverpool, manchester];

/*2A*/
function ordernaPorNacionais(a,b){
	if(a.titulos[0].qtd > b.titulos[0].qtd){
		return -1;
	} else{
		return 1;
	}
}
times.sort(ordernaPorNacionais);

/*2B*/
function ordernaPorContinentais(a,b){
	if(a.titulos[1].qtd > b.titulos[1].qtd){
		return -1;
	} else{
		return 1;
	}
}
times.sort(ordernaPorContinentais);

/*2C*/
function ordernaPorMundiais(a,b){
	if(a.titulos[2].qtd > b.titulos[2].qtd){
		return -1;
	} else{
		return 1;
	}
}
times.sort(ordernaPorMundiais);