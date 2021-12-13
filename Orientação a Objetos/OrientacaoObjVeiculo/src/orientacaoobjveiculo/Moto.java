

package orientacaoobjveiculo;

/**
 * @author Sâmela Hostins
 */
public class Moto extends Veiculo {

    private int qtdCilindradas;
    
    @Override
     public float venderVeiculo(){   
        return 1000;
 }

    @Override
    public String toString() {
        return "Moto{" + "qtdCilindradas=" + qtdCilindradas + '}';
    }

    public int getQtdCilindradas() {
        return qtdCilindradas;
    }

    public void setQtdCilindradas(int qtdCilindradas) {
        this.qtdCilindradas = qtdCilindradas;
    }
     
     
}
