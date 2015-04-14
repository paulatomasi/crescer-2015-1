import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class ElfoTest.
 *
 * @author  Paula Tomasi
 */
public class ElfoTest
{
   private final double DELTA = 0.005;
    
   @Test
   public void elfoNasceComNome(){
    String esperado = "Legolas";
    Elfo elfo = new Elfo(esperado);
    
    assertEquals(esperado, elfo.getNome());
    assertEquals(1, elfo.getContadorDeElfos());
   }
   
   @Test
   public void contadorRetorna2(){
       Elfo elfo1 = new Elfo("Elfo1");
       Elfo elfo2 = new Elfo("Elfo2");
       assertEquals(2, elfo2.getContadorDeElfos());
   }
   
   @Test
   public void contadorRetorna10(){
       Elfo elfo1 = new Elfo("Elfo1");
       Elfo elfo2 = new Elfo("Elfo2");
       Elfo elfo3 = new Elfo("Elfo3");
       Elfo elfo4 = new Elfo("Elfo4");
       Elfo elfo5 = new Elfo("Elfo5");
       Elfo elfo6 = new Elfo("Elfo6");
       Elfo elfo7 = new Elfo("Elfo7");
       Elfo elfo8 = new Elfo("Elfo8");
       Elfo elfo9 = new Elfo("Elfo9");
       Elfo elfo10 = new Elfo("Elfo10");
       assertEquals(10, elfo10.getContadorDeElfos());
   }
    
   @Test    
   public void elfoNasceCom42Flechas(){
    int esperado = 42;
    Elfo elfo = new Elfo("Qualquer um");
    assertEquals(esperado, elfo.getFlechas());
    elfo.zerar();
   }
   
   @Test
   public void elfoNasceComNomeEFlechasInformados(){
       String nome = "Barbie";
       int flechas = 9999;
       Elfo elfo = new Elfo(nome, flechas);
       assertEquals(nome, elfo.getNome());
       assertEquals(flechas, elfo.getFlechas());
       elfo.zerar();
   }   
   
   @Test
   public void elfoNasceCom100DeVida(){
       Elfo elfo = new Elfo("Legolas");
       double vidaEsperada = 100;
       assertEquals(vidaEsperada, elfo.getVida(), DELTA);
       elfo.zerar();
   }
   
   @Test
   public void elfoAtiraFlechaEmUmOrc(){
       Elfo elfo = new Elfo("Legolas");
       Orc orc = new Orc ();
       elfo.atirarFlecha(orc);
       int experiencia = 1;
       int flechas = 41;
       assertEquals(experiencia, elfo.getExperiencia());
       assertEquals(flechas, elfo.getFlechas());
       elfo.zerar();
   } 
   
   @Test
   public void elfoAtiraFlechasNoMesmoOrc(){
       Elfo elfo = new Elfo("Legolas");
       Orc orc = new Orc ();
       elfo.atirarFlecha(orc);
       elfo.atirarFlecha(orc);
       int experiencia = 2;
       int flechas = 40;
       assertEquals(experiencia, elfo.getExperiencia());
       assertEquals(flechas, elfo.getFlechas());
       elfo.zerar();
   }
   
   @Test
   public void elfoToStringPadrao(){
        Elfo elfo = new Elfo("Legolas");
        String esperado = ("Legolas possui 42 flechas e 0 niveis de experiencia.");
        String resultadoObtido = elfo.toString();
        assertEquals(esperado, resultadoObtido);
        elfo.zerar();
    }
   
   
   @Test
   public void elfoToStringAtiraFlecha(){
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc();
        elfo.atirarFlecha(orc);
        String esperado = ("Legolas possui 41 flechas e 1 nivel de experiencia.");
        String resultadoObtido = elfo.toString();
        assertEquals(esperado, resultadoObtido);
        elfo.zerar();
    }
    
   @Test
   public void elfoToStringAtira10Flechas(){
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc();
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        String esperado = ("Legolas possui 32 flechas e 10 niveis de experiencia.");
        String resultadoObtido = elfo.toString();
        assertEquals(esperado, resultadoObtido);
        elfo.zerar();
    }
    
   @Before
   public void SetUp(){
       Elfo.zerar();
   }
}