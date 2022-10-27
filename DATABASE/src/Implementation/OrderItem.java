package Implementation;

public class OrderItem extends MenuItem {
	
	//Every orderItems for one customer
	//list every different orders, including all the items, the way of receiving, and the price for each
	public int ID = -1;
	public int itemAmount = 0;
	public String[] pizzaSize = new String[10];
	public String[] pizzaBase = new String[10];
	public String[] pizzaSauce = new String[10];
	public String[] pizzaTopping = new String[10];
	public String[] pizzaSubtypes = new String[10];
	public String[] pasta = new String[10];
	public String[] side = new String[10];
	public String[] drink = new String[10];
	public int[] pizzaPrice = new int[10];
	public int[] pizzaCalorie = new int[10];
	public int[] addOnPrice = new int[10];
	public int[] addOnCalorie = new int[10];


}
