package application;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.petshop.ChowChawgas;
import entities.petshop.MeuCaninoFeliz;
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
        int option = scan.nextInt();

        switch (option) {
            case 1:
            	String[] resultValidation = entryAndValidation();
            	
            	DayOfWeek dayOfWeek = dateTreatment(resultValidation);
            	int smallDogsQuantity = Integer.parseInt(resultValidation[1]);
            	int bigDogsQuantity = Integer.parseInt(resultValidation[2]);
            	
            	
            	currentData(dayOfWeek, smallDogsQuantity, bigDogsQuantity);

            	MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
            	ChowChawgas chowChawgas = new ChowChawgas();
            	VaiRex vaiRex = new VaiRex();
            	
            	String[][] valuesPetshop = calculateTotalValuePetShops(meuCaninoFeliz, vaiRex, chowChawgas, dayOfWeek, smallDogsQuantity, bigDogsQuantity);
            	validadatesTie(valuesPetshop);
            	
            	
                break;
            case 2:
                System.out.println("Thank you for using Mr. Eduardo's kennel system!");
                break;
            default:
                System.out.println("Invalid option! Let`s return to Menu.");
            	System.out.println("---------------------------");
                menu();
                break;
        }
        scan.close();
    }

    public static String[] entryAndValidation() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter the entry in the format: <data> <number of small dogs> <amount of large dogs>");
		System.out.println("Example: 03/08/2018 3 5");
		
        String entry = scan.nextLine();
        
        String[] entryParts = entry.split(" ");

        if (entryParts.length != 3) {
        	entryParts = entryAndValidation();
        }
        scan.close();
        return entryParts;
    }
    
    public static DayOfWeek dateTreatment(String[] dateEntry) {
    	String dateEntryTreated = dateEntry[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateEntryTreated, formatter);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek;
    }
    
    public static void currentData(DayOfWeek dayOfWeek, double smallDogsQuantity, double bigDogsQuantity) {
    	System.out.println("---------------------------");
    	System.out.println("Current data.\n\nDay of Week: " + dayOfWeek + "\nSmall Dog(s) Quantity: " + smallDogsQuantity + "\nBig Dog(s) Quantity: " + bigDogsQuantity);
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
    
    public static void validadatesTie(String[][] totalValuesPetShops) {
    	
    	double totalValueMeuCaninoFeliz = Double.parseDouble(totalValuesPetShops[0][0]);
    	double totalValueVaiRex = Double.parseDouble(totalValuesPetShops[1][0]);
    	double totalValueChowChawgas = Double.parseDouble(totalValuesPetShops[2][0]);
    	double distanceMeuCaninoFeliz = Double.parseDouble(totalValuesPetShops[0][1]);
    	double distanceVaiRex = Double.parseDouble(totalValuesPetShops[1][1]);
    	double distanceChowChawgas = Double.parseDouble(totalValuesPetShops[2][1]);
    	
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
    	        System.out.println("The shipper place is Meu Canino Feliz: R$" + totalValueMeuCaninoFeliz);
    	    } else if (shortestDistance == distanceVaiRex) {
    	        System.out.println("---------------------------");
    	        System.out.println("The shipper place is Vai Rex: R$" + totalValueVaiRex);
    	    } else {
    	        System.out.println("---------------------------");
    	        System.out.println("The shipper place is ChowChawgas: R$" + totalValueChowChawgas);
    	    }
    	} else if (totalValueMeuCaninoFeliz == totalValueVaiRex) {
    	    if (distanceMeuCaninoFeliz < distanceVaiRex) {
    	        System.out.println("---------------------------");
    	        System.out.println("The nearest place is Meu Canino Feliz: R$" + totalValueMeuCaninoFeliz);
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
    	    } else {
    	        System.out.println("---------------------------");
    	        System.out.println("The nearest place is is ChowChawgas: R$" + totalValueChowChawgas);
    	    }
    	}
    }
}