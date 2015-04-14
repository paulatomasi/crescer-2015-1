import java.util.*;
/**
 * Define objetos Elfo Verde
 * 
 * @author Paula Tomasi 
 */
public class ElfoVerde extends Elfo
{
    public ElfoVerde(String nome){
        super(nome);
    }
    
    public ElfoVerde(String nome, int flechas){
        this(nome);
        super.flechas = flechas;
    }
    
    protected void atirarFlecha(Orc orc) {
        super.atirarFlecha(orc);
        this.experiencia++;
    }
    
    public void adicionarItem(ItemDoInventario item){
        boolean descricaoDoItem = item.getDescricao().equalsIgnoreCase("Espada de aco valiriano") || item.getDescricao().equalsIgnoreCase("Arco e Flecha de vidro");
        if (descricaoDoItem){
            super.adicionarItem(item);
        }else{
            return;
        }
    }
    
    public String toString(){
        return "Elfo verde: " + super.toString();
    }
    
}