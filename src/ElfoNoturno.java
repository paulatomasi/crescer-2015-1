import java.util.*;
/**
 * Define objetos ElfoNoturno
 * 
 * @author Paula Tomasi
 */
public class ElfoNoturno extends Elfo
{
    public ElfoNoturno(String nome){
        super(nome);
    }
    
    public ElfoNoturno(String nome, int flechas){
        this(nome);
        super.flechas = flechas;
    }
    
    protected void atirarFlecha(Orc orc) {
        super.atirarFlecha(orc);
        this.experiencia+=2;
        this.vida -= (double) (vida*5)/100;
        atualizarStatus();
        
    }
    
    public void flechasParaMorrer(Orc orc){
        while (vida!=0){
            this.atirarFlecha(orc);
        }  
    }
}
