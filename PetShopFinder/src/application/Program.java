package application;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.petshop.ChowChawgas;
import entities.petshop.MeuCaninoFeliz;
import entities.petshop.VaiRex;
import entities.petshop.PetShopPresenter;

public class Program {

	public static void main(String[] args) {
				
		System.out.println("Welcome to the MyDog system, which will save you money!");

		menu();
				
	}
	
	public static void menu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Find the best petshop");
        System.out.println("2. Leave");

        Scanner scan = new Scanner(System.in);
        
        int option = typeInputValidation(scan);

        switch (option) {
            case 1:
            	String[] resultValidation = entryAndValidation();
            	
            	DayOfWeek dayOfWeek = FindDayOfWeekForDate(resultValidation);
            	int smallDogsQuantity = Integer.parseInt(resultValidation[1]);
            	int bigDogsQuantity = Integer.parseInt(resultValidation[2]);
            	
            	
            	currentData(dayOfWeek, smallDogsQuantity, bigDogsQuantity);

            	MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
            	ChowChawgas chowChawgas = new ChowChawgas();
            	VaiRex vaiRex = new VaiRex();
            	PetShopPresenter presenter = new PetShopPresenter();
            	String[][] valuesPetshop = calculateTotalValuePetShops(meuCaninoFeliz, vaiRex, chowChawgas, dayOfWeek, smallDogsQuantity, bigDogsQuantity);
            	
            	validadatesTie(valuesPetshop);
            	presenter.setSuccess(true);
            	
                break;
            case 2:
            	System.out.println("---------------------------");
                System.out.println("Thank you for using Mr. Eduardo's kennel system!");
            	System.out.println("---------------------------");
                break;
            case 0:
            	System.out.println("---------------------------");
    			System.out.println("Enter a correct option!");
            	System.out.println("---------------------------");
            	menu();
                break;
            default:
            	System.out.println("---------------------------");
                System.out.println("Invalid option! Let`s return to Menu.");
            	System.out.println("---------------------------");
                menu();
                break;
        }
        scan.close();
    }
	
	public static int typeInputValidation(Scanner scan) {
		try {
        	int option = scan.nextInt();
        	return option;
        }catch (Exception e) {
			return 0;
		}
	}

	public static String[] entryAndValidation() {
	    Scanner scan = new Scanner(System.in);
	    String[] entryParts = null;
	    
	    boolean resultDateValidation = false;
	    boolean resultNumberOfDogs = false;
	    boolean resultDataValidation = false;
	    
	    while (resultDateValidation == false) {
	    	System.out.println("---------------------------");
	    	System.out.println("Please enter the entry in the format: <date> <number of small dogs> <number of big dogs>");
	    	System.out.println("Example: 03/08/2018 3 5");
	    	
	    	String entry = scan.nextLine();
	    	
	    	entryParts = entry.split(" ");
	    	
		    resultDateValidation = IsThreeTypesOfData(entryParts);
	    }
	    
	    	resultNumberOfDogs = IsNumberOfDogsAInteger(entryParts);
	    	
	    	resultDataValidation = dateValidation(entryParts);

	    	if(resultNumberOfDogs == false || resultDataValidation == false) {
	    		entryParts = entryAndValidation();
	    	}
	    scan.close();
	    return entryParts;
	}
    
    public static Boolean IsThreeTypesOfData(String[] entryParts){
        if (entryParts.length != 3) {
        	System.out.println("---------------------------");
        	System.out.println("Inappropriate Data Entry Format");
        	return false;
        }
        return true;
    }
    
    public static boolean IsNumberOfDogsAInteger(String[] entryParts) {
        try {
        	int smallDogsValidation = Integer.parseInt(entryParts[1]);
        	int bigDogsValidation = Integer.parseInt(entryParts[2]);
        	System.out.println("---------------------------");
        	System.out.println("Data Entry\n");
        	System.out.println("Number of Small Dogs: " + smallDogsValidation + "---OK" +";\n"  +
        			"Number of Big Dogs: " + bigDogsValidation + "---OK" +";");
        	return true;
        } catch (NumberFormatException e) {
        	System.out.println("---------------------------");
        	System.out.println("Data Entry\n");
            System.out.println("The values for the number of dogs should be Integer numbers.");
            return false;
        }
    }

    public static LocalDate dateFormatter(String[] dateEntry) {
    	String dateEntryTreated = dateEntry[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateEntryTreated, formatter);
        return date;
    }
    
    public static boolean dateValidation(String[] dateEntry) {
        try {
        	LocalDate date = dateFormatter(dateEntry);
        	System.out.println("Date formatted: " + date + "---OK");
        	return true;
        }catch (Exception e) {
        	System.out.println("Wrong date format.");
        	return false;
		}
    }
   
    public static DayOfWeek FindDayOfWeekForDate(String[] dateEntry) {
    	DayOfWeek dayOfWeek = dateFormatter(dateEntry).getDayOfWeek();
        return dayOfWeek;
    }  
    
    public static void currentData(DayOfWeek dayOfWeek, int smallDogsQuantity, int bigDogsQuantity) {
    	System.out.println("---------------------------");
    	System.out.println("Data Processed.\n\nDay of Week: " + dayOfWeek + "\nSmall Dog(s) Quantity: " + smallDogsQuantity + "\nBig Dog(s) Quantity: " + bigDogsQuantity);
    	System.out.println("---------------------------");
    }
    
    public static String[][] calculateTotalValuePetShops(MeuCaninoFeliz meuCaninoFeliz, VaiRex vaiRex, ChowChawgas chowChawgas, DayOfWeek dayOfWeek, int smallDogsQuantity, int bigDogsQuantity) {
    	
    	double totalValueMeuCaninoFeliz = meuCaninoFeliz.calculateTotalPrice(dayOfWeek, smallDogsQuantity, bigDogsQuantity);
    	double totalValueVaiRex = vaiRex.calculateTotalPrice(dayOfWeek, smallDogsQuantity, bigDogsQuantity);
    	double totalValueChowChawgas = chowChawgas.calculateTotalPrice(dayOfWeek, smallDogsQuantity, bigDogsQuantity);
    	
    	System.out.println("Total Value: \n");
    	System.out.println("Meu Canino Feliz: R$" + totalValueMeuCaninoFeliz + ";");
    	System.out.println("Vai Rex: R$" + totalValueVaiRex + ";");
    	System.out.println("ChowChawgas: R$" + totalValueChowChawgas + ";");
    	
    	String[][] totalValuesPetShops = new String[3][2];
    	totalValuesPetShops[0][0] = Double.toString(totalValueMeuCaninoFeliz);
    	totalValuesPetShops[1][0] = Double.toString(totalValueVaiRex);
    	totalValuesPetShops[2][0] = Double.toString(totalValueChowChawgas);
    	totalValuesPetShops[0][1] = Double.toString(meuCaninoFeliz.getDistance());
    	totalValuesPetShops[1][1] = Double.toString(vaiRex.getDistance());
    	totalValuesPetShops[2][1] = Double.toString(chowChawgas.getDistance());
    	return totalValuesPetShops;
    	
    }
    
    public static PetShopPresenter validadatesTie(String[][] totalValuesPetShops) {
    	
    	double totalValueMeuCaninoFeliz = Double.parseDouble(totalValuesPetShops[0][0]);
    	double totalValueVaiRex = Double.parseDouble(totalValuesPetShops[1][0]);
    	double totalValueChowChawgas = Double.parseDouble(totalValuesPetShops[2][0]);
    	double distanceMeuCaninoFeliz = Double.parseDouble(totalValuesPetShops[0][1]);
    	double distanceVaiRex = Double.parseDouble(totalValuesPetShops[1][1]);
    	double distanceChowChawgas = Double.parseDouble(totalValuesPetShops[2][1]);
    	PetShopPresenter presenter = new PetShopPresenter();

    	if (totalValueMeuCaninoFeliz < totalValueVaiRex && totalValueMeuCaninoFeliz < totalValueChowChawgas) {
    	    System.out.println("---------------------------");
    	    System.out.println("The shipper place is Meu Canino Feliz: R$" + totalValueMeuCaninoFeliz);
    	} else if (totalValueVaiRex < totalValueMeuCaninoFeliz && totalValueVaiRex < totalValueChowChawgas) {
    	    System.out.println("---------------------------");
    	    System.out.println("The shipper place is Vai Rex: R$" + totalValueVaiRex);
    	} else if (totalValueChowChawgas < totalValueMeuCaninoFeliz && totalValueChowChawgas < totalValueVaiRex) {
    	    System.out.println("---------------------------");
    	    System.out.println("The shipper place is ChowChawgas: R$" + totalValueChowChawgas);
    	} else if (totalValueMeuCaninoFeliz == totalValueVaiRex && totalValueMeuCaninoFeliz == totalValueChowChawgas) {
    	    double shortestDistance = Math.min(distanceMeuCaninoFeliz, Math.min(distanceVaiRex, distanceChowChawgas));
    	    
    	    if (shortestDistance == distanceMeuCaninoFeliz) {
    	        System.out.println("---------------------------");
    	        System.out.println("The nearest place is Meu Canino Feliz: R$" + totalValueMeuCaninoFeliz);
    	        presenter.setMeuCaninoFeizTieWin(true);
    	    } else if (shortestDistance == distanceVaiRex) {
    	        System.out.println("---------------------------");
    	        System.out.println("The nearest place is Vai Rex: R$" + totalValueVaiRex);
    	        presenter.setVaiRexTieWin(true);
    	    } else {
    	        System.out.println("---------------------------");
    	        System.out.println("The nearest place is ChowChawgas: R$" + totalValueChowChawgas);
    	        presenter.setChowChawgasTieWin(true);
    	    }
    	} else if (totalValueMeuCaninoFeliz == totalValueVaiRex) {
    	    if (distanceMeuCaninoFeliz < distanceVaiRex) {
    	        System.out.println("---------------------------");
    	        System.out.println("The nearest place is Meu Canino Feliz: R$" + totalValueMeuCaninoFeliz);
    	        presenter.setMeuCaninoFeizTieWin(true);
    	        return presenter;

    	    } else {
    	        System.out.println("---------------------------");
    	        System.out.println("The nearest place is Vai Rex: R$" + totalValueVaiRex);
    	    }
    	} else if (totalValueMeuCaninoFeliz == totalValueChowChawgas) {
    	    if (distanceMeuCaninoFeliz < distanceChowChawgas) {
    	        System.out.println("---------------------------");
    	        System.out.println("The nearest place is Meu Canino Feliz: R$" + totalValueMeuCaninoFeliz);
    	    } else {
    	        System.out.println("---------------------------");
    	        System.out.println("The nearest place is ChowChawgas: R$" + totalValueChowChawgas);
    	    }
    	} else {
    	    if (distanceVaiRex < distanceChowChawgas) {
    	        System.out.println("---------------------------");
    	        System.out.println("The nearest place is Vai Rex: R$" + totalValueVaiRex);
    	        presenter.setVaiRexTieWin(true);
    	        return presenter;
    	    } else {
    	        System.out.println("---------------------------");
    	        System.out.println("The nearest place is ChowChawgas: R$" + totalValueChowChawgas);
    	        presenter.setChowChawgasTieWin(true);
    	        return presenter;
    	    }
    	}
		return presenter;
    }
}