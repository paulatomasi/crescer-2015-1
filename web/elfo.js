function Elfo (options){
	options = options || {};
	this.nome = options.nome;
	this.flechas = options.flechas || 42;
	this.experiencia = 0;
};

Elfo.prototype.atirarFlecha = function(){
	this.flechas--;
	this.experiencia++
};