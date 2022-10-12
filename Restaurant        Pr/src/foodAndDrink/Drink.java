package foodAndDrink;

import java.util.ArrayList;
import java.util.Random;

public class Drink extends Request {

	public DrinkCategory category;

	public Drink(String name, int preTime, int consTime, DrinkCategory category) {
		super(name, preTime, consTime);
		this.category = category;
	}

	public static Drink randomDrink() {

		//İçecek Listesi tanımlandı.
		
		ArrayList<Drink> drinkList = new ArrayList<Drink>();
		drinkList.add(new Drink("DEMLEME CAY", 250, 350, DrinkCategory.Hot));
		drinkList.add(new Drink("AMERICANO", 500, 600, DrinkCategory.Hot));
		drinkList.add(new Drink("ICED LATTE", 500, 600, DrinkCategory.Cold));
		drinkList.add(new Drink("DETOX", 1000, 250, DrinkCategory.Cold));
		drinkList.add(new Drink("LIMONATA", 500, 600, DrinkCategory.Cold));
		drinkList.add(new Drink("COCTAILS", 1500, 2000, DrinkCategory.Cocktails));
		drinkList.add(new Drink("REDWINE", 1000, 2000, DrinkCategory.Wine));
		drinkList.add(new Drink("BEER", 500, 1000, DrinkCategory.Beer));
		drinkList.add(new Drink("MILKSHAKE", 1000, 1500, DrinkCategory.Cold));

		Random r = new Random();
		Drink drink = drinkList.get(r.nextInt(drinkList.size()));
		return drink;

	}

	@Override
	public void make() {
		// TODO Auto-generated method stub

	}
}
