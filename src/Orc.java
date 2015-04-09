    /**
     * Define objeto Orc
     * 
     * @author Paula Tomasi
     */
    import java.util.*;
    public class Orc
    {
        private int vida = 110;
        private String nome;
        private int experiencia = 0;
        private Status status = Status.VIVO;
        ArrayList<ItemDoInventario> item = new ArrayList<ItemDoInventario>();
    
        public Orc(String nome) {
            this.nome = nome;
        }
        public Orc(){
        }
        
        public void orcMorto(){
            if (this.vida == 0){
                this.status = Status.MORTO;
            }
        }
        
        /**
         * Perde vida quando recebe ataque
         */
        public void recebeAtaque(){
            if (vida>0){
                double numero = gerarNumero();
                    if (numero<0){
                        this.experiencia += 2;
                        return;
                    }else if (numero>100){
                        int danoVida = 10;
                        if (this.vida >= danoVida){
                            this.vida -= danoVida;
                            this.status = Status.FERIDO;
                        }
                    }
            }else {
                this.status = Status.MORTO;
            }
        }
        
        /**
         * Imprime a vida atual do orc na tela
         * @return String com a vida atual do orc
         * Ex: Vida atual: 110
         */
    
        private double gerarNumero(){
            double  numero = 0.0;
            boolean possuiNomeComMaisDeCincoCaracteres = this.nome != null && this.nome.length()>5;
            boolean estaFugindo = this.status == Status.FUGINDO;
            boolean estaDormindoOuCacando = this.status == Status.DORMINDO || this.status == Status.CACANDO;
            // Letra A
            if (possuiNomeComMaisDeCincoCaracteres){
                numero += 65.0;
            }else {
                numero -= 60.0;
            }
            // Letra B
            if (this.vida>=30 && this.vida<=60){
                numero *= 2;
            }else if (this.vida >20){
                numero *= 3;
            }
            // Letra C
            if (estaFugindo){
                numero /= 2;
            }else if (estaDormindoOuCacando){
                    numero += 1.0;
                }
            // Letra D
            if (this.experiencia % 2 ==0){
                numero = Math.pow(numero, 3);
            }
            if (this.experiencia % 2 != 0 && this.experiencia>2){
                numero = Math.pow(numero, 2);
            }
            return numero;
        }
        
        public void adicionarItem(ItemDoInventario itemAdicionar){
            item.add(itemAdicionar);
        }
        
        /**
         * Recebe o item que vai perder;
         * Percorre todo o arraylist;
         * Procura igualdade entre o item passado como parametro e os existentes na lista;
         * Quando iguais, remove o item da  lista e diminui x;
         */
        public void perderItem(ItemDoInventario x){
            item.remove(x);
        }
        
        public ArrayList<ItemDoInventario> getItem(){
            return this.item;
        }
        
        public String getNome(){
            return this.nome;
        }
        
        public int getVida(){
            return this.vida;
        }
    
        public int getExperiencia(){
            return this.experiencia;
        }

        public Status getStatus() {
            return this.status;
        }
        
        public void setExperiencia(int novaExperiencia){
            this.experiencia = novaExperiencia;
        }
        
        public String toString(){
            return "Vida atual: " + this.vida;
        }
}
