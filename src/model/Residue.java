package model;

public abstract class Residue {
	//CONSTANTS
	public static final String INDUSTRIAL = "Industrial";
	public static final String HOUSEHOLD = "Household";
	public static final String CONSTRUCTION = "Construction";
	public static final String LOCAL = "Local";
	public static final String HOSPITAL = "Hospital";
	public static final double FINDUSTRIAL = 0.1;
	public static final double FHOUSEHOLD = 0.05;
	public static final double FCONTRUCTION = 0.08;
	public static final double FLOCAL = 0.12;
	public static final double FHOSPITAL = 0.15;
	
	
	//RELATIONS
	private Product product;
	
	//ATTRIBUTES
	private String name;
	private String id;
	private String origin;
	private String color;
	private int decoTime; //Decomposition time in days.
	
	//CONSTRUCTOR
	/**Constructor for class Residue. No residue can be created directly in class Residue, as it is an abstract class.<br>
	*<b>pre: </b>At least one product must created and must no null.
	*@param name, String - Residue name.
	*@param product, Product - product that has the residue. product != null
	*@param id, String id of the residue.
	*@param origin, String origin of the residue.
	*@param color, String color of the residue.
	*@param decoTime, int decomposition time of the residue in days.	
	*/
	public Residue(String name, Product product, String id, String origin, String color, int decoTime) {
		this.name = name;
		this.product = product;
		this.id = id;
		this.origin = origin;
		this.color = color;
		this.decoTime = decoTime;
	}
	
	//SETS AND GETS
	/**Returns the value of the attribute name.<br>
	<b>pre: </b>A residue of any subClass must exist and has to be no null.
	*@return String value of attribute name.	
	*/
	public String getName() {
		return name;
	}
	/**Changes the value of the attribute name of object from residue subClasse's.<br>
	*<b>pre: </b>A residue of any subClass must exist and has to be no null.
	*@param name String new residue name.
	*<b>pos: </b>Attribute name is updated.
	*/
	public void setName(String name) {
		this.name = name;
	}
	/**Returns the value of the attribute id.<br>
	<b>pre: </b>A residue of any subClass must exist and has to be no null.
	*@return String value of attribute id.	
	*/
	public String getId() {
		return id;
	}
	/**Changes the value of the attribute if of object from residue subClasse's.<br>
	*<b>pre: </b>A residue of any subClass must exist and has to be no null.
	*@param id String new residue id.
	*<b>pos: </b>Attribute id is updated.
	*/
	public void setId(String id) {
		this.id = id;
	}
	/**Returns the value of the attribute origin.<br>
	<b>pre: </b>A residue of any subClass must exist and has to be no null.
	*@return String value of attribute origin.	
	*/
	public String getOrigin() {
		return origin;
	}
	/**Changes the value of the attribute origin of object from residue subClasse's.<br>
	*<b>pre: </b>A residue of any subClass must exist and has to be no null.
	*@param origin String new residue origin.
	*<b>pos: </b>Attribute origin is updated.
	*/
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**Returns the value of the attribute color.<br>
	<b>pre: </b>A residue of any subClass must exist and has to be no null.
	*@return String value of attribute color.	
	*/
	public String getColor() {
		return color;
	}
	/**Changes the value of the attribute color of object from residue subClasse's.<br>
	*<b>pre: </b>A residue of any subClass must exist and has to be no null.
	*@param color String new residue color.
	*<b>pos: </b>Attribute color is updated.
	*/
	public void setColor(String color) {
		this.color = color;
	}
	/**Returns the value of the attribute decoTime.<br>
	<b>pre: </b>A residue of any subClass must exist and has to be no null.
	*@return String value of attribute decoTime.	
	*/
	public int getDecoTime() {
		return decoTime;
	}
	/**Changes the value of the attribute decoTime of object from residue subClasse's.<br>
	*<b>pre: </b>A residue of any subClass must exist and has to be no null.
	*@param decoTime String new residue decomposition time.
	*<b>pos: </b>Attribute decoTime is updated.
	*/
	public void setDecoTime(int decoTime) {
		this.decoTime = decoTime;
	}
	
	//METHODS
	/**Calculates and returns the harmful effect factor depending on the residue origin.<br>
	*<b>pre: </b>A residue of any subClass must exist and has to be no null.
	*@return Harmful effect factor.
	*/
	public double calcHarmfulEffectFactor() {
		double factor = 0;
		 switch (this.getOrigin()) {
		 	case "Industrial":
		 		factor = FINDUSTRIAL;
		 	break;
		 	case "Household":
		 		factor = FHOUSEHOLD;
		 	break;
		 	case "Construction":
		 		factor = FCONTRUCTION;
		 	break;
		 	case "Local":
		 		factor = FLOCAL;
		 	break;
		 	case "Hospital":
		 		factor = FHOSPITAL;
		 	break;
		 	default:		 	
		 }		
		return factor;
	}
	/**Declares abstract method calcHarmfulEffect for all subClass's Biodegradable and Recyclable.<br>
	*@return double
	*/
	public abstract double calcHarmfulEffect();
	/**Returns a string with all the attributes of a residue and its values.<br>
	*<b>pre: </b>A residue of any subClass must exist and has to be no null.
	*@return String with all the attributes an its values.
	*/
	public String toString() {
		String objToString = "Name: " + this.name + "\n Product: " +  (this.product).getName() + "\n Id: " + this.id + "\n Origin: " + this.origin + "Color: " + this.color + "\n Decomposition Time: " + this.decoTime + " days";
		return objToString;
	}

	
}
