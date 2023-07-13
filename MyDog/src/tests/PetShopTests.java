package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.petshop.MeuCaninoFeliz;

import java.time.DayOfWeek;

public class PetShopTests {

    @Test
    public void testCalculateTotalPrice_Weekday() {
        MeuCaninoFeliz petShop = new MeuCaninoFeliz();
        double totalPrice = petShop.calculateTotalPrice(DayOfWeek.MONDAY, 3, 2);
        Assertions.assertEquals(140.0, totalPrice);
    }

    @Test
    public void testCalculateTotalPrice_Weekend() {
        MeuCaninoFeliz petShop = new MeuCaninoFeliz();
        double totalPrice = petShop.calculateTotalPrice(DayOfWeek.SATURDAY, 0, 0);
        Assertions.assertEquals(0, totalPrice);
    }


}
