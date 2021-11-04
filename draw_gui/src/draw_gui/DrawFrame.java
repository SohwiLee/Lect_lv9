package draw_gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DrawFrame extends JFrame implements MouseListener {

	private JButton close = new JButton("close");

	public DrawFrame() {
		super("Let's Draw!");
		setLayout(null);
		setBounds(100, 100, 1000, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		close.setLayout(null);
		close.setBounds(850, 500, 80, 80);
		close.setBackground(Color.white);
		close.addMouseListener(this);
		// closebutton 패널에다 만들 시
		// 패널.close.addActionListener(this);
		// 하단, actionPerformed에서 처리
		
		add(new DrawPanel());
		add(close);

		setVisible(true);
		revalidate();
		// this.dispose(); // this : JFrame < close : 프레임에 적용
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this.close) {
			this.dispose();
		}
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
