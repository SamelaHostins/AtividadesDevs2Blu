import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 * @author Sâmela Hostins
 */
public class LançandoExceçãoComNumeroInformado {
    
    //A idade não pode ser negativa, precisa ser um número e não pode ser maior que 100
    //Se for colocada outra coisa além de um número o código precisa pedir o número novamente.

    public static void main(String[] args) {
 
		try {
		  digitaNomeIdadeRecursivo();
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void digitaNomeIdadeRecursivo()  {
		String nome = JOptionPane.showInputDialog("Informe nome");			
		
		boolean deuExcecao = true;
		String idade = "";
                
		while(deuExcecao) {
			idade = JOptionPane.showInputDialog("Informe idade");
			try {
			   int idadeNumerica = Integer.parseInt(idade);
			   if(idadeNumerica < 0) {
				   throw new IllegalArgumentException("Idade não pode ser negativa");
			   }
			   
			  if(idadeNumerica > 100) {
				  throw new InputMismatchException("Cara com essa a previdencia vc vai falir");
			  }
			   
			   deuExcecao = false;	   
			   
			}
			catch (NumberFormatException e) {
				System.err.println("Idade inválida");
				deuExcecao = true;
			}
		}	
		
		System.out.println(nome + " vc tem " + idade + " anos.");
	}	
}