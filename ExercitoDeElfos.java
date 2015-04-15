import java.util.HashMap;
import java.util.*;
/**
 * Cria um exercito de elfos.
 * 
 * @author Paula Tomasi
 */
public class ExercitoDeElfos {
    private HashMap<String, Elfo> elfosAlistados = new HashMap<>();
    
    public void alistarElfo(Elfo elfo) {
        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        if (podeAlistar) {
            elfosAlistados.put(elfo.getNome(), elfo);
        }
    }
    
    public HashMap<String, Elfo> getElfosAlistados() {
        return this.elfosAlistados;
    }
    
    public Elfo buscarElfo(String nome) {
        return elfosAlistados.get(nome);
    }
    
    public HashMap<String, Elfo> buscarElfosComStatusIguais(Status status) {
        HashMap<String, Elfo> elfosComStatusIguais = new HashMap<>();
        for (Elfo elfo : elfosAlistados.values()) {
           if(elfo.getStatus().equals(status)){
               elfosComStatusIguais.put(elfo.getNome(), elfo);
           }
        }
        return elfosComStatusIguais;
    }
}