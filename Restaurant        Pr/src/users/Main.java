package users;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import foodAndDrink.Order;

public class Main {

	ArrayList<Waiter> waiterList = Waiter.getList();

	ArrayList<Chef> chefList = Chef.getList();

	HashMap<Integer, Table> tableList = Table.getList();

	public Queue<Customer> waitingCustomers = new LinkedList<Customer>();

	public Queue<Order> orderList = new LinkedList<Order>();

	WaiterPoolHandler waiters = new WaiterPoolHandler(waiterList);

	ChefPoolHandler chefs = new ChefPoolHandler(chefList);

	static Main main = new Main();

	static Date getDate(String date) {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
		Date rdate;
		try {
			rdate = dateformat.parse(date);
			return rdate;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {

		Thread newCustomerThread = new Thread(new Runnable() {

			@Override
			public void run() {

				ArrayList<Customer> list = Customer.getList();
				Random rand = new Random();

				for (int i = 0; i < 6; i++) {
					System.out.println("*** YENI MUSTERI ***");
					for (int j = 0; j < 5; j++) {

						try {
							Thread.sleep(rand.nextInt(1500));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Customer customer = list.get(i * 5 + j);

						System.out.println("*** " + customer.getName() + " isimli musteri restauranta geldi. ***");

						int emptyIndex = -1;
						boolean isEmptyPlaceExist = false;

						for (int k = 0; k < main.tableList.size(); k++) {
							if (main.tableList.get(k).isEmpty()) {
								isEmptyPlaceExist = true;
								emptyIndex = k;
								break;
							}
						}
						if (isEmptyPlaceExist) {
							customer.setTableNo(emptyIndex);

							main.tableList.put(emptyIndex, new Table(customer));

							main.waiters.work();

						} else {

							boolean isWaiting = rand.nextBoolean();
							if (isWaiting) {
								main.waitingCustomers.add(customer);
								System.out.println("***" + customer.getName() + " boş masa bekliyor.");

							} else {
								System.out.println("*** " + customer.getName()
										+ " isimli musteri beklemek istemedi ve restauranttan ayrildi. ");

							}

						}

					}

				}
			}
		});
		newCustomerThread.start();

	}

}