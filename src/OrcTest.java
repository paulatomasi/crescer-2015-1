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
	    int vidaEsperada = 100;
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
	
}