package model;

public class Product {
	private String name;
	private String id;
	private String description;
	private Residue[] residues;
		
	/**Constructor for class product.<br>
	*@param name, String Product name.
	*@param id, String id of the product.
	*@param description, String description of the product.
	*@param size, number of residues that the product generates.
	*<b>pos: </b>Object of class Product is created.	
	*/
	public Product(String name, String id, String description, int size) {
		this.name = name;
		this.id = id;
		this.description = description;
		residues = new Residue[size];
	}
	/**Returns the name of a product.<br>
	<b>pre: </b>A product must exist and has to be no null.
	*@return String value of attribute name.	
	*/
	public String getName() {
		return name;
	}
	/**Changes the name of the product.<br>
	*<b>pre: </b>A product must exist and has to be no null.
	*@param name String new product name.
	*<b>pos: </b>Attribute name is updated.
	*/
	public void setName(String name) {
		this.name = name;
	}
	/**Returns the product id.<br>
	<b>pre: </b>A product must exist and has to be no null.
	*@return String value of attribute id.	
	*/
	public String getId() {
		return id;
	}
	/**Changes the id of the product.<br>
	*<b>pre: </b>A product must exist and has to be no null.
	*@param id String new product name.
	*<b>pos: </b>Attribute name is updated.
	*/
	public void setId(String id) {
		this.id = id;
	}
	/**Returns the description of a product.<br>
	<b>pre: </b>A product must exist and has to be no null.
	*@return String value of attribute description.	
	*/
	public String getDescription() {
		return description;
	}
	/**Changes the description of the product.<br>
	*<b>pre: </b>A product must exist and has to be no null.
	*@param description String new product description.
	*<b>pos: </b>Attribute description is updated.
	*/
	public void setDescription(String description) {
		this.description = description;
	}
	/**Creates a new Inert residue for a given product.<br>
	*<b>pre: </b>At least one product must created and must no null.
	*@param name, String - Residue name.
	*@param product, Product - product that has the residue. product != null
	*@param id, String id of the residue.
	*@param origin, String origin of the residue.
	*@param color, String color of the residue.
	*@param decoTime, int decomposition time of the residue in days.
	*@param tip, String recomendation to dispose of the residue.
	*<b>pos: </b>New Inert residue is created.
	*@return Message of success or null String if the object could not be created.
	*/
	public String addResidue(String name, Product product, String id, String origin, String color, int decoTime, String tip) {//FOR INERT
		String msg = null;
		for(int i =0; i<residues.length;i++) {
			if(residues[i]==null) {
				residues[i] = new Inert(name,product,id,origin,color,decoTime,tip);
				msg = "Residue created succesfully.";
			}			
		} 
		return msg;		
	}
	/**Creates a new Recyclable residue for a given product<br>
	*<b>pre: </b>At least one product must created and must be no null.
	*@param name, String - Residue name.
	*@param product, Product - product that has the residue. product != null
	*@param id, String id of the residue.
	*@param origin, String origin of the residue.
	*@param color, String color of the residue.
	*@param decoTime, int decomposition time of the residue in days.
	*@param type, String recyclable residue type.
	*@param description, String description of the recyclable residue.
	*<b>pos: </b>New recyclable residue is created.
	*@return Message of success or null String if the object could not be created.
	*/
	public String addResidue(String name, Product product, String id, String origin, String color, int decoTime, String type,String description) {//FOR RECYCLABLE
		String msg = null;	
		for(int i =0; i<residues.length;i++) {
			if(residues[i]==null) {
				residues[i] = new Recyclable(name,product,id,origin,color,decoTime,type,description);
				msg = "Residue created succesfully.";
			}			
		} 
		return msg;
	}	
	/**Creates new Biodegradable residue for a given product.<br>
	*<b>pre: </b>At least one product must created and must be no null.
	*@param name, String - Residue name.
	*@param product, Product - product that has the residue. product != null
	*@param id, String id of the residue.
	*@param origin, String origin of the residue.
	*@param color, String color of the residue.
	*@param decoTime, int decomposition time of the residue in days.
	*@param canCompost, boolean true or false depending in if a the biodegrdable residue is compostable or not.
	*<b>pos: </b>New biodegradable residue is created.
	*@return Message of success or null String if the object could not be created.
	*/
	public String addResidue(String name, Product product, String id, String origin, String color, int decoTime, boolean canCompost) {//FOR BIODEGRADABLE
		String msg = null;
		for(int i =0; i<residues.length;i++) {
			if(residues[i]==null) {
				residues[i] = new Biodegradable(name,product,id,origin,color,decoTime,canCompost);
				msg = "Residue created succesfully.";
			}			
		} 
		return msg;		
	}
	/**Returns a string with all the attributes of a product and its values.<br>
	*<b>pre: </b>A product must exist and has to be no null.
	*@return String with all the attributes an its values.
	*/
	public String toStringPro() {
		String objToString = "Name: " + this.name + "\nId: " +  this.id + "\nDescription: " + this.description;
		return objToString;
	}
	/**Returns a string with all the attributes of a product, its values and its residues ordered from the most to the less harmful.<br>
	*<b>pre: </b>A product must exist and has to be no null.
	*@return String with all the attributes, its values and the ordered residues from the most to the less harmful.
	*/
	public String toStringProOR() {//MAKES A STRING WITH THE RESIDUES OF A PRODUCT, ORDERED FROM THE MOST TO THE LESS HARMFUL
		String orderedResidues = "Product name and id: " + this.name + " - " + this.id + "\n Residues:\n ";
		boolean check = false;
		int highestPos = 0;
		double[] harmfulArray = new double[residues.length];
		for (int i=0; i<residues.length;i++) {
			if (residues[i]!=null) {
				if (residues[i] instanceof Inert) {
					harmfulArray[i] = ((Inert)residues[i]).calcHarmfulEffect();
				}
				else if (residues[i] instanceof Recyclable) {
					harmfulArray[i] = ((Recyclable)residues[i]).calcHarmfulEffect();
				}
				else if (residues[i] instanceof Biodegradable) {
					harmfulArray[i] = ((Biodegradable)residues[i]).calcHarmfulEffect();
				}	
			}
		}
		
		while(!check) {
			for(int i = 0; i<harmfulArray.length;i++) {
				if(highestPos<harmfulArray[i]) {
					highestPos = i;
				}				
			}
			
			if(highestPos!=0) {
				orderedResidues += "Name: " + residues[highestPos].getName() + " Id: " + residues[highestPos].getId() +  "\n " ;
				harmfulArray[highestPos] = 0;
				highestPos = 0;
			}
			else {
				check = true;
			}						
		}
		return orderedResidues;		
	}
}
