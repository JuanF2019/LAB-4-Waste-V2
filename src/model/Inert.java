package model;

public class Inert extends Residue {
	
	//ATTRIBUTES
	private String tip;	
	
	//CONSTRUCTOR
	/**Constructor for class Inert<br>
	*<b>pre: </b>At least one product must created and must no null.
	*@param name, String - Residue name.
	*@param product, Product - product that has the residue. product != null
	*@param id, String id of the residue.
	*@param origin, String origin of the residue.
	*@param color, String color of the residue.
	*@param decoTime, int decomposition time of the residue in days.
	*@param tip, String recomendation to dispose of the residue.
	*<b>pos: </b>Object of class  Inert is created, extending class residue.
	*/
	public Inert(String name, Product product, String id, String origin, String color, int decoTime, String tip) {
		super(name, product, id, origin, color, decoTime);
		this.tip = tip;
	}
	
	//SETS AND GETS
	/**Returns the value of the attribute tip.<br>
	<b>pre: </b>A inert residue must exist and has to be no null.
	*@return String value of attribute tip.	
	*/
	public String getTip() {
		return tip;
	}
	/**Changes the value of the attribute tip of object from class Inert<br>
	*<b>pre: </b>A inert residue must exist and has to be no null.
	*@param tip String new recomendation to dispose of the residue.
	*<b>pos: </b>Attribute tip is updated.
	*/
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	//METHODS
	/**Calculates and return the harmful effect of a residue from class inert.<br>
	*<b>pre: </b>A inert residue must exist and has to be no null.
	*@return double Harmful effect of the Inert residue.
	*/
	public double calcHarmfulEffect() {
		double harmfulEffect = 0;
		harmfulEffect = (super.calcHarmfulEffectFactor())*(this.getDecoTime());
		return harmfulEffect;
	}
	/**Returns a string with all the attributes of a inert residue and its values.<br>
	*<b>pre: </b>A inert residue must exist and has to be no null.
	*@return String with all the attributes an its values.
	*/
	public String toString() {
		String objToString = super.toString() + "\n Tip: " + this.tip;
		return objToString;
	}
}
