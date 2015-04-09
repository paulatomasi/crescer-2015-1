import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class OrcTest.
 *
 * @author  Paula Tomasi
 */
public class OrcTest
{
    @Test
    public void orcNasceComNomeInformado(){
        String nomeEsperado = "Tom";
        Orc orc = new Orc(nomeEsperado);
        assertEquals(nomeEsperado, orc.getNome());
    }
    
    @Test
    public void orcNasceComNomeVazio(){
        String nomeEsperado = "";
        Orc orc = new Orc(nomeEsperado);
        assertEquals(nomeEsperado, orc.getNome());
    }
    
    @Test
    public void orcNasceComNomeNulo(){
        String nomeEsperado = null;
        Orc orc = new Orc(nomeEsperado);
        assertEquals(nomeEsperado, orc.getNome());
    }
    
    @Test
    public void orcNasceVivo(){
        Orc orc = new Orc();
        Status esperado = Status.VIVO;
        assertEquals(esperado, orc.getStatus());
    }
    
    @Test
    public void orcRecebeUmAtaque(){
        Orc orc = new Orc("Nome Grande Aqui");
        orc.recebeAtaque();
        int esperado = 100;
        int resultadoObtido = orc.getVida();
        assertEquals(esperado, resultadoObtido);
    }

    @Test
    public void orcFericoAposReceberAtaque(){
        Orc orc = new Orc("Nome Grande Aqui");
        orc.recebeAtaque();
        Status statusEsperado = Status.FERIDO;
        assertEquals(statusEsperado, orc.getStatus());
    }
    
    @Test
    public void orcRecebeDoisAtaques(){
        Orc orc = new Orc("Nome Grande Aqui");
        orc.recebeAtaque();
        orc.recebeAtaque();
        int esperado = 90;
        int resultadoObtido = orc.getVida();
        assertEquals(esperado, resultadoObtido);
    }

    @Test
    public void orcRecebeCincoAtaques(){
        Orc orc = new Orc("Nome Grande Aqui");
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        int esperado = 60;
        int resultadoObtido = orc.getVida();
        assertEquals(esperado, resultadoObtido);
    }

