package draw_gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class DrawPanel extends MyUtil {
	int startX;
	int startY; // ��������
	int endX;
	int endY; // ������
	int width;
	int height;

	public DrawPanel() {
		setBounds(20, 20, 800, 600);
		setBackground(Color.white);

		addMouseListener(this);
		addMouseMotionListener(this);

		setFocusable(true);
		addKeyListener(this);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// ó�� ���� ��ġ Ȯ��
		startX = e.getX();
		startY = e.getY();
//		System.out.println(startX + ", " + startY);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// ������ �� ��ġ Ȯ��
		endX = e.getX();
		endY = e.getY();
//		System.out.println(endX + ", " + endY);
		System.out.println((endX - startX) + "," + (endY - startY));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// �巡�׵Ǵ� ��ǥ Ȯ��
		// ó����ġ~������ġ ��ǥ���̷� �簢�� ���� �� �� ����
		// �������� �簢�� �׾���
		width = e.getX() - startX;
		height = e.getY() - startY;
		System.out.println("W:" + width + ", H:" + height);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// keyPress �� shift ������ + �巡�� �� ���簢
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

		if (width > 0 && height < 0) {
			g.drawRect(startX, startY + height, width, -height);
		} else if (width < 0 && height > 0) {
			g.drawRect(startX + width, startY, -width, height);
		} else if (width < 0 && height < 0) {
			g.drawRect(startX + width, startY + height, -width, -height);
		} else {
			g.drawRect(startX, startY, width, height);
		}

		requestFocusInWindow(); // key listener�� ���� ��Ŀ�� �ٽ� ��û
		repaint();
	}

}
