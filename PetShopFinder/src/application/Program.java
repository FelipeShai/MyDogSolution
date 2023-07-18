package application;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import entities.petshop.ChowChawgas;
import entities.petshop.MeuCaninoFeliz;
import entities.petshop.PetShop;
import entities.petshop.VaiRex;

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
        
        MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();
        
        int option = typeInputValidation(scan);

        switch (option) {
            case 1:
            	String[] resultValidation = entryAndValidation();
            	
            	DayOfWeek dayOfWeek = FindDayOfWeekForDate(resultValidation);
            	int smallDogsQuantity = Integer.parseInt(resultValidation[1]);
            	int bigDogsQuantity = Integer.parseInt(resultValidation[2]);
            	
            	
            	currentDate(dayOfWeek);

            	List<PetShop> petShops = new ArrayList<>();
            	
            	petShops = calculateTotalValuePetShopsList(
            			meuCaninoFeliz, vaiRex, chowChawgas, dayOfWeek, smallDogsQuantity, bigDogsQuantity);
            	
            	PetShop petShopResult = findBestPetShop(petShops);
            	
            	System.out.println("The best PetShop is " + petShopResult.getName());
            	
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
    
    public static void currentDate(DayOfWeek dayOfWeek) {
    	System.out.println("---------------------------");
    	System.out.println("Date Processed.\nDay of Week: " + dayOfWeek);
    	System.out.println("---------------------------");
    }
        
    public static List<PetShop> calculateTotalValuePetShopsList(MeuCaninoFeliz meuCaninoFeliz, VaiRex vaiRex, ChowChawgas chowChawgas, DayOfWeek dayOfWeek, int smallDogsQuantity, int bigDogsQuantity) {
    	
    	double totalValueMeuCaninoFeliz = meuCaninoFeliz.calculateTotalPrice(dayOfWeek, smallDogsQuantity, bigDogsQuantity);
    	double totalValueVaiRex = vaiRex.calculateTotalPrice(dayOfWeek, smallDogsQuantity, bigDogsQuantity);
    	double totalValueChowChawgas = chowChawgas.calculateTotalPrice(dayOfWeek, smallDogsQuantity, bigDogsQuantity);
    	
    	meuCaninoFeliz.setTotalValue(totalValueMeuCaninoFeliz);
    	vaiRex.setTotalValue(totalValueVaiRex);
    	chowChawgas.setTotalValue(totalValueChowChawgas);
    	
    	List<PetShop> allPetShopInformations = new ArrayList<>();
    	allPetShopInformations.add(meuCaninoFeliz);
    	allPetShopInformations.add(vaiRex);
    	allPetShopInformations.add(chowChawgas);
    	
    	return allPetShopInformations;
    	
    }
                          
    public static PetShop findBestPetShop(List<PetShop> petShops) {
    	List<PetShop> petShopsOrdered = petShops;
    	
    	petShopsOrdered.sort(Comparator.comparing(PetShop::getTotalValue).thenComparing(PetShop::getDistance));

    	return petShopsOrdered.get(0);
    }
}