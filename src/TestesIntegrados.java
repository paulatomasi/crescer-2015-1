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
    @Test
    public void umElfoAtiraEmDoisOrcs(){
        Elfo elfo = new Elfo("Legolas");
        Orc orc1 = new Orc();
        Orc orc2 = new Orc();
        elfo.atirarFlecha(orc1);
        elfo.atirarFlecha(orc2);
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        int vidaEsperadaOrc1 = 100;
        int vidaEsperadaOrc2 = 100;
        String toStringEsperadoOrc = "Vida atual: 100";
        String toStringEsperadoElfo = "Legolas possui 40 flechas e 2 nível(eis) de experiência.";
        
       assertEquals(experienciaEsperada, elfo.getExperiencia());
       assertEquals(flechasEsperadas, elfo.getFlechas());
       assertEquals(vidaEsperadaOrc1, orc1.getVida());
       assertEquals(vidaEsperadaOrc2, orc2.getVida());
       assertEquals(toStringEsperadoOrc, orc1.toString());
       assertEquals(toStringEsperadoOrc, orc2.toString());
       assertEquals(toStringEsperadoElfo, elfo.toString());
    }
}