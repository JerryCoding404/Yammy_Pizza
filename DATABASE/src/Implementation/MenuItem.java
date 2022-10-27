package Implementation;


public class MenuItem {

	//restore all the item data in the internal system for recall the display
	
	//setup pizza class for the combination of calorie & price info
	public static class Pizza{
		//define all variables
		public String pizzaSize = "";
		public String pizzaBase = "";
		public String pizzaSauce = "";
		public String pizzaTopping = "";
		public String pizzaSubtypes = "";
		public int pizzaCalorie = 0;
		public int pizzaPrice = 0;
		
		//input calorie & price info into the pizza combination
		public int VerifyPrice() {
			
			int price = 404;
			//price list
			//use pizzaSize & pizzaTopping combination
			if(pizzaSize == "Small_8inch") {
				switch(pizzaTopping) {
					case "Supreme":
						price = 5;
						break;
							
					case "SausageSizzle":
						price = 6;
						break;
						
					case "Hawaiian":
						price = 7;
						break;
					
					case "Chicken":
						price = 8;
						break;
						
					case "VeggieLovers":
						price = 9;
						break;
					
				}
			}else if(pizzaSize == "Large_11inch") {
				switch(pizzaTopping) {
					case "Supreme":
						price = 10;
						break;
						
					case "SausageSizzle":
						price = 11;
						break;
						
					case "Hawaiian":
						price = 12;
						break;
					
					case "Chicken":
						price = 13;
						break;
						
					case "VeggieLovers":
						price = 14;
						break;
					
				}
			}else if(pizzaSize == "Extralarge_12inch") {
				switch(pizzaTopping) {
					case "Supreme":
						price = 15;
						break;
						
					case "SausageSizzle":
						price = 16;
						break;
						
					case "Hawaiian":
						price = 17;
						break;
					
					case "Chicken":
						price = 18;
						break;
						
					case "VeggieLovers":
						price = 19;
						break;
						
				}
			}
			
			pizzaPrice = price;
			return pizzaPrice;
		
		}
	
		public int VerifyCalorie() {
			
			int calorie = 404;
			
			//combination of pizzaTopping & pizzaSubtypes
			
			switch(pizzaTopping) {
				case "Supreme":
					if(pizzaSubtypes == "SweetChillChicken") {
						calorie = 2000;
					}else if(pizzaSubtypes == "PeriperiChicken") {
						calorie = 2100;
					}else if(pizzaSubtypes == "GardenGoodness") {
						calorie = 2200;
					}else if(pizzaSubtypes == "VeganCheese") {
						calorie = 2300;
					}
					break;
						
				case "SausageSizzle":
					if(pizzaSubtypes == "SweetChillChicken") {
						calorie = 1500;
					}else if(pizzaSubtypes == "PeriperiChicken") {
						calorie = 1600;
					}else if(pizzaSubtypes == "GardenGoodness") {
						calorie = 1700;
					}else if(pizzaSubtypes == "VeganCheese") {
						calorie = 1800;
					}
					break;
					
				case "Hawaiian":
					if(pizzaSubtypes == "SweetChillChicken") {
						calorie = 1000;
					}else if(pizzaSubtypes == "PeriperiChicken") {
						calorie = 1100;
					}else if(pizzaSubtypes == "GardenGoodness") {
						calorie = 1200;
					}else if(pizzaSubtypes == "VeganCheese") {
						calorie = 1300;
					}
					break;
				
				case "Chicken":
					if(pizzaSubtypes == "SweetChillChicken") {
						calorie = 2500;
					}else if(pizzaSubtypes == "PeriperiChicken") {
						calorie = 2600;
					}else if(pizzaSubtypes == "GardenGoodness") {
						calorie = 2700;
					}else if(pizzaSubtypes == "VeganCheese") {
						calorie = 2800;
					}
					break;
					
				case "VeggieLovers":
					if(pizzaSubtypes == "SweetChillChicken") {
						calorie = 2900;
					}else if(pizzaSubtypes == "PeriperiChicken") {
						calorie = 3000;
					}else if(pizzaSubtypes == "GardenGoodness") {
						calorie = 3100;
					}else if(pizzaSubtypes == "VeganCheese") {
						calorie = 3200;
					}
					break;
				
			}
			
			pizzaCalorie = calorie;
			return pizzaCalorie;
		}

	}

		
	//setup add-ons class list & info
	public static class AddOns{
		//define all variables
		public String pasta;
		public String side;
		public String drink;
		public int addOnPrice;
		public int addOnCalorie;
		
		//input calorie & price info into specific addOn
		public int VerifyPrice() {
			int pastaPrice = 0;
			int sidePrice = 0;
			int drinkPrice = 0;
			
			//input pasta price
			if(pasta == "CreamyMushroom") {
				pastaPrice = 15;
			}else if(pasta == "lassBolognese") {
				pastaPrice = 16;
			}
			//input side price
			if(side == "ChickenWings") {
				sidePrice = 5;
			}else if(side == "GarlicBread") {
				sidePrice = 2;
			}
			//input drink price
			if(drink == "SoftDrinks") {
				drinkPrice = 4;
			}else if(drink == "FruitJuice") {
				drinkPrice = 6;
			}
			
			addOnPrice = pastaPrice + sidePrice + drinkPrice;
			
			
			return addOnPrice;
		}
		
		public int VerifyCalorie() {
			int pastaCalorie = 0;
			int sideCalorie = 0;
			int drinkCalorie = 0;
			
			//input pasta calorie
			if(pasta == "CreamyMushroom") {
				pastaCalorie = 1400;
			}else if(pasta == "lassBolognese") {
				pastaCalorie = 1600;
			}
			//input side calorie
			if(side == "ChickenWings") {
				sideCalorie = 300;
			}else if(side == "GarlicBread") {
				sideCalorie = 150;
			}
			//input drink calorie
			if(drink == "SoftDrinks") {
				drinkCalorie = 200;
			}else if(drink == "FruitJuice") {
				drinkCalorie = 600;
			}
			
			addOnCalorie = pastaCalorie + sideCalorie + drinkCalorie;
			
			return addOnCalorie;
		}
		
	}

	/*
	int menuItemID;
	String title;
	String description;
	*/
	
	//ingredient description list
	//enum Ingredient{ tomato, flour, chicken, vegetable, sausage, pineapple, cheese, pastaNoodle, chickenWings, garlicBread, mushroom }
	

}

