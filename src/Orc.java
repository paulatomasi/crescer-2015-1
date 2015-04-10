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
        
        public void setStatus(Status novoStatus) {
         this.status = novoStatus;
        }
        
        public void setExperiencia(int novaExperiencia){
            this.experiencia = novaExperiencia;
        }
        
        public String toString(){
            return "Vida atual: " + this.vida;
        }
        
        public String getDescricoesItens(){
            StringBuilder builder = new StringBuilder();
            for (int x = 0; x<item.size(); x++){
                ItemDoInventario itemAtual = item.get(x);
                boolean ultimoIndice = x == item.size() - 1;
                builder.append(
                    ultimoIndice ?
                    itemAtual.getDescricao() :
                    itemAtual.getDescricao() + ","
                );
            }
            return builder.toString();
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
        
        public ItemDoInventario getItemComMaiorQuantidade(){
            int maiorQuantidade = 0;
            int quantidade = 0;
            ItemDoInventario itemAtual = null;
            for (int x = 0; x<item.size(); x++){
                quantidade = item.get(x).getQuantidade();
                if (quantidade > maiorQuantidade){
                    itemAtual = item.get(x);
                    maiorQuantidade = quantidade;
                }
            }
            return itemAtual;
        }
        
        public void ordenarItens(){
            for (int i = 0; i < item.size(); i++){
                for (int j = 0; j < item.size() - 1; j++){
                    ItemDoInventario itemAtual = this.item.get(j);
                    ItemDoInventario proximo = this.item.get(j+1);
                    boolean precisaTrocar = itemAtual.getQuantidade() > proximo.getQuantidade();
                    if (precisaTrocar){
                        this.item.set(j, proximo);
                        this.item.set(j+1, itemAtual);
                    }
                }
            }
        }
    }
