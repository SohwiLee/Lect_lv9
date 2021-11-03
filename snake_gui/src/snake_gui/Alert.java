package snake_gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Alert extends JFrame{
	private JLabel text = new JLabel();
	public Alert() {
		super("Game Clear!");
		setLayout(null);
//		setBounds(SnakeGame.WIDTH/2 - 150, SnakeGame.HEIGHT-100, 300, 200);
		setBounds(200, 200, 300, 200);
		text.setBounds(0, 0, 300, 200);
		text.setText("¸öÅë°ú Ãâµ¿! »ç¸Á...");
		text.setFont(new Font("",Font.BOLD,25));
		text.setHorizontalAlignment(JLabel.CENTER);
		
		add(text);
		setVisible(true);
		revalidate();
	}
}