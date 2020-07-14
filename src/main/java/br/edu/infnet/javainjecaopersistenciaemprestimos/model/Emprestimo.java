package br.edu.infnet.javainjecaopersistenciaemprestimos.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

	
//	private Integer id;
//	private Date inicio;
//	private Date fim;
//	private Double taxaDeJuros;
//	private Double total;
//	private Double montanteDevido;
//	private Integer parcelas; 
//	private Date vencimento;
//	
//	private List<Pagamento> pagamentos;
//	
//	private Cliente cliente;
//	private Coletor coletor;
//	
	
	private Integer idTransacao;
	private Cliente cliente;
	private Coletor coletor;
	private Date data;
	private Double montante;
	private Double taxaDeJuro;
	
}
