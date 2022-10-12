package users;

public class IllegalOrderException extends Exception {
	
	@Override
	public String getMessage() {
		return "Maksimum 2 yiyecek ve Maksimum 1 içecek siparis edilebilir.";
	}

}
