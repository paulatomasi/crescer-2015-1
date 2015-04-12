import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class ElvoVerdeTest.
 * 
 * @author Paula Tomasi 
 */
public class ElfoVerdeTest
{
    
   @Test
   public void elfoVerdeNasceComNome(){
    String esperado = "Legolas";
    ElfoVerde elfoVerde = new ElfoVerde(esperado);
    assertEquals(esperado, elfoVerde.getNome());
   }

   @Test    
   public void elfoVerdeNasceCom42Flechas(){
    int esperado = 42;
    ElfoVerde elfoVerde = new ElfoVerde("Qualquer um");
    assertEquals(esperado, elfoVerde.getFlechas());
   }
   
   @Test
   public void elfoVerdeNasceComNomeEFlechasInformados(){
   String nome = "Barbie";
   int flechas = 9999;
   ElfoVerde elfoVerde = new ElfoVerde(nome, flechas);
   assertEquals(nome, elfoVerde.getNome());
   assertEquals(flechas, elfoVerde.getFlechas());
   }  

   @Test
   public void elfoVerdeAtiraFlechaEmUmOrc(){
       ElfoVerde elfoVerde = new ElfoVerde("Legolas");
       Orc orc = new Orc ();
       int experiencia = 2;
       int flechas = 41;
       elfoVerde.atirarFlecha(orc);
       assertEquals(experiencia, elfoVerde.getExperiencia());
       assertEquals(flechas, elfoVerde.getFlechas());
   } 

   @Test
   public void elfoVerdeAtiraFlechasNoMesmoOrc(){
       ElfoVerde elfoVerde = new ElfoVerde("Legolas");
       Orc orc = new Orc ();
       elfoVerde.atirarFlecha(orc);
       elfoVerde.atirarFlecha(orc);
       int experiencia = 4;
       int flechas = 40;
       assertEquals(experiencia, elfoVerde.getExperiencia());
       assertEquals(flechas, elfoVerde.getFlechas());
   }

   @Test
   public void elfoVerdeToStringAtira10Flechas(){
        ElfoVerde elfoVerde = new ElfoVerde("Legolas");
        Orc orc = new Orc();
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        String esperado = ("Legolas possui 32 flechas e 20 niveis de experiencia.");
        String resultadoObtido = elfoVerde.toString();
        assertEquals(esperado, resultadoObtido);
    }

    @Test
    public void elfoVerdeRecebeEspadaDeAcoValiriano() {
        ElfoVerde elfoVerde = new ElfoVerde("Legolas");
        ItemDoInventario item1 = new ItemDoInventario("Espada de aco valiriano", 1); 
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ArrayList<ItemDoInventario> inventarioObtido = elfoVerde.getItem();
        elfoVerde.adicionarItem(item1); 
        inventarioEsperado.add(item1);     
        assertEquals(inventarioEsperado, inventarioObtido);
    }

    @Test
    public void elfoVerdeRecebeArcoEFlechaDeVidro() {
        ElfoVerde elfoVerde = new ElfoVerde("Legolas");
        ItemDoInventario item1 = new ItemDoInventario("Arco e flecha de vidro", 3); 
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ArrayList<ItemDoInventario> inventarioObtido = elfoVerde.getItem();
        elfoVerde.adicionarItem(item1); 
        inventarioEsperado.add(item1);     
        assertEquals(inventarioEsperado, inventarioObtido);
    }
    
    @Test
    public void elfoVerdeRecebeEspadaEAdaga() {
        ElfoVerde elfoVerde = new ElfoVerde("Legolas");
        ItemDoInventario item1 = new ItemDoInventario("Espada de aco valiriano", 1); 
        ItemDoInventario item2 = new ItemDoInventario("Adaga", 3); 
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ArrayList<ItemDoInventario> inventarioObtido = elfoVerde.getItem();
        elfoVerde.adicionarItem(item1); 
        elfoVerde.adicionarItem(item2); 
        inventarioEsperado.add(item1); 
        assertEquals(inventarioEsperado, inventarioObtido);
    }
}
