// 5. Crie no seu programa principal menu para cadastro de cidades, que peça ao usuário
// todos os dados e que no fim o insira no banco de dados, este programa deve avaliar se os
// dados inseridos correspondem ao tipo pedido e tratar este comportamento. Também será
// possível remover uma cidade pelo DDD através dessa interface..

package exercicioJdbc;

import java.util.Scanner;

public class programaPrincipal {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opcao = 99;
		boolean capital = false;
		cidadesDao cidadesDao = new cidadesDao();
		System.out.println("Programa de cadastro de novas cidades");
		do {
			System.out.println("(1) - Cadastrar nova cidade");
			System.out.println("(2) - Remover cidade do registro");
			System.out.println("(3) - Consultar cidades armazenadas");
			System.out.println("(4) - Consultar cidade pelo DDD");
			System.out.println("(5) - Consultar cidades com nome similar a texto inserido");
			System.out.println("(0) - Fechar programa");
			opcao = input.nextInt();
			input.nextLine();
			if(opcao==1) {
				insereCidade(input, capital, cidadesDao);
			} else if(opcao==2) {
				deletaCidade(input, cidadesDao);
			} else if(opcao==3) {
				cidadesDao.listarCidades();
			} else if(opcao==4) {
				consultaCidadeDDD(input, cidadesDao);
			} else if(opcao==5) {
				consultaCidadesInicio(input, cidadesDao);
			} else if(opcao==0) {
				System.out.println("Obrigado, e até a próxima :)");
				break;
			}
		} while(opcao!=0);
		input.close();
	}

	private static void consultaCidadesInicio(Scanner input, cidadesDao cidadesDao) {
		System.out.print("Digite o texto com o qual se inicia o nome da cidade: ");
		String inicio = input.nextLine();
		cidadesDao.consultaCidadeInicio(inicio);
	}

	private static void consultaCidadeDDD(Scanner input, cidadesDao cidadesDao) {
		System.out.print("Digite o DDD da cidade: ");
		int ddd = input.nextInt();
		input.nextLine();
		cidadesDao.consultaCidadeDDD(ddd);
	}

	private static void deletaCidade(Scanner input, cidadesDao cidadesDao) {
		System.out.print("Digite o DDD da cidade a ser removida: ");
		int ddd = input.nextInt();
		input.nextLine();
		cidadesDao.removeCidade(ddd);
	}

	private static void insereCidade(Scanner input, boolean capital, cidadesDao cidadesDao) {
		System.out.print("Digite o DDD da cidade: ");
		int ddd = input.nextInt();
		input.nextLine();
		System.out.print("Digite o nome da cidade: ");
		String nome = input.nextLine();
		System.out.print("Digite o número de habitantes da cidade: ");
		int numeroHabitantes = input.nextInt();
		input.nextLine();
		System.out.print("Digite o valor da renda per capita da cidade: ");
		double rendaPerCapita = input.nextDouble();
		input.nextLine();
		System.out.print("A cidade é a capital do estado? (digite sim ou nao) ");
		String resposta = input.nextLine();
			if(resposta.equals("sim")) {
				capital = true;
			} else if(resposta.equals("nao")) {
				capital = false;
			}
		System.out.print("Digite o estado ao qual pertence a cidade (digite apenas as duas letras da sigla): ");
		String estado = input.nextLine();
		System.out.print("Digite o nome do prefeito da cidade: ");
		String nomePrefeito = input.nextLine();
		cidadesPojo novaCidadeCadastrada = new cidadesPojo(ddd, nome, numeroHabitantes, rendaPerCapita, capital, estado, nomePrefeito);
		cidadesDao.insereCidade(novaCidadeCadastrada);
		}
}