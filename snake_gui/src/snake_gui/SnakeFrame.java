package snake_gui;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame {
	private SnakePanel panel = new SnakePanel();

	public SnakeFrame() {
		super("Snake Game");
		setLayout(null);
		setBounds(100, 100, 900, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(panel);

		setVisible(true);
		revalidate();
	}
}