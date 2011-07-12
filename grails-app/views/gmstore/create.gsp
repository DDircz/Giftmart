<html>
<head> 
	<title> Create Gmstores</title>
	<meta name="layout" content="main" />
</head>
<body>

	<h1> Create Gmstore</h1>

	<g:form action="save" method="post">
		<table>
			<tbody>
				<tr>
					<td>
						<label for="name">Name:</label>
					</td>
					<td>
						<input type="text" name="name" value=""/>
					</td>					
				</tr>
				<tr>
					<td>
						<label for="addr">Address:</label>
					</td>
					<td>
						<input type="text" name="addr" value=""/>
					</td>					
				</tr>
				<tr>
					<td>
						<label for="city">City:</label>
					</td>
					<td>
						<input type="text" name="city" value=""/>
					</td>					
				</tr>
				<tr>
					<td>
						<label for="state">State:</label>
					</td>
					<td>
						<input type="text" name="state" value=""/>
					</td>					
				</tr>
				<tr>
					<td>
						<label for="zip">Zip:</label>
					</td>
					<td>
						<input type="text" name="zip" value=""/>
					</td>					
				</tr>
			</tbody>
		</table>
		<input type="submit"/>
	</g:form>
</body>
</html>
