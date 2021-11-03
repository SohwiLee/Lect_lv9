package draw_gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DrawFrame extends JFrame implements MouseListener {
//	private JButton close = new JButton("close");

	public DrawFrame() {
		super("Let's Draw!");
		setLayout(null);
		setBounds(200, 200, 900, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

//		close.setBounds(0, 0, 80, 80);
//		close.setBackground(Color.white);
//		close.addMouseListener(this);
//		add(close);
		

		add(new DrawPanel());

		setVisible(true);
		revalidate();
		// this.dispose(); // this : JFrame < close : 프레임에 적용
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println("GG");
//		if (e.getSource() == this.close) {
//			this.dispose();
//		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
