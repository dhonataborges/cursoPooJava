package entity;

import enuns.SituacaoConta;

public class ContaPagar extends Conta {

	private Fornecedor fornecedor;

	public ContaPagar() {

	}

	public ContaPagar(Fornecedor fornecedor, String descricao, Double valor, String dataVencimento) {
		this.fornecedor = fornecedor;
		setDescricao(descricao);
		setValor(valor);
		setDataVencimento(dataVencimento);
	}

	public void pagar() {
		if (SituacaoConta.PAGA.equals(this.getSituacaoConta())) {
			System.out.println("N�o pode pagar uma conta que j� est� paga: " + this.getDescricao() + ".");
		} else if (SituacaoConta.CANCELADA.equals(this.getSituacaoConta())) {
			System.out.println("N�o pode pagar uma conta que est� cancelada: " + this.getDescricao() + ".");
		} else {
			System.out.println(
					"Pagando conta " + this.getDescricao() + " no valor de " + this.getValor() + " e vencimento em "
							+ this.getDataVencimento() + " do fornecedor " + this.getFornecedor().getNome() + ".");

			// altera situa��o da conta para PAGA
			this.situacaoConta = SituacaoConta.PAGA;
		}
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}
