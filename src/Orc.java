    import java.util.*;
    /**
       * Define objeto Orc
         * 
           * @author Paula Tomasi
             */
    
    public class Orc extends Personagem
    {
        public Orc(String nome) {
            super(nome, 110);
        }
        
        public Orc(){
            this("");
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
        private double gerarNumero() {
         double numeroGerado = 0.0;
         // Letra A
         boolean possuiNome = this.nome != null && this.nome.length() > 5;
         if (possuiNome && this.nome.length() > 5) {
             numeroGerado += 65;
         } else {
             numeroGerado -= 60;
         }
         // Letra B
         boolean possuiVidaEntre30e60 = this.vida >= 30 && this.vida <= 60;
         if (possuiVidaEntre30e60) {
             numeroGerado *= 2;
         } else if (this.vida < 20) {
             numeroGerado *= 3;
         }
         // Letra D
         if (this.status == Status.FUGINDO) {
             numeroGerado /= 2;
         } else if (this.status == Status.CACANDO || this.status == Status.DORMINDO) { 
             numeroGerado += 1;
         }
         // Letra D
         boolean experienciaPar = this.experiencia % 2 == 0;
         if (experienciaPar) {
             numeroGerado = numeroGerado * numeroGerado * numeroGerado;
         } else if (this.experiencia > 2) {
             numeroGerado = numeroGerado * numeroGerado;
         }  
         return numeroGerado;
        }
        
        public void setExperiencia(int novaExperiencia){
            this.experiencia = novaExperiencia;
        }
        
        public String toString(){
            return "Vida atual: " + this.vida;
        }
        
        public void setStatus(Status novoStatus) {
         this.status = novoStatus;
        }

        public  void tentarSorte(){
            double numeroGerado = gerarNumero();
            if (numeroGerado == 3481){
                for (int x = 0; x<item.size(); x++){
                    int novaQuantidadeItem = item.get(x).getQuantidade() + 1000;
                    item.get(x).setQuantidade(novaQuantidadeItem);
                }
            }
        }
        public void imprimeNome() {
            // TODO: System.out.println...
        }
    }
