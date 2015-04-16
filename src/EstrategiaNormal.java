import java.util.*;
/**
 * @author Paula Tomasi
 */

public class EstrategiaNormal implements EstrategiaDeAtaque {
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
        System.out.println("Estratégia normalzinha...");
        for (Elfo elfo : elfos) {
            for (Orc orc : orcs) {
                elfo.atirarFlecha(orc);
            }
        }        
    }
}