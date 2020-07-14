
<%@ include file="header.jsp"%>

<body>

	<div class="container">
		<br>
		<h3>Empréstimos</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Cliente</th>
					<th scope="col">Coletor</th>
					<th scope="col">Data</th>
					<th scope="col">Montante</th>
					<th scope="col">Juros</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="emprestimo" items="${emprestimos }">
					<tr>
						<th scope="row">${emprestimo.idTransacao }</th>
						<td>${emprestimo.cliente.nome }</td>
						<td>${emprestimo.coletor.nome }</td>
						<td>${emprestimo.data }</td>
						<td>${emprestimo.montante }</td>
						<td>${emprestimo.taxaDeJuro }</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<br>

		<h3>Novo Empréstimo</h3>

		<form method="POST" modelAttribute="emprestimo">

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
				<label for="coletor">Coletor</label> <select name="coletorId"
					class="form-control">
					<option value="">..</option>
					<c:forEach var="coletor" items="${coletores}">
						<option value="${coletor.id}">${coletor.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="nome">Data</label> <input type="date"
					class="form-control" id="data" name="strData"
					 placeholder="Data do empréstimo">
			</div>
			
			<div class="form-group">
				<label for="nome">Montante</label> <input type="text"
					class="form-control" id="montante" name="montante"
					 placeholder="Valor">
			</div>
			
			<div class="form-group">
				<label for="nome">Taxa de Juro</label> <input type="text"
					class="form-control" id="taxaDeJuro" name="taxaDeJuro"
					 placeholder="Taxa De Juro">
			</div>

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>



	</div>
</body>


<%@ include file="footer.jsp"%>
