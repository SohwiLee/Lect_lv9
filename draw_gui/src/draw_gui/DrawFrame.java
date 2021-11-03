package draw_gui;

import javax.swing.JFrame;

public class DrawFrame extends JFrame {
	public DrawFrame() {
		setLayout(null);
		setBounds(200, 200, 900, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		add(new DrawPanel());
		setVisible(true);
		revalidate();
	//  this.dispose(); // this : JFrame < close : 프레임에 적용
	}

}
