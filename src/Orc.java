/**
 * Define objeto Orc
 * 
 * @author Paula Tomasi
 */
public class Orc
{
    private int vida = 110;
    /**
     * Perde vida quando recebe ataque
     */
    public void recebeAtaque(){
        vida = vida - 10;
    }
    public int getVida(){
    return this.vida;
    }
}
