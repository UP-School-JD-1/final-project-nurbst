package users;

import java.util.ArrayList;

import foodAndDrink.Order;
import foodAndDrink.Request;

public class Customer extends Person {

	public boolean isOrdered;
	public Order order;
	public int tableNo;
	public boolean isFinished;

	public Customer(String name, String tckn, Gender gender) throws IllegalOrderException {
		super(name, tckn, gender);
		isOrdered = false;
		this.order = Order.generateOrder(this);
		this.tableNo = -1;
		this.isFinished = false;
	}

	@Override
	public void run() {
		Main main = Main.main;
		if (isFinished == false) {
			if (isOrdered == false) {
				main.orderList.add(order);
				isOrdered = true;
			}
			System.out.println(" *** " + getName() + " siparis veriyor. ***");
			main.chefs.work();
		} 
		else {
			System.out.println("***" + getName() + " yemegi servis edildi.");
			
			try {
				Thread.sleep(order.getConsTotalTime());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("***" + order.getCustomer().getName() + " yemegini bitirdi ve restauranttan ayrildi."
					+ "\t\n Restarurantta " + order.getConsTotalTime() + " sure bulundu.");
		}

	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public boolean isOrdered() {
		return isOrdered;
	}

	public void setOrdered(boolean isOrdered) {
		this.isOrdered = isOrdered;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	static ArrayList<Customer> getList() {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		try {
			customerList.add(new Customer("Serdar", "1517743608", Gender.male));
			customerList.add(new Customer("Eser", "1204629463", Gender.male));
			customerList.add(new Customer("Afra", "7692692571", Gender.female));
			customerList.add(new Customer("Erel", "2021230511", Gender.male));
			customerList.add(new Customer("Dilek", "1588112170", Gender.female));
			customerList.add(new Customer("Tahir", "1632276618", Gender.male));
			customerList.add(new Customer("Adelya", "1849077068", Gender.female));
			customerList.add(new Customer("Ecem", "1696015527", Gender.female));
			customerList.add(new Customer("Taner", "1342016164", Gender.male));
			customerList.add(new Customer("Melissa", "1206173527", Gender.female));
			customerList.add(new Customer("Cem", "1221334182", Gender.male));
			customerList.add(new Customer("Melis", "1055517726", Gender.female));

		} catch (IllegalOrderException e) {
		}

		return customerList;

	}

	@Override
	public String toString() {
		return "Customer [isOrdered=" + isOrdered + ", order=" + order + ", tableNo=" + tableNo + "]";
	}
}
