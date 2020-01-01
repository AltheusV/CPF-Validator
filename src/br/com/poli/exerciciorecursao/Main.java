package br.com.poli.exerciciorecursao;
/**
 * Exercício de Recursão 2018.2
 * @author Matheus Albert Oliveira dos Santos
 * 
 */
public class Main {

	public static void main(String[] args) {
		
		String[] conjuntoDeCpfs = new String[] {"96979990987","98974996987", "96974996981"}; // exemplo
		Cpf novoCpf = new Cpf();
		System.out.println(novoCpf.cpfRecursivo(conjuntoDeCpfs)); //caso o retorno seja vazio, não há nenhum CPF válido.

	}

}

// Codigo do professor Byron :


//// funcao recursiva
//private static String validarCpf(String candidata, String[] opcoes) {
//	String resposta = null;
//	if (candidata.length() == 11) {
//		// validar o cpf -> caso base da recursao
//		if (verificarCpf(candidata)) {
//			return candidata;
//		} else {
//			return null;
//		}
//	} else {
//		boolean flags[] = new boolean[256];
//		for (int i = 0; i < opcoes.length; i++) {
//			StringBuffer aux = new StringBuffer(candidata);
//			char c = opcoes[i].charAt(candidata.length());
//			if (! flags[c]) {
//				flags[c] = true;
//				aux.append(c);
//				resposta = validarCpf(aux.toString(), opcoes);
//				if (resposta != null) {
//					break;
//				}
//			}
//		}
//	}
//	return resposta;
//}
//
//private static boolean verificarCpf(String candidata) {
//	// TODO implementar funcao de calculo do digito verificador do CPF
//	return false;
//}
//
//public static void validarCpf(String[] opcoes) {
//	String s = validarCpf("", opcoes);
//	System.out.println(s);
//}