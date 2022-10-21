package Implementation;

import BackEndDatabase.OrderDetail;

public class FoodOrder extends MenuItem {

	//1. For checking & recalling menu items data for the display
	//2. includes calculation of price & discounts, orders, calorie intakes

	public Pizza selectPizza = new Pizza();
	public AddOns selectAddOns = new AddOns();
	
	public int defineOrderID;
	public OrderItem orderItem = new OrderItem();
	public OrderDetail data = new OrderDetail();
	
	//Step1. Move the selected item information from SwitchDisplay to the assigned(ID) OrderItem
	/* information includes : selected item title & description, price & calorie
	 * "C,U,and D" functions in the screen_Checkout
	 */
	
	public void createNewOrder() {
		//specify current orderItems and create one more in OrderItem Class
		orderItem.ID = orderItem.itemAmount + 1;
		assignOrderItem();
		//after assigning menuItem to OrderItem, clean up selection data for next order
		resetSelection();
		//reset orderItem amount
		orderItem.itemAmount ++;
		
	}
	
	public void updateOrder() {
		//specify current orderItems and update in OrderItem Class
		orderItem.ID = defineOrderID;
		assignOrderItem();
		//after assigning menuItem to OrderItem, clean up selection data for next order
		resetSelection();

	}
	
	public void deleteOrder() {
		//specify current orderItems and delete in OrderItem Class
		orderItem.ID = defineOrderID;
		//rearrange orderItems in OrderItem Class
		for(int i = orderItem.ID; i < orderItem.itemAmount; i++) {
			//add pizza to order item 
			orderItem.pizzaSize[i-1] = orderItem.pizzaSize[i];
			orderItem.pizzaBase[i-1] = orderItem.pizzaBase[i];
			orderItem.pizzaSauce[i-1] = orderItem.pizzaSauce[i];
			orderItem.pizzaTopping[i-1] = orderItem.pizzaTopping[i];
			orderItem.pizzaSubtypes[i-1] = orderItem.pizzaSubtypes[i];
			orderItem.pizzaPrice[i-1] = orderItem.pizzaPrice[i];
			orderItem.pizzaCalorie[i-1] = orderItem.pizzaCalorie[i];
			
			//add add-on to order item
			orderItem.pasta[i-1] = orderItem.pasta[i];
			orderItem.side[i-1] = orderItem.side[i];
			orderItem.drink[i-1] = orderItem.drink[i];
			orderItem.addOnPrice[i-1] = orderItem.addOnPrice[i];
			orderItem.addOnCalorie[i-1] = orderItem.addOnCalorie[i];
		}
		//delete the last OrderItem in OrderItem Class
		orderItem.pizzaSize[orderItem.itemAmount-1] = null;
		orderItem.pizzaBase[orderItem.itemAmount-1] = null;
		orderItem.pizzaSauce[orderItem.itemAmount-1] = null;
		orderItem.pizzaTopping[orderItem.itemAmount-1] = null;
		orderItem.pizzaSubtypes[orderItem.itemAmount-1] = null;
		orderItem.pizzaPrice[orderItem.itemAmount-1] = 0;
		orderItem.pizzaCalorie[orderItem.itemAmount-1] = 0;
		
		orderItem.pasta[orderItem.itemAmount-1] = null;
		orderItem.side[orderItem.itemAmount-1] = null;
		orderItem.drink[orderItem.itemAmount-1] = null;
		orderItem.addOnPrice[orderItem.itemAmount-1] = 0;
		orderItem.addOnCalorie[orderItem.itemAmount-1] = 0;
		
		//reset orderItem amount
		orderItem.itemAmount --;	
		
	}
	
	
	//Step2. "R" function in displaying selected items to the screen_Checkout & scree_Payment
	public void readOrders() {
		
	}
	
	
	//Step3. Calculate Price & Calorie with each orderItem & in total
	/* including
	 * check all the items in the orderItem
	 * specify every items with it's price & calorie in MenuItem
	 * call the numbers and do the math.
	 */
	
	public int Payment() {
		int payment = 0;
		//Sum all orderItems
		for(int i = 0 ; i < orderItem.itemAmount ; i++) {
			payment = payment + orderItem.pizzaPrice[i] + orderItem.addOnPrice[i];
		}
		
		return payment;
	}
	
