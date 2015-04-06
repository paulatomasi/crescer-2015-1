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
   @Test
   public void elfoNasceComNome(){
    String esperado = "Legolas";
    Elfo elfo = new Elfo(esperado);
    assertEquals(esperado, elfo.getNome());
   }
    
   @Test    
   public void elfoNasceCom42Flechas(){
    int esperado = 42;
    Elfo elfo = new Elfo("Qualquer um");
    assertEquals(esperado, elfo.getFlechas());
   }
   
   @Test
   public void elfoNasceComNomeEFlechasInformados(){
   String nome = "Barbie";
   int flechas = 9999;
   Elfo elfo = new Elfo(nome, flechas);
   assertEquals(nome, elfo.getNome());
   assertEquals(flechas, elfo.getFlechas());
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
   } 
   
   @Test
   public void alfoAtiraFlechasNoMesmoOrc(){
       Elfo elfo = new Elfo("Legolas");
       Orc orc = new Orc ();
       elfo.atirarFlecha(orc);
       elfo.atirarFlecha(orc);
       int experiencia = 2;
       int flechas = 40;
       assertEquals(experiencia, elfo.getExperiencia());
       assertEquals(flechas, elfo.getFlechas());
   }
   
   @Test
   public void elfoToStringPadrao(){
        Elfo elfo = new Elfo("Legolas");
        String esperado = ("Legolas possui 42 flechas e 0 nível(eis) de experiência.");
        String resultadoObtido = elfo.toString();
        assertEquals(esperado, resultadoObtido);
    }
   
   
   @Test
   public void elfoToStringAtiraFlecha(){
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc();
        elfo.atirarFlecha(orc);
        String esperado = ("Legolas possui 41 flechas e 1 nível(eis) de experiência.");
        String resultadoObtido = elfo.toString();
        assertEquals(esperado, resultadoObtido);
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
        String esperado = ("Legolas possui 32 flechas e 10 nível(eis) de experiência.");
        String resultadoObtido = elfo.toString();
        assertEquals(esperado, resultadoObtido);
    }
}