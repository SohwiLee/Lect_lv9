package draw_gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

public class Content extends Util {

	// ��ǥ1 : �簢�� ���� �׸���
	// ��ǥ2 : ��ȭ - �ﰢ���� �׸���

	public JButton close = new JButton("close");
	private JButton[] choice = new JButton[3];
	private boolean[] drawCheck = new boolean[3];

	// �׷����� ��ü
//	private int shapeX, shapeY, shapeW, shapeH;
	ArrayList<Nemo> nemos = new ArrayList<>();// ���콺 ������� �迭�ȿ� ����!, for�� ���� paintcomponent�� �ֱ�
	ArrayList<Nemo> rounds = new ArrayList<>();
//	private int x1, x2, x3, y1, y2, y3;
	ArrayList<Nemo> triangles = new ArrayList<>();

	private int x, y, startX, startY, xx, yy;
	private Nemo nemo = null; // �巡�� �ϴ� ���� ���� �׸��� �ִ� �׸�
//	private Round round = null;
//	private Triangle triangle = null;

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
		String[] text = { "��", "��", "��" };
		for (int i = 0; i < 3; i++) {
			this.choice[i] = new JButton();
			this.choice[i].setBounds(30, pos, 50, 50);
			this.choice[i].setText(text[i]);
			this.choice[i].addActionListener(this);
			// ó�� ���۽� �簢���׸��� �⺻ Ȱ��ȭ
			if (i == 0) {
				this.choice[i].setBackground(Color.pink);
			} else {
				this.choice[i].setBackground(Color.white);
			}
			add(this.choice[i]);
			pos += 53;
		}
		// ó�� ���۽� �簢���׸��� �⺻ Ȱ��ȭ
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
		this.startX = x; // ������ ������ ��ǥ�� �������� ���!
		this.startY = y;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.x = this.startX; // ����Ʈ Ƣ�� �� ����
		this.y = this.startY;

		xx = e.getX();
		yy = e.getY();

		// �׸���
		int width = drawCheck[1] ? xx - x : Math.abs(xx - x);
		int height = drawCheck[1] ? yy - y : Math.abs(yy - y);

		// ����ó��
		if (this.x > xx && width > 1) {
			x = startX - width; // ������-width����ŭ!
		}
		if (this.y > yy && height > 1) {
			y = startY - height;
		}

		this.nemo = new Nemo(x, y, width, height, Color.blue);
//		this.round = new Round(x, y, width, height, Color.orange);
//		this.triangle = new Triangle(xx - ((xx - startX) / 2), startX, xx, startY, yy, yy);
//		System.out.println(this.nemo.getX()+", "+ this.nemo.getY()+", "+this.nemo.getWidth()+", "+this.nemo.getHeight());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// ��ǥ �� �������
		if (drawCheck[0]) {
			this.nemos.add(this.nemo);
//			nemos.add(new Nemo(shapeX, shapeY, shapeW, shapeH, Color.blue));
		} else if (drawCheck[1]) {
			this.triangles.add(this.nemo);
//			triangles.add(new Triangle(x1, x2, x3, y1, y2, y3));
		} else if (drawCheck[2]) {
			this.rounds.add(this.nemo);
//			rounds.add(new Round(shapeX, shapeY, shapeW, shapeH, Color.orange));
		}
//		for (int i = 0; i < this.nemos.size(); i++) {
//			System.out.println(nemos.get(i).getX()+" "+ nemos.get(i).getY() + " " +nemos.get(i).getWidth()+" "+nemos.get(i).getHeight());
//		}

		this.nemo = null;
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		if (this.nemo != null) {
			g.setColor(this.nemo.getC());
			if (this.drawCheck[0]) {
				// �簢���׸��� ������
				g.drawRect(this.nemo.getX(), this.nemo.getY(), this.nemo.getWidth(), this.nemo.getHeight());
			} else if (this.drawCheck[1]) {
				// �ﰢ�� �׸���
				// drawPolygon(int[],int[],int);
				// (x��ǥ �迭, y��ǥ �迭, ������ ����)
				// sX sY () xx sY
				// sX yy() () xx yy
				int xxx[] = new int[3];
				int yyy[] = new int[3];
				xxx[0] = this.nemo.getX();
				yyy[0] = this.nemo.getY();
				xxx[1] = this.nemo.getX() - (this.nemo.getWidth() / 2);
				yyy[1] = this.nemo.getY() + this.nemo.getHeight();
				xxx[2] = this.nemo.getX() + (this.nemo.getWidth() / 2);
				yyy[2] = this.nemo.getY() + this.nemo.getHeight();
				g.drawPolygon(xxx, yyy, 3);
			} else if (this.drawCheck[2]) {
				g.drawRoundRect(this.nemo.getX(), this.nemo.getY(), this.nemo.getWidth(), this.nemo.getHeight(),
						this.nemo.getWidth(), this.nemo.getHeight());
			}
		}
		for (Nemo n : this.nemos) {
			g.setColor(n.getC());
			g.drawRect(n.getX(), n.getY(), n.getWidth(), n.getHeight());
		}
		for (Nemo n : this.triangles) {
			g.setColor(n.getC());
			int xx[] = new int[3];
			int yy[] = new int[3];
			xx[0] = n.getX();
			yy[0] = n.getY();
			xx[1] = n.getX() - (n.getWidth() / 2);
			yy[1] = n.getY() + n.getHeight();
			xx[2] = n.getX() + (n.getWidth() / 2);
			yy[2] = n.getY() + n.getHeight();
			g.drawPolygon(xx, yy, 3);
		}
		for (Nemo n : this.rounds) {
			g.setColor(n.getC());
			g.drawRoundRect(n.getX(), n.getY(), n.getWidth(), n.getHeight(), n.getWidth(), n.getHeight());
		}
		requestFocusInWindow();
		repaint();

	}
}
