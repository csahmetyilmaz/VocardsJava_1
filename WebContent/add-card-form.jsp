<!DOCTYPE html>
<html>
<head>
<title>Add New Card</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-card-style.css">
</head>
<body>
	<div id="wrapper">

		<div id="header">
			<h2>Vocards Flash Cards</h2>
		</div>
	</div>
	<div id="container">


		<h3>Add New Card</h3>
		<form action="CardControllerServlet" method="POST">

			<input type="hidden" name="command" value="ADD">
			<table>
				<tbody>
					<tr>
						<td><label>Mot:</label></td>
						<td><input type="text" name="mot" /></td>
					
						<td><label>Tr Mot:</label></td>
						<td><input type="text" name="tMot" /></td>
					</tr>
					<tr>
						<td><label>Type:</label></td>
						<td><input type="text" name="type" /></td>
					
						<td><label>Tr Type:</label></td>
						<td><input type="text" name="tType" /></td>
					</tr>
					<tr>
						<td><label>Synonyme:</label></td>
						<td><input type="text" name="syno" /></td>
					
						<td><label>Tr Synonyme:</label></td>
						<td><input type="text" name="tSyno" /></td>
					</tr>
					<tr>
						<td><label>Phrase:</label></td>
						<td><input type="text" name="phrase" /></td>
				
						<td><label>Tr Phrase:</label></td>
						<td><input type="text" name="tPhrase" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save" /></td>
					</tr>
				</tbody>
			</table>


		</form>
		<div style="clear: both;"></div>
		<p>
			<a href="CardControllerServlet">Back To List</a>
		</p>



	</div>

</body>
</html>