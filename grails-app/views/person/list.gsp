<html>
<head> 
	<title> List People</title>
	<meta name="layout" content="main" />
</head>
<body>

	<g:link action="create">Go to create</g:link><br/>
	<g:link controller="gmstore" action="list">See list of stores</g:link>
	<h1> List all People</h1>
	<table>
		<tbody>
				<tr>
					<td>BadgeKey</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>email</td>
					<td>Store Name</td>
					<td/><td/>
				</tr>
			<g:each in="${pList}" var="p">
				<tr>
					<td>${p.badgekey}</td>
					<td>${p.fname}</td>
					<td>${p.lname}</td>
					<td>${p.email}</td>
					<td>${p.store.name}</td>
					<td><g:link action="edit" params="${[id: p.id]}">Edit</g:link></td>
					<td><g:link action="delete" params="${[id: p.id]}">Delete</g:link></td>
				</tr>
			</g:each>
		</tbody>
	</table>
</body>
</html>