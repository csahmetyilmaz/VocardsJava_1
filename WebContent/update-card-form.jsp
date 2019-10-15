<!DOCTYPE html>
<html>
<head>
<title>Update This Card</title>
<!--  
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-card-style.css">

-->

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
	<div id="wrapper">

		<div id="header">
			<h2>Vocards Flash Cards</h2>
		</div>
	</div>
	<div id="container">


		<h3>Update This Card</h3>
		<form action="CardControllerServlet" method="GET">

			<input type="hidden" name="command" value="UPDATE"> <input
				type="hidden" name="cardId" value="${THE_CARD.id}">
			<table class="table table-striped">
				<tbody>
					<tr>
						<td><label>Mot:</label></td>
						<td><input type="text" name="mot" value="${THE_CARD.mot}" /></td>

						<td><label>Tr Mot:</label></td>

						<td><input type="text" name="tMot" value="${THE_CARD.tMot}" /></td>
					</tr>
					<tr>
						<td><label>Type:</label></td>

						<td><input type="text" name="type" value="${THE_CARD.type}" /></td>

						<td><label>Tr Type:</label></td>
						<td><input type="text" name="tType" value="${THE_CARD.tType}" /></td>
					</tr>
					<tr>
						<td><label>Synonyme:</label></td>
						<td><input type="text" name="syno" value="${THE_CARD.syno}" /></td>

						<td><label>Tr Synonyme:</label></td>
						<td><input type="text" name="tSyno" value="${THE_CARD.tSyno}" /></td>
					</tr>
					<tr>
						<td><label>Phrase:</label></td>
						<td><input type="text" name="phrase"
							value="${THE_CARD.phrase}" /></td>

						<td><label>Tr Phrase:</label></td>
						<td><input type="text" name="tPhrase"
							value="${THE_CARD.tPhrase}" /></td>
					</tr>

				</tbody>

			</table>

			<div align="center">
				<input type="submit" value="Save changes" class="btn btn-primary" />

			</div>


		</form>
		<div style="clear: both;"></div>
		<p>
			<a href="CardControllerServlet">Back To List</a>
		</p>



	</div>

</body>
</html>