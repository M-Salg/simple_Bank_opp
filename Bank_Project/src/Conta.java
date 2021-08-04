import java.util.Scanner;

public class Conta {

	//CRIAR AS VARI�VEIS QUE REPRESENTAM ESTA CLASSE

	private int balan�o;
	private int transa�aoAnterior;
	private String nomeCliente;
	private String clienteID;



	//CRIAR OS CONSTRUTORES DA CLASSE

	public Conta( String nomeCliente, String clienteID) {


		this.nomeCliente = nomeCliente;
		this.clienteID = clienteID;
	}

	//CRIAR FUN��O PARA O DEP�SITO DE DINHEIRO

	void deposito (int montante) {
		if(montante != 0) {
			balan�o= balan�o+montante;
			transa�aoAnterior = montante;
		}
	}

	//CREIAR FUN��O LEVANTAMENTO DE DINHEIRO

	void levantamento (int montanteLevantado) {
		if(balan�o >= montanteLevantado ) {
			balan�o = balan�o -montanteLevantado;
			transa�aoAnterior = -montanteLevantado;


		}
	}

	//CRIAR FUN��O QUE APRESENTA A TRANSA��O ANTERIOR FEITA PELO CLIENTE
	
	void saberTransa�aoAnterior () {

		if(transa�aoAnterior > 0) {
			System.out.println("A transa��o anterior foi a seguinte: Dep�sito de " + transa�aoAnterior);
		}else if (transa�aoAnterior < 0){
			System.out.println("A transa��o anterior foi a seguinte: Levantamento " + transa�aoAnterior);

		}else {
			System.out.println("N�o houve ainda transa��es.");
		}
		
	}
	
	//FUN��O PARA CALCULAR FUNDOS OBTIDOS AO METER O DINHEIRO A IVESTIR A UMA CERTA TAXA DE JURO E A UM DETERMINADO NUMERO DE ANOS
	
	void calcularJuros (int anos) {
		double juro = 0.015;
		
		double novoBala�oObtido= (balan�o*juro*anos) +balan�o;
		
		System.out.println("A percentagem atual de juros � de: " + (juro *100) + "%");
		System.out.println("O valor a obter ao fim de " + anos + " anos a uma taxa de " + (juro *100) + "% " + "�: " + novoBala�oObtido + "�");
		System.out.println();
	}
	
	
	void menuPrincipal() {
		char op�ao = '\0';
		Scanner lerOp�ao = new Scanner(System.in);
		
		System.out.println("Bem-vindo(a), " + nomeCliente + "!");
		System.out.println("O seu ID de conta �: " + clienteID);
		System.out.println();
		System.out.println("O que gostaria de fazer na sua conta?");
		System.out.println();
		System.out.println("A.  Verificar o seu balan�o atual");
		System.out.println("B.  Fazer um dep�sito");
		System.out.println("C.  Fazer um levantamento");
		System.out.println("D.  Verificar a transa��o anterior");
		System.out.println("E.  Calcular investimentos");
		System.out.println("f.  Sair");
		
		
		do {
			System.out.println();
			System.out.println("Introduza uma op��o: ");
			
			char op�ao1 = lerOp�ao.next().charAt(0);
			op�ao =  Character.toUpperCase(op�ao1);
			System.out.println();
			
			
			//FAZEMOS UM SWITCH - � COMO QUE UM IF STATEMENT SIMPIFICADO. LEVA COMO PARAMETRO AQUILO QUE VAI COMPARAR COM OS "CASE"
			switch(op�ao) {
			
			case 'A':
				System.out.println("==========================================");
				System.out.println("Balan�o = " + balan�o + "�");
				System.out.println("==========================================");
				System.out.println();
				break;
				
			case 'B':
				System.out.println("Introduza um montante a depositar:");
				int montante = lerOp�ao.nextInt();
				deposito(montante);
				System.out.println();
				break;
				
			case 'C':
				System.out.println("Introduza o valor que quer levantar:");
				int montanteLevantado = lerOp�ao.nextInt();
				levantamento(montanteLevantado);
				System.out.println();
				break;
				
			case 'D':
				System.out.println("==========================================");
				saberTransa�aoAnterior ();
				System.out.println("==========================================");
				break;
				
			case 'E':
				System.out.println("Introduza o n�mero de anos deste investimento:");
				int anos = lerOp�ao.nextInt();
				calcularJuros(anos);
				System.out.println();
				break;
				
			case 'F':
				System.out.println("==========================================");
				break;
				
				// O "CASE" DEFAULT SERVE PARA PASSAR MENSAGEM QUE NENHUM DOS CASES FORAM SELECIONADOS 
			default:
				System.out.println("ERRO: Op��o que escolheu � inv�lida. Por favor escolha entre as seguintes op��es: A, B, C, D, E, F");
				break;
		
				
				
				
			}
		}while (op�ao != 'F');
		System.out.println("Obrigado pela sua visita. Volte sempre!");
	}
	
	
}




