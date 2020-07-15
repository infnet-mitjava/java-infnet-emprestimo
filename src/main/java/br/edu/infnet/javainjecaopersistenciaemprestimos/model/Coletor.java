package br.edu.infnet.javainjecaopersistenciaemprestimos.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Coletor extends Pessoa {

	public Coletor(int id, String nome, Endereco endereco) {
		super(id, nome, endereco);
	}

}
