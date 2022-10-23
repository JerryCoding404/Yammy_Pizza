package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.Box;

public class windowBuilder extends JFrame {

	private JPanel contentPane;
	private JTextField txtTtt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowBuilder frame = new windowBuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public windowBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "name_402604234254416");
		
		JButton btnNewButton = new JButton("small");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("large");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("extra large");
		panel_1.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_402597017125499");
		
		Box verticalBox = Box.createVerticalBox();
		panel.add(verticalBox);
		
		JTextPane txtpnTtt = new JTextPane();
		txtpnTtt.setText("ttt111" + "\n" + "line2");
		panel.add(txtpnTtt);
		
		JTextArea txtrTtt = new JTextArea();
		txtrTtt.setText("ttt222" + "\n" + "line2");
		panel.add(txtrTtt);
		
		JTextField txtTtt = new JTextField();
		txtTtt.setBackground(new Color(255, 255, 255));
		txtTtt.setHorizontalAlignment(SwingConstants.CENTER);
		txtTtt.setText("ttt333" + "\n" + "line2");
		
		panel.add(txtTtt);
		txtTtt.setColumns(10);
	}

}
