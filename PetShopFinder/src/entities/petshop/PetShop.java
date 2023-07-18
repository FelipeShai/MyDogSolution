package entities.petshop;

import java.time.DayOfWeek;

public class PetShop implements IPetShop {
	
	private String name;
	private double distance;
	private double smallDogPriceWeekday;
	private double smallDogPriceWeekend;
	private double bigDogPriceWeekday;
	private double bigDogPriceWeekend;
	private double totalValue;

	
	public PetShop(String name, double distance, double smallDogPriceWeekday, double smallDogPriceWeekend, double bigDogPriceWeekday,
			double bigDogPriceWeekend) {
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	
}
