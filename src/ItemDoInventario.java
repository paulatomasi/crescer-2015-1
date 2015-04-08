/**
 * Define objetos ItemDoInventario.
 * 
 * @author Paula Tomasi.
 */
public class ItemDoInventario
{
    private String descricao;
    private int quantidade;
    
    public ItemDoInventario (){
    }
    
    public ItemDoInventario(String novaDescricao, int novaQuantidade){
        this.descricao = novaDescricao;
        this.quantidade = novaQuantidade;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setQuantidade(int novaQuantidade){
        this.quantidade = novaQuantidade;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
}
