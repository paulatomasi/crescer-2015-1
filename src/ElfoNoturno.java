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

    public void atirarFlecha(Orc orc) {
        super.atirarFlecha(orc);
        experiencia += 2;
        this.vida -=(vida * 0.05);
        this.status = (int)this.vida == 0 ? Status.MORTO : this.status;
    }   
    
    public String toString(){
        return "Elfo noturno: " + super.toString();
    }
}
