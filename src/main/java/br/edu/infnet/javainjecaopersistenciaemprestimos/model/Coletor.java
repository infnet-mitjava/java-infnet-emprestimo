package br.edu.infnet.javainjecaopersistenciaemprestimos.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "coletor")
@NoArgsConstructor
public class Coletor extends Pessoa {

	public Coletor(int id, String nome, Endereco endereco) {
		super(id, nome, endereco);
	}

}
