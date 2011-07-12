package giftmart

class GmstoreController {
	
	def index = {
		redirect(action: "list")
	}
	
	def create = {
		
	}
	
	def save = {
		def gmstore = new Gmstore(params)
		println "hola: " + params
		gmstore.save(flush:true)
		println gmstore
		redirect(action: "list")
	}
	
	def list = {
		def gmlist = Gmstore.list()
//		println gmlist
		render(view: "list", model: [gmlist: gmlist])
	}
	
	def edit = {
		def gmstore = Gmstore.get(params.id)
		render(view: "edit", model: [gmstore: gmstore])
	}
	
	def update = {
		def gmstore = Gmstore.get(params.id)
		gmstore.properties = params
		gmstore.save(flush:true)
		redirect(action: "list")
	}
	
	def delete = {
		def gmstore = Gmstore.get(params.id)
		gmstore.delete(flush:true)
		redirect(action: "list")
	}
	
	def people = {
		def gms = Gmstore.get(params.id)
	}
	
	/*
	 * Process for ETL load of GiftMart's .dbf files
	 *  1. Convert to .csv via ms excel
	 *  2. Remove superflous commas (99% will be in the "comments" field)
	 *  3. Have a browser hit this url
	 *  to debug well:
	 *  delete all records from the table, so a jillion uq constraints arent thrown
	 */
	def etl = {
		def allLinesLessHeader = params.extra ? new File("/media/sf_UMG/badStoresUM.csv").readLines()[1..-1] : new File("/media/sf_UMG/UM.csv").readLines()[1..-1]
		//def badEntriesFile = new File("/media/sf_UMG/badStoresUM.csv")
		def countBadEntries = 0
		allLinesLessHeader.eachWithIndex { line, i ->
			i%1000 == 0 ? println("\n\n begin line: " + i) : ''
			//i%1000 == 0 ? println(line) : ''
//0 NAME,1 ADDR,2 CITY,3 STATE,4 ZIP,5 PHONE,6 CLASS,7 CODE,8 DATELAST,9 DLAST1,10 DLAST2,11 COMMENTS,12 BKEY,13 FAX,
//14 TAXNUM,15 DLAST3,DLAST4,DLAST5,DLAST6,DLAST7,DLAST8,21 DLAST9,22 ARK
			def tokens = line.tokenize(',')
//			if(i%1000 == 0) {
//				 tokens.eachWithIndex {token, j ->
//					  println j + ":" + token
//				  }
//			}
			def gm = new Gmstore(
				name: tokens[0] == "`" ? null : tokens[0] ,
				addr: tokens[1] == "`" ? null : tokens[1] ,
				city: tokens[2] == "`" ? null : tokens[2] ,
				state: tokens[3] == "`" ? null : tokens[3] ,
				zip: tokens[4] == "`" ? null : tokens[4] ,
				phone: tokens[5] == "`" ? null : tokens[5] ,
				gmclass: tokens[6] == "`" ? null : tokens[6] ,
				code: tokens[7] == "`" ? null : tokens[7] ,
				comments: tokens[11] == "`" ? null : tokens[11] ,
				bkey: tokens[12] == "`" ? null : tokens[12] ,
				fax: tokens[13] == "`" ? null : tokens[13] ,
				taxnum: tokens[14] == "`" ? null : tokens[14]
				)
			
			
			if(tokens.size() <= 22) {
				gm.save(flush:true)
				if(!gm.validate()) { 
					println("\n\nBad news! at line: " + i + " : bkey: " + gm.bkey + " : errors are: " + gm.errors.toString()[0..120] + "\n\n")
					countBadEntries++
				}
			}
			else {
				countBadEntries++
				println("\n\nBad news! at line: " + i + " : bkey: " + gm.bkey)// + " : errors are: " + gm.errors.toString()[0..120] + "\n\n")
			}
			i%1000 == 0 ? println("\n end line: " +i): ''
							
		}
		println countBadEntries
		redirect(action: 'list')		
	}
	
}
