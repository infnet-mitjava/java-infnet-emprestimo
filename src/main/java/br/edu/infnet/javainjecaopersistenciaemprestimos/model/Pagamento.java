package br.edu.infnet.javainjecaopersistenciaemprestimos.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
	
	private Integer id;
	private Emprestimo emprestimo;
	private Date data;
	
	private Double montanteAPagar;
	private Double jurosPagos;
	private String observacoes;
	private boolean pago;
	
	public Pagamento(Emprestimo emprestimo, Date data, Double montanteAPagar, Double jurosPagos, String observacoes, boolean pago) {
		this.emprestimo = emprestimo;
		this.data = data;
		this.montanteAPagar = montanteAPagar;
		this.jurosPagos = jurosPagos;
		this.observacoes = observacoes;
		this.pago = pago;
	}
	
}
