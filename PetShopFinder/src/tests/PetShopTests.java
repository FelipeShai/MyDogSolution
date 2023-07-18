package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import application.Program;
import entities.petshop.ChowChawgas;
import entities.petshop.MeuCaninoFeliz;
import entities.petshop.PetShop;
import entities.petshop.VaiRex;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class PetShopTests {
	
	//This is the validation stage of the service price calculation results.
	@Test
    public void testCalculateTotalPriceMeuCaninoFelizWeekday() {
        MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        double totalPrice = meuCaninoFeliz.calculateTotalPrice(DayOfWeek.MONDAY, 2, 3);
        Assertions.assertEquals(160.0, totalPrice);
    }

    @Test
    public void testCalculateTotalPriceMeuCaninoFelizWeekend() {
        MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        double totalPrice = meuCaninoFeliz.calculateTotalPrice(DayOfWeek.SATURDAY, 1, 1);
        Assertions.assertEquals(72.0, totalPrice);
    }

    @Test
    public void testCalculateTotalPriceVaiRexWeekday() {
        VaiRex vaiRex = new VaiRex();
        double totalPrice = vaiRex.calculateTotalPrice(DayOfWeek.WEDNESDAY, 4, 2);
        Assertions.assertEquals(160.0, totalPrice);
    }

    @Test
    public void testCalculateTotalPriceVaiRexWeekend() {
        VaiRex vaiRex = new VaiRex();
        double totalPrice = vaiRex.calculateTotalPrice(DayOfWeek.SUNDAY, 2, 5);
        Assertions.assertEquals(315.0, totalPrice);
    }

    @Test
    public void testCalculateTotalPriceChowChawgasWeekday() {
        ChowChawgas chowChawgas = new ChowChawgas();
        double totalPrice = chowChawgas.calculateTotalPrice(DayOfWeek.FRIDAY, 3, 1);
        Assertions.assertEquals(135.0, totalPrice);
    }

    @Test
    public void testCalculateTotalPriceChowChawgas_Weekend() {
        ChowChawgas chowChawgas = new ChowChawgas();
        double totalPrice = chowChawgas.calculateTotalPrice(DayOfWeek.SATURDAY, 1, 2);
        Assertions.assertEquals(120.0, totalPrice);
    }
    
    //These tests are related to tie-breaking by distance when the total value of services provided by each PetShop is equal.
    @Test
    public void testTieBreakerByDistanceMeuCaninoFeliz() {

    	MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();
        
    	List<PetShop> petShops = new ArrayList<>();
    	
    	petShops = Program.calculateTotalValuePetShopsList(meuCaninoFeliz, vaiRex, chowChawgas, DayOfWeek.SATURDAY, 0, 0);            	
        meuCaninoFeliz.setDistance(1.0);
        vaiRex.setDistance(2.0);
        chowChawgas.setDistance(3.0);
        
    	PetShop petShopResult = Program.findBestPetShop(petShops);
    	Assertions.assertEquals("Meu Canino Feliz", petShopResult.getName());
    }
    
    @Test
    public void testTieBreakerByDistanceVaiRex() {

    	MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();
        
    	List<PetShop> petShops = new ArrayList<>();
    	
    	petShops = Program.calculateTotalValuePetShopsList(meuCaninoFeliz, vaiRex, chowChawgas, DayOfWeek.SATURDAY, 0, 0);            	
        meuCaninoFeliz.setDistance(2.0);
        vaiRex.setDistance(1.0);
        chowChawgas.setDistance(3.0);
        
    	PetShop petShopResult = Program.findBestPetShop(petShops);
    	Assertions.assertEquals("VaiRex", petShopResult.getName());
    }
    
    @Test
    public void testTieBreakerByDistanceChowChawgas() {

    	MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();
        
    	List<PetShop> petShops = new ArrayList<>();
    	
    	petShops = Program.calculateTotalValuePetShopsList(meuCaninoFeliz, vaiRex, chowChawgas, DayOfWeek.SATURDAY, 0, 0);            	
        meuCaninoFeliz.setDistance(3.0);
        vaiRex.setDistance(2.0);
        chowChawgas.setDistance(1.0);
        
    	PetShop petShopResult = Program.findBestPetShop(petShops);
    	Assertions.assertEquals("ChowChawgas", petShopResult.getName());
    }
    
    //These tests validate the result of tie-breaking between 2 out of the 3 pet shops.
    @Test
    public void testTiebreakerBetweenMeuCaninoFelizAndVaiRex() {

    	MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();
        
    	List<PetShop> petShops = new ArrayList<>();
    	
    	petShops = Program.calculateTotalValuePetShopsList(meuCaninoFeliz, vaiRex, chowChawgas, DayOfWeek.SATURDAY, 1, 1);
    	meuCaninoFeliz.setTotalValue(100);
    	vaiRex.setTotalValue(100);
    	chowChawgas.setTotalValue(150);
        meuCaninoFeliz.setDistance(1.0);
        vaiRex.setDistance(2.0);
        
    	PetShop petShopResult = Program.findBestPetShop(petShops);
    	Assertions.assertEquals("Meu Canino Feliz", petShopResult.getName());
    }
    
    @Test
    public void testTiebreakerBetweenMeuCaninoFelizAndChowChawgas() {

    	MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();
        
    	List<PetShop> petShops = new ArrayList<>();
    	
    	petShops = Program.calculateTotalValuePetShopsList(meuCaninoFeliz, vaiRex, chowChawgas, DayOfWeek.SATURDAY, 1, 1);
    	meuCaninoFeliz.setTotalValue(100);
    	vaiRex.setTotalValue(150);
    	chowChawgas.setTotalValue(100);
        meuCaninoFeliz.setDistance(1.0);
        chowChawgas.setDistance(3.0);
        
    	PetShop petShopResult = Program.findBestPetShop(petShops);
    	Assertions.assertEquals("Meu Canino Feliz", petShopResult.getName());
    }
    
    @Test
    public void testTiebreakerBetweenVaiRexFelizAndChowChawgas() {

    	MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();
        
    	List<PetShop> petShops = new ArrayList<>();
    	
    	petShops = Program.calculateTotalValuePetShopsList(meuCaninoFeliz, vaiRex, chowChawgas, DayOfWeek.SATURDAY, 1, 1);
    	meuCaninoFeliz.setTotalValue(150);
    	vaiRex.setTotalValue(100);
    	chowChawgas.setTotalValue(100);
        vaiRex.setDistance(1.0);
        chowChawgas.setDistance(2.0);
        
    	PetShop petShopResult = Program.findBestPetShop(petShops);
    	Assertions.assertEquals("VaiRex", petShopResult.getName());
    }
    
    @Test
    public void testTiebreakerBetweenVaiRexFelizAndMeuCaninoFeliz() {

    	MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();
        
    	List<PetShop> petShops = new ArrayList<>();
    	
    	petShops = Program.calculateTotalValuePetShopsList(meuCaninoFeliz, vaiRex, chowChawgas, DayOfWeek.SATURDAY, 1, 1);
    	meuCaninoFeliz.setTotalValue(100);
    	vaiRex.setTotalValue(100);
    	chowChawgas.setTotalValue(150);
        vaiRex.setDistance(1.0);
        meuCaninoFeliz.setDistance(2.0);
        
    	PetShop petShopResult = Program.findBestPetShop(petShops);
    	Assertions.assertEquals("VaiRex", petShopResult.getName());
    }
    
    @Test
    public void testTiebreakerBetweenChowChawgasAndMeuCaninoFeliz() {

    	MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();
        
    	List<PetShop> petShops = new ArrayList<>();
    	
    	petShops = Program.calculateTotalValuePetShopsList(meuCaninoFeliz, vaiRex, chowChawgas, DayOfWeek.SATURDAY, 1, 1);
    	meuCaninoFeliz.setTotalValue(100);
    	vaiRex.setTotalValue(150);
    	chowChawgas.setTotalValue(100);
        chowChawgas.setDistance(1.0);
        meuCaninoFeliz.setDistance(2.0);
        
    	PetShop petShopResult = Program.findBestPetShop(petShops);
    	Assertions.assertEquals("ChowChawgas", petShopResult.getName());
    }
    
    @Test
    public void testTiebreakerBetweenChowChawgasAndVaiRex() {

    	MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();
        
    	List<PetShop> petShops = new ArrayList<>();
    	
    	petShops = Program.calculateTotalValuePetShopsList(meuCaninoFeliz, vaiRex, chowChawgas, DayOfWeek.SATURDAY, 1, 1);
    	meuCaninoFeliz.setTotalValue(150);
    	vaiRex.setTotalValue(100);
    	chowChawgas.setTotalValue(100);
        vaiRex.setDistance(2.0);
        chowChawgas.setDistance(1.0);
        
    	PetShop petShopResult = Program.findBestPetShop(petShops);
    	Assertions.assertEquals("ChowChawgas", petShopResult.getName());
    }
}
