package Window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow frame = new GameWindow();
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
	public GameWindow() {
		setTitle("One Hand");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton JokerButton = new JButton("Joker");
		JokerButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		JokerButton.setBounds(190, 500, 122, 55);
		contentPane.add(JokerButton);
		
		JLabel PointText = new JLabel("Points :");
		PointText.setFont(new Font("Tahoma", Font.BOLD, 20));
		PointText.setBounds(24, 25, 85, 42);
		contentPane.add(PointText);
		
		JLabel PointAmount = new JLabel("0");
		PointAmount.setForeground(new Color(255, 255, 255));
		PointAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PointAmount.setBounds(107, 28, 45, 36);
		contentPane.add(PointAmount);
		
		JLabel HandCard1 = new JLabel("");
		HandCard1.setBounds(140, 160, 150, 255);
		contentPane.add(HandCard1);
		
		JLabel HandCard4 = new JLabel("");
		HandCard4.setBounds(385, 160, 150, 255);
		contentPane.add(HandCard4);
		
		JLabel HandCard2 = new JLabel("");
		HandCard2.setBounds(225, 160, 150, 255);
		contentPane.add(HandCard2);
		
		JLabel HandCard3 = new JLabel("");
		HandCard3.setBounds(310, 160, 150, 255);
		contentPane.add(HandCard3);
		
		JLabel CardDeck = new JLabel("");
		CardDeck.setBounds(774, 36, 150, 200);
		contentPane.add(CardDeck);
		
		JLabel CardDiscarded = new JLabel("");
		CardDiscarded.setBounds(670, 25, 94, 118);
		contentPane.add(CardDiscarded);
		
		JLabel Joker_1 = new JLabel("");
		Joker_1.setBounds(24, 495, 45, 75);
		contentPane.add(Joker_1);
		
		JLabel Joker_2 = new JLabel("");
		Joker_2.setBounds(80, 495, 45, 75);
		contentPane.add(Joker_2);
		
		JLabel Joker_3 = new JLabel("");
		Joker_3.setBounds(135, 495, 45, 75);
		contentPane.add(Joker_3);
		
		JLabel HideCard = new JLabel("");
		HideCard.setBounds(774, 252, 150, 200);
		contentPane.add(HideCard);
		
		JLabel lblNewLabel = new JLabel("Joker Card Bench");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(749, 462, 175, 42);
		contentPane.add(lblNewLabel);
	}
}
