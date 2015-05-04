import java.util.*;
/**
 * @author Paula Tomasi
 */
public interface EstrategiaDeAtaque
{
    void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs);
    
    ArrayList<Elfo> getOrdemDoUltimoAtaque();
}