import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaIntercaladaTest
{
    @Test
    public void exercitoIntercaladoComeçandoComElfoVerde() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudaDeEstrategia(new EstrategiaIntercalada());
        Elfo noturno = new ElfoNoturno("Noturno");
        Elfo noturno2 = new ElfoNoturno("Noturno 2");
        Elfo noturno3 = new ElfoNoturno("Noturno 3");
        Elfo verde = new ElfoVerde("Verde");
        Elfo verde2 = new ElfoVerde("Verde 2");
        Elfo verde3 = new ElfoVerde("Verde 3");
        exercito.alistarElfo(verde);
        exercito.alistarElfo(verde3);
        exercito.alistarElfo(noturno);
        exercito.alistarElfo(noturno2);
        exercito.alistarElfo(verde2);
        exercito.alistarElfo(noturno3);
        ArrayList<Elfo> esperado = new ArrayList<>(
            Arrays.asList(verde2, noturno2, verde, noturno3, verde3, noturno));
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc())));
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertEquals(esperado, resultado);
    }
    
   @Test
    public void exercitoIntercaladoComeçandoComElfoNoturno() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudaDeEstrategia(new EstrategiaIntercalada());
        Elfo night1 = new ElfoNoturno("Noturno 1");
        Elfo night2 = new ElfoNoturno("Elfo Noturno 2");
        Elfo green1 = new ElfoVerde("Elfo Verde 1");
        Elfo green2 = new ElfoVerde("Green 2");
        exercito.alistarElfo(green1);
        exercito.alistarElfo(green2);
        exercito.alistarElfo(night1);
        exercito.alistarElfo(night2);
        ArrayList<Elfo> esperado = new ArrayList<>(
            Arrays.asList(night1, green2, night2, green1)
        );
        // Act
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc())
        ));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void exercitoDesproporcionalNãoAtaca() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudaDeEstrategia(new EstrategiaIntercalada());
        Elfo noturno = new ElfoNoturno("Noturno");
        Elfo noturno2 = new ElfoNoturno("Noturno 2");
        Elfo verde = new ElfoVerde("Verde");
        exercito.alistarElfo(verde);
        exercito.alistarElfo(noturno);
        exercito.alistarElfo(noturno2);
        ArrayList<Elfo> esperado = new ArrayList<>();
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc())));
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertEquals(esperado, resultado);
    }
}