package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import application.Program;
import entities.petshop.ChowChawgas;
import entities.petshop.MeuCaninoFeliz;
import entities.petshop.PetShopPresenter;
import entities.petshop.VaiRex;

import java.time.DayOfWeek;

public class PetShopTests {

	PetShopPresenter presenter = new PetShopPresenter();

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

    @Test
    public void testTieBreakerByDistanceChowChawgas() {
        MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();

        double totalValueMeuCaninoFeliz = 110.0;
        double totalValueVaiRex = 100.0;
        double totalValueChowChawgas = 100.0;

        meuCaninoFeliz.setDistance(3.0);
        vaiRex.setDistance(2.0);
        chowChawgas.setDistance(1.0);

        String[][] totalValuesPetShops = new String[][]{
                {String.valueOf(totalValueMeuCaninoFeliz), String.valueOf(meuCaninoFeliz.getDistance())},
                {String.valueOf(totalValueVaiRex), String.valueOf(vaiRex.getDistance())},
                {String.valueOf(totalValueChowChawgas), String.valueOf(chowChawgas.getDistance())}
        };

        presenter = Program.validadatesTie(totalValuesPetShops);
        Assertions.assertEquals(presenter.isChowChawgasTieWin(), true);
    }
    
    @Test
    public void testTieBreakerByDistanceMeuCaninoFeliz() {
        MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();

        double totalValueMeuCaninoFeliz = 100.0;
        double totalValueVaiRex = 100.0;
        double totalValueChowChawgas = 110.0;

        meuCaninoFeliz.setDistance(1.0);
        vaiRex.setDistance(2.0);
        chowChawgas.setDistance(3.0);

        String[][] totalValuesPetShops = new String[][]{
                {String.valueOf(totalValueMeuCaninoFeliz), String.valueOf(meuCaninoFeliz.getDistance())},
                {String.valueOf(totalValueVaiRex), String.valueOf(vaiRex.getDistance())},
                {String.valueOf(totalValueChowChawgas), String.valueOf(chowChawgas.getDistance())}
        };

        presenter = Program.validadatesTie(totalValuesPetShops);
        Assertions.assertEquals(presenter.isMeuCaninoFeizTieWin(), true);
    }
    
    @Test
    public void testTieBreakerByDistanceVaiRex() {
        MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();

        double totalValueMeuCaninoFeliz = 110.0;
        double totalValueVaiRex = 100.0;
        double totalValueChowChawgas = 100.0;

        meuCaninoFeliz.setDistance(3.0);
        vaiRex.setDistance(1.0);
        chowChawgas.setDistance(2.0);

        String[][] totalValuesPetShops = new String[][]{
                {String.valueOf(totalValueMeuCaninoFeliz), String.valueOf(meuCaninoFeliz.getDistance())},
                {String.valueOf(totalValueVaiRex), String.valueOf(vaiRex.getDistance())},
                {String.valueOf(totalValueChowChawgas), String.valueOf(chowChawgas.getDistance())}
        };

        presenter = Program.validadatesTie(totalValuesPetShops);
        Assertions.assertEquals(presenter.isVaiRexTieWin(), true);
    }

    @Test
    public void testTieBreakerByDistancePricesEqualValuesVaiRex() {
        MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();

        double totalValueMeuCaninoFeliz = 100.0;
        double totalValueVaiRex = 100.0;
        double totalValueChowChawgas = 100.0;

        meuCaninoFeliz.setDistance(3.0);
        vaiRex.setDistance(1.0);
        chowChawgas.setDistance(2.0);

        String[][] totalValuesPetShops = new String[][]{
                {String.valueOf(totalValueMeuCaninoFeliz), String.valueOf(meuCaninoFeliz.getDistance())},
                {String.valueOf(totalValueVaiRex), String.valueOf(vaiRex.getDistance())},
                {String.valueOf(totalValueChowChawgas), String.valueOf(chowChawgas.getDistance())}
        };

        presenter = Program.validadatesTie(totalValuesPetShops);
        Assertions.assertEquals(presenter.isVaiRexTieWin(), true);
    }

    @Test
    public void testTieBreakerByDistancePricesEqualValuesMeuCaninoFeliz() {
        MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();

        double totalValueMeuCaninoFeliz = 100.0;
        double totalValueVaiRex = 100.0;
        double totalValueChowChawgas = 100.0;

        meuCaninoFeliz.setDistance(1.0);
        vaiRex.setDistance(3.0);
        chowChawgas.setDistance(2.0);

        String[][] totalValuesPetShops = new String[][]{
                {String.valueOf(totalValueMeuCaninoFeliz), String.valueOf(meuCaninoFeliz.getDistance())},
                {String.valueOf(totalValueVaiRex), String.valueOf(vaiRex.getDistance())},
                {String.valueOf(totalValueChowChawgas), String.valueOf(chowChawgas.getDistance())}
        };

        presenter = Program.validadatesTie(totalValuesPetShops);
        Assertions.assertEquals(presenter.isMeuCaninoFeizTieWin(), true);
    }
    
    @Test
    public void testTieBreakerByDistancePricesEqualValuesChowChawgas() {
        MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz();
        VaiRex vaiRex = new VaiRex();
        ChowChawgas chowChawgas = new ChowChawgas();

        double totalValueMeuCaninoFeliz = 100.0;
        double totalValueVaiRex = 100.0;
        double totalValueChowChawgas = 100.0;

        meuCaninoFeliz.setDistance(3.0);
        vaiRex.setDistance(2.0);
        chowChawgas.setDistance(1.0);

        String[][] totalValuesPetShops = new String[][]{
                {String.valueOf(totalValueMeuCaninoFeliz), String.valueOf(meuCaninoFeliz.getDistance())},
                {String.valueOf(totalValueVaiRex), String.valueOf(vaiRex.getDistance())},
                {String.valueOf(totalValueChowChawgas), String.valueOf(chowChawgas.getDistance())}
        };

        presenter = Program.validadatesTie(totalValuesPetShops);
        Assertions.assertEquals(presenter.isChowChawgasTieWin(), true);
    }
    
    
    
}
