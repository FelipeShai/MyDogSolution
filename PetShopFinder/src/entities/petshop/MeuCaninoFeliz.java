package entities.petshop;

public class MeuCaninoFeliz extends PetShop {	
	
	static String _name = "Meu Canino Feliz";
	static double _distance = 2;
	static double _smallDogPriceWeekday = 20;
	static double _smallDogPriceWeekend = _smallDogPriceWeekday + _smallDogPriceWeekday * 0.2;
	static double _bigDogPriceWeekday = 40;
	static double _bigDogPriceWeekend = _bigDogPriceWeekday + _bigDogPriceWeekday * 0.2;
	
	public MeuCaninoFeliz() 
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
