package model;

public class Inert extends Residue {
	
	//ATTRIBUTES
	private String tip;	
	
	//CONSTRUCTOR
	public Inert(String name, Product product, String id, String origin, String color, int decoTime, String tip) {
		super(name, product, id, origin, color, decoTime);
		this.tip = tip;
	}
	
	//SETS AND GETS
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	//METHODS	
	public double calcHarmfulEffect() {
		double harmfulEffect = 0;
		harmfulEffect = (super.calcHarmfulEffectFactor())*(this.getDecoTime());
		return harmfulEffect;
	}
	
	public String toString() {
		String objToString = super.toString() + "\n Tip: " + this.tip;
		return objToString;
	}
}
