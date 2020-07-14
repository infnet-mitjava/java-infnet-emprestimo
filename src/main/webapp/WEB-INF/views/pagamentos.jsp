
<%@ include file="header.jsp"%>

<body>

	<div class="container">
		<br>
		<h3>Pagamentos</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Cliente</th>
					<th scope="col">Data</th>
					<th scope="col">Mês</th>
					<th scope="col">Valor Pago</th>
					<th scope="col">Juros</th>
					<th scope="col">observacoes</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="pagamento" items="${pagamentos }">
					<tr>
						<th scope="row">${pagamento.id }</th>
						<td>${emprestimo.cliente.nome }</td>
						<td>${emprestimo.data }</td>
						<td>${emprestimo.mesDePagamento }</td>
						<td>${emprestimo.jurosPagos }</td>
						<td>${emprestimo.observacoes }</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<br>

		<h3>Novo Pagamento</h3>

		<form method="POST" modelAttribute="pagamento">

			<div class="form-group">
				<label for="cliente">Cliente</label> <select name="clienteId"
					class="form-control">
					<option value="">..</option>
					<c:forEach var="cliente" items="${clientes}">
						<option value="${cliente.numero}">${cliente.nome}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group">
				<label for="nome">Data</label> <input type="date"
					class="form-control" id="data" name="strData"
					 placeholder="Data do empréstimo">
			</div>
			
			<div class="form-group">
				<label for="nome">Mês</label> <input type="text"
					class="form-control" id="mesDePagamento" name="mesDePagamento"
					 placeholder="Mês">
			</div>
			
			<div class="form-group">
				<label for="nome">Taxa de Juro</label> <input type="text"
					class="form-control" id="montantePago" name="montantePago"
					 placeholder="Montante Pago">
			</div>
			
			<div class="form-group">
				<label for="nome">Taxa de Juro</label> <input type="text"
					class="form-control" id="montantePago" name="montantePago"
					 placeholder="Montante Pago">
			</div>
			
			<div class="form-group">
				<label for="nome">Juros Pagos</label> <input type="text"
					class="form-control" id="jurosPagos" name="jurosPagos"
					 placeholder="Juros Pago">
			</div>

			<div class="form-group">
				<label for="nome">Observações</label> <input type="text"
					class="form-control" id="observacoes" name="observacoes"
					 placeholder="Observações">
			</div>

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>


	</div>
</body>


<%@ include file="footer.jsp"%>
