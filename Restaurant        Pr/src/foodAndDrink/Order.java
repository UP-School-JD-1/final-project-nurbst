package foodAndDrink;

import java.util.ArrayList;
import java.util.List;

import users.Customer;
import users.IllegalOrderException;

public class Order {

	public List<Request> orders;

	public boolean isStarted;
	public Customer customer;

	public Order(List<Request> orders, Customer customer) throws IllegalOrderException {

		int foodCo = getFoodCount(orders);
		int drinkCo = getDrinkCount(orders);

		if (foodCo > 2 || drinkCo > 1) {
			throw new IllegalOrderException();
		}
		this.orders = orders;
		this.isStarted = false;
		this.customer = customer;
	}

	public List<Request> getOrders() {
		return orders;
	}

	public void setOrders(List<Request> orders) throws IllegalOrderException {
		int foodCo = getFoodCount(orders);
		int drinkCo = getDrinkCount(orders);

		if (foodCo > 2 || drinkCo > 1) {
			throw new IllegalOrderException();
		}
		this.orders = orders;
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	// Sipariş hazırlanma süresi

	public int getPreTotalTime() {
		int temp = 0;
		for (Request request : orders) {
			temp += request.getPreTime();
		}
		return temp;
	}

	// Tüketilme süresi

	public int getConsTotalTime() {
		int temp = 0;
		for (Request request : orders) {
			temp += request.getConsTime();
		}
		return temp;
	}

	public static int getFoodCount(List<Request> crudeList) {
		int total = 0;

		for (Request request : crudeList) {
			try {
				Food food = (Food) request;
				total++;
			} catch (Exception e) {
				continue;
			}
		}
		return total;
	}

	public static int getDrinkCount(List<Request> crudeList) {
		int total = 0;

		for (Request request : crudeList) {
			try {
				Drink drink = (Drink) request;
				total++;
			} catch (Exception e) {
				continue;
			}
		}
		return total;
	}

	public static Order generateOrder(Customer customer) throws IllegalOrderException {
		ArrayList<Request> orderList = new ArrayList<Request>();
		Food f1 = Food.randomFood();
		Food f2 = Food.randomFood();
		Drink d = Drink.randomDrink();

		if (f1 != null) {
			orderList.add(f1);
		}
		if (f2 != null) {
			orderList.add(f2);
		}
		if (d != null) {
			orderList.add(d);
		}
		if (orderList.isEmpty()) {
			while (true) {
				Food newFood = Food.randomFood();
				if (newFood != null) {
					orderList.add(newFood);
					return new Order(orderList, customer);
				}
			}
		}
		return new Order(orderList, customer);
	}

	@Override
	public String toString() {
		String t = " ";
		for (Request request : orders) {
			t += "\n\t" + request;
		}
		return t;

	}

}