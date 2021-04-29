package br.com.poli.exerciciorecursao;
/**
 * Exercicio de Recursao 2018.2
 * @author Matheus Albert Oliveira dos Santos
 * 
 */
public class Main {
	public static void main(String[] args) {
		String[] conjuntoDeCpfs = new String[] {"96979990987","98974996987", "96974996981"}; // exemplo
		Validator novoCpf = new Validator();
		System.out.println(novoCpf.cpfRecursivo(conjuntoDeCpfs)); //caso o retorno seja vazio, nao ha nenhum CPF valido.
	}
}