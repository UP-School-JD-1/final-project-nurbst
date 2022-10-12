package users;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import foodAndDrink.Order;

public class WaiterPoolHandler {

	public ArrayList<Waiter> waiters;
	public ThreadPoolExecutor threadPool;

	public WaiterPoolHandler(ArrayList<Waiter> waiters) {
		this.waiters = waiters;

		this.threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(waiters.size());
	}

	public void work() {
		Random r = new Random();
		Waiter availableWaiter = waiters.get(r.nextInt(waiters.size()));

		threadPool.execute(availableWaiter);
	}

}