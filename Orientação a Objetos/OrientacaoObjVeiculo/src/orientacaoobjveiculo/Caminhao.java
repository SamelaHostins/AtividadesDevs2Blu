
package orientacaoobjveiculo;

/**
 * @author Sâmela Hostins
 */
public class Caminhao extends Veiculo{

    private int qtdEixos;
    private int capacidadeCarga;
   
    @Override
 public float venderVeiculo(){   
        return 1000;
 }  

    @Override
    public String toString() {
        return "Caminhao{" + "qtdEixos=" + qtdEixos + ", capacidadeCarga=" + capacidadeCarga + '}';
    }

    public int getQtdEixos() {
        return qtdEixos;
    }

    public void setQtdEixos(int qtdEixos) {
        this.qtdEixos = qtdEixos;
    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
   

}
