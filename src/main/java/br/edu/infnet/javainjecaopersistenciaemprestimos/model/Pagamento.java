package br.edu.infnet.javainjecaopersistenciaemprestimos.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

	
//	private Integer id;
//	private Date data;
//	private Double montante;
//	private String observacao;
//	private TipoPagamento tipoPagamento;
	
	
	private Integer id;
	private Cliente cliente;
	private Date data;
	
	//enum?
	private String mesDePagamento;
	private Double montantePago;
	private Double jurosPagos;
	private String observacoes;
}
