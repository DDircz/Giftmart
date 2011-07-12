package giftmart

class Gmstore {
	
	int id // TODO ditch this later?
	String name
	String addr
	String city
	String state
	String zip
	String phone
	String gmclass
	String code
	String comments	
	String bkey
	String fax
	String taxnum
	
	static mapping = {
		version false
	}
	
    static constraints = {
		bkey(unique:true)
		gmclass(nullable:true)
		code(nullable:true)
		comments(nullable:true)
		fax(nullable:true)
		taxnum(nullable:true)
		phone(nullable: true)
		state(nullable: true)
		zip(nullable: true)
    }
	
}
