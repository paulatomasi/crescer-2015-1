import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaElfosVerdesTest
{
    @Test
    public void exercitoEmbaralhadoEstrategiaElfosVerdes() throws NaoPodeAlistarException {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudaDeEstrategia(new EstrategiaElfosVerdes());
        Elfo noturno = new ElfoNoturno("Noturno 1");
        Elfo noturno2 = new ElfoNoturno("Noturno 2");
        Elfo verde = new ElfoVerde("Verde 1");
        Elfo noturno3 = new ElfoNoturno("Noturno 3");
        Elfo verde2 = new ElfoVerde("Verde 2");
        exercito.alistarElfo(noturno);
        exercito.alistarElfo(noturno2);
        exercito.alistarElfo(verde);
        exercito.alistarElfo(noturno3);
        exercito.alistarElfo(verde2);
        ArrayList<Elfo> esperado = new ArrayList<>(
        Arrays.asList(verde2, verde, noturno, noturno2, noturno3)
        );
        exercito.atacarHorda(new ArrayList<>(
        Arrays.asList(new Orc(), new Orc(), new Orc())
        ));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }
    
    @Test
    public void exercitoSóDeVerdes() throws NaoPodeAlistarException {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudaDeEstrategia(new EstrategiaElfosVerdes());
        Elfo verde = new ElfoVerde("Verde 1");
        Elfo verde2 = new ElfoVerde("Verde 2");
        exercito.alistarElfo(verde);
        exercito.alistarElfo(verde2);
        ArrayList<Elfo> esperado = new ArrayList<>(
        Arrays.asList(verde2, verde)
        );
        exercito.atacarHorda(new ArrayList<>(
        Arrays.asList(new Orc(), new Orc(), new Orc())));
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }
}