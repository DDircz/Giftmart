<html>
<head> 
	<title> Edit Person</title>
	<meta name="layout" content="main" />
</head>
<body>

	<h1> Edit Person</h1>

	<g:form action="save" method="post">
		<table>
			<tbody>
				<tr>
					<td>
						<label for="fName">First Name:</label>
					</td>
					<td>
						<input type="text" name="fName" value="${person.fName}"/>
					</td>					
				</tr>
				<tr>
					<td>
						<label for="lName">Last Name:</label>
					</td>
					<td>
						<input type="text" name="lName" value="${person.lName}"/>
					</td>					
				</tr>
				<tr>
					<td>
						<label for="email">Email Address:</label>
					</td>
					<td>
						<input type="text" name="email" value="${person.email}"/>
					</td>					
				</tr>
				<tr>
					<td>
						<label for="myStore">Gift Mart Store:</label>
					</td>
					<td>
						<g:select name="myStore.id" from="${stores}" value="${person.myStore.name}" optionKey="id" optionValue="name"/>
					</td>					
				</tr>
			</tbody>
		</table>
		<input type="submit"/>
	</g:form>
</body>
</html>
