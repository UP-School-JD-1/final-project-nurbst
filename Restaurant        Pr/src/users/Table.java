package users;

import java.util.HashMap;

public class Table {

	public Customer customer;

	public Table(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean isEmpty() {
		return getCustomer() == null;
	}

	@Override
	public String toString() {
		return "Masanin musterisi : " + (getCustomer() == null ? "null" : getCustomer().getName());
	}

	static HashMap<Integer, Table> getList() {
		HashMap<Integer, Table> tableList = new HashMap<Integer, Table>();

		for (int i = 0; i < 4; i++) {
			tableList.put(i, new Table(null));
		}
		return tableList;
	}

}