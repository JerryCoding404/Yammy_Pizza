package UI;

import javax.swing.*;

import BackEndDatabase.SQL;
import Implementation.FoodOrder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchDisplay {
	
	//Variables for screens display
	String screenIndex;
	JFrame frame = new JFrame();
	JPanel panelCont = new JPanel();
	JPanel screen01 = new JPanel();
	JPanel screen02 = new JPanel();
	JPanel screen03 = new JPanel();
	JPanel screen04 = new JPanel();
	JButton buttonPayment = new JButton();
	JButton buttonReturn = new JButton();
	JButton buttonSmall = new JButton();
	JButton buttonLarge = new JButton();
	JButton buttonExtraLarge = new JButton();
	JButton Supreme = new JButton();
	JButton SausageSizzle = new JButton();
	JButton Hawaiian = new JButton();
	JButton Chicken = new JButton();
	JButton VeggieLovers = new JButton();
	JButton SweetChillChicken = new JButton();
	JButton PeriperiChicken = new JButton();
	JButton GardenGoodness = new JButton();
	JButton VeganCheese = new JButton();
	JTextPane pizzaDescription = new JTextPane();
	JTextPane paymentDescription = new JTextPane();
	CardLayout cl = new CardLayout();
	

	
	
	//Variables for functions
	FoodOrder foodOrder = new FoodOrder();
	int buttonID;
	
	//calling database
	SQL database = new SQL();
	

	public SwitchDisplay() {
		/*
		//test recall image
		ImageIcon imageSmall = new ImageIcon(getClass().getResource("small.jpg"));
		ImageIcon imageLarge = new ImageIcon(getClass().getResource("large.jpg"));
		ImageIcon imageExtraLarge = new ImageIcon(getClass().getResource("extraLarge.jpg"));
		
		final JLabel small = new JLabel(imageSmall);
		final JLabel large = new JLabel(imageLarge);
		final JLabel extraLarge = new JLabel(imageExtraLarge);
		
		System.out.println("assignImages");
		*/
		
		//frame setting
		frame.setSize(500,500);
		frame.setBounds(100, 100, 450, 300);

		//screen01 setting (select pizzaSize)
		screen01.setBackground(new Color(0,100,0));
		screen01.setBounds(0,0,200,200);
		screen01.setBackground(Color.BLUE);
		
		buttonSmall.setText("Small");
		buttonLarge.setText("Large");
		buttonExtraLarge.setText("ExtraLarge");
		
		screen01.add(buttonSmall);
		screen01.add(buttonLarge);
		screen01.add(buttonExtraLarge);
		
		
		//screen02 setting (select pizzaTopping)
		screen02.setBackground(new Color(50,0,0));
		screen02.setBounds(0,0,200,200);
		screen02.setBackground(Color.GREEN);

		Supreme.setText("Supreme");
		SausageSizzle.setText("SausageSizzle");
		Hawaiian.setText("Hawaiian");
		Chicken.setText("Chicken");
		VeggieLovers.setText("VeggieLovers");
		
		screen02.add(Supreme);
		screen02.add(SausageSizzle);
		screen02.add(Hawaiian);
		screen02.add(Chicken);
		screen02.add(VeggieLovers);

		//screen04 setting (select pizzaTopping)
		screen04.setBackground(new Color(50,0,0));
		screen04.setBounds(0,0,200,200);
		screen04.setBackground(Color.GREEN);

		SweetChillChicken.setText("SweetChillChicken");
		PeriperiChicken.setText("PeriperiChicken");
		GardenGoodness.setText("GardenGoodness");
		VeganCheese.setText("VeganCheese");

		screen04.add(SweetChillChicken);
		screen04.add(PeriperiChicken);
		screen04.add(GardenGoodness);
		screen04.add(VeganCheese);
		
		//screen03 setting (submit payment & read order & create new order)
		screen03.setBackground(new Color(50,0,0));
		screen03.setBounds(0,0,200,200);
		screen03.setBackground(Color.RED);

		paymentDescription.setText("");
		pizzaDescription.setText("");
		buttonPayment.setText("Submit Payment");
		buttonReturn.setText("update order");
		
		screen03.add(pizzaDescription);
		screen03.add(paymentDescription);
		screen03.add(buttonPayment);
		screen03.add(buttonReturn);

		
		//Control Panel setting (adding every screens and label them)
		panelCont.setLayout(cl);
		panelCont.add(screen01, "1");
		panelCont.add(screen02, "2");
		panelCont.add(screen03, "3");
		panelCont.add(screen04, "4");
		cl.show(panelCont, "1");
		
		
		//screen01_first selection page
		buttonSmall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//assign pizzaSize = "Small"
				foodOrder.selectPizza.pizzaSize = "Small_8inch";
				VerifyMealText();
				
				//assign image 
				//screen03.add(small);
				
				//switch to screen02
				screenIndex = "2";
				cl.show(panelCont, screenIndex);
			}
		});
		
		buttonLarge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//assign pizzaSize = "Large"
				foodOrder.selectPizza.pizzaSize = "Large_11inch";
				VerifyMealText();
				
				//assign image
				//screen03.add(large);
				
				//switch to screen02
				screenIndex = "2";
				cl.show(panelCont, screenIndex);
			}
		});
		
		buttonExtraLarge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//assign pizzaSize = "ExtraLarge"
				foodOrder.selectPizza.pizzaSize = "Extralarge_12inch";
				VerifyMealText();
				
				//assign image
				//screen03.add(extraLarge);
				
				//switch to screen02
				screenIndex = "2";
				cl.show(panelCont, screenIndex);
			}
		});

		//screen02_final selection page
		Supreme.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//assign
				foodOrder.selectPizza.pizzaTopping = "Supreme";
				VerifyMealText();
				
				//switch to screen02
				screenIndex = "4";
				cl.show(panelCont, screenIndex);
			}
		});
		
		SausageSizzle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//assign
				foodOrder.selectPizza.pizzaTopping = "SausageSizzle";
				VerifyMealText();
				
				//switch to screen02
				screenIndex = "4";
				cl.show(panelCont, screenIndex);
			}
		});
		
		Hawaiian.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//assign
				foodOrder.selectPizza.pizzaTopping = "Hawaiian";
				VerifyMealText();
				
				//switch to screen02
				screenIndex = "4";
				cl.show(panelCont, screenIndex);
			}
		});
		
		Chicken.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//assign
				foodOrder.selectPizza.pizzaTopping = "Chicken";
				VerifyMealText();
				
				//switch to screen02
				screenIndex = "4";
				cl.show(panelCont, screenIndex);
			}
		});
		
		VeggieLovers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//assign
				foodOrder.selectPizza.pizzaTopping = "VeggieLovers";
				VerifyMealText();
				
				//switch to screen02
				screenIndex = "4";
				cl.show(panelCont, screenIndex);
			}
		});
		
		//screen04_final selection page
		
		SweetChillChicken.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//assign
				foodOrder.selectPizza.pizzaSubtypes = "SweetChillChicken";
				VerifyMealText();
				foodOrder.createNewOrder();
				VerifyPriceCalorieText();
				
				//switch to screen02
				screenIndex = "3";
				cl.show(panelCont, screenIndex);
			}
		});
		
		PeriperiChicken.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//assign
				foodOrder.selectPizza.pizzaSubtypes = "PeriperiChicken";
				VerifyMealText();
				foodOrder.createNewOrder();
				VerifyPriceCalorieText();
				
				//switch to screen02
				screenIndex = "3";
				cl.show(panelCont, screenIndex);
			}
		});
		
		GardenGoodness.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//assign
				foodOrder.selectPizza.pizzaSubtypes = "GardenGoodness";
				VerifyMealText();
				foodOrder.createNewOrder();
				VerifyPriceCalorieText();
				
				//switch to screen02
				screenIndex = "3";
				cl.show(panelCont, screenIndex);
			}
		});
		
		VeganCheese.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//assign
				foodOrder.selectPizza.pizzaSubtypes = "VeganCheese";
				VerifyMealText();
				foodOrder.createNewOrder();
				VerifyPriceCalorieText();
				
				//switch to screen02
				screenIndex = "3";
				cl.show(panelCont, screenIndex);
			}
		});
		
		
		//screen03_ show payment, order information
		buttonPayment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//orderComplete
				System.out.println("You have paid : " + foodOrder.Payment());
				try {
					foodOrder.CompleteOrder();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("order Complete!");
				
				
			}
		});
		
		buttonReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//only for update & delete buttons
				//assign the buttonID to the foodOrder class for use
				buttonID = 1;
				foodOrder.defineOrderID = buttonID;
				foodOrder.resetOrderItem();
				foodOrder.resetSelection();
				
				
				//switch to screen01
				screenIndex = "1";
				cl.show(panelCont, screenIndex);
				System.out.println("return to screen01");
			}
		});
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panelCont);
		frame.setVisible(true);
		
	}

	public void VerifyMealText() {
		//read & assign selected text to every JTextPane
		pizzaDescription.setText("Your pizza description : " + "\n"  + foodOrder.selectPizza.pizzaSize + "\n" + foodOrder.selectPizza.pizzaTopping +  "\n" + foodOrder.selectPizza.pizzaSubtypes + "\n");
		System.out.print("select : " + "\n"  + foodOrder.selectPizza.pizzaSize + "\n" + foodOrder.selectPizza.pizzaTopping + "\n" + foodOrder.selectPizza.pizzaSubtypes + "\n");
	}
	
	public void VerifyPriceCalorieText() {
		//read & assign selected text to every JTextPane
		paymentDescription.setText("All calorie intake : " + foodOrder.CalorieIntake() + "\nTotal Payment : " + foodOrder.Payment());
	}
	
	/*Create a new class for the operation
	 * 
	 * public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwitchDisplay();
			}
		});
	}*/

}