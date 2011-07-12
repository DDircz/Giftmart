<html>
<head> 
	<title> List people for a store</title>
	<meta name="layout" content="main" />
</head>
<body>


	<h1>List the people for store ${gms.name}</h1>
	<table>
		<tbody>
			<g:each in="${gmlist}" var="gms">
				<tr>
					<td>${gms.name}</td>
					<td>${gms.address}</td>
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