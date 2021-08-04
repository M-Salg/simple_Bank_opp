import java.util.Scanner;

public class Conta {

	//CRIAR AS VARIÁVEIS QUE REPRESENTAM ESTA CLASSE

	private int balanço;
	private int transaçaoAnterior;
	private String nomeCliente;
	private String clienteID;



	//CRIAR OS CONSTRUTORES DA CLASSE

	public Conta( String nomeCliente, String clienteID) {


		this.nomeCliente = nomeCliente;
		this.clienteID = clienteID;
	}

	//CRIAR FUNÇÃO PARA O DEPÓSITO DE DINHEIRO

	void deposito (int montante) {
		if(montante != 0) {
			balanço= balanço+montante;
			transaçaoAnterior = montante;
		}
	}

	//CREIAR FUNÇÃO LEVANTAMENTO DE DINHEIRO

	void levantamento (int montanteLevantado) {
		if(balanço >= montanteLevantado ) {
			balanço = balanço -montanteLevantado;
			transaçaoAnterior = -montanteLevantado;


		}
	}

	//CRIAR FUNÇÃO QUE APRESENTA A TRANSAÇÃO ANTERIOR FEITA PELO CLIENTE
	
	void saberTransaçaoAnterior () {

		if(transaçaoAnterior > 0) {
			System.out.println("A transação anterior foi a seguinte: Depósito de " + transaçaoAnterior);
		}else if (transaçaoAnterior < 0){
			System.out.println("A transação anterior foi a seguinte: Levantamento " + transaçaoAnterior);

		}else {
			System.out.println("Não houve ainda transações.");
		}
		
	}
	
	//FUNÇÃO PARA CALCULAR FUNDOS OBTIDOS AO METER O DINHEIRO A IVESTIR A UMA CERTA TAXA DE JURO E A UM DETERMINADO NUMERO DE ANOS
	
	void calcularJuros (int anos) {
		double juro = 0.015;
		
		double novoBalaçoObtido= (balanço*juro*anos) +balanço;
		
		System.out.println("A percentagem atual de juros é de: " + (juro *100) + "%");
		System.out.println("O valor a obter ao fim de " + anos + " anos a uma taxa de " + (juro *100) + "% " + "é: " + novoBalaçoObtido + "€");
		System.out.println();
	}
	
	
	void menuPrincipal() {
		char opçao = '\0';
		Scanner lerOpçao = new Scanner(System.in);
		
		System.out.println("Bem-vindo(a), " + nomeCliente + "!");
		System.out.println("O seu ID de conta é: " + clienteID);
		System.out.println();
		System.out.println("O que gostaria de fazer na sua conta?");
		System.out.println();
		System.out.println("A.  Verificar o seu balanço atual");
		System.out.println("B.  Fazer um depósito");
		System.out.println("C.  Fazer um levantamento");
		System.out.println("D.  Verificar a transação anterior");
		System.out.println("E.  Calcular investimentos");
		System.out.println("f.  Sair");
		
		
		do {
			System.out.println();
			System.out.println("Introduza uma opção: ");
			
			char opçao1 = lerOpçao.next().charAt(0);
			opçao =  Character.toUpperCase(opçao1);
			System.out.println();
			
			
			//FAZEMOS UM SWITCH - É COMO QUE UM IF STATEMENT SIMPIFICADO. LEVA COMO PARAMETRO AQUILO QUE VAI COMPARAR COM OS "CASE"
			switch(opçao) {
			
			case 'A':
				System.out.println("==========================================");
				System.out.println("Balanço = " + balanço + "€");
				System.out.println("==========================================");
				System.out.println();
				break;
				
			case 'B':
				System.out.println("Introduza um montante a depositar:");
				int montante = lerOpçao.nextInt();
				deposito(montante);
				System.out.println();
				break;
				
			case 'C':
				System.out.println("Introduza o valor que quer levantar:");
				int montanteLevantado = lerOpçao.nextInt();
				levantamento(montanteLevantado);
				System.out.println();
				break;
				
			case 'D':
				System.out.println("==========================================");
				saberTransaçaoAnterior ();
				System.out.println("==========================================");
				break;
				
			case 'E':
				System.out.println("Introduza o número de anos deste investimento:");
				int anos = lerOpçao.nextInt();
				calcularJuros(anos);
				System.out.println();
				break;
				
			case 'F':
				System.out.println("==========================================");
				break;
				
				// O "CASE" DEFAULT SERVE PARA PASSAR MENSAGEM QUE NENHUM DOS CASES FORAM SELECIONADOS 
			default:
				System.out.println("ERRO: Opção que escolheu é inválida. Por favor escolha entre as seguintes opções: A, B, C, D, E, F");
				break;
		
				
				
				
			}
		}while (opçao != 'F');
		System.out.println("Obrigado pela sua visita. Volte sempre!");
	}
	
	
}




