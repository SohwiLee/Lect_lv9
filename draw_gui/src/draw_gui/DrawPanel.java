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


	public DrawPanel() {
		setBounds(20, 20, 800, 600);
		setBackground(Color.white);

		addMouseListener(this);
		addMouseMotionListener(this);

		setFocusable(true);
		addKeyListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// 처음 누른 위치 확인
//		System.out.println(e.getX() + "," + e.getY());
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// 드래그되는 좌표 확인
		// 처음위치~지금위치 좌표차이로 사각형 범위 알 수 있음
		// 범위따라 사각형 그어짐
//		System.out.println(e.getX() + "," + e.getY());
		width = e.getX() - x;
		height = e.getY() - y;
//		System.out.println(width + ", " + height);
	}

	// keyPress → shift 누르고 + 드래그 → 정사각
	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println(e.getKeyChar());
		if (e.isShiftDown() == true) {
			if (width != height && width > height) {
				height = width;
			} else if (width != height && width < height) {
				width = height;
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawRect(x, y, width, height);

		repaint();
	}

}
