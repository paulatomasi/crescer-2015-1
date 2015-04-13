import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class ElfoNoturnoTest.
 * 
 * @author Paula Tomasi 
 */
public class ElfoNoturnoTest
{
    
   @Test
   public void elfoNoturnoNasceComNome(){
       String esperado = "Legolas";
       ElfoNoturno elfoNoturno = new ElfoNoturno(esperado);
       assertEquals(esperado, elfoNoturno.getNome());
   }

   @Test    
   public void elfoNoturnoNasceCom42Flechas(){
       int esperado = 42;
       ElfoNoturno elfoNoturno = new ElfoNoturno("Qualquer um");
       assertEquals(esperado, elfoNoturno.getFlechas());
   }
   
   @Test
   public void elfoNoturnoNasceComNomeEFlechasInformados(){
       String nome = "Barbie";
       int flechas = 9999;
       ElfoNoturno elfoNoturno = new ElfoNoturno(nome, flechas);
       assertEquals(nome, elfoNoturno.getNome());
       assertEquals(flechas, elfoNoturno.getFlechas());
   }  
   
   @Test
   public void elfoNoturnoPerde5DeVidaQuandoAtiraUmaFlecha(){
       String nome = "Barbie";
       ElfoNoturno elfoNoturno = new ElfoNoturno(nome);
       Orc orc = new Orc ();
       elfoNoturno.atirarFlecha(orc);
       int vidaEsperada = 95;
       int expEsperada = 3;
       assertEquals(nome, elfoNoturno.getNome());
       assertEquals(vidaEsperada, elfoNoturno.getVida());
       assertEquals(expEsperada, elfoNoturno.getExperiencia());
   }
   
   @Test
   public void elfoNoturnoPerde5DeVidaQuandoAtiraDuasFlecha(){
       String nome = "Barbie";
       ElfoNoturno elfoNoturno = new ElfoNoturno(nome);
       Orc orc = new Orc ();
       elfoNoturno.atirarFlecha(orc);
       elfoNoturno.atirarFlecha(orc);
       int vidaEsperada = 90;
       int expEsperada = 6;
       assertEquals(nome, elfoNoturno.getNome());
       assertEquals(vidaEsperada, elfoNoturno.getVida());
       assertEquals(expEsperada, elfoNoturno.getExperiencia());
   }

}