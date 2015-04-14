import java.util.*;
/**
 * Define objetos Elfo
 * 
 * @author Paula Tomasi
 */
public class Elfo extends Personagem
{
    protected int flechas = 42;
    protected static int contador;
    /**
     * Cria objetos Elfo
     * 
     * @param umNome Nome que o elfo recebera
     * @param flechas Quantidade inicial de flechas
     */
    public Elfo(String umNome, int flechas)
    {
        this(umNome);
        this.flechas = flechas;
        contadorDeElfos();
    }
    
    public Elfo(String nome) {
        super(nome, 100);
        contadorDeElfos();
    }
    
    /**
     * Atira uma flecha, perde uma unidade e da dano no Orc.
     */
    protected void atirarFlecha(Orc orc) {
        flechas--;
        experiencia++;
        orc.recebeAtaque();
    }
    
    protected int getFlechas(){
        return this.flechas;
    }
     
    public String toString(){
       // return (this.nome + " possui " + this.flechas + " " + textoFlechas + " e " + this.experiencia + " " + textoNiveis + " de experiÃªncia.");
       return String.format("%s possui %d %s e %d %s de experiencia.", 
            this.nome, 
            this.flechas, 
            this.flechas == 1 ? "flecha" : "flechas", 
            this.experiencia, 
            this.experiencia == 1 ? "nivel" : "niveis");
    }
    
    public int contadorDeElfos(){
        return contador ++;
    }
    
    public static void zerar(){
        contador = 0;
    }
}
