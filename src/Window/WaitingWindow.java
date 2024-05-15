package Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.GameController;
import score.Score;

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
	private Score HighScore;
	
	private GameController secondWindow;
	

	/**
	 * Create the frame.
	 */
	public WaitingWindow() {
		String filePath = System.getProperty("user.dir");
		filePath += "/src/resources/Score.txt";
		this.HighScore = new Score();
		this.HighScore.getScoreFromFile(filePath);
		setTitle("One Hand");  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 620);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
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
		Play.addActionListener(this);
		
		JLabel ScoreText = new JLabel("High Score :");
		ScoreText.setForeground(new Color(255, 0, 0));
		ScoreText.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		ScoreText.setBounds(227, 341, 174, 69);
		contentPane.add(ScoreText);
		
		String var = "";
		var += this.HighScore.getScore();
		AmountHighScored = new JLabel(var);
		AmountHighScored.setForeground(new Color(0, 0, 0));
		AmountHighScored.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		AmountHighScored.setBounds(411, 351, 85, 48);
		contentPane.add(AmountHighScored);
	
		JLabel DevName = new JLabel("THUNEVIN Fabien    /   FRAISSE Tom");
		DevName.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
		DevName.setBounds(60, 420, 790, 80);
		contentPane.add(DevName);
		
		this.secondWindow = null;
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Play) {
			if(this.secondWindow == null) {
				this.setVisible(false);
				this.secondWindow = new GameController();
				this.secondWindow.start();
			}
		}
	}
}
