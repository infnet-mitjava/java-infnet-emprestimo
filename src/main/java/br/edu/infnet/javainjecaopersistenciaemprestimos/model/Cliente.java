package br.edu.infnet.javainjecaopersistenciaemprestimos.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
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
		this.saldoDevedor += emprestimo.getTotal();
		
	}
	
	public void efetuarPagamento(Pagamento pagamento) {
		this.saldoDevedor -= pagamento.getMontanteAPagar();
	}
	
}
