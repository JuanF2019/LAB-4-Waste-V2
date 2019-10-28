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
	public Residue(String name, Product product, String id, String origin, String color, int decoTime) {
		this.name = name;
		this.product = product;
		this.id = id;
		this.origin = origin;
		this.color = color;
		this.decoTime = decoTime;
	}
	
	//SETS AND GETS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDecoTime() {
		return decoTime;
	}

	public void setDecoTime(int decoTime) {
		this.decoTime = decoTime;
	}
	
	//METHODS
	
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
	
	public abstract double calcHarmfulEffect();
	
	public String toString() {
		String objToString = "Name: " + this.name + "\n Product: " +  (this.product).getName() + "\n Id: " + this.id + "\n Origin: " + this.origin + "Color: " + this.color + "\n Decomposition Time: " + this.decoTime + " days";
		return objToString;
	}

	
}
