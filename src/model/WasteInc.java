package model;

public class WasteInc {
	
	//RELATIONS
	private Product[] products;
	private Residue[] globalResidues;
	
	//ATTRIBUTES
	private String name;
	
	//CONSTRUCTOR
	public WasteInc(String name) {
		this.name = name;
		products = new Product[5];
		globalResidues = new Residue[5];
	}

	//SETS AND GETS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//METHODS
	public String searchResByName(String name) {//RETURNS NULL STRING IF NO RESIDUE WAS FOUND
		boolean check = false;
		String objToString = null;
		
		for(int i =0; i<globalResidues.length && !check;i++) {
			if(globalResidues[i]!=null && (globalResidues[i].getName()).equals(name)) {
				objToString = globalResidues[i].toString();
				check = true;
			}			
		}		
		return objToString;
	}
	
	public String searchResById(String id) {//RETURNS NULL STRING IF NO RESIDUE WAS FOUND
		boolean check = false;
		String objToString = null;
		
		for(int i =0; i<globalResidues.length && !check;i++) {
			if(globalResidues[i]!=null && (globalResidues[i].getId()).equals(id)) {
				objToString = globalResidues[i].toString();
				check = true;
			}			
		}		
		return objToString;
	}
	
	public String searchProByName(String name) {//RETURNS NULL STRING IF NO PRODUCT WAS FOUND
		boolean check = false;
		String objToString = null;
		
		for(int i =0; i<products.length && !check;i++) {
			if(products[i]!=null && (products[i].getName()).equals(name)) {
				objToString = products[i].toStringPro();
				check = true;
			}			
		}		
		return objToString;
	}
	
	public String searchProById(String id) {//RETURNS NULL STRING IF NO PRODUCT WAS FOUND
		boolean check = false;
		String objToString = null;
		
		for(int i =0; i<products.length && !check;i++) {
			if(products[i]!=null && (products[i].getId()).equals(id)) {
				objToString = products[i].toStringPro();
				check = true;
			}			
		}		
		return objToString;
	}
	
	public String toString(Residue residue) {
		String objToString = null;
		if (residue!=null) {
			if (residue instanceof Inert) {
				objToString = ((Inert)residue).toString();
			}
			else if (residue instanceof Recyclable) {
				objToString = ((Recyclable)residue).toString();
			}
			else if (residue instanceof Biodegradable) {
				objToString = ((Biodegradable)residue).toString();
			}	
		}
		return objToString;
	}	

	public String addResidue(String name, String productId, String id, String origin, String color, int decoTime, String tip) {//FOR INERT
		String msg = null;
		for(int i =0; i<globalResidues.length;i++) {
			if(globalResidues[i]==null) {
				globalResidues[i] = new Inert(name,products[searchProductPosById(productId)],id,origin,color,decoTime,tip);
				msg = "Residue created succesfully.";
			}			
		} 
		return msg;		
	}
	
	public String addResidue(String name, String productId, String id, String origin, String color, int decoTime, String type,String description) {//FOR RECYCLABLE
		String msg = null;	
		for(int i =0; i<globalResidues.length;i++) {
			if(globalResidues[i]==null) {
				globalResidues[i] = new Recyclable(name,products[searchProductPosById(productId)],id,origin,color,decoTime,type,description);
				msg = "Residue created succesfully.";
			}			
		} 
		return msg;
	}	
	
	public String addResidue(String name, String productId, String id, String origin, String color, int decoTime, boolean canCompost) {//FOR BIODEGRADABLE
		String msg = null;
		for(int i =0; i<globalResidues.length;i++) {
			if(globalResidues[i]==null) {
				globalResidues[i] = new Biodegradable(name,products[searchProductPosById(productId)],id,origin,color,decoTime,canCompost);
				msg = "Residue created succesfully.";
			}			
		} 
		return msg;		
	}
	
	public String addProduct(String name, String id, String description, int size) {
		String msg = null;
		for(int i =0; i<products.length;i++) {
			if(products[i]==null) {
				products[i] = new Product(name,id,description,size);
				msg = "Product created succesfully.";
			}			
		}
		return msg;
	}
	
	public int searchProductPosById(String productId) {
		boolean check = false;
		int pos = -1;
		for(int i =0; i<products.length && !check;i++) {
			if(products[i]!=null && (products[i].getId()).equals(productId)) {
				pos = i;
				check = true;
			}			
		}
		return pos;
	}
	
	public String toStringPro() {
		String str = null;
		for(int i = 0; i<products.length;i++) {
			if(products[i]!=null) {
				str += "\n" + products[i].toStringPro() + "\n";
			}			
		}
		return str;
	}
	
	public String toStringProOR(String productId) {
		String orderedResidues = "";
		int productPos = searchProductPosById(productId);
		
		if (productPos==-1) {
			orderedResidues = null;
		}
		else {
			orderedResidues = products[productPos].toStringProOR();
		}
		return orderedResidues;
	}

	public String generateReport() {
		String str = "Inert: \n ";
			
		for(int i = 0; i < globalResidues.length;i++) {
			if (globalResidues[i]!=null && globalResidues[i] instanceof Inert) {
				str += ((Inert)globalResidues[i]).toString();
			}
		}
		
		str += "\nRecyclable: \n";
		for(int i = 0; i < globalResidues.length;i++) {
			if (globalResidues[i]!=null && globalResidues[i] instanceof Recyclable) {
				str += ((Recyclable)globalResidues[i]).toString();
			}
		}
		
		str += "\nBiodegradable: \n";
		for(int i = 0; i < globalResidues.length;i++) {
			if (globalResidues[i]!=null && globalResidues[i] instanceof Biodegradable) {
				str += ((Biodegradable)globalResidues[i]).toString();
			}
		}		
		return str;
	}
}
