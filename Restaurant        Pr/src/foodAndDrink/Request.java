package foodAndDrink;

public abstract class Request implements Consumable {
	
	public String name;
	//Hazırlanma Süresi
	public int preTime;
	//Tüketilme Süresi
	public int consTime;
	
	public Request(String name,int preTime, int consTime) {
		this.name=name;
		this.preTime=preTime;
		this.consTime=consTime;
	}


	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPreTime() {
		return preTime;
	}



	public void setPreTime(int preTime) {
		this.preTime = preTime;
	}



	public int getConsTime() {
		return consTime;
	}



	public void setConsTime(int consTime) {
		this.consTime = consTime;
	}



	@Override
	public String toString() {
		return "Siparis Ismi : "+ getName();
	}
	
}
