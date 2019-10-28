package model;

public class Product {
	private String name;
	private String id;
	private String description;
	private Residue[] residues;
		
	
	public Product(String name, String id, String description, int size) {
		this.name = name;
		this.id = id;
		this.description = description;
		residues = new Residue[size];
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
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
	
	public String toStringPro() {
		String objToString = "Name: " + this.name + "\nId: " +  this.id + "\nDescription: " + this.description;
		return objToString;
	}
	
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
