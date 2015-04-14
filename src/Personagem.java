import java.util.*;
/**
 * Classe base para todos personagens do jogo.
 * 
 * @author Paula Tomasi
 */
public class Personagem{
    protected ArrayList<ItemDoInventario> item = new ArrayList<ItemDoInventario>();
    Status status = Status.VIVO;
    protected double vida;
    protected String nome;
    protected int experiencia;
    
    protected Personagem(String nome, double vida){
        this.nome = nome;
        this.vida = vida;
    }
    
    protected Status getStatus(){
        return status;
    }
    
    protected double getVida(){
        return vida;
    }
    
    protected String getNome(){
        return nome;
    }
    
    protected int getExperiencia(){
        return experiencia;
    }
    
    public void adicionarItem(ItemDoInventario itemAdicionar){
        item.add(itemAdicionar);
    }
    
    public void atualizarStatus(){
        if (vida <100 && vida>0){
            status = Status.FERIDO;
        }
        
        if (vida == 0){
            status = Status.MORTO;
        }
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
        /*for (int i = 0; i < item.size(); i++){
                for (int j = 0; j < item.size() - 1; j++){
                    ItemDoInventario itemAtual = this.item.get(j);
                    ItemDoInventario proximo = this.item.get(j+1);
                    boolean precisaTrocar = itemAtual.getQuantidade() > proximo.getQuantidade();
                    if (precisaTrocar){
                        this.item.set(j, proximo);
                        this.item.set(j+1, itemAtual);
                    }
                }
            }*/
            
        Collections.sort(this.item, new Comparator<ItemDoInventario>()
        {
            public int compare(ItemDoInventario item, ItemDoInventario outroItem) {
                return Integer.compare(item.getQuantidade(), outroItem.getQuantidade());
            }});
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
}
