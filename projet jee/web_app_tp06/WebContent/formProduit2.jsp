<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Connexion</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css" />
</head>

<body>
	<c:if test="${not empty erreur }">
		<div class="erreur">
			<c:out value="${ erreur }">
			</c:out>
		</div>
	</c:if>

	<div>Veuillez saisir les caractéristiques d'un produit :</div>
	<div>
		<form action="formProduitAction" method="POST">
			<jsp:useBean id="bean" class="model.Produit" scope="request" />
			<table>
				<tr>
					<td class="label">Id:</td>
					<td><input type="text" name="id" value="${ bean.id }" /></td>
				</tr>
				<tr>
					<td class="label">code:</td>
					<td><input type="text" name="code" value="${ bean.code }" /></td>
				</tr>
				<tr>
					<td class="label">Désignation:</td>
					<td><input type="text" name="designation"
						value="${ bean.designation }" /></td>
				</tr>
				<tr>
					<td class="label">Prix:</td>
					<td><input type="text" name="prix" value="${ bean.prix }" /></td>
				</tr>
				<tr>
					<td class="label">Catégorie:</td>
					<td><select name="categorie">
							<option value="">--------------</option>
							<option value="Plastique">Plastique</option>
							<option value="Alimentaire" >Alimentaire</option>
							<option value="Cosmétique">Cosmétique</option>	
					</select></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit"
						value="ok " /> <input type="reset" value="Annuler" /></td>
				</tr>






			</table>
		</form>
	</div>
</body>
</html>