import java.util.*;
/**
 * @author Paula Tomasi
 */
public class EstrategiaNoturna implements EstrategiaDeAtaque
{
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
        System.out.println("Super estratégia noturna.. ATIVAR!!!");
        int quantidadeDeAtaques = elfos.size() * orcs.size();
        int limiteElfosNoturnos = (int)(quantidadeDeAtaques * 0.3);
        int quantidadeDeElfosNoturnosQueJáAtacaram = 0;
        for (Elfo elfoQueVaiAtacar : elfos) {
            boolean eElfoNoturno = elfoQueVaiAtacar instanceof ElfoNoturno;
            if (eElfoNoturno) {
                if (quantidadeDeElfosNoturnosQueJáAtacaram >= limiteElfosNoturnos)
                    continue;
                quantidadeDeElfosNoturnosQueJáAtacaram++;
            }
            for (Orc orc : orcs) {
                elfoQueVaiAtacar.atirarFlecha(orc);
            }
        }
    }
}