package entities.petshop;

public class VaiRex extends PetShop{

	static String _nome = "VaiRex";
	static double _distance = 1.7;
	static double _smallDogPriceWeekday = 15;
	static double _smallDogPriceWeekend = 20;
	static double _bigDogPriceWeekday = 50;
	static double _bigDogPriceWeekend = 55;
	
	public VaiRex() 
	{
		super(
				_nome,
				_distance,
				_smallDogPriceWeekday,
				_smallDogPriceWeekend,
				_bigDogPriceWeekday,
				_bigDogPriceWeekend
			);
	}
	
}
