import java.util.HashMap;
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
}