    @Test
    public void orcToStringAposRecebeDozeAtaques(){
        Orc orc = new Orc("Nome Grande Aqui");
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        String esperado = "Vida atual: 0";
        String resultadoObtido = orc.toString();
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcMorreAoZerarVida(){
        Orc orc = new Orc("Nome Grande Aqui");
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        Status statusEsperado = Status.MORTO;
        assertEquals(statusEsperado, orc.getStatus());
    }
    
    @Test
    public void orcToStringVidaPadrao(){
        Orc orc = new Orc();
        String esperado = "Vida atual: 110";
        String resultadoObtido = orc.toString();
        assertEquals(esperado, resultadoObtido);
    }

    @Test
    public void orcToStringAposRecebeAtaque(){
        Orc orc = new Orc();
        orc.recebeAtaque();
        String esperado = "Vida atual: 110";
        String resultadoObtido = orc.toString();
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberDozeAtaques() {
        Orc orc = new Orc("Nome Grande Aqui");
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        String esperado = "Vida atual: 0";
        String resultadoObtido = orc.toString();
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoMenorQueZero(){
        Orc orc = new Orc("Tom");
        orc.recebeAtaque();
        int vidaEsperada = 110;
        int experienciaEsperada = 2;
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroEntre0E100(){
        Orc orc = new Orc("Nome Grande Aqui");
        orc.setExperiencia(1);
        orc.recebeAtaque();
        int vidaEsperada = 110;
        int experienciaEsperada = 1;
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroMaiorQue100(){
        Orc orc = new Orc("Tomzinho");
        orc.setExperiencia(2);
        orc.recebeAtaque();
        int vidaEsperada = 100;
        int experienciaEsperada = 2;
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeUmItem(){
        Orc orc = new Orc("Nome Grande Aqui");
        ItemDoInventario item1 = new ItemDoInventario("Clava", 5);
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ArrayList<ItemDoInventario> inventarioObtido = orc.getItem();
        orc.adicionarItem(item1);
        inventarioEsperado.add(item1);
        assertEquals(inventarioEsperado, inventarioObtido);
    }
    
    @Test
    public void orcRecebeDoisItem(){
        Orc orc = new Orc("Nome Grande Aqui");
        ItemDoInventario item1 = new ItemDoInventario("Clava", 5);
        ItemDoInventario item2 = new ItemDoInventario("Adaga", 9);
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ArrayList<ItemDoInventario> inventarioObtido = orc.getItem();
        orc.adicionarItem(item1);
        orc.adicionarItem(item2);
        inventarioEsperado.add(item1);
        inventarioEsperado.add(item2);
        assertEquals(inventarioEsperado, inventarioObtido);
    }
    
    @Test
    public void orcRecebeDezItens(){
        Orc orc = new Orc("Nome Grande Aqui");
        ItemDoInventario item1 = new ItemDoInventario("Clava", 5);
        ItemDoInventario item2 = new ItemDoInventario("Adaga", 9);
        ItemDoInventario item3 = new ItemDoInventario("Machado", 2);
        ItemDoInventario item4 = new ItemDoInventario("Lanca", 6);
        ItemDoInventario item5 = new ItemDoInventario("Arco", 1);
        ItemDoInventario item6 = new ItemDoInventario("Espada", 3);
        ItemDoInventario item7 = new ItemDoInventario("Punhal", 7);
        ItemDoInventario item8 = new ItemDoInventario("Arma", 8);
        ItemDoInventario item9 = new ItemDoInventario("Metralhadora", 2);
        ItemDoInventario item10 = new ItemDoInventario("Bazuca", 6);
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ArrayList<ItemDoInventario> inventarioObtido = orc.getItem();
        orc.adicionarItem(item1);
        orc.adicionarItem(item2);
        orc.adicionarItem(item3);
        orc.adicionarItem(item4);
        orc.adicionarItem(item5);
        orc.adicionarItem(item6);
        orc.adicionarItem(item7);
        orc.adicionarItem(item8);
        orc.adicionarItem(item9);
        orc.adicionarItem(item10);
        inventarioEsperado.add(item1);
        inventarioEsperado.add(item2);
        inventarioEsperado.add(item3);
        inventarioEsperado.add(item4);
        inventarioEsperado.add(item5);
        inventarioEsperado.add(item6);
        inventarioEsperado.add(item7);
        inventarioEsperado.add(item8);
        inventarioEsperado.add(item9);
        inventarioEsperado.add(item10);
        assertEquals(inventarioEsperado, inventarioObtido);
    }
    
    @Test
    public void orcRecebeUmItemEPerdeUmItem(){
        Orc orc = new Orc("Nome Grande Aqui");
        ItemDoInventario item1 = new ItemDoInventario("Clava", 5);
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ArrayList<ItemDoInventario> inventarioObtido = orc.getItem();
        orc.adicionarItem(item1);
        inventarioEsperado.add(item1);
        orc.perderItem(item1);
        inventarioEsperado.remove(item1);
        assertEquals(inventarioEsperado, inventarioObtido);
    }
    
    @Test
    public void orcRecebetTresItensEPerdeDoisItens(){
        Orc orc = new Orc("Nome Grande Aqui");
        ItemDoInventario item1 = new ItemDoInventario("Clava", 5);
        ItemDoInventario item2 = new ItemDoInventario("Adaga", 9);
        ItemDoInventario item3 = new ItemDoInventario("Machado", 2);
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ArrayList<ItemDoInventario> inventarioObtido = orc.getItem();
        orc.adicionarItem(item1);
        inventarioEsperado.add(item1);
        orc.perderItem(item1);
        inventarioEsperado.remove(item1);
        orc.adicionarItem(item2);
        inventarioEsperado.add(item2);
        orc.perderItem(item2);
        inventarioEsperado.remove(item2);
        orc.adicionarItem(item3);
        inventarioEsperado.add(item3);
        orc.perderItem(item3);
        inventarioEsperado.remove(item3);
        assertEquals(inventarioEsperado, inventarioObtido);
    }
        @Test
    public void orcRecebeDezItensEPerdeSeisItens(){
        Orc orc = new Orc("Nome Grande Aqui");
        ItemDoInventario item1 = new ItemDoInventario("Clava", 5);
        ItemDoInventario item2 = new ItemDoInventario("Adaga", 9);
        ItemDoInventario item3 = new ItemDoInventario("Machado", 2);
        ItemDoInventario item4 = new ItemDoInventario("Lanca", 6);
        ItemDoInventario item5 = new ItemDoInventario("Arco", 1);
        ItemDoInventario item6 = new ItemDoInventario("Espada", 3);
        ItemDoInventario item7 = new ItemDoInventario("Punhal", 7);
        ItemDoInventario item8 = new ItemDoInventario("Arma", 8);
        ItemDoInventario item9 = new ItemDoInventario("Metralhadora", 2);
        ItemDoInventario item10 = new ItemDoInventario("Bazuca", 6);
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ArrayList<ItemDoInventario> inventarioObtido = orc.getItem();
        orc.adicionarItem(item1);
        orc.adicionarItem(item2);
        orc.adicionarItem(item3);
        orc.adicionarItem(item4);
        orc.adicionarItem(item5);
        orc.adicionarItem(item6);
        orc.adicionarItem(item7);
        orc.adicionarItem(item8);
        orc.adicionarItem(item9);
        orc.adicionarItem(item10);
        inventarioEsperado.add(item1);
        inventarioEsperado.add(item2);
        inventarioEsperado.add(item3);
        inventarioEsperado.add(item4);
        inventarioEsperado.add(item5);
        inventarioEsperado.add(item6);
        inventarioEsperado.add(item7);
        inventarioEsperado.add(item8);
        inventarioEsperado.add(item9);
        inventarioEsperado.add(item10);
        orc.perderItem(item1);
        orc.perderItem(item2);
        orc.perderItem(item3);
        orc.perderItem(item5);
        orc.perderItem(item7);
        orc.perderItem(item9);
        inventarioEsperado.remove(item1);
        inventarioEsperado.remove(item2);
        inventarioEsperado.remove(item3);
        inventarioEsperado.remove(item5);
        inventarioEsperado.remove(item7);
        inventarioEsperado.remove(item9);
        assertEquals(inventarioEsperado, inventarioObtido);
    }
    
    @Test
    public void getDescricoesComNenhumItem(){
        Orc orc = new Orc();
        String descricaoEsperada = "";
        assertEquals(descricaoEsperada, orc.getDescricoesItens());
    }
    
    @Test
    public void getDescricoesComUmItem(){
        Orc orc = new Orc();
        ItemDoInventario item1 = new ItemDoInventario("Clava", 5);
        orc.adicionarItem(item1);
        String descricaoEsperada = "Clava";
        assertEquals(descricaoEsperada, orc.getDescricoesItens());
    }
    
    @Test
    public void getDescricoesComCincoItens(){
        Orc orc = new Orc();
        ItemDoInventario item1 = new ItemDoInventario("Clava", 5);
        ItemDoInventario item2 = new ItemDoInventario("Adaga", 9);
        ItemDoInventario item3 = new ItemDoInventario("Machado", 2);
        ItemDoInventario item4 = new ItemDoInventario("Lanca", 6);
        ItemDoInventario item5 = new ItemDoInventario("Arco", 1);
        orc.adicionarItem(item1);
        orc.adicionarItem(item2);
        orc.adicionarItem(item3);
        orc.adicionarItem(item4);
        orc.adicionarItem(item5);
        String descricaoEsperada = "Clava,Adaga,Machado,Lanca,Arco";
        assertEquals(descricaoEsperada, orc.getDescricoesItens());
    }
    
    @Test
    public void orcTentarSorteAumenta1000UnidadesDosItens() {
        // Arrange
        Orc urukhai = new Orc();
        urukhai.setStatus(Status.DORMINDO);
        urukhai.setExperiencia(3);
        urukhai.adicionarItem(new ItemDoInventario("Pocao de mana", 3));
        urukhai.adicionarItem(new ItemDoInventario("Pocao de lanca", 1));
        // Act
        urukhai.tentarSorte();
        // Assert
        ItemDoInventario pocao = urukhai.getItem().get(0);
        ItemDoInventario lanca = urukhai.getItem().get(1);
        assertEquals(1003, pocao.getQuantidade());
        assertEquals(1001, lanca.getQuantidade());
    }
    
    @Test
    public void orcTentaSorteNaoFazNada(){
         Orc orc = new Orc();
         orc.adicionarItem(new ItemDoInventario("Pocao de mana", 3));
         orc.adicionarItem(new ItemDoInventario("Pocao de lanca", 1));
         orc.tentarSorte();
         ItemDoInventario pocao = orc.getItem().get(0);
         ItemDoInventario lanca = orc.getItem().get(1);
         assertEquals(3, pocao.getQuantidade());
         assertEquals(1, lanca.getQuantidade());
    }
    
    @Test
    public void testarItemComMaiorQuantidade(){
        Orc orc = new Orc();
        ItemDoInventario item1 = new ItemDoInventario("Pocao de mana", 3);
        ItemDoInventario item2 = new ItemDoInventario("Pocao de lanca", 1);
        orc.adicionarItem(item1);
        orc.adicionarItem(item2);
        ItemDoInventario resultadoEsperado = orc.getItem().get(0);
        ItemDoInventario resutladoObtido = orc.getItemComMaiorQuantidade();
        assertEquals(resultadoEsperado, resutladoObtido);
    }
    
    @Test
    public void testarItemComMaiorQuantidadeComUmItem(){
        Orc orc = new Orc();
        ItemDoInventario item1 = new ItemDoInventario("Pocao de mana", 3);
        orc.adicionarItem(item1);
        ItemDoInventario resultadoEsperado = orc.getItem().get(0);
        ItemDoInventario resutladoObtido = orc.getItemComMaiorQuantidade();
        assertEquals(resultadoEsperado, resutladoObtido);
    }
    
    @Test
    public void testarItemComMaiorQuantidadeComInventarioVazio(){
        Orc orc = new Orc();
        ItemDoInventario resultadoEsperado = null;
        ItemDoInventario resutladoObtido = orc.getItemComMaiorQuantidade();
        assertEquals(resultadoEsperado, resutladoObtido);
    }
    
    @Test
    public void testarDoisItensComMesmaQuantidade(){
        Orc orc = new Orc();
        ItemDoInventario item1 = new ItemDoInventario("Pocao de mana", 3);
        ItemDoInventario item2 = new ItemDoInventario("Pocao de lanca", 3);
        orc.adicionarItem(item1);
        orc.adicionarItem(item2);
        ItemDoInventario resultadoEsperado = orc.getItem().get(0);
        ItemDoInventario resutladoObtido = orc.getItemComMaiorQuantidade();
        assertEquals(resultadoEsperado, resutladoObtido);
    }
    
    @Test
    public void qualItemTemMaiorQuantidade(){
        Orc orc = new Orc();
        ItemDoInventario item1 = new ItemDoInventario("Adaga", 15);
        ItemDoInventario item2 = new ItemDoInventario("Pocao", 2);
        ItemDoInventario item3 = new ItemDoInventario("Flechas", 17);
        ItemDoInventario item4 = new ItemDoInventario("Pedras preciosas", 9);
        ItemDoInventario item5 = new ItemDoInventario("Beyblade", 18);
        orc.adicionarItem(item1);
        orc.adicionarItem(item2);
        orc.adicionarItem(item3);
        orc.adicionarItem(item4);
        orc.adicionarItem(item5);
        ItemDoInventario resultadoEsperado = orc.getItem().get(4);
        ItemDoInventario resutladoObtido = orc.getItemComMaiorQuantidade();
        assertEquals(resultadoEsperado, resutladoObtido);
    }
}