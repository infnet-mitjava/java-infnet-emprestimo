package br.edu.infnet.javainjecaopersistenciaemprestimos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pagamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emprestimo_id")
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
