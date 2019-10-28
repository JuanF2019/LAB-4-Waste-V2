package ui;
import model.*;
import java.util.Scanner;

public class Main {
	private static Scanner inputNum;
	private static Scanner inputStr;
	private WasteInc wasteInc;
	
	public Main(String name){
		wasteInc = new WasteInc(name);
	}
	
	public static void main(String[] args) {
		Main obj = new Main("3R's-Inc");
		inputNum = new Scanner(System.in);
		inputStr = new Scanner(System.in);
		boolean menu = true;
		int menuOpt = 0;
		System.out.println("Welcome to 3R's-Inc integrated software.");
		while(menu) {
			System.out.println("----------\nMenu: ");
			System.out.println("1. Add product.");
			System.out.println("2. Add residue.");
			System.out.println("3. Find residue by name.");
			System.out.println("4. Find residue by id.");
			System.out.println("5. Print residues ordered by harmfulness");
			System.out.println("6. Print product list. ");
			System.out.println("7. Generate report.");
			System.out.println("8. Exit");
			System.out.println("Type the number corresponding to the option you want to execute: ");
			menuOpt = inputNum.nextInt();
			switch(menuOpt) {
			case 1:
				obj.addProduct();
			break;
			case 2:
				obj.addResidueOnly();
			break;
			case 3:
				obj.findResidueByName();
			break;
			case 4:
				obj.findResidueById();
			break;
			case 5:
				obj.printProResOR();
			break;
			case 6:
				obj.printProducts();
			break;
			case 7:
				obj.generateReport();
			break;
			case 8:
				System.out.println("Closing program...");
				menu = false;
			break;
			default:
				System.out.println("Invalid option, type a valid one.");
			}
		}
	}
	
	public void addProduct() {
		String name = "";
		String id = "";
		String description = "";
		int size = 0;	
		boolean check = false;
		inputNum = new Scanner(System.in);
		inputStr = new Scanner(System.in);		
		
		System.out.println("Type the product name:");
		name = inputStr.nextLine();
		
		do {
			System.out.println("Type the product id: ");
			id = inputStr.nextLine();
			if (wasteInc.searchProById(id)!=null) {
				System.out.println("Id already taken, type a valid id");
			}
			else {
				check = true;
			}
		} while(!check);
		
		System.out.println("Type the product description: ");
		description  = inputStr.nextLine();
		System.out.println("Type the number of residues that the product produce. ");
		size = inputNum.nextInt();		
		
		String str = wasteInc.addProduct(name, id, description, size);
		if (str!=null) {
			System.out.println(str);
			System.out.println("Now, you will have to create one residue, you can later on create more for this product");
			addResidue(id);
		}
		else {
			System.out.println("Could not create product.");
		}
		
		
	}
	
