package br.edu.infnet.javainjecaopersistenciaemprestimos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Pessoa{

	private Double saldoDevedor;
	
	public Cliente(Integer id, String nome, Endereco endereco, Double saldoDevedor) {
		super(id,nome,endereco);
		this.saldoDevedor = saldoDevedor;
	}
	
	public void addEmprestimo(Emprestimo emprestimo) {
		this.getEmprestimos().add(emprestimo);
		
		//TODO: CALCULAR JUROS
		this.saldoDevedor += emprestimo.getMontante();
		
	}
	
	public void efetuarPagamento(Pagamento pagamento) {
		this.saldoDevedor -= pagamento.getMontanteAPagar();
	}
	
}
