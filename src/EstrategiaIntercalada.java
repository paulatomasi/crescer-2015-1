import java.util.*;

public class EstrategiaIntercalada implements EstrategiaDeAtaque
{
    private ArrayList<Elfo> ordemAtaque = new ArrayList<>();
    
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
        if (elfos.isEmpty() || !validarProporcoes(elfos)) {
            return;
        }
        intercalar(elfos);
        for (Elfo elfo : ordemAtaque) {
            for (Orc orc : orcs) {
                if (elfo != null)
                    elfo.atirarFlecha(orc);
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemAtaque;
    }
    
    private boolean validarProporcoes(ArrayList<Elfo> elfos) {
        int contadorElfosVerdes = 0, contadorElfosNoturnos = 0;
        
        for (Elfo elfo : elfos) {
            if (elfo instanceof ElfoVerde) {
                contadorElfosVerdes++;
            } else if (elfo instanceof ElfoNoturno) {
                contadorElfosNoturnos++;
            }
        }
        return contadorElfosVerdes == contadorElfosNoturnos;
    }
    
    private void intercalar(ArrayList<Elfo> elfo) {     
        Elfo primeiro = elfo.get(0);
        ordemAtaque.add(primeiro);
        Class classeDoUltimoAdicionado = primeiro.getClass();
        elfo.remove(primeiro);
        while (elfo.size() > 0) {
            for (int j = 0; j < elfo.size(); j++) {
                Elfo atual = elfo.get(j);
                boolean estáIntercalado = atual.getClass() != classeDoUltimoAdicionado;
                
                if (estáIntercalado) {
                    ordemAtaque.add(atual);
                    classeDoUltimoAdicionado = atual.getClass();
                    elfo.remove(atual);
                }
            }
        }
    }
}