import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class DeliverySystem {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliverySystem window = new DeliverySystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeliverySystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 808, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblJavaiComida = new JLabel("JAVAI COMIDA");
		lblJavaiComida.setHorizontalAlignment(SwingConstants.CENTER);
		lblJavaiComida.setFont(new Font("Quicksand", Font.PLAIN, 71));
		frame.getContentPane().add(lblJavaiComida, BorderLayout.NORTH);
	}

}
