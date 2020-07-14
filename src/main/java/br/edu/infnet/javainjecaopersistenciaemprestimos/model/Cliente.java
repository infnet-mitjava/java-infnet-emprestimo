package br.edu.infnet.javainjecaopersistenciaemprestimos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	private Integer numero;
	private String nome;
	private Endereco endereco;
	private double saldo;
}
