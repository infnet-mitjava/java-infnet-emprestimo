package br.edu.infnet.javainjecaopersistenciaemprestimos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPagamento {

	private String codigo;
	private String descricao;
}
