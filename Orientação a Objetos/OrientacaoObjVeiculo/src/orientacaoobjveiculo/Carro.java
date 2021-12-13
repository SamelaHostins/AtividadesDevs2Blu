
package orientacaoobjveiculo;

/**
 * @author Sâmela Hostins
 */
public class Carro extends Veiculo{

    private int qtdDeHp;
    
    @Override
 public float venderVeiculo(){   
        return 10000;
 }   

    @Override
    public String toString() {
        return "Carro{" + "qtdDeHp=" + qtdDeHp + '}';
    }
 
 
    
}
