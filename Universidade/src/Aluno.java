
/*Classe do Aluno que define seus atributos como privados para serem acessados diretamente apenas
 * de dentro da classe.*/
public class Aluno {
	private String nome;
	private String raAluno;
	private String modeloAula;
	private String situacaoAluno;
	private int presencaAluno;
	private double [] notas;
	private double notaFinal;
	
	/*Construtor vazio para criar o objeto sem argumentos que serão atribuídos por setters.*/
	public Aluno() {
	}
	
	/*Construtor com argumentos que são informados pelo os setters.
	 * Na onde a definição da nota final, a mesma é multiplicada por 10 e depois dividida por 10 para retornar apenas 2 digitos após a vírgula.
	 * Sem interferir no resultado da situação que foi calculado no método de cálculo de notas.*/
	public Aluno(String nome, String raAluno, String modeloAula, int presencaAluno, double notas[]) {
		setNome(nome);
		setRaAluno(raAluno);
		setModeloAula(modeloAula);
		setPresencaAluno(presencaAluno);
		setNotas(notas);
	    this.notaFinal = Math.round(calculoDeNotas() * 10.0) / 10.0;
		situacaoFinalAluno();	    
	}
	
	
	/*Dentro desse método, após as notas serem armazenadas dentro de um array, as condições if conferem
	 * o tamanho do array para variar o tipo de cálculo de nota e retornar a notaFinal de acordo com o cálculo
	 * equivalente a quantia de notas. */
	private double calculoDeNotas() {
    	if (notas.length == 2) {
    		return
    				(notas[0] + notas[1]) / 2;
    	} else if (notas.length == 3) {
    		return
    				(notas[0] + notas[1] * 2 + notas[2] * 4) / 7;
    	} else if (notas.length == 4) {
    		return
    				(notas[0] * 0.15) + (notas[1] * 0.30) + (notas[2] * 0.10) + (notas[3] * 0.45);
     	} else {
     		//Caso o tamanho do array não seja aceito em nanhuma das condições retorna a mensagem de erro.
     		throw new IllegalArgumentException("A quantidade de notas é inválida.");
     	}
	}
	
	/*Um método que verifica a situação do aluno a partir do seu modelo de aula
	 * levando em consideração a sua notaFinal, que através de operadores ternários retorna a situação do aluno.*/
	private void situacaoFinalAluno() {
		if (modeloAula.equalsIgnoreCase("EAD")) {
			situacaoAluno = notaFinal >= 5 ? "Aprovado." : "Reprovado.";
		} else {
			/*Caso o modelo aula seja diferente de EAD, os operadores ternários levam em consideração a notaFinal e
			 * a presença do aluno para retornar sua situação. */
			situacaoAluno = (notaFinal >= 5 && presencaAluno >= 75) ? "Aprovado." : "Reprovado.";
		}
	}	
	
	
	
	/*Setters para atribuir os valores vindos da classe Main nos atributos dessa classe.*/
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public void setRaAluno(String raAluno) {
		this.raAluno = raAluno;
	}
	
	
	/*Setter que primeiro verifica se o modelo de aula informado é correspondente com o exigido no código.
	 * Faz a verificação ignorando letras maiúsculas, e caso seja diferente de EAD ou PRESENCIAL, retorna a mensagem de erro.*/
	public void setModeloAula(String modeloAula) {
		if (!modeloAula.equalsIgnoreCase("Presencial") &&
	            !modeloAula.equalsIgnoreCase("EAD")) {
				throw new IllegalArgumentException("O modelo de aula deve ser Presencial ou EAD.");
			}
		//Caso os dados sejam válidados atribui o valor ao atributo dessa classe, deixando tudo como letra maiúscula.
		this.modeloAula = modeloAula.toUpperCase();
	}
	
	
	public void setPresencaAluno(int presencaAluno) {
		this.presencaAluno = presencaAluno;
	}
	
	
	public void setNotas(double[] notas) {
		this.notas = notas;
	}
	
	
	
    /*Getters para serem acessados no método dadosDoAluno e retornar os valores das variáveis.*/
	public String getNome() {
		return
				nome;
	}
	
	public String getRaAluno() {
		return
				raAluno;
	}
	
	public String getModeloAula() {
		return
				modeloAula;
	}
	
	public double getNotaFinal() {
		return
				notaFinal;
	}
	
	public String getSituacaoAluno() {
		return
				situacaoAluno;
	}
	
	
    /*Método de descrição para retornar a String com a formatação dos dados do Aluno, padronizada.*/
	public String dadosDoAluno() {
		return
				"Aluno:" + "\n" +
				"  Nome: " + getNome() + "\n" +
				"  RA: " + getRaAluno() + "\n" +
				"  Modelo de aula: " + getModeloAula() + "\n" +
				"  Nota final: " + getNotaFinal() + "\n" +
				"  Situação: " + getSituacaoAluno() + "\n";
				
	}	
	
}
