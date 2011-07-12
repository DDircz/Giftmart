<html>
<head> 
	<title> Create Person</title>
	<meta name="layout" content="main" />
</head>
<body>

	<h1> Create Person</h1>

	<g:form action="save" method="post">
		<table>
			<tbody>
				<tr>
					<td>
						<label for="fname">First Name:</label>
					</td>
					<td>
						<input type="text" name="fname" value=""/>
					</td>					
				</tr>
				<tr>
					<td>
						<label for="lname">Last Name:</label>
					</td>
					<td>
						<input type="text" name="lname" value=""/>
					</td>					
				</tr>
				<tr>
					<td>
						<label for="email">Email Address:</label>
					</td>
					<td>
						<input type="text" name="email" value=""/>
					</td>					
				</tr>
				<tr>
					<td>
						<label for="store">Gift Mart Store:</label>
					</td>
					<td>
						<g:select name="store.id" from="${stores}" value="" optionKey="id" optionValue="name"/>
					</td>					
				</tr>
			</tbody>
		</table>
		<input type="submit"/>
	</g:form>
</body>
</html>
