import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class OrcTest.
 *
 * @author  Paula Tomasi
 */
public class OrcTest
{
    @Test
    public void orcNasceCom110vida(){
        //Arange - Montagem dos dados do teste
        // Act - Execução da ação do teste
        // Assert - Verificação se o resultado é o esperado
        Orc orc = new Orc();
        int esperado = 110;
        int obtido = orc.getVida();
        assertEquals(obtido, esperado);
    }
    public void orcRecebeUmAtaque(){
    Orc orc = new Orc();
   orc.recebeAtaque();
    int esperado = 100;
    int resultadoObtido = orc.getVida();
    assertEquals(esperado, resultadoObtido);
    }
    
    public void orcRecebeDoisAtaques(){
    Orc orc = new Orc();
    orc.recebeAtaque();
    orc.recebeAtaque();
    int esperado = 90;
    int resultadoObtido = orc.getVida();
    assertEquals(esperado, resultadoObtido);
    }
    
    public void orcRecebeCincoAtaques(){
    Orc orc = new Orc();
    orc.recebeAtaque();
    orc.recebeAtaque();
    orc.recebeAtaque();
    orc.recebeAtaque();
    orc.recebeAtaque();
    int esperado = 60;
    int resultadoObtido = orc.getVida();
    assertEquals(esperado, resultadoObtido);
    }
}