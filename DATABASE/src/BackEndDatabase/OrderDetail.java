package BackEndDatabase;

public class OrderDetail {

	//for receiving all customers order items and put it into inner system to the kitchen
	//including the payment received (to the accounting system)
	//and the food ordered (to the kitchen)
	//and the ingredient used (to the inventory control system)
	public int customerOrderID = 1;
	public String[] orderDescription = new String[10];
	public int[] orderIncome = new int[10];
	public String[] orderIngredientUsed = new String[10];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
