package giftmart

class PersonController {
	def index = {
		redirect(action: "list")
	}
	
	def create = {
		def stores = Gmstore.list()
		render(view: "create", model: [stores: stores])
	}
	
	def save = {
		def p = new Person(params)
		println "hola: " + params
		p.save(flush:true)
		println p
		redirect(action: "list")
	}
	
	def list = {
		def pList = Person.list()
		render(view: "list", model: [pList: pList])
	}
	
	def edit = {
		def p = Person.get(params.id)
		def stores = Gmstore.list()
		render(view: "edit", model: [person: p, stores :stores])
	}
	
	def update = {
		def p = Person.get(params.id)
		p.properties = params
		p.save(flush:true)
		redirect(action: "list")
	}
	
	def delete = {
		def p = Person.get(params.id)
		p.delete(flush: true)
		redirect(action: "list")
	}
	
	
	def etl = {	
		
		def allLinesLessHeader = new File("/media/sf_UMG/UMB.csv").readLines()[1..-1]
		def countBadEntries = 0
		allLinesLessHeader.eachWithIndex { line, i -> 
			//0 BKEY,1 LNAME,2 FNAME,3 COMMENTS,4 EMAIL,5 BadgeDATE,6 AttendedDATE,7 NKEY,8 TITLE,
			//9 OO,10 ADATE1,11 ADATE2,12 ADATE3,13 ADATE4,14 ADATE5,15 ADATE6,16 ADATE7,17 ADATE8,18 ADATE9,19 ARK
			def tokens = line.tokenize(',')
			def p = new Person(
				store: Gmstore.findByBkey(tokens[0]), // bkey is store primary key
				bkey: tokens[0] == "`" ? null : tokens[0] ,
				lname: tokens[1] == "`" ? null : tokens[1] ,
				fname: tokens[2] == "`" ? null : tokens[2] ,
				comments: tokens[3] == "`" ? null : tokens[3] ,
				email: tokens[4] == "`" ? null : tokens[4] ,
				badgeDate: tokens[5] == "`" ? null : tokens[5] ,
				nkey: tokens[7] == "`" ? null : tokens[7] ,
				title: tokens[8] == "`" ? null : tokens[8] ,
				oo: tokens[9] == "`" ? null : tokens[9] ,
				badgekey: tokens[0] + "" + tokens[7]
				)
			i%1000 == 0 ? println("how we doin? " + p.badgekey + " : " + tokens[6]) : ''
			if(tokens.size() <= 19) {
				p.save(flush:true)
				if(!p.validate()) {
					println("\n\nBad news! at line: " + i + " : bkey: " + p.badgekey + " : errors are: " + p.errors.toString()[0..150] + "\n\n")
					countBadEntries++
				}
			}
			else {
				countBadEntries++
				println("\n\nBad news! at line: " + i + " : bkey: " + p.bkey)// + " : errors are: " + gm.errors.toString()[0..120] + "\n\n")
			}
			
			// Date Handling TODO
			// tokens 6, 10 thru 18 are potential winners
			// if p is valid, check through each of those tokens
			// if they aren't null aka `, save em and validate
			// Still need to think about which keys to be storing here, think I should store the bkeys and badgekeys on the attendance
			// in case we migrate the primary key, it'll cause less headache
			def datelist = [tokens[6], tokens[10..18]].flatten()
			datelist.each { date ->
				if(date != '`') {
					def att = new Attendance(d: date, p: p, gm: p.store, bkey: p.bkey, badgekey: p.badgekey)
					att.save(flush:true)
					if(!att.validate()) {
						println "Oh No! The date was no good... it was: " + att.d
					}
				}
			}
			
				
		}	
		println countBadEntries
		redirect(action:"list")
	}
	
}
