package model;

public class Recyclable extends Residue implements Suitable {
	
	//CONSTANTS
	public static final double LESSBONUS = 0.02;
	public static final String PAPER = "Paper";
	public static final String CARDBOARD = "Cardboard";
	public static final String GLASS = "Glass";
	public static final String PLASTIC = "Plastic";
	public static final String METAL = "Metal";
	
	//ATTRIBUTES
	private String type;
	private String description;
	
	//CONSTRUCTOR
	/**Constructor for class Recyclable.<br>
	*<b>pre: </b>At least one product must created and must be no null.
	*@param name, String - Residue name.
	*@param product, Product - product that has the residue. product != null
	*@param id, String id of the residue.
	*@param origin, String origin of the residue.
	*@param color, String color of the residue.
	*@param decoTime, int decomposition time of the residue in days.
	*@param type, String recyclable residue type.
	*@param description, String description of the recyclable residue.
	*<b>pos: </b>Object of class  recyclable is created, extending class residue.
	*/
	public Recyclable(String name, Product product, String id, String origin, String color, int decoTime, String type,String description) {
		super(name, product, id, origin, color, decoTime);
		this.type = type;
		this.description = description;
	}
	
	//SETS AND GETS
	/**Returns the value of the attribute type.<br>
	<b>pre: </b>A recyclable residue must exist and has to be no null.
	*@return String value of attribute type.
	*/
	public String getType() {
		return type;
	}
	/**Changes the value of the attribute type of object from class Recyclable.<br>
	*<b>pre: </b>A recyclable residue must exist and has to be no null.
	*@param type String new recyclable residue type.
	*<b>pos: </b>Attribute type is updated.
	*/
	public void setType(String type) {
		this.type = type;
	}
	/**Returns the value of the attribute description.<br>
	<b>pre: </b>A recyclable residue must exist and has to be no null.
	*@return String value of attribute description.	
	*/
	public String getDescription() {
		return description;
	}
	/**Changes the value of the attribute type of object from class Recyclable.<br>
	*<b>pre: </b>A recyclable residue must exist and has to be no null.
	*@param description String new description of the residue.
	*<b>pos: </b>Attribute description is updated.
	*/
	public void setDescription(String description) {
		this.description = description;
	}
	
	//METHODS
	/**Calculates and return the harmful effect of a residue from class Recyclable.<br>
	*<b>pre: </b>A Recyclable residue must exist and has to be no null.
	*@return double Harmful effect of the Recyclable residue.
	*/
	public double calcHarmfulEffect() {
		double harmfulEffect = 0;
		harmfulEffect = ((super.calcHarmfulEffectFactor())-LESSBONUS)*(this.getDecoTime());
		return harmfulEffect;
	}
	/**Calculates and return if a residue from class Recyclable is suitable or not.<br>
	*<b>pre: </b>A Recyclable residue must exist and has to be no null.
	*@return boolean True or false depending if Recyclable residue is suitable or not.
	*/
	public boolean isSuitable() {
		boolean isSuitable = false;
		
		if (this.description!=null) {
			isSuitable = true;
		}			
		return isSuitable;
	}
	/**Returns a string with all the attributes of a recyclable residue and its values.<br>
	*<b>pre: </b>A recyclable residue must exist and has to be no null.
	*@return String with all the attributes an its values.
	*/
	public String toString() {
		String objToString = super.toString() + "\n Type: " + this.type + "\n Description: " +  this.description;
		return objToString;
	}

	
}
