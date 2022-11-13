package Banco;

public abstract class Contas {
	private String nomeDoTitular;
	private int numeroDaConta;
	private double saldo;
	private double saldopoupanca;

	public Contas(String nomeDoTitular, int numeroDaConta) {
		this.nomeDoTitular = nomeDoTitular;
		this.numeroDaConta = numeroDaConta;
	}

	public Contas(String nomeDoTitular, int numeroDaConta, double inicialdeposito) {
		this.nomeDoTitular = nomeDoTitular;
		this.numeroDaConta = numeroDaConta;
		deposito(inicialdeposito);
	}

	public Contas(double saldopoupanca) {
		this.saldopoupanca = saldopoupanca;
	}

	public String getNomeDoTitular() {
		return nomeDoTitular;
	}

	public void setNomeDoTitular(String nomeDoTitular) {
		this.nomeDoTitular = nomeDoTitular;
	}

	public int getNumeroDaConta() {
		return numeroDaConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getSaldopoupanca() {
		return saldopoupanca;
	}

	public void deposito(double quantia) {
		saldo += quantia;
	}

	public void saque(double quantia) {
		saldo -= quantia;
	}

	public void aplicar(double quantia) {
		saldo -= quantia;
		saldopoupanca += quantia;
	}

	public void resgatar(double quantia) {
		saldopoupanca -= quantia;
		saldo += quantia;
	}

	public String toString() {
		return "--- BANCO FUCTURA ---\n"
				+"\n - Titular: " 
				+ nomeDoTitular + "\n - Conta: " 
				+ numeroDaConta + "\n - Saldo: R$ "
				+ String.format("%.2f", saldo);

	}

}
