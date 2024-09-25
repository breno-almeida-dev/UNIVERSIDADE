
public class Main {

	public static void main(String[] args) {
		
		/*Instancia 4 alunas para com as sua respectivas notas dentro do array.*/
		double[] notas1 = {3.0, 6.5};
		Aluno aluno1 = new Aluno("Jéssica", "256513", "ead", 00, notas1);
		
		double[] notas2 = {8.5, 6.8, 7.6};
		Aluno aluno2 = new Aluno("Fernanda", "257897", "Presencial", 65, notas2);
		
		double[] notas3 = {5.0, 6.4, 8.6};
		Aluno aluno3 = new Aluno("Taína", "277895", "presencial", 90, notas3);
		
		double[] notas4 = {5.0, 6.4, 8.6, 9.8};
		Aluno aluno4 = new Aluno("Luana", "277909", "EaD", 00, notas4);	
		
		/*Chama o método de descrição dos dados do aluno de acordo com cada aluna e mostra no terminal.*/
		System.out.println(aluno1.dadosDoAluno());
		System.out.println(aluno2.dadosDoAluno());
		System.out.println(aluno3.dadosDoAluno());
		System.out.println(aluno4.dadosDoAluno());
		
	}

}
