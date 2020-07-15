package br.edu.infnet.javainjecaopersistenciaemprestimos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {
	
	private Integer id;
	private Cliente cliente;
	private Coletor coletor;
	private Date dataEmprestimo;
	private Integer diaVencimento;
	private Double montante;
	private Double taxaDeJuro;
	private Integer numeroParcelas;
	private Integer parcelasPagas;
	private boolean quitado;
	
	private List<Pagamento> pagamentos  = new ArrayList<>();
	
	public void addPagamento(Pagamento pagamento) {
		if(!quitado) {
			this.pagamentos.add(pagamento);
			this.parcelasPagas++;
			if(this.parcelasPagas.equals(numeroParcelas)) {
				this.quitado = true;
			}
		}
	}
	
}
