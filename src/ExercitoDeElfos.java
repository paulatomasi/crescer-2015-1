import java.util.*;
/**
 * Cria um exercito de elfos.
 * 
 * @author Paula Tomasi
 */
public class ExercitoDeElfos {
    private HashMap<String, Elfo> elfosAlistados = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> porStatus = new HashMap<>();
    private EstrategiaDeAtaque estrategia = new EstrategiaNormal();
     
    public HashMap<String, Elfo> getElfosAlistados() {
        return this.elfosAlistados;
    }
    
    public HashMap<Status, ArrayList<Elfo>> getElfosAlistadosPorStatus() {
        return this.porStatus;
    }
    
    public void alistarElfo(Elfo elfo) throws NaoPodeAlistarException {
        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        if(podeAlistar) {
            elfosAlistados.put(elfo.getNome(), elfo);
        }else{
            ErrosDoJogo.naoPodeAlistar();
        }
    }
    
        public Elfo buscarElfo(String nome) {
        return elfosAlistados.get(nome);
    }
    
        public ArrayList<Elfo> buscar(Status status) {
        agruparPorStatus();
        return porStatus.get(status);
    }
    
     public void agruparPorStatus() {
        porStatus.clear();
        for (Map.Entry<String, Elfo> parChaveValor : elfosAlistados.entrySet()) {
            Elfo elfo = parChaveValor.getValue();
            Status status = elfo.getStatus();
            if (porStatus.containsKey(status)) {
                porStatus.get(status).add(elfo);
            } else {
                porStatus.put(status, new ArrayList<>(
                    Arrays.asList(elfo)
                ));
            }
        }
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
    
    public void atacarHorda(ArrayList<Orc> orcs) {
        ArrayList<Elfo> elfosQueVãoPraPeleia = buscar(Status.VIVO);
        estrategia.atacarOrcs(elfosQueVãoPraPeleia, orcs);
    }
}