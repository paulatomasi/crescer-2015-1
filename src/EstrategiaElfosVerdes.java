import java.util.*;

public class EstrategiaElfosVerdes implements EstrategiaDeAtaque
{
    private ArrayList<Elfo> ordemAtaque = new ArrayList<>();
    
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
        //ordenaComBubbleSort(elfos);
        ordenaComBubbleSort(elfos);
        
        for (Elfo elfo : elfos) {
            ordemAtaque.add(elfo);
            for (Orc orc : orcs) {
                elfo.atirarFlecha(orc);
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemAtaque;
    }
    
    private void ordenaComBubbleSort(ArrayList<Elfo> elfo) {
        
        boolean trocar = true;
        while (trocar) {
            trocar = false;
            for (int i = 0; i < elfo.size() - 1; i++) {
                Elfo atual = elfo.get(i);
                Elfo proximo = elfo.get(i + 1);
                boolean precisaTrocar = atual instanceof ElfoNoturno && proximo instanceof ElfoVerde;
                if (precisaTrocar) {
                    elfo.set(i, proximo);
                    elfo.set(i + 1, atual);
                    trocar = true;
                }
            }
        }
    }
}