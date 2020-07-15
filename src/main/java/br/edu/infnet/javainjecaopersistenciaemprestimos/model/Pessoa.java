package br.edu.infnet.javainjecaopersistenciaemprestimos.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pessoa {

	private Integer id;
	private String nome;
	private Endereco endereco;
	
	private List<Emprestimo> emprestimos = new ArrayList<>();
	
	
	public Pessoa(Integer id, String nome, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}
	
}
