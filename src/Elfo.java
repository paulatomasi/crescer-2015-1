/**
 * Define objetos Elfo
 * 
 * @author Paula Tomasi
 */
public class Elfo
{
    private String nome;
    private int flechas = 42;
    private int experiencia = 0;
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
    }
    
    public Elfo(String nome) {
        this.nome = nome;
    }
    /**
     * Atira uma flecha, perde uma unidade e da dano no Orc.
     */
    public void atirarFlecha(Orc orc) {
        flechas--;
        experiencia++;
        orc.recebeAtaque();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getFlechas(){
        return this.flechas;
    }

    public int getExperiencia(){
        return this.experiencia;
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
}