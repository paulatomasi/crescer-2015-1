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
public class ExercitoDeElfos.
{
    @Test
    public void alistarElfoNorturno(){
         ElfoNoturno elfo = new ElfoNoturno();
         HashMap<String, Elfo> elfosAlistadosExperado = new HashMap<>();
         ExercitosDeElfos elfosAlistados = new ExercitosDeElfos();
         elfosAlistado.alistarElfo(elfo);
         HashMap<String, Elfo> elfosAlistadosObtido = elfosAlistados.getExercito();
         assertEquals(elfosAlistadosExperado, elfosAlistadosObtido);
    }

    @Test
    public void alistarElfoVerde(){
         ElfoVerde elfo = new ElfoVerde ();
         HashMap<String, Elfo> elfosAlistadosExperado = new HashMap<>();
         ExercitosDeElfos elfosAlistados = new ExercitosDeElfos();
         elfosAlistado.alistarElfo(elfo);
         HashMap<String, Elfo> elfosAlistadosObtido = elfosAlistados.getExercito();
         assertEquals(elfosAlistadosExperado, elfosAlistadosObtido);
    }

    @Test
    public void alistarElfoVerde(){
         Elfo elfo = new Elfo();
         HashMap<String, Elfo> elfosAlistadosExperado = new HashMap<>();
         ExercitosDeElfos elfosAlistados = new ExercitosDeElfos();
         elfosAlistado.alistarElfo(elfo);
         HashMap<String, Elfo> elfosAlistadosObtido = elfosAlistados.getExercito();
         assertEquals(elfosAlistadosExperado, elfosAlistadosObtido);
    }

    @Test
    public void alistarElfoVerde(){
         ElfoVerde elfoVerde = new ElfoVerde();
         ElfoNoturno elfoNoturno = new ElfoNoturno();
         ElfoNoturno elfoNoturno2 = new ElfoNoturno();
	 Elfo elfo = new Elfo();
         HashMap<String, Elfo> elfosAlistadosExperado = new HashMap<>();
         ExercitosDeElfos elfosAlistados = new ExercitosDeElfos();
         elfosAlistado.alistarElfo(elfoVerde);
         elfosAlistado.alistarElfo(elfoNoturno);
         elfosAlistado.alistarElfo(elfoNoturno2);
         elfosAlistado.alistarElfo(elfo);
         HashMap<String, Elfo> elfosAlistadosObtido = elfosAlistados.getExercito();
         assertEquals(elfosAlistadosExperado, elfosAlistadosObtido);
    }
}
