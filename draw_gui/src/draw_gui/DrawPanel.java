package draw_gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class DrawPanel extends MyUtil {
	int startX;
	int startY; // 시작지점
//	int endX;
//	int endY; // 끝지점
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
		// 처음 누른 위치 확인
		startX = e.getX();
		startY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// 떼었을 때 위치 확인
//		endX = e.getX();
//		endY = e.getY();
//		System.out.println((endX - startX) + "," + (endY - startY));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// 드래그되는 좌표 확인
		// 처음위치~지금위치 좌표차이로 사각형 범위 알 수 있음
		// 범위따라 사각형 그어짐
		width = e.getX() - startX;
		height = e.getY() - startY;
		// System.out.println("W:" + width + ", H:" + height);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// keyPress → shift 누르고 + 드래그 → 정사각
		if (e.isShiftDown() == true) {
			if (width > 0 && height < 0) {
				width = -height;
			} else if (width < 0 && height > 0) {
				height = -width;
			} else {
				height = width;
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

		requestFocusInWindow(); // key listener에 대한 포커스 다시 요청
		repaint();
	}

}
