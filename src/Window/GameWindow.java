package Window;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import card.Card;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class GameWindow extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	protected JLabel Joker1;
	protected JLabel Joker2;
	protected JLabel Joker3;
	protected JLabel Joker4;
	
	protected JLabel HandCard1;
	protected JLabel HandCard2;
	protected JLabel HandCard3;
	protected JLabel HandCard4;
	
	protected JLabel HideCard;
	protected JLabel CardDeck;
	protected JLabel CardDiscarded;
	
	protected JButton JokerButton;
	protected JButton PlayButton;
	private boolean useJoker;
	private boolean Continue;
	
	/**
	 * Create the frame.
	 */
	public GameWindow() {
		
		this.useJoker = false;
		this.Continue = false;
		
		setTitle("One Hand");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 620);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel PointText = new JLabel("Points :");
		PointText.setFont(new Font("Tahoma", Font.BOLD, 20));
		PointText.setBounds(24, 25, 85, 42);
		contentPane.add(PointText);
		
		JLabel PointAmount = new JLabel("0");
		PointAmount.setForeground(new Color(255, 255, 255));
		PointAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PointAmount.setBounds(107, 28, 45, 36);
		contentPane.add(PointAmount);
		
		HandCard1 = new JLabel("");
		HandCard1.setBounds(80, 160, 150, 255);
		contentPane.add(HandCard1);
		
		HandCard4 = new JLabel("");
		HandCard4.setBounds(545, 160, 150, 255);
		contentPane.add(HandCard4);
		
		HandCard2 = new JLabel("");
		HandCard2.setBounds(235, 160, 150, 255);
		contentPane.add(HandCard2);
		
		HandCard3 = new JLabel("");
		HandCard3.setBounds(390, 160, 150, 255);
		contentPane.add(HandCard3);
		
		CardDeck = new JLabel("");
		CardDeck.setIcon(new ImageIcon(GameWindow.class.getResource("/resources/init.png")));
		CardDeck.setBounds(774, 36, 150, 200);
		contentPane.add(CardDeck);
		
		CardDiscarded = new JLabel("");
		CardDiscarded.setBounds(670, 25, 94, 118);
		contentPane.add(CardDiscarded);
		
		Joker1 = new JLabel(new ImageIcon(GameWindow.class.getResource("/resources/Joker.png")));
		Joker1.setBounds(24, 495, 45, 75);
		contentPane.add(Joker1);
		
		Joker2 = new JLabel(new ImageIcon(GameWindow.class.getResource("/resources/Joker.png")));
		Joker2.setBounds(80, 495, 45, 75);
		contentPane.add(Joker2);
		
		Joker3 = new JLabel(new ImageIcon(GameWindow.class.getResource("/resources/Joker.png")));
		Joker3.setBounds(135, 495, 45, 75);
		contentPane.add(Joker3);
		
		HideCard = new JLabel("");
		HideCard.setBounds(774, 252, 150, 200);
		contentPane.add(HideCard);
		
		JLabel lblNewLabel = new JLabel("Joker Card Bench");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(749, 462, 175, 42);
		contentPane.add(lblNewLabel);
		
		PlayButton = new JButton("Continue");
		PlayButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		PlayButton.setBounds(346, 495, 134, 60);
		contentPane.add(PlayButton);
		PlayButton.addActionListener(this);
		
		JokerButton = new JButton("Joker");
		JokerButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		JokerButton.setBounds(190, 500, 122, 55);
		contentPane.add(JokerButton);
		JokerButton.addActionListener(this);
		this.setVisible(true);
	}
	
	private String CardIcon(int number, char type) {
		String imagePath = "";
		imagePath = "/resources/";
		if(number < 11 && number >= 1) {
			imagePath += number;	
		}else {
			if(number == 11) {
				imagePath += "J";	
			}else if(number ==12) {
				imagePath += "Q";	
			}else if (number ==13) {
				imagePath += "K";	
			}
		}
		if(type == 'c') {
			imagePath += "C.png";
		}
		else if(type == 'd') {
			imagePath += "D.png";
		}
		else if(type == 'h') {
			imagePath += "H.png";
		}
		else if(type == 's') {
			imagePath += "S.png";
		}
		
		return imagePath;
	}
	
	public void addCard(Card var,int handIndex) {
		String imagePath = "";
		imagePath = this.CardIcon(var.getNumber(),var.getSuit());
		if(handIndex == 1) { 
			HandCard1.setIcon(new ImageIcon(GameWindow.class.getResource(imagePath)));
		}else if(handIndex == 2) {
			HandCard2.setIcon(new ImageIcon(GameWindow.class.getResource(imagePath)));
		}else if(handIndex == 3) {
			HandCard3.setIcon(new ImageIcon(GameWindow.class.getResource(imagePath)));
		}else if (handIndex == 4) {
			HandCard4.setIcon(new ImageIcon(GameWindow.class.getResource(imagePath)));
		}
	}
	public void discardJoker(int jokerLast) {
		if(jokerLast == 3) {
			Joker3.setIcon(null);
		}
		else if (jokerLast == 2) {
			Joker3.setIcon(null);
		}else if(jokerLast == 1){
			Joker3.setIcon(null);
		}
	}
	public void discardCard(int index) {
		if(index == 1) { 
			HandCard1.setIcon(null);
		}else if(index == 2) {
			HandCard2.setIcon(null);
		}else if(index == 3) {
			HandCard3.setIcon(null);
		}else if (index == 4) {
			HandCard4.setIcon(null);
		}
		
		if(CardDiscarded.getIcon() == null) {
			CardDiscarded.setIcon(new ImageIcon(GameWindow.class.getResource("/resources/init.png")));
		}
	}
	public void hideCard(Card var) {
		HideCard.setIcon(new ImageIcon(GameWindow.class.getResource(CardIcon(var.getNumber(),var.getSuit()))));
	}
	public boolean getUseJoker() {
		return this.useJoker;
	}
	public void setUseJoker(boolean var) {
		this.useJoker = var;
	}
	public boolean getContinue() {
		return this.Continue;
	}
	public void setContinue(boolean var) {
		this.Continue = var;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == PlayButton) {
			this.Continue = true;
		}else if(e.getSource() == JokerButton) {
			this.useJoker = true;
		}
		
	}
}
