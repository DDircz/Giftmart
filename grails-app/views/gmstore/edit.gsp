<html>
<head> 
	<title> Edit Gmstores</title>
	<meta name="layout" content="main" />
</head>
<body>

	<h1>Edit Gmstore</h1>

	<g:form action="update" method="post">
		<table>
			<tbody>
				<tr>
					<td>
						<label for="name">Name:</label>
					</td>
					<td>
						<input type="text" name="name" value="${gmstore.name}"/>
					</td>					
				</tr>
				<tr>
					<td>
						<label for="addr">Address:</label>
					</td>
					<td>
						<input type="text" name="addr" value="${gmstore.addr}"/>
					</td>					
				</tr>
				<tr>
					<td>
						<label for="city">City:</label>
					</td>
					<td>
						<input type="text" name="city" value="${gmstore.city}"/>
					</td>					
				</tr>
				<tr>
					<td>
						<label for="state">State:</label>
					</td>
					<td>
						<input type="text" name="state" value="${gmstore.state}"/>
					</td>					
				</tr>
				<tr>
					<td>
						<label for="zip">Zip:</label>
					</td>
					<td>
						<input type="text" name="zip" value="${gmstore.zip}"/>
					</td>					
				</tr>
			</tbody>
		</table>
		<input type="hidden" name="id" value="${gmstore.id}"/>
		<input type="submit"/>
	</g:form>
</body>
</html>
