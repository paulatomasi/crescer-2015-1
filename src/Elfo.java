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
     * @param umNome Nome que o elfo receberá
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
     * Atira uma flecha, perde uma unidade e dá dano no Orc.
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
}
