<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Vocards Language Learning App</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

</head>


<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">VOCARDS</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Decouvrir</a></li>
					<li><a href="#about">Play</a></li>
					<li><a href="#contact">A Propos</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Langue(Fr) <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>


<div class="page-header">
        <!-- put add Card button -->
        
        
			
      </div>

	<div>
		<div>
			<input type="button" value="Add New Card" class="btn btn-primary"
				onclick="window.location.href='add-card-form.jsp';return false;"
				 /><p><p>

			<table class="table table-striped">
				<tr>
					<th>Mot</th>
					<th>Traduction</th>
					<th>Type</th>
					<th>Tr Type</th>
					<th>Synonyme</th>
					<th>Tr Synonyme</th>
					<th>Phrase</th>
					<th>Tr Phrase</th>
					<th>Etat</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempCard" items="${CARD_LIST}">

					<!-- Set up Link for each card -->
					<c:url var="tempLink" value="CardControllerServlet">

						<c:param name="command" value="LOAD" />
						<c:param name="cardId" value="${tempCard.id }" />
					</c:url>

					<!-- Set up DELETE Link for each card -->
					<c:url var="deleteLink" value="CardControllerServlet">

						<c:param name="command" value="DELETE" />
						<c:param name="cardId" value="${tempCard.id }" />
					</c:url>


					<tr>
						<td>${tempCard.mot}</td>
						<td>${tempCard.tMot}</td>
						<td>${tempCard.type}</td>
						<td>${tempCard.tType}</td>
						<td>${tempCard.syno}</td>
						<td>${tempCard.tSyno}</td>
						<td>${tempCard.phrase}</td>
						<td>${tempCard.tPhrase}</td>
						<td>${tempCard.auteurId}</td>
						<td><a href="${tempLink}">
						
						<button type="button" class="btn btn-sm btn-warning">Update</button>
						</a>
						
						
						 | <a
							href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this card?')))return false">

								
								
								<button type="button" class="btn btn-sm btn-danger">Delete</button></a>
								</td>
					</tr>
				</c:forEach>

			</table>
		</div>


	</div>

</body>

</html>