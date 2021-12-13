
package orientacaoobjveiculo;

/**
 * @author Sâmela Hostins
 */
public class Veiculo {

    private String cor;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private int qtdPassageiros;

    public float venderVeiculo(){
        float valorDoVeiculo = 0;
        return  valorDoVeiculo;
    }
    
    
    //Setters
    
    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

//Getters
    
    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }
    

}
