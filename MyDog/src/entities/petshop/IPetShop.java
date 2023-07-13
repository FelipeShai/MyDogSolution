package entities.petshop;

import java.time.DayOfWeek;

public interface IPetShop {

	public double calculateTotalPrice(DayOfWeek dayOfWeek, int smallDogsQuantity, int bigDogsQuantity);
}
