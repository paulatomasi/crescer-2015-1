import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class ExercitoDeElfos.
 * 
 * @author Paula Tomasi 
 */
public class ExercitoDeElfosTest
{
    @Test
     public void alistarElfoBaseNãoAlista() {
         Elfo elfo = new Elfo("Legolas");
         HashMap<String, Elfo> elfosAlistadosEsperado = new HashMap<>();
         ExercitoDeElfos elfosAlistados = new ExercitoDeElfos();
        try {
            elfosAlistados.alistarElfo(elfo);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        HashMap<String, Elfo> elfosAlistadosObtido = elfosAlistados.getElfosAlistados();
        assertEquals(elfosAlistadosEsperado, elfosAlistadosObtido);
     }
    
    @Test
    public void alistarElfoNorturno(){
         ElfoNoturno elfo = new ElfoNoturno("Legolas");
         HashMap<String, Elfo> elfosAlistadosExperado = new HashMap<>();
         ExercitoDeElfos elfosAlistados = new ExercitoDeElfos();
         elfosAlistadosExperado.put(elfo.getNome(), elfo);
         try {
            elfosAlistados.alistarElfo(elfo);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
         HashMap<String, Elfo> elfosAlistadosObtido = elfosAlistados.getElfosAlistados();
         assertEquals(elfosAlistadosExperado, elfosAlistadosObtido);
    }

    @Test
    public void alistarElfoVerde(){
         ElfoVerde elfo = new ElfoVerde ("Elfo verde");
         HashMap<String, Elfo> elfosAlistadosExperado = new HashMap<>();
         ExercitoDeElfos elfosAlistados = new ExercitoDeElfos();
         elfosAlistadosExperado.put(elfo.getNome(), elfo);
        try {
            elfosAlistados.alistarElfo(elfo);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
         HashMap<String, Elfo> elfosAlistadosObtido = elfosAlistados.getElfosAlistados();
         assertEquals(elfosAlistadosExperado, elfosAlistadosObtido);
    }

    @Test
    public void alistarElfo(){
         Elfo elfo = new Elfo("Elfo");
         HashMap<String, Elfo> elfosAlistadosExperado = new HashMap<>();
         ExercitoDeElfos elfosAlistados = new ExercitoDeElfos();
         try {
            elfosAlistados.alistarElfo(elfo);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
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
         try {
            elfosAlistados.alistarElfo(elfoVerde);
            elfosAlistados.alistarElfo(elfoNoturno);
            elfosAlistados.alistarElfo(elfoNoturno2);
            elfosAlistados.alistarElfo(elfo);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
         HashMap<String, Elfo> elfosAlistadosObtido = elfosAlistados.getElfosAlistados();
         assertEquals(elfosAlistadosExperado, elfosAlistadosObtido);
    }
    
    @Test
    public void pegarElfosComStatusMortoEmExercitoDeUmElfoVivoEUmElfoMorto()
    {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Noturno");
        ElfoVerde elfoVerde = new ElfoVerde("Verde");
        elfoNoturno.status = Status.VIVO;
        elfoVerde.status = Status.MORTO;
        ExercitoDeElfos elfosAlistados = new ExercitoDeElfos();
        HashMap<String, Elfo> elfosAlistadosExperado = new HashMap<>();
        elfosAlistadosExperado.put(elfoVerde.getNome(), elfoVerde);
        try {
            elfosAlistados.alistarElfo(elfoNoturno);
            elfosAlistados.alistarElfo(elfoVerde);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        HashMap<String, Elfo> elfosAlistadosObtido = elfosAlistados.buscarElfosComStatusIguais(Status.MORTO);
        assertEquals(elfosAlistadosExperado, elfosAlistadosObtido);
    }
    
    @Test
    public void pegarElfosComStatusMortoEmExercitoDeDoisElfosVivosETresElfosMortos()
    {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Noturno");
        ElfoNoturno elfoNoturno2 = new ElfoNoturno("Noturninho");
        ElfoVerde elfoVerde = new ElfoVerde("Verde");
        ElfoVerde elfoVerde2 = new ElfoVerde("Verdinho");
        ElfoVerde elfoVerde3 = new ElfoVerde("Verdão");
        elfoNoturno.status = Status.VIVO;
        elfoNoturno2.status = Status.MORTO;
        elfoVerde.status = Status.MORTO;
        elfoVerde2.status = Status.VIVO;
        elfoVerde3.status = Status.MORTO;
        ExercitoDeElfos elfosAlistados = new ExercitoDeElfos();
        HashMap<String, Elfo> elfosAlistadosExperado = new HashMap<>();
        elfosAlistadosExperado.put(elfoNoturno2.getNome(), elfoNoturno2);
        elfosAlistadosExperado.put(elfoVerde.getNome(), elfoVerde);
        elfosAlistadosExperado.put(elfoVerde3.getNome(), elfoVerde3);
        try {
            elfosAlistados.alistarElfo(elfoNoturno);
            elfosAlistados.alistarElfo(elfoNoturno2);
            elfosAlistados.alistarElfo(elfoVerde);
            elfosAlistados.alistarElfo(elfoVerde2);
            elfosAlistados.alistarElfo(elfoVerde3);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        HashMap<String, Elfo> elfosAlistadosObtido = elfosAlistados.buscarElfosComStatusIguais(Status.MORTO);
        assertEquals(elfosAlistadosExperado, elfosAlistadosObtido);
    }
    
    @Test
    public void agruparVariosElfosPorStatus() {
        ElfoVerde elfoVivo1 = new ElfoVerde("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        ElfoVerde elfoAtacando1 = new ElfoVerde("Green 2");
        ElfoVerde elfoAtacando2 = new ElfoVerde("Green 3");
        elfoAtacando1.atirarFlecha(new Orc());
        elfoAtacando2.atirarFlecha(new Orc());
        HashMap<Status, ArrayList<Elfo>> esperado = new HashMap<>();
        
        esperado.put(Status.ATACANDO, new ArrayList<>(
            Arrays.asList(elfoAtacando1, elfoAtacando2)
        ));
        esperado.put(Status.VIVO, new ArrayList<>(
            Arrays.asList(elfoVivo2, elfoVivo3, elfoVivo1)
        ));
        
        ExercitoDeElfos elfosAlistados = new ExercitoDeElfos();
        try {
            elfosAlistados.alistarElfo(elfoAtacando1);
            elfosAlistados.alistarElfo(elfoAtacando2);
            elfosAlistados.alistarElfo(elfoVivo1);
            elfosAlistados.alistarElfo(elfoVivo2);
            elfosAlistados.alistarElfo(elfoVivo3);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        elfosAlistados.agruparPorStatus();
        HashMap<Status, ArrayList<Elfo>> resultado = elfosAlistados.getElfosAlistadosPorStatus();
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void buscarPorStatusAtacandoComVariosElfos() {
        ElfoVerde elfoVivo1 = new ElfoVerde("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        ElfoVerde elfoAtacando1 = new ElfoVerde("Green 2");
        ElfoVerde elfoAtacando2 = new ElfoVerde("Green 3");
        elfoAtacando1.atirarFlecha(new Orc());
        elfoAtacando2.atirarFlecha(new Orc());
        
        ArrayList<Elfo> esperado = new ArrayList<>(
            Arrays.asList(elfoAtacando1, elfoAtacando2)
        );
        
        ExercitoDeElfos elfosAlistados = new ExercitoDeElfos();
        try {
            elfosAlistados.alistarElfo(elfoAtacando1);
            elfosAlistados.alistarElfo(elfoAtacando2);
            elfosAlistados.alistarElfo(elfoVivo1);
            elfosAlistados.alistarElfo(elfoVivo2);
            elfosAlistados.alistarElfo(elfoVivo3);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        ArrayList<Elfo> resultado = elfosAlistados.buscar(Status.ATACANDO);
        assertEquals(esperado, resultado);
    }
}
