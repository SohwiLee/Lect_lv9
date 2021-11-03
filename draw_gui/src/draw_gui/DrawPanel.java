package draw_gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

class Square {
	private int x, y, width, height;

	public Square(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}

}

public class DrawPanel extends MyUtil {
	int x;
	int y;
	int width;
	int height;
	Square rect = new Square(x, y, width, height);
	JButton close = new JButton();

	public DrawPanel() {
		setBounds(0, 0, 900, 700);

		setBtn();

		addMouseListener(this);
		addMouseMotionListener(this);

		setFocusable(true);
		addKeyListener(this);

	}

	private void setBtn() {
		setLayout(null);
		this.close.setBounds(700, 500, 80, 80);
		this.close.setText("Close");
		this.close.setBackground(Color.white);
		this.close.setHorizontalAlignment(JLabel.CENTER);
		this.close.addActionListener(this);
		add(this.close);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// ó�� ���� ��ġ Ȯ��
//		System.out.println(e.getX() + "," + e.getY());
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// �巡�׵Ǵ� ��ǥ Ȯ��
		// ó����ġ~������ġ ��ǥ���̷� �簢�� ���� �� �� ����
		// �������� �簢�� �׾���
//		System.out.println(e.getX() + "," + e.getY());
		width = e.getX() - x;
		height = e.getY() - y;
		System.out.println(width+", "+height);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	// keyPress �� shift ������ + �巡�� �� ���簢
	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println(e.getKeyChar());
		if (e.isShiftDown() == true) {
			height=width;
//			if(width>=height) {
//				width=height;
//			}else if(width<=height) {
//				height=width;
//			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		x=0;y=0;width=0;height=0;
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawRect(x, y, width, height);
		
		repaint();
	}

}
