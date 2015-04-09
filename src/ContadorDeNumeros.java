/**
 * Cria objetos contador de numeros
 * 
 * @author Paula
 */
public class ContadorDeNumeros
{
    public void contarAte(int numero){
        for (int x = 1; x<=numero; x++){
            System.out.println(x);
        }
    }
    
    public void contarRegressivamente(int numero){
        for (int x = numero; x>=1; x--){
            System.out.println(x);
        }
    }
}
