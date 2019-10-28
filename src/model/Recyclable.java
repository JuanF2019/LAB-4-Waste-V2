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
	public Recyclable(String name, Product product, String id, String origin, String color, int decoTime, String type,String description) {
		super(name, product, id, origin, color, decoTime);
		this.type = type;
		this.description = description;
	}
	
	//SETS AND GETS
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	//METHODS
	public double calcHarmfulEffect() {
		double harmfulEffect = 0;
		harmfulEffect = ((super.calcHarmfulEffectFactor())-LESSBONUS)*(this.getDecoTime());
		return harmfulEffect;
	}
	
	public boolean isSuitable() {
		boolean isSuitable = false;
		
		if (this.description!=null) {
			isSuitable = true;
		}			
		return isSuitable;
	}

	public String toString() {
		String objToString = super.toString() + "\n Type: " + this.type + "\n Description: " +  this.description;
		return objToString;
	}

	
}
