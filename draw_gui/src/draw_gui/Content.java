package draw_gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

public class Content extends Util {

	// 목표1 : 사각형 여럿 그리기
	// 목표2 : 심화 - 삼각형도 그리기

	public JButton close = new JButton("close");
	private JButton[] choice = new JButton[3];
	private boolean[] drawCheck = new boolean[3];

	// 그려지는 객체
	private int shapeX, shapeY, shapeW, shapeH;
	ArrayList<Nemo> nemos = new ArrayList<>();// 마우스 릴리즈시 배열안에 고정!, for문 돌려 paintcomponent에 넣기
	ArrayList<Round> rounds = new ArrayList<>();
	private int x1, x2, x3, y1, y2, y3;
	ArrayList<Triangle> triangles = new ArrayList<>();

	private int x, y, startX, startY, xx, yy;
	private Nemo nemo = null; // 드래그 하는 동안 현재 그리고 있는 네모
	private Round round = null;
	private Triangle triangle = null;

	public Content() {
		setLayout(null);
		setBounds(0, 0, 900, 700);

		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		addKeyListener(this);

		setButton();
	}

	private void setButton() {
		this.close.setBounds(750, 550, 100, 50);
		this.close.setBackground(Color.white);
		add(this.close);

		// btns
		int pos = 30;
		String[] text = { "□", "△", "○" };
		for (int i = 0; i < 3; i++) {
			this.choice[i] = new JButton();
			this.choice[i].setBounds(30, pos, 50, 50);
			this.choice[i].setText(text[i]);
			this.choice[i].addActionListener(this);
			// 처음 시작시 사각형그리기 기본 활성화
			if (i == 0) {
				this.choice[i].setBackground(Color.pink);
			} else {
				this.choice[i].setBackground(Color.white);
			}
			add(this.choice[i]);
			pos += 53;
		}
		// 처음 시작시 사각형그리기 기본 활성화
		drawCheck[0] = true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 3; i++) {
			if (e.getSource() == choice[i]) {
				drawCheck[i] = true;
			} else {
				drawCheck[i] = false;
			}

			if (drawCheck[i]) {
				this.choice[i].setBackground(Color.pink);
			} else {
				this.choice[i].setBackground(Color.white);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();
		this.startX = x; // 프레스 시점의 좌표를 고정으로 기억!
		this.startY = y;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		xx = e.getX();
		yy = e.getY();

		// 네모설정
		int width = Math.abs(xx - x);
		int height = Math.abs(yy - y);

		// 예외처리
		if (this.x > xx && width > 1) {
			x = startX - width; // 시작점-width값만큼!
		}
		if (this.y > yy && height > 1) {
			y = startY - height;
		}

		this.nemo = new Nemo(x, y, width, height, Color.blue);
		this.round = new Round(x, y, width, height, Color.orange);
		this.triangle = new Triangle(xx - ((xx - startX) / 2), startX, xx, startY, yy, yy);
//		System.out.println(this.nemo.getX()+", "+ this.nemo.getY()+", "+this.nemo.getWidth()+", "+this.nemo.getHeight());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// 좌표 및 도형기억
		if (drawCheck[0]) {
			nemos.add(new Nemo(shapeX, shapeY, shapeW, shapeH, Color.blue));
		} else if (drawCheck[1]) {
			triangles.add(new Triangle(x1, x2, x3, y1, y2, y3));
		} else if (drawCheck[2]) {
			rounds.add(new Round(shapeX, shapeY, shapeW, shapeH, Color.orange));
		}
//		for (int i = 0; i < this.nemos.size(); i++) {
//			System.out.println(nemos.get(i).getX()+" "+ nemos.get(i).getY() + " " +nemos.get(i).getWidth()+" "+nemos.get(i).getHeight());
//		}
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		// 사각형모음
		for (int i = 0; i < this.nemos.size(); i++) {
			Nemo inOrder = this.nemos.get(i);
			g.setColor(Color.red);
			g.drawRect(inOrder.getX(), inOrder.getY(), inOrder.getWidth(), inOrder.getHeight());
//			System.out.println(inOrder.getX()+", "+ inOrder.getY() + " " +inOrder.getWidth()+" "+inOrder.getHeight());
		}
		// 삼각형모음
		for (int i = 0; i < this.triangles.size(); i++) {
			Triangle inOrder = this.triangles.get(i);
			int[] triX = { inOrder.getX1(), inOrder.getX2(), inOrder.getX3() };
			int[] triY = { inOrder.getY1(), inOrder.getY2(), inOrder.getY3() };
			g.setColor(Color.red);
			g.drawPolygon(triX, triY, 3);
		}
		// 원모음
		for (int i = 0; i < this.rounds.size(); i++) {
			Round inOrder = this.rounds.get(i);
			g.setColor(Color.red);
			g.drawRoundRect(inOrder.getX(), inOrder.getY(), inOrder.getWidth(), inOrder.getHeight(), inOrder.getWidth(),
					inOrder.getHeight());
		}

		// 사각형그리기 스레드
		if (this.drawCheck[0] && this.nemo != null) {
			g.setColor(this.nemo.getC());
			g.drawRect(this.nemo.getX(), this.nemo.getY(), this.nemo.getWidth(), this.nemo.getHeight());
			shapeX = this.nemo.getX();
			shapeY = this.nemo.getY();
			shapeW = this.nemo.getWidth();
			shapeH = this.nemo.getHeight();
		}

		// 삼각형 그리기
		// drawPolygon(int[],int[],int);
		// (x좌표 배열, y좌표 배열, 꼭지점 개수)
		if (this.drawCheck[1] && this.triangle != null) {
			// sX sY () xx sY
			// sX yy() () xx yy
			int[] xxx = { triangle.getX1(), triangle.getX2(), triangle.getX3() };
			int[] yyy = { triangle.getY1(), triangle.getY2(), triangle.getY3() };
			g.setColor(Color.green);
			g.drawPolygon(xxx, yyy, 3);
			x1 = triangle.getX1();
			x2 = triangle.getX2();
			x3 = triangle.getX3();
			y1 = triangle.getY1();
			y2 = triangle.getY2();
			y3 = triangle.getY3();
		}

		// 원그리기
		if (this.drawCheck[2] && this.round != null) {
			g.setColor(Color.orange);
			g.drawRoundRect(this.round.getX(), this.round.getY(), this.round.getWidth(), this.round.getHeight(),
					this.round.getWidth(), this.round.getHeight());
			shapeX = this.round.getX();
			shapeY = this.round.getY();
			shapeW = this.round.getWidth();
			shapeH = this.round.getHeight();
		}
		requestFocusInWindow();
		repaint();

	}
}
