package giftmart

class Person {
	
	int id // TODO ditch this later?
	String fname
	String lname
	String comments
	String email
	Date badgeDate
	String nkey
	String title
	String oo
	String badgekey
	String bkey // TODO this might replace store
	Gmstore store
	
	static mapping = {
		version false
	}
	
    static constraints = {
		badgekey(unique: true)
		comments(nullable: true)
		title(nullable:true)
		oo(nullable:true)
		email(nullable:true)
		badgeDate(nullable:true)
		fname(nullable:true)
    }
}
