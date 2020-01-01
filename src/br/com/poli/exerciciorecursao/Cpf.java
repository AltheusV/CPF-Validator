package br.com.poli.exerciciorecursao;

public class Cpf {

	public String calculaDigitoVerificador(String cpf){	// retorna o digito verificador do cpf
														// metodo que irá verificar se o cpf é válido
		String verificadores = "";						// a partir do digito verificador.
		int digitoVerificador = 0;
		int somatorio1 = 0;
		int somatorio2 = 0;
		int count = 10;

		if(cpf.length()==9){
			for(int pos =0; pos<=8; pos++){
				somatorio1+=Character.getNumericValue((cpf.charAt(pos)))*count;
				somatorio2+=Character.getNumericValue((cpf.charAt(pos)))*(count+1);
				count--;
			}

			digitoVerificador = 11 - (somatorio1 % 11);

			if(digitoVerificador>9){
				digitoVerificador=0;
			}

			verificadores+= Integer.toString(digitoVerificador);

			somatorio2+= digitoVerificador*2;
			digitoVerificador = 11 - (somatorio2 % 11);

			if(digitoVerificador>9){
				digitoVerificador=0;
			}

			verificadores+= Integer.toString(digitoVerificador);	
		}
		return verificadores;
	}

	public String cpfRecursivo(String[] cpfs){		// METODO PRINCIPAL
													// caso o retorno seja vazio, não há nenhum CPF válido.
		return verificaCpf(cpfs,"",0,1);			// possui como parametro uma string vazia para combinacoes, e 0 e 1 para as posicoes iniciais dos arrays
	}

	private String verificaCpf(String[] cpfs, String cpfVerificado, int cpf1, int cpf2){ 		// metodo recursivo

		if(cpfs.length==1){						// se houver apenas 1 cpf no array, nao há necessidade das combinacoes.
			cpfVerificado = cpfs[0];
		}

		if(cpfVerificado.length()== 11){		// se o cpf estiver completo (com os 11 digitos)
												
			String checarDigitos = "";
			String checarCpf = "";

			checarDigitos += cpfVerificado.charAt(9);			// separa o digito verificador do cpf
			checarDigitos += cpfVerificado.charAt(10);

			for(int i =0; i<cpfVerificado.length()-2; i++){		// repassa os 9 primeiros digitos do cpf para 
				checarCpf+=cpfVerificado.charAt(i);				// a string que será comparada.
			}

			if(checarDigitos.equals(calculaDigitoVerificador(checarCpf))){		// compara os digitos verificadores.
				return cpfVerificado;											// se estiver ok, retorna o cpf.
			}

			else{																

				if(cpfs.length==1){												// se houver apenas 1 cpf no array, e nao bateu com o digito verificador
					return "";													// retorna vazio
				}

				return checarCpf + cpfVerificado.charAt(9);						// se nao, retorna o cpf com 10 digitos, para realizar a proxima combinacao.
			}
		}
		else{
			int qtd = cpfs.length; 								// quantidade de cpfs.
			int pos = cpfVerificado.length();					// posicao do digito no momento. CpfVerificado inicia "" e aumenta a partir da chamada recursiva.

			while(cpf1<qtd){
				while(cpf2<qtd){														// compara o valor correspondente a posicao do cpf atual com o do próximo,
					if(cpfs[cpf1].charAt(pos) != cpfs[cpf2].charAt(pos)){			// se for diferente, concatena com o valor do primeiro, e chama o método para o próximo digito

						cpfVerificado+=cpfs[cpf1].charAt(pos);
						cpfVerificado = verificaCpf(cpfs, cpfVerificado,cpf1,cpf2);

						if(cpfVerificado.length()==11){						// se no caso base retornar 11 digitos, o cpf é válido
							return cpfVerificado;							// portanto, retorna o cpf.
						}

						else{												// realiza um laco para fazer todas as combinacoes possiveis com os cpfs restantes.
							for(int count=cpf2; count<qtd; count++){
								cpfVerificado+=cpfs[count].charAt(pos);							
								cpfVerificado = verificaCpf(cpfs, cpfVerificado,cpf1,cpf2);
								
								if(cpfVerificado.length()==11){							// se tiver os 11 digitos, o cpf é válido.
									return cpfVerificado;
								}
							}
					
							
						}
					}
					else{
						cpfVerificado+=cpfs[cpf1].charAt(pos);				// se os valores forem iguais, não há necessidade de checar 2x
						cpfVerificado = verificaCpf(cpfs, cpfVerificado,cpf1,cpf2);
					}
					
					if(cpfVerificado.length()==11){							// se tiver os 11 digitos, o cpf é válido.
						return cpfVerificado;
					}
					
					else if(cpfVerificado.length()==0){						// se a string de verificacao estiver vazia
						
						if(cpf1==qtd-2 && cpf2==qtd-1){						// se verificou todas as combinacoes possiveis
							return cpfVerificado;
						}
						else if(cpf2+1==qtd){								// acabou as combinacoes possiveis para este cpf	
							cpf1++;											// a combinacao será agora do próximo cpf
							cpf2=cpf1+1;									// com o próximo do próximo.
						}
						else{
							cpf2++;											// verifica a combinacao do cpf atual, com o proximo cpf
						}
					}
					else{													
								
						for(int count=cpf2; count<qtd; count++){					// realiza um laco para fazer todas as combinacoes possiveis com os cpfs restantes.
							cpfVerificado+=cpfs[count].charAt(pos);
							cpfVerificado = verificaCpf(cpfs, cpfVerificado,cpf1,cpf2);
							
							if(cpfVerificado.length()==11){							// se tiver os 11 digitos, o cpf é válido.
								return cpfVerificado;
							}
						}
																			// se nenhuma combinacao nesta posicao retornou o cpf
						String proximoCpf = "";								// o metodo retorna a string com um digito a menos, ou seja
						for(int k = 0; k<cpfVerificado.length()-1; k++){	// irá para uma proxima combinacao entre os dois cpfs atuais.
							proximoCpf += cpfVerificado.charAt(k);
						}
						return proximoCpf;
					}
				}

			}
		}
		return cpfVerificado;
	}

}
