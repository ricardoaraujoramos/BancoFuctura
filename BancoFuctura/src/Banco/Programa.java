package Banco;

import java.util.Locale;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		ContaCorrente contas;
		System.out.println("--- BANCO FUCTURA ---");
		System.out.print(" - Digite o nome: ");
		String nomeDoTitular = sc.nextLine();

		System.out.print(" - Digite a conta: ");
		int numeroDaConta = sc.nextInt();
		System.out.print(" - Será feito um depósito inicial (s/n)? ");
		char responde = sc.next().charAt(0);
		if (responde == 's') {
			System.out.println(" - Digite valor desejado no deposito: ");
			double inicialdeposito = sc.nextDouble();
			contas = new ContaCorrente(nomeDoTitular, numeroDaConta, inicialdeposito);
			System.out.printf("%n - Deposito feito no valor de: R$ %.2f%n", inicialdeposito);
		} else {
			contas = new ContaCorrente(nomeDoTitular, numeroDaConta);
		}

		System.out.println(contas);

		boolean criterio = true;
		while (criterio) {
			System.out.println();
			System.out.println(" - Por favor, digite:"
					+ "\n\n--- Conta - Corrente ---"
					+ "\n1 - Saldo da Conta Corrente" 
					+ "\n2 - Fazer Deposito"
					+ "\n3 - Fazer Saque" 
					+ "\n\n--- Conta - Poupança ---"
					+ "\n4 - Aplicar na Poupança" 
					+ "\n5 - Resgatar da Poupança"
					+ "\n6 - Saldo da Poupança" 
					+ "\n\n7 - Finalizar");
			int opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("--- Conta - Corrente ---");
				System.out.printf(" - Saldo da Conta Corrente é de: R$ %.2f", contas.getSaldo());
				break;

			case 2:
				System.out.println(" - Digite quanto deseja depositar: ");
				double valorD = sc.nextDouble();
				contas.deposito(valorD);
				System.out.printf(" - Seu novo saldo é de: R$ %.2f\n", contas.getSaldo());
				System.out.printf(" - Deposito feito no valor de: R$ %.2f", valorD);

				break;

			case 3:
				System.out.println(" - Digite quanto deseja sacar: ");
				double valorS = sc.nextDouble();
				contas.saque(valorS);
				System.out.printf(" - Seu novo saldo é de: R$ %.2f\n", contas.getSaldo());
				System.out.printf(" - Saque feito no valor de: R$ %.2f\n", valorS);

				break;

			case 4:
				System.out.println(" - Digite quanto deseja aplicar na poupança: ");
				double valorA = sc.nextDouble();
				contas.aplicar(valorA);
				System.out.printf(" - Seu novo saldo da Conta Corrente é de: R$ %.2f\n", contas.getSaldo());
				System.out.printf(" - Seu novo saldo da Poupança é de: R$ %.2f\n", contas.getSaldopoupanca());
				System.out.printf(" - Aplicou na Poupança o valor de: R$ %.2f\n", valorA);
				break;

			case 5:
				System.out.println(" - Digite quanto deseja resgater da poupança: ");
				double valorR = sc.nextDouble();
				contas.resgatar(valorR);
				System.out.printf(" - Seu novo saldo da Conta Corrente é de: R$ %.2f\n", contas.getSaldo());
				System.out.printf(" - Seu novo saldo da Poupança é de: R$ %.2f\n", contas.getSaldopoupanca());
				System.out.printf(" - Resgatou da Poupança o valor de: R$ %.2f\n", valorR);
				break;

			case 6:
				System.out.printf(" - Seu Saldo da Poupança é de: R$ %.2f\n", contas.getSaldopoupanca());
				break;

			case 7:
				System.out.println(" - Obrigado!");
				criterio = false;
				break;
			default:
				System.out.println(" - Desculpe, comando inválido!");
				break;

			}

		}
		sc.close();
	}
}
