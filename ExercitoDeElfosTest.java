import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
/**
 * The test class ExercitoDeElfos.
 * 
 * @author Paula Tomasi 
 */
public class ExercitoDeElfosTest
{
    @Test
    public void alistarElfoNorturno(){
         ElfoNoturno elfo = new ElfoNoturno("Legolas");
         HashMap<String, Elfo> elfosAlistadosExperado = new HashMap<>();
         ExercitoDeElfos elfosAlistados = new ExercitoDeElfos();
         elfosAlistadosExperado.put(elfo.getNome(), elfo);
         elfosAlistados.alistarElfo(elfo);
         HashMap<String, Elfo> elfosAlistadosObtido = elfosAlistados.getElfosAlistados();
         assertEquals(elfosAlistadosExperado, elfosAlistadosObtido);
    }

    @Test
    public void alistarElfoVerde(){
         ElfoVerde elfo = new ElfoVerde ("Elfo verde");
         HashMap<String, Elfo> elfosAlistadosExperado = new HashMap<>();
         ExercitoDeElfos elfosAlistados = new ExercitoDeElfos();
         elfosAlistadosExperado.put(elfo.getNome(), elfo);
         elfosAlistados.alistarElfo(elfo);
         HashMap<String, Elfo> elfosAlistadosObtido = elfosAlistados.getElfosAlistados();
         assertEquals(elfosAlistadosExperado, elfosAlistadosObtido);
    }

    @Test
    public void alistarElfo(){
         Elfo elfo = new Elfo("Elfo");
         HashMap<String, Elfo> elfosAlistadosExperado = new HashMap<>();
         ExercitoDeElfos elfosAlistados = new ExercitoDeElfos();
         elfosAlistados.alistarElfo(elfo);
         HashMap<String, Elfo> elfosAlistadosObtido = elfosAlistados.getElfosAlistados();
         assertEquals(elfosAlistadosExperado, elfosAlistadosObtido);
    }
    
    @Test
    public void alistarElfos(){
         ElfoVerde elfoVerde = new ElfoVerde("Verde");
         ElfoNoturno elfoNoturno = new ElfoNoturno("Noturno");
         ElfoNoturno elfoNoturno2 = new ElfoNoturno("Noturninho");
         Elfo elfo = new Elfo("Elfo");
         HashMap<String, Elfo> elfosAlistadosExperado = new HashMap<>();
         ExercitoDeElfos elfosAlistados = new ExercitoDeElfos();
         elfosAlistadosExperado.put(elfoVerde.getNome(), elfoVerde);
         elfosAlistadosExperado.put(elfoNoturno.getNome(), elfoNoturno);
         elfosAlistadosExperado.put(elfoNoturno2.getNome(), elfoNoturno2);
         elfosAlistados.alistarElfo(elfoVerde);
         elfosAlistados.alistarElfo(elfoNoturno);
         elfosAlistados.alistarElfo(elfoNoturno2);
         elfosAlistados.alistarElfo(elfo);
         HashMap<String, Elfo> elfosAlistadosObtido = elfosAlistados.getElfosAlistados();
         assertEquals(elfosAlistadosExperado, elfosAlistadosObtido);
    }
}
