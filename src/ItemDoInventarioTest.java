import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class ItemDoInventarioTest.
 *
 * @author  Paula Tomasi
 */
public class ItemDoInventarioTest
{
    @Test
    public void itemComDescricaoEQuantidade(){
        int quantidadeEsperada = 12;
        String descricaoEsperada = "Martelo do Thor";
        ItemDoInventario item = new ItemDoInventario(descricaoEsperada,quantidadeEsperada);
        assertEquals(quantidadeEsperada, item.getQuantidade());
        assertEquals(descricaoEsperada, item.getDescricao());
    }
}
