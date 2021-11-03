package snake_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

class SnakePanel extends MyUtil {

	private Rect[][] map = new Rect[10][10];

	private ArrayList<Rect> snake = new ArrayList<>();
	int yy;
	int xx;
	private ArrayList<ArrayList<Integer>> yx = new ArrayList<>();
	private Color head = Color.red;
	private Color body = Color.green;
	private int dir;
	private boolean growTail;

	private ArrayList<Rect> items = new ArrayList<Rect>();
	private ArrayList<ArrayList<Integer>> itemsYx = new ArrayList<ArrayList<Integer>>();

	private JButton[] btns = new JButton[4];
	private JButton reset = new JButton();

	public SnakePanel() {
		setLayout(null);
		setBounds(0, 0, 900, 700);

		setMap();
		setSnake();
		setItems();
		setButtons();
		setReset();

		setFocusable(true);
		addKeyListener(this);

		System.out.println(yx);
	}

	private void setMap() {
		int x = 50;
		int y = 80;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				this.map[i][j] = new Rect(x, y, 50, 50, Color.black);
				x += 50;
			}
			y += 50;
			x = 50;
		}

	}

	private void setSnake() {
		for (int i = 0; i < 4; i++) {
			Rect temp = this.map[0][i];
			Rect nemo = null;
			if (i == 0) {
				nemo = new Rect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), head);
			} else {
				nemo = new Rect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), body);
			}
			this.snake.add(nemo);

			ArrayList<Integer> pair = new ArrayList<>();
			pair.add(0);
			pair.add(i);
			this.yx.add(pair);
//			System.out.println(this.yx);
		}

	}

	private void setItems() {
		Random ran = new Random();
		int n = ran.nextInt(10) + 5;
		for (int i = 0; i < n; i++) {
			int y = ran.nextInt(this.map.length);
			int x = ran.nextInt(this.map.length);

			boolean check = false;
			for (int j = 0; j < this.yx.size(); j++) {
				if (y == this.yx.get(j).get(0) && x == this.yx.get(j).get(1)) {
					check = true;
				}
			}

			if (check) {
				i--;
			} else {
				Rect temp = this.map[y][x];
				Rect item = new Rect(temp.getX() + 10, temp.getY() + 10, temp.getWidth() - 20, temp.getHeight() - 20,
						Color.cyan);
				this.items.add(item);

				ArrayList<Integer> pair = new ArrayList<Integer>();
				pair.add(y);
				pair.add(x);
				this.itemsYx.add(pair);
			}

		}

	}

	private void setReset() {
		this.reset.setBounds(620, 470, 150, 50);
		this.reset.setText("Reset");
		this.reset.setBackground(Color.white);
		this.reset.addMouseListener(this);
		add(this.reset);
	}

	private void setButtons() {
		int x = 670;
		int y = 350;
		String text[] = { "¡ã", "¢¸", "¡å", "¢º" };
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton();
			btns[i].setBounds(x, y, 50, 50);
			btns[i].setBackground(Color.white);
			btns[i].setText(text[i]);
			if (i == 0) {
				x -= 50;
				y += 50;
			} else {
				x += 50;
			}
			btns[i].addMouseListener(this);
			add(btns[i]);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// reset
		if (e.getSource() == this.reset) {
			// item reset
			for (int i = 0; i < this.itemsYx.size(); i++) {
				this.items.remove(i);
				this.itemsYx.remove(i);
			}

			// snake reset
			for (int i = 0; i < this.yx.size(); i++) {
				System.out.println(i);
				yx.clear();
			}
			this.yx = new ArrayList<>();
			ArrayList<Integer> pair = new ArrayList<>();
			pair.add(0);
			pair.add(0);
			this.yx.add(pair);
			System.out.println(yx);
			for (int i = 0; i < snake.size(); i++) {
				this.snake.clear();
			}
			yy = this.yx.get(0).get(0);
			xx = this.yx.get(0).get(1);
			setItems();
			setSnake();

		} else {
			// dir
			if (e.getSource() == this.btns[1]) {// ÁÂ
				this.dir = 1;
			} else if (e.getSource() == this.btns[3]) {// ¿ì
				this.dir = 2;
			} else if (e.getSource() == this.btns[0]) {// »ó
				this.dir = 3;
			} else if (e.getSource() == this.btns[2]) {// ÇÏ
				this.dir = 4;
			}
			move();

		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// snake
		for (int i = 0; i < this.snake.size(); i++) {
			Rect nemo = this.snake.get(i);
			g.setColor(nemo.getC());
			g.fillRect(nemo.getX(), nemo.getY(), nemo.getWidth(), nemo.getHeight());
		}

		// map
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				Rect nemo = this.map[i][j];
				g.setColor(nemo.getC());
				g.drawRect(nemo.getX(), nemo.getY(), nemo.getWidth(), nemo.getHeight());
			}
		}

		// item
		for (int i = 0; i < this.items.size(); i++) {
			Rect nemo = this.items.get(i);
			g.setColor(nemo.getC());
			g.fillRoundRect(nemo.getX(), nemo.getY(), nemo.getWidth(), nemo.getHeight(), nemo.getWidth(),
					nemo.getHeight());
		}

		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_LEFT) {
			this.dir = 1;
		} else if (e.getKeyCode() == e.VK_RIGHT) {
			this.dir = 2;
		} else if (e.getKeyCode() == e.VK_UP) {
			this.dir = 3;
		} else if (e.getKeyCode() == e.VK_DOWN) {
			this.dir = 4;
		}

		move();
	}

	private void move() {
		System.out.println(yx);
		yy = this.yx.get(0).get(0);
		xx = this.yx.get(0).get(1);

		// movement
		if (dir == 1 && xx > 0) {
			xx--;
		} else if (dir == 2 && xx < this.map.length - 1) {
			xx++;
		} else if (dir == 3 && yy > 0) {
			yy--;
		} else if (dir == 4 && yy < this.map.length - 1) {
			yy++;
		}

		// eat items
		for (int i = 0; i < this.itemsYx.size(); i++) {
			if (yy == this.itemsYx.get(i).get(0) && xx == this.itemsYx.get(i).get(1)) {
				this.items.remove(i);
				this.itemsYx.remove(i);// ÁÂÇ¥Á¤º¸µµ °»½Å
				this.growTail = true;
			}
		}

		// check body
		boolean check = false;
		for (int i = 0; i < this.yx.size(); i++) {
			if (yy == this.yx.get(i).get(0) && xx == this.yx.get(i).get(1)) {
				check = true;
			}
		}
		if (!check) {
			Rect tail = this.snake.get(this.snake.size() - 1);
			ArrayList<Integer> tailYx = this.yx.get(this.yx.size() - 1);

			for (int i = this.snake.size() - 1; i > 0; i--) {
				Rect temp = this.snake.get(i - 1);
				temp.setC(body);
				this.snake.set(i, temp);
				this.yx.set(i, this.yx.get(i - 1));
			}

			// head
			Rect temp = this.map[yy][xx];
			Rect newHead = new Rect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), head);
			this.snake.set(0, newHead);

			ArrayList<Integer> pair = new ArrayList<>();
			pair.add(yy);
			pair.add(xx);
			this.yx.set(0, pair);

			if (growTail) {
				this.snake.add(tail);
				this.yx.add(tailYx);
				growTail = false;
			}
		} else {
			System.out.println("Ãæµ¹! »ç¸Á...");
			new Alert();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.dir = 0;
	}

}