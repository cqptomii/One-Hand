package viewport;

import javax.swing.JFrame;

public class Window extends JFrame {
	public Window() {
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("TestWindow");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
	}
}
