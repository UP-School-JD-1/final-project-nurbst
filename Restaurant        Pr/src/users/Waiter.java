package users;

import java.util.ArrayList;

import foodAndDrink.Order;

public class Waiter extends Employee {

	Table lookTable = null;

	public Waiter(String name, String tckn, Gender gender, Department department) {
		super(name, tckn, gender, department);
	}

	@Override
	public void run() {

		Main main = Main.main;
		setLookTable(lookTable);

		// dolu ise müşteriyi tetikle
		lookTable.getCustomer().run();
		
		// siparişten sonra şefi tetikle
		main.chefs.work();

	}

	public Table getLookTable() {
		return lookTable;
	}

	public void setLookTable(Table lookingTable) {

		Main main = Main.main;
		
		// Masaların kontrolü

		for (int i = 0; i < main.tableList.size(); i++) {

			Table temp = main.tableList.get(i);
			if (temp.isEmpty() == false && temp.getCustomer().isOrdered() == false) {

				lookTable = temp;
				break;
			}

		}

		if (lookTable == null) {
			return;
		}
		this.lookTable = lookingTable;
	}

	static ArrayList<Waiter> getList() {
		ArrayList<Waiter> waiterList = new ArrayList<Waiter>();
		waiterList.add(new Waiter("Nur", "299497482", Gender.female, Department.waiter));
		waiterList.add(new Waiter("Defne", "512926130", Gender.female, Department.waiter));
		waiterList.add(new Waiter("Semih", "228691044", Gender.male, Department.waiter));
		waiterList.add(new Waiter("Emir", "582345028", Gender.male, Department.waiter));
		waiterList.add(new Waiter("Turan", "876516782", Gender.male, Department.waiter));

		return waiterList;
	}

}