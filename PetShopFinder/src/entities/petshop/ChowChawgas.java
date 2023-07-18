package entities.petshop;

public class ChowChawgas extends PetShop{
	
	static String _name = "ChowChawgas";
	static double _distance = 0.8;
	static double _smallDogPriceWeekday = 30;
	static double _smallDogPriceWeekend = _smallDogPriceWeekday;
	static double _bigDogPriceWeekday = 45;
	static double _bigDogPriceWeekend = _bigDogPriceWeekday;
	
	public ChowChawgas() 
	{
		super(
				_name,
				_distance,
				_smallDogPriceWeekday,
				_smallDogPriceWeekend,
				_bigDogPriceWeekday,
				_bigDogPriceWeekend
			);
	}
}
