package foodAndDrink;

import java.util.ArrayList;
import java.util.Random;

public class Food extends Request {

	public FoodCategory category;

	public Food(String name, int preTime, int consTime, FoodCategory category) {
		super(name, preTime, consTime);
		this.category = category;
	}

	public FoodCategory getCategory() {
		return category;
	}

	public void setCategory(FoodCategory category) {
		this.category = category;
	}

	// Yemek listesi , müşterilerin random seçebileceği kısım

	public static Food randomFood() {


		//Yiyecek Listesi tanımlandı.
		
		ArrayList<Food> foodList = new ArrayList<Food>();
		foodList.add(new Food("ROKFOR KREMALI BURGER", 5000, 6000, FoodCategory.MainCourse));
		foodList.add(new Food("4 PEYNIRLI PIZZA", 4800, 5500, FoodCategory.Pizza));
		foodList.add(new Food("SEZAR SALATA", 3000, 4000, FoodCategory.Salad));
		foodList.add(new Food("VEGAN KOFTE", 5000, 6000, FoodCategory.Vegan));
		foodList.add(new Food("ET TACO", 4000, 5000, FoodCategory.MainCourse));
		foodList.add(new Food("AVOKADOLU POSE YUMURTA", 2500, 3500, FoodCategory.Breakfast));
		foodList.add(new Food("SAN SEBASTIAN CHEESECAKE", 1500, 2500, FoodCategory.Dessert));
		foodList.add(new Food("VEGAN CHEESEBURGER", 5000, 6000, FoodCategory.Vegan));
		foodList.add(new Food("MENEMEN", 3000, 4000, FoodCategory.Breakfast));

		Random r = new Random();
		Food food = foodList.get(r.nextInt(foodList.size()));
		return food;

	}

	@Override
	public void make() {

	}

}