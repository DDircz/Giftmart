<html>
<head> 
	<title> List Gmstores</title>
	<meta name="layout" content="main" />
</head>
<body>

	<g:link action="create">Go to create</g:link><br/>
	<g:link controller="person" action="list">See list of people</g:link>
	<h1> List all Gmstores</h1>
	<table>
		<tbody>
				<tr>
					<td>BKey</td>
					<td>Name</td>
					<td>Address</td>
					<td>City</td>
					<td>State</td>
					<td>Zip Code</td>
					<td/><td/>
				</tr>
			<g:each in="${gmlist}" var="gms">
				<tr>
					<td>${gms.bkey}</td>
					<td>${gms.name}</td>
					<td>${gms.addr}</td>
					<td>${gms.city}</td>
					<td>${gms.state}</td>
					<td>${gms.zip}</td>
					<td><g:link action="edit" params="${[id: gms.id]}">Edit</g:link>
					<td><g:link action="delete" params="${[id: gms.id]}">Delete</g:link>
				</tr>
			</g:each>
		</tbody>
	</table>
</body>
</html>