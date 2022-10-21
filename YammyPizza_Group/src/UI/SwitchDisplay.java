package UI;

import javax.swing.*;

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
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	CardLayout cl = new CardLayout();
	
	//Variables for functions
	FoodOrder foodOrder = new FoodOrder();
	int buttonID;
	

	public SwitchDisplay() {
		
		//frame setting
		frame.setSize(500,500);
		frame.setBounds(100, 100, 450, 300);

		//screen01 setting
		screen01.setBackground(new Color(0,100,0));
		screen01.setBounds(0,0,200,200);
		screen01.setBackground(Color.BLUE);
		
		button1.setText("Select Meals");
		screen01.add(button1);
		
		//screen02 setting
		screen02.setBackground(new Color(50,0,0));
		screen02.setBounds(0,0,200,200);
		screen02.setBackground(Color.GREEN);

		button2.setText("Finish Order & submit payment");
		screen02.add(button2);
		
		//screen03 setting
		screen03.setBackground(new Color(50,0,0));
		screen03.setBounds(0,0,200,200);
		screen03.setBackground(Color.RED);

		button3.setText("create new orders");
		screen03.add(button3);
		
		//Control Panel setting (adding every screens and label them)
		panelCont.setLayout(cl);
		panelCont.add(screen01, "1");
		panelCont.add(screen02, "2");
		panelCont.add(screen03, "3");
		cl.show(panelCont, "1");
		
		
		//Switch Screens & record Meal
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				/*Test
				 * assign a orderItem select ID (for every update & delete button)
				 * select pizza_pizzaSize
				 * select pasta_creamyMuchroom
				 */
				
				
				//for selection buttons
				//assign the meal name to the foodOrder class for use
				System.out.println("order" + foodOrder.orderItem.ID);
				foodOrder.selectPizza.pizzaSize = "Small_8inch";
				System.out.println("select pizza size is " + foodOrder.selectPizza.pizzaSize);
				foodOrder.selectAddOns.pasta = "CreamyMushroom";
				System.out.println("select pasta is " + foodOrder.selectAddOns.pasta);

				//switch to screen02
				screenIndex = "2";
				cl.show(panelCont, screenIndex);
			}
		});
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Calculation
				int totalPayment = 0;
				totalPayment = foodOrder.Payment();
				System.out.println("checkout and submit current order");
				
				//switch to screen03
				screenIndex = "3";
				cl.show(panelCont, screenIndex);
				
			}
		});
		
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//only for update & delete buttons
				//assign the buttonID to the foodOrder class for use
				buttonID = 1;
				foodOrder.defineOrderID = buttonID;
				
				foodOrder.createNewOrder();
				System.out.println("order" + buttonID + "has beem updated!");
				
				//switch to screen01
				screenIndex = "1";
				cl.show(panelCont, screenIndex);
			}
		});
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panelCont);
		frame.setVisible(true);
		
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