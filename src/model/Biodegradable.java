package model;

public class Biodegradable extends Residue implements Suitable {
	
	//CONSTANTS
	public static final double LESSBONUS = 0.01;
	
	//ATTRIBUTES
	private boolean canCompost;	
	
	//CONTRUCTOR
	public Biodegradable(String name, Product product, String id, String origin, String color, int decoTime, boolean canCompost) {
		super(name, product, id, origin, color, decoTime);
		this.canCompost = canCompost;
	}
	
	//SETS AND GETS
	public boolean getCanCompost() {
		return canCompost;
	}

	public void setCanCompost(boolean canCompost) {
		this.canCompost = canCompost;
	}
	
	//METHODS
	public double calcHarmfulEffect() {
		double harmfulEffect = 0;
		harmfulEffect = ((super.calcHarmfulEffectFactor())-LESSBONUS)*(this.getDecoTime());
		return harmfulEffect;
	}
	
	public boolean isSuitable() {
		boolean isSuitable = false;
		
		if (this.canCompost && (this.getDecoTime()<365)) {
			isSuitable = true;
		}			
		return isSuitable;
	}
	
	public String toString() {
		String objToString = super.toString() + "\n Can compost?: " + this.canCompost;
		return objToString;
	}

}
