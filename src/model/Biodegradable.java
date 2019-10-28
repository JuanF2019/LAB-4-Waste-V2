package model;

public class Biodegradable extends Residue implements Suitable {
	
	//CONSTANTS
	public static final double LESSBONUS = 0.01;
	
	//ATTRIBUTES
	private boolean canCompost;	
	
	//CONTRUCTOR
	/**Constructor for class Biodegradable<br>
	*<b>pre: </b>At least one product must created and must be no null.
	*@param name, String - Residue name.
	*@param product, Product - product that has the residue. product != null
	*@param id, String id of the residue.
	*@param origin, String origin of the residue.
	*@param color, String color of the residue.
	*@param decoTime, int decomposition time of the residue in days.
	*@param canCompost, boolean true or false depending in if a the biodegrdable residue is compostable or not.
	*<b>pos: </b>Object of class  Biodegradable is created, extending class residue.
	*/
	public Biodegradable(String name, Product product, String id, String origin, String color, int decoTime, boolean canCompost) {
		super(name, product, id, origin, color, decoTime);
		this.canCompost = canCompost;
	}
	
	//SETS AND GETS
	/**Returns the value of the attribute canCompost.<br>
	<b>pre: </b>A biodegradable residue must exist and has to be no null.
	*@return boolean value of attribute canCompost.
	*/
	public boolean getCanCompost() {
		return canCompost;
	}
	/**Changes the value of the attribute canCompost of object from class Recyclable.<br>
	*<b>pre: </b>A biodegrdable residue must exist and has to be no null.
	*@param canCompost String new recyclable residue canCompost.
	*<b>pos: </b>Attribute canCompost is updated.
	*/
	public void setCanCompost(boolean canCompost) {
		this.canCompost = canCompost;
	}
	
	//METHODS
	/**Calculates and return the harmful effect of a residue from class Biodegradable.<br>
	*<b>pre: </b>A Biodegradable residue must exist and has to be no null.
	*@return double Harmful effect of the Biodegradable residue.
	*/
	public double calcHarmfulEffect() {
		double harmfulEffect = 0;
		harmfulEffect = ((super.calcHarmfulEffectFactor())-LESSBONUS)*(this.getDecoTime());
		return harmfulEffect;
	}
	/**Calculates and return if a residue from class biodegradable is suitable or not.<br>
	*<b>pre: </b>A biodegradable residue must exist and has to be no null.
	*@return boolean True or false depending if biodegradable residue is suitable or not.
	*/
	public boolean isSuitable() {
		boolean isSuitable = false;
		
		if (this.canCompost && (this.getDecoTime()<365)) {
			isSuitable = true;
		}			
		return isSuitable;
	}
	/**Returns a string with all the attributes of a Biodegradable residue and its values<br>
	*<b>pre: </b>A Biodegrdable residue must exist and has to be no null.
	*@return String with all the attributes an its values.
	*/
	public String toString() {
		String objToString = super.toString() + "\n Can compost?: " + this.canCompost;
		return objToString;
	}

}
