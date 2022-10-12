package users;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ChefPoolHandler{
	
	public ArrayList<Chef> chefs;
	public ThreadPoolExecutor  threadPool;
	
	public ChefPoolHandler(ArrayList<Chef> chefs) {
		this.chefs=chefs;
		this.threadPool=(ThreadPoolExecutor) Executors.newFixedThreadPool(chefs.size());
	}
	
	// Müsait olan şeflerin rasgele birinin atanması
	
	public void work() {
		Random r=new Random();
		Chef availableChef=chefs.get(r.nextInt(chefs.size()));
		threadPool.execute(availableChef);
	}
}