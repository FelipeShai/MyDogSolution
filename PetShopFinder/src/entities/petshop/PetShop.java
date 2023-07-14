package entities.petshop;

import java.time.DayOfWeek;

public class PetShop implements IPetShop {
	
	private String nome;
	private double distance;
	private double smallDogPriceWeekday;
	private double smallDogPriceWeekend;
	private double bigDogPriceWeekday;
	private double bigDogPriceWeekend;
	
	public PetShop(String nome, double distance, double smallDogPriceWeekday, double smallDogPriceWeekend, double bigDogPriceWeekday,
			double bigDogPriceWeekend) {
		this.nome = nome;
		this.distance = distance;
		this.smallDogPriceWeekday = smallDogPriceWeekday;
		this.smallDogPriceWeekend = smallDogPriceWeekend;
		this.bigDogPriceWeekday = bigDogPriceWeekday;
		this.bigDogPriceWeekend = bigDogPriceWeekend;
	}
	
	public double calculateTotalPrice(DayOfWeek dayOfWeek, int smallDogsQuantity, int bigDogsQuantity) {
		if(dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7 ) {
			double totalPrice = (smallDogPriceWeekend * smallDogsQuantity) + (bigDogPriceWeekend * bigDogsQuantity);
			return totalPrice;
		} else {
			double totalPrice = smallDogPriceWeekday * smallDogsQuantity + bigDogPriceWeekday * bigDogsQuantity;
			return totalPrice;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getSmallDogPriceWeekday() {
		return smallDogPriceWeekday;
	}

	public void setSmallDogPriceWeekday(double smallDogPriceWeekday) {
		this.smallDogPriceWeekday = smallDogPriceWeekday;
	}

	public double getSmallDogPriceWeekend() {
		return smallDogPriceWeekend;
	}

	public void setSmallDogPriceWeekend(double smallDogPriceWeekend) {
		this.smallDogPriceWeekend = smallDogPriceWeekend;
	}

	public double getBigDogPriceWeekday() {
		return bigDogPriceWeekday;
	}

	public void setBigDogPriceWeekday(double bigDogPriceWeekday) {
		this.bigDogPriceWeekday = bigDogPriceWeekday;
	}

	public double getBigDogPriceWeekend() {
		return bigDogPriceWeekend;
	}

	public void setBigDogPriceWeekend(double bigDogPriceWeekend) {
		this.bigDogPriceWeekend = bigDogPriceWeekend;
	}
	
	
}
