package Window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class WaitingWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JButton Play;
	protected JLabel AmountHighScored;
	private boolean Continue = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaitingWindow frame = new WaitingWindow();
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
	public WaitingWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel GameTitle = new JLabel("One Hand");
		GameTitle.setFont(new Font("Viner Hand ITC", Font.BOLD, 80));
		GameTitle.setBounds(227, 49, 379, 143);
		contentPane.add(GameTitle);
		
		Play = new JButton("Play");
		Play.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
		Play.setBounds(311, 243, 236, 80);
		contentPane.add(Play);
		
		JLabel ScoreText = new JLabel("High Score :");
		ScoreText.setForeground(new Color(255, 0, 0));
		ScoreText.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		ScoreText.setBounds(227, 341, 174, 69);
		contentPane.add(ScoreText);
		
		AmountHighScored = new JLabel("0");
		AmountHighScored.setForeground(new Color(0, 0, 0));
		AmountHighScored.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		AmountHighScored.setBounds(411, 351, 85, 48);
		contentPane.add(AmountHighScored);
		
		JLabel DevName = new JLabel("THUNEVIN Fabien    /   FRAISSE Tom");
		DevName.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
		DevName.setBounds(60, 420, 790, 80);
		contentPane.add(DevName);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Play) {
			this.setContinue();
		}
	}
	
	private void setContinue() {
		this.Continue = true;
	}
	public boolean getGameState() {
		return this.Continue;
	}

}