	public int CalorieIntake() {
		int calorieIntake = 0;
		//Sum all orderItems
		for(int i = 0 ; i < orderItem.itemAmount ; i++) {
			calorieIntake = calorieIntake + orderItem.pizzaCalorie[i] + orderItem.addOnCalorie[i];
		}
		
		return calorieIntake;
	}
	
	//Step4. after customer submit payment, clean up current data for the next food order
	
	public void CompleteOrder() {
		//record all orderItems to the back-end
		
		for(int i = 0 ; i < orderItem.itemAmount ; i++) {
			data.orderDescription[data.customerOrderID-1] = orderItem.itemAmount + orderItem.pizzaSize[i] + orderItem.pizzaBase[i] + orderItem.pizzaSauce[i] + orderItem.pizzaTopping[i] + orderItem.pizzaSubtypes[i] + orderItem.pasta[i] + orderItem.side[i] + orderItem.drink[i];
		}
		for(int i = 0 ; i < orderItem.itemAmount ; i++) {
			data.orderIncome[data.customerOrderID-1] = orderItem.pizzaPrice[i] + orderItem.addOnPrice[i];
		}
		data.customerOrderID++;
		
		//reset OrderItem
		orderItem.ID = -1;
		orderItem.itemAmount = 0;
		orderItem.pizzaSize = new String[orderItem.pizzaSize.length];
		orderItem.pizzaBase = new String[orderItem.pizzaBase.length];
		orderItem.pizzaSauce = new String[orderItem.pizzaSauce.length];
		orderItem.pizzaTopping = new String[orderItem.pizzaTopping.length];
		orderItem.pizzaSubtypes = new String[orderItem.pizzaSubtypes.length];
		orderItem.pasta = new String[orderItem.pasta.length];
		orderItem.side = new String[orderItem.side.length];
		orderItem.drink = new String[orderItem.drink.length];
		orderItem.pizzaPrice = new int[orderItem.pizzaPrice.length];
		orderItem.pizzaCalorie = new int[orderItem.pizzaCalorie.length];
		orderItem.addOnPrice = new int[orderItem.addOnPrice.length];
		orderItem.addOnCalorie = new int[orderItem.addOnCalorie.length];
		
		//reset MenuItem
		resetSelection();
	}


	//assignOrderItem and reserSelection are inner methods
	public void assignOrderItem() {
		
		//assign from MenuItem class to OrderItem class
		//add pizza to order item 
		orderItem.pizzaSize[orderItem.ID - 1] = selectPizza.pizzaSize;
		orderItem.pizzaBase[orderItem.ID - 1] = selectPizza.pizzaBase;
		orderItem.pizzaSauce[orderItem.ID - 1] = selectPizza.pizzaSauce;
		orderItem.pizzaTopping[orderItem.ID - 1] = selectPizza.pizzaTopping;
		orderItem.pizzaSubtypes[orderItem.ID - 1] = selectPizza.pizzaSubtypes;
		orderItem.pizzaPrice[orderItem.ID - 1] = selectPizza.VerifyPrice();
		orderItem.pizzaCalorie[orderItem.ID - 1] = selectPizza.VerifyCalorie();
		
		//add add-on to order item
		orderItem.pasta[orderItem.ID - 1] = selectAddOns.pasta;
		orderItem.side[orderItem.ID - 1] = selectAddOns.side;
		orderItem.drink[orderItem.ID - 1] = selectAddOns.drink;
		orderItem.addOnPrice[orderItem.ID - 1] = selectAddOns.VerifyPrice();
		orderItem.addOnCalorie[orderItem.ID - 1] = selectAddOns.VerifyCalorie();
		
	}

	public void resetSelection() {
		//clean up the menuItem data for new & update data
		//reset pizza
		selectPizza.pizzaSize = "";
		selectPizza.pizzaBase = "";
		selectPizza.pizzaSauce = "";
		selectPizza.pizzaTopping = "";
		selectPizza.pizzaSubtypes = "";
		selectPizza.pizzaCalorie = 0;
		selectPizza.pizzaPrice = 0;
		//reset add-ons
		selectAddOns.pasta = "";
		selectAddOns.side = "";
		selectAddOns.drink = "";
		selectAddOns.addOnPrice = 0;
		selectAddOns.addOnCalorie = 0;
		
	}
	
}