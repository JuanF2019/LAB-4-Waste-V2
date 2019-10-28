package model;

public class WasteInc {
	
	//RELATIONS
	private Product[] products;
	private Residue[] globalResidues;
	
	//ATTRIBUTES
	private String name;
	
	//CONSTRUCTOR
	/**Constructor for class WasteInc.<br>
	*@param name String name of the waste company.
	*<b>pos: </b>Object of class WasteInc is created.
	*/
	public WasteInc(String name) {
		this.name = name;
		products = new Product[5];
		globalResidues = new Residue[5];
	}

	//SETS AND GETS
	/**Returns the name of the waste company.<br>
	<b>pre: </b>A waste company must exist and has to be no null.
	*@return String value of attribute name.	
	*/
	public String getName() {
		return name;
	}
	/**Changes the name of the waste company.<br>
	*<b>pre: </b>A product must exist and has to be no null.
	*@param name String new waste company name.
	*<b>pos: </b>Attribute name is updated.
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	//METHODS
	/**Returns the information of a residue given its name or null String if no residue was found.<br>
	*<b>pre: </b>At least one product and one residue must exist.
	*@param name String name of the residue.
	*@return String with the residue information or null String if no residue was found.
	*/
	public String searchResByName(String name) {//RETURNS NULL STRING IF NO RESIDUE WAS FOUND
		boolean check = false;
		String objToString = null;
		
		for(int i =0; i<globalResidues.length && !check;i++) {
			if(globalResidues[i]!=null && (globalResidues[i].getName()).equals(name)) {
				objToString = globalResidues[i].toString();
				check = true;
			}			
		}		
		return objToString;
	}
	/**Returns the information of a residue given its id or null String if no residue was found.<br>
	*<b>pre: </b>At least one product and one residue must exist.
	*@param id String id of the residue.
	*@return String with the residue information or null String if no residue was found.
	*/
	public String searchResById(String id) {//RETURNS NULL STRING IF NO RESIDUE WAS FOUND
		boolean check = false;
		String objToString = null;
		
		for(int i =0; i<globalResidues.length && !check;i++) {
			if(globalResidues[i]!=null && (globalResidues[i].getId()).equals(id)) {
				objToString = globalResidues[i].toString();
				check = true;
			}			
		}		
		return objToString;
	}
	/**Returns the information of a product given its name or null String if no product was found.<br>
	*<b>pre: </b>At least one product and one residue must exist.
	*@param name String name of the product.
	*@return String with the product information or null String if no product was found.
	*/
	public String searchProByName(String name) {//RETURNS NULL STRING IF NO PRODUCT WAS FOUND
		boolean check = false;
		String objToString = null;
		
		for(int i =0; i<products.length && !check;i++) {
			if(products[i]!=null && (products[i].getName()).equals(name)) {
				objToString = products[i].toStringPro();
				check = true;
			}			
		}		
		return objToString;
	}
	/**Returns the information of a product given its id or null String if no product was found.<br>
	*<b>pre: </b>At least one product and one residue must exist.
	*@param id String id of the product.
	*@return String with the product information or null String if no product was found.
	*/
	public String searchProById(String id) {//RETURNS NULL STRING IF NO PRODUCT WAS FOUND
		boolean check = false;
		String objToString = null;
		
		for(int i =0; i<products.length && !check;i++) {
			if(products[i]!=null && (products[i].getId()).equals(id)) {
				objToString = products[i].toStringPro();
				check = true;
			}			
		}		
		return objToString;
	}
	/**Returns the information of a residue given a residue of any type.<br>
	*<b>pre: </b>At least one product and one residue must exist.
	*@param residue Residue object of which the imformation will be extracted.
	*@return String with the residue information or null String if residue was null.
	*/
	public String toString(Residue residue) {
		String objToString = null;
		if (residue!=null) {
			if (residue instanceof Inert) {
				objToString = ((Inert)residue).toString();
			}
			else if (residue instanceof Recyclable) {
				objToString = ((Recyclable)residue).toString();
			}
			else if (residue instanceof Biodegradable) {
				objToString = ((Biodegradable)residue).toString();
			}	
		}
		return objToString;
	}	
	/**Adds a residue of class Inert<br>
	*<b>pre: </b>At least one product must created and must no null.
	*@param name, String Residue name.
	*@param productId, product id of the product that produced the residue.
	*@param id, String id of the residue.
	*@param origin, String origin of the residue.
	*@param color, String color of the residue.
	*@param decoTime, int decomposition time of the residue in days.
	*@param tip, String recomendation to dispose of the residue.
	*<b>pos: </b>Object of class  Inert is created.
	*@return Message of success or null String if the object could not be created.
	*/
	public String addResidue(String name, String productId, String id, String origin, String color, int decoTime, String tip) {//FOR INERT
		String msg = null;
		for(int i =0; i<globalResidues.length;i++) {
			if(globalResidues[i]==null) {
				globalResidues[i] = new Inert(name,products[searchProductPosById(productId)],id,origin,color,decoTime,tip);
				msg = "Residue created succesfully.";
			}			
		} 
		return msg;		
	}
	/**Creates a new Recyclable residue for a given product<br>
	*<b>pre: </b>At least one product must created and must be no null.
	*@param name, String - Residue name.
	*@param productId, productId, product id of the product that produced the residue.
	*@param id, String id of the residue.
	*@param origin, String origin of the residue.
	*@param color, String color of the residue.
	*@param decoTime, int decomposition time of the residue in days.
	*@param type, String recyclable residue type.
	*@param description, String description of the recyclable residue.
	*<b>pos: </b>New recyclable residue is created.
	*@return Message of success or null String if the object could not be created.
	*/
	public String addResidue(String name, String productId, String id, String origin, String color, int decoTime, String type,String description) {//FOR RECYCLABLE
		String msg = null;	
		for(int i =0; i<globalResidues.length;i++) {
			if(globalResidues[i]==null) {
				globalResidues[i] = new Recyclable(name,products[searchProductPosById(productId)],id,origin,color,decoTime,type,description);
				msg = "Residue created succesfully.";
			}			
		} 
		return msg;
	}	
	/**Creates new Biodegradable residue for a given product.<br>
	*<b>pre: </b>At least one product must created and must be no null.
	*@param name, String - Residue name.
	*@param productId, id of the product that which contain the residue.
	*@param id, String id of the residue.
	*@param origin, String origin of the residue.
	*@param color, String color of the residue.
	*@param decoTime, int decomposition time of the residue in days.
	*@param canCompost, boolean true or false depending in if a the biodegrdable residue is compostable or not.
	*<b>pos: </b>New biodegradable residue is created.
	*@return Message of success or null String if the object could not be created.
	*/
	public String addResidue(String name, String productId, String id, String origin, String color, int decoTime, boolean canCompost) {//FOR BIODEGRADABLE
		String msg = null;
		for(int i =0; i<globalResidues.length;i++) {
			if(globalResidues[i]==null) {
				globalResidues[i] = new Biodegradable(name,products[searchProductPosById(productId)],id,origin,color,decoTime,canCompost);
				msg = "Residue created succesfully.";
			}			
		} 
		return msg;		
	}
	/**Adds a product and initialize its residues array.<br>
	*@param name, String Product name.
	*@param id, String id of the product.
	*@param description, String description of the product.
	*@param size, number of residues that the product generates.
	*<b>pos: </b>Object of class Product is created.
	*@return Message of success or null String if the object could not be created.	
	*/
	public String addProduct(String name, String id, String description, int size) {
		String msg = null;
		for(int i =0; i<products.length;i++) {
			if(products[i]==null) {
				products[i] = new Product(name,id,description,size);
				msg = "Product created succesfully.";
			}			
		}
		return msg;
	}
	/**Returns the position of product given its id.<br>
	*<b>pre: </b>At least one product and one residue must exist.
	*@param productId String id of the product to find.
	*@return int with the position of the product in the products array, -1 if no product was found.
	*/
	public int searchProductPosById(String productId) {
		boolean check = false;
		int pos = -1;
		for(int i =0; i<products.length && !check;i++) {
			if(products[i]!=null && (products[i].getId()).equals(productId)) {
				pos = i;
				check = true;
			}			
		}
		return pos;
	}
	/**Returns a string with all the attributes of a product and its values.<br>
	*<b>pre: </b>A product must exist and has to be no null.
	*@return String with all the attributes an its values.
	*/
	public String toStringPro() {
		String str = null;
		for(int i = 0; i<products.length;i++) {
			if(products[i]!=null) {
				str += "\n" + products[i].toStringPro() + "\n";
			}			
		}
		return str;
	}
	/**Returns a string with all the name and id of a product and its residues ordered from the most to the less harmful. Given the product id<br>
	*<b>pre: </b>A product must exist and has to be no null.
	*@param productId String id of the product.
	*@return String with the name and id of a product and its residues ordered from the most to the less harmful.
	*/
	public String toStringProOR(String productId) {
		String orderedResidues = "";
		int productPos = searchProductPosById(productId);
		
		if (productPos==-1) {
			orderedResidues = null;
		}
		else {
			orderedResidues = products[productPos].toStringProOR();
		}
		return orderedResidues;
	}
	/**Generates a report of all the residues information ordered by its type.<br>
	*<b>pre: </b>A product must exist and its residues have to be no null.
	*@return Report with all the residues information ordered by its type.
	*/
	public String generateReport() {
		String str = "Inert: \n ";
			
		for(int i = 0; i < globalResidues.length;i++) {
			if (globalResidues[i]!=null && globalResidues[i] instanceof Inert) {
				str += ((Inert)globalResidues[i]).toString();
			}
		}
		
		str += "\nRecyclable: \n";
		for(int i = 0; i < globalResidues.length;i++) {
			if (globalResidues[i]!=null && globalResidues[i] instanceof Recyclable) {
				str += ((Recyclable)globalResidues[i]).toString();
			}
		}
		
		str += "\nBiodegradable: \n";
		for(int i = 0; i < globalResidues.length;i++) {
			if (globalResidues[i]!=null && globalResidues[i] instanceof Biodegradable) {
				str += ((Biodegradable)globalResidues[i]).toString();
			}
		}		
		return str;
	}
}
