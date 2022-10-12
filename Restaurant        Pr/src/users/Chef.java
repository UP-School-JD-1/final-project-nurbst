package users;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import foodAndDrink.Order;

public class Chef extends Employee {

	private Waiter waiter;

	public Chef(String name, String tckn, Gender gender, Department department) {
		super(name, tckn, gender, department);
	}

	@Override
	public void run() {

		Main main = Main.main;

		Order order = main.orderList.poll();

		if (order.isStarted() == false) {
			order.setStarted(true);
			System.out.println("Chef " + getName() + " siparisi hazirlamaya basladi " + "\t\n"
					+ order.getCustomer().getName() + " siparisleri : " + order);

			try {
				Thread.sleep(order.getPreTotalTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		
			
			System.out.println("*** " + order.getCustomer().getName() + " siparisi tamamlandi.");
			System.out.println("Yemek " + order.getPreTotalTime() + " surede hazirlandi.");
			
			order.getCustomer().setFinished(true);
			order.getCustomer().run();


		}

	}

	public static ArrayList<Chef> getList() {
		ArrayList<Chef> chefList = new ArrayList<Chef>();

		chefList.add(new Chef("Atalay", "944492885", Gender.male, Department.chef));
		chefList.add(new Chef("Miray", "1924896462", Gender.female, Department.chef));
		chefList.add(new Chef("Lale", "2074548728", Gender.female, Department.chef));

		return chefList;
	}

}