	public void addResidue(String productId) {
		int resTypeOption = 0;
		int resOriginOpt = 0;
		boolean menu = true;
		boolean menu2 = true;
		boolean menu3 = true;
		boolean check = false;
		boolean canCompost = false;
		String name = "";
		String id = "";
		String origin = "";
		String color = "";
		int decoTime = 0;
		String tip = "";
		String type = "";
		String description = "";
		String str = "";
		inputStr = new Scanner(System.in);
		inputNum = new Scanner(System.in);		
		System.out.println("Type the residue name:");
		name = inputStr.nextLine();
		
		do {
			System.out.println("Type the residue id: ");
			id = inputStr.nextLine();
			if (wasteInc.searchResById(id)!=null) {
				System.out.println("Id already taken, type a valid id");
			}
			else {
				check = true;
			}
		} while(!check);
		
		while(menu) {
			System.out.println("1. Industrial");
			System.out.println("2. Household");
			System.out.println("3. Construction");
			System.out.println("4. Local");
			System.out.println("5. Hospital");			
			System.out.println("Select the residue origin: ");
			resOriginOpt = inputNum.nextInt();
			switch(resOriginOpt) {			
			case 1:
				origin = "Industrial";
				menu = false;
			break;
			case 2:
				origin = "Household";
				menu = false;
			break;
			case 3:
				origin = "Construction";
				menu = false;
			break;
			case 4:
				origin = "Local";
				menu = false;
			break;
			case 5:
				origin = "Hospital";
				menu = false;
			break;
			default:
				System.out.println("Invalid option type a valid option.");			
			}			
		}
		
		System.out.println("Type the residue color:");
		color = inputStr.nextLine();
		
		check = false;
		while(!check) {
			System.out.println("Type the residue decomposition time in days: ");
			decoTime = inputStr.nextInt();
			if (decoTime <= 0) {
				System.out.println("Invalid time, type a valid one: ");
			}
			else {
				check = true;
			}
		}
		
		int recTypeOpt = 0;
		
		menu = true;
		while(menu) {
			System.out.println("1. Inert");
			System.out.println("2. Recyclable");
			System.out.println("3. Biodegradable");
			System.out.println("Select the residue type: ");
			resTypeOption = inputNum.nextInt();
			switch(resTypeOption) {
			
			case 1:
				System.out.println("Write a recomendation to dispose of this residue: ");
				tip = inputStr.nextLine();
				System.out.println(wasteInc.addResidue(name, productId, id, origin, color, decoTime, tip));
				menu = false;
			break;
			case 2:
				while(menu2) {
					System.out.println("1. Paper");
					System.out.println("2. Cardboard");
					System.out.println("3. Glass");
					System.out.println("4. Plastic");
					System.out.println("5. Metal");
					System.out.println("Select the recyclable residue type: ");
					recTypeOpt = inputNum.nextInt();
					switch (recTypeOpt) {
						case 1:
							type = "Paper";
							menu2 = false;
						break;
						case 2:
							type = "Cardboard";
							menu2 = false;
						break;
						case 3:
							type = "Glass";
							menu2 = false;
						break;
						case 4:
							type = "Plastic";
							menu2 = false;
						break;
						case 5:
							type = "Metal";
							menu2 = false;
						break;
						default:
							System.out.println("Invalid option, type a valid one");
							
					}
					System.out.println("Type a description");
					description = inputStr.nextLine();
					
				}
				str = wasteInc.addResidue(name, productId, id, origin, color, decoTime, type, description);
				menu = false;
			break;
			case 3:
				while(menu3) {
					System.out.println("1. Yes");
					System.out.println("2. No");
					System.out.println("The residue can be composted?: ");
					recTypeOpt = inputNum.nextInt();
					switch (recTypeOpt) {
						case 1:
							canCompost = true;
							menu3 = false;
						break;
						case 2:
							canCompost = false;
							menu3 = false;
						break;						
						default:
							System.out.println("Invalid option, type a valid one");
							
					}
				str = wasteInc.addResidue(name, productId, id, origin, color, decoTime, canCompost);
				menu = false;
				}
			break;
			default:
				System.out.println("Invalid option type a valid option.");			
			}
			if (str == null) {
				System.out.println("Could not create residue");
			}
			else {
				System.out.println(str);
			}
		}
	}
	
	public void addResidueOnly() {
		String str = wasteInc.toStringPro();
		boolean check = false;
		String id = "";
		inputStr = new Scanner(System.in);
		
		if(str == null) {
			System.out.println("Create product: ");
			addProduct();
			check = true;
		}
		else {
			System.out.println(str);
		}
		
		while(!check) {
			
			System.out.println("Write the id of the product you want to create the residue for, or type -none- to create a new one.");
			id = inputStr.nextLine();
			
			if (id.equals("none")) {
				addProduct();
				check = true;
			}
			else if(wasteInc.searchProById(id)!=null) {
				addResidue(id);
				check = true;
			}
			else {
				System.out.println("Product not found, type a valid id or none.");
			}			
		}		
	}

	public void findResidueByName() {
		inputStr = new Scanner(System.in);
		String name = "";
		String str = "";
		System.out.println("Type residue name: ");
		name = inputStr.nextLine();
		
		str = wasteInc.searchResByName(name);
		
		if(str == null) {
			System.out.println("No residue found.");
		}
		else {
			System.out.println(str);
		}
		
	}
	
	public void findResidueById() {
		inputStr = new Scanner(System.in);
		String id = "";
		String str = "";
		System.out.println("Type residue id: ");
		id = inputStr.nextLine();
		
		str = wasteInc.searchResById(id);
		
		if(str == null) {
			System.out.println("No residue found.");
		}
		else {
			System.out.println(str);
		}
		
	}
	
	public void printProResOR() {
		inputStr = new Scanner(System.in);
		String id = "";
		String str = "";
		System.out.println("Type product id: ");
		id = inputStr.nextLine();
		
		str = wasteInc.toStringProOR(id);
		
		if (str == null) {
			System.out.println("No product found.");
		}
		else {
			System.out.println(str);
		}	
	}

	public void printProducts() {
		String str = "";
		str = wasteInc.toStringPro();		
		
		if (str == null) {
			System.out.println("No products found.");
		}
		else {
			System.out.println(str);
		}
	}
	
	public void generateReport() {
		System.out.println(wasteInc.generateReport());
	}
}
