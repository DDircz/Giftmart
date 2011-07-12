dataSource {
	dataSource {
		dbCreate = "update"
		driverClassName = "com.mysql.jdbc.Driver"
		url = "jdbc:mysql://localhost/gmart"
		username = "root"
		password = "starwars"
	}
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update"
            driverClassName = "com.mysql.jdbc.Driver"
            url = "jdbc:mysql://localhost/gmart"
            username = "root"
            password = "starwars"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:hsqldb:mem:testDb"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:hsqldb:file:prodDb;shutdown=true"
        }
    }
}
