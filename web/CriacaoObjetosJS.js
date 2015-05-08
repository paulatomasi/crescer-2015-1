function Elfo(options){
	options = options || {};
	this.nome = options.nome;
	this.flechas = options.flechas || 42;
	this.experiencia = 0;
	
	this.atirarFlechas = function(){
		this.flechas--;
		this.experiencia++;
	}
}

var elfo = new Elfo({nome: "Legolas"});