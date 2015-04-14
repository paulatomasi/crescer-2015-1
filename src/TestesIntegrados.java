import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Testes integrados entre objetos Elfo e Orc.
 *
 * @author  CWI Software
*/
public class TestesIntegrados
{
    private final double DELTA = 0.005;
    
    @Test
    public void umElfoAtiraEmDoisOrcs(){
        Elfo elfo = new Elfo("Legolas");
        Orc orc1 = new Orc("Nome Grande Aqui 1");
        Orc orc2 = new Orc("Nome Grande Aqui 2");
        elfo.atirarFlecha(orc1);
        elfo.atirarFlecha(orc2);
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        double vidaEsperadaOrc1 = 100;
        double vidaEsperadaOrc2 = 100;
        String toStringEsperadoOrc = "Vida atual: 100.0";
        String toStringEsperadoElfo = "Legolas possui 40 flechas e 2 niveis de experiencia.";
        
       assertEquals(experienciaEsperada, elfo.getExperiencia());
       assertEquals(flechasEsperadas, elfo.getFlechas());
       assertEquals(vidaEsperadaOrc1, orc1.getVida(), DELTA);
       assertEquals(vidaEsperadaOrc2, orc2.getVida(), DELTA);
       assertEquals(toStringEsperadoOrc, orc1.toString());
       assertEquals(toStringEsperadoOrc, orc2.toString());
       assertEquals(toStringEsperadoElfo, elfo.toString());
    }
}