package snake_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

class SnakePanel extends MyUtil {
	private final int SIZE = 10;
	private final int mapSize = 50;
	private Rect[][] map;

	private int size; // 길이정보
	private Rect[] snake;
	private boolean isSnake;
	private int xx;
	private int yy;
	private int dir; // 1상 2좌 3하 4우

	private JButton reset; // 리셋버튼
	private JButton[] btn; // 방향키버튼
	String text[] = { "▲", "◀", "▼", "▶" };

	public SnakePanel() {
		setLayout(null);
		setBounds(0, 0, 900, 700);
		setVisible(true);

		setMap();
		setSnake();
		setItems();
		setReset();
		setBtns();
	}

	private void setItems() { // 아이템 랜덤뿌리기
		Random ran = new Random();
		
		int rX = ran.nextInt(SIZE);
		int rY = ran.nextInt(SIZE);
		map[rX][rY].setC(Color.cyan);
//		for(int i=0;i<map.length;i++) {
//			for(int j=0;j<map[i].length;j++) {
//				
//			}
//		}
	}

	private void setSnake() {
		int sX = mapSize;
		int sY = mapSize;
		size = 4;
		snake = new Rect[size];
		for (int i = 0; i < size; i++) {
			snake[i] = new Rect(sX, sY, mapSize, mapSize);
			sX += mapSize;
		}
		
	}

	private void setReset() {
		reset = new JButton();
		reset.setBounds(700, 500, mapSize * 3, mapSize);
		reset.setText("Reset");
		reset.setFont(new Font("", Font.BOLD, 15));
		reset.setBackground(Color.white);
		reset.addActionListener(this);
		reset.setVisible(true);
		add(reset);
	}

	private void setBtns() {
		int btnX = 0;
		int btnY = 0;

		btn = new JButton[4];
		for (int i = 0; i < 4; i++) {
			btn[i] = new JButton();
			btn[i].addActionListener(this);
			btn[i].setText(text[i]);
			btn[i].setBackground(Color.white);
			// setting again
			btn[i].setBounds(btnX + 600, btnY + 300, mapSize, mapSize);
			btnX += mapSize;
			add(btn[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton temp = (JButton) e.getSource();
		for (int i = 0; i < 4; i++) {
			if (temp.getText() == text[i]) {
				dir = (i + 1);
			}
		}
		update();

	}

	private void update() {
		// head
		xx = this.snake[0].getX();
		yy = this.snake[0].getY();
		// 몸통이 있다면 조건 추가

		// 두번째 몸통부터 : 좌우에 있다면 첫째머리와 인접하 방향으로
		// 두번째 몸통부터 : 위에 있다면 같은 방향으로
		if (this.dir == 1 && yy > mapSize && !isSnake) { // 상
			yy -= mapSize;
			System.out.println(isSnake);
		} else if (dir == 2 && xx > mapSize&& !isSnake) { // 좌
			xx -= mapSize;
		} else if (dir == 3 && yy < mapSize * 10&& !isSnake) { // 하
			yy += mapSize;
		} else if (dir == 4 && xx < mapSize * 10&& !isSnake) { // 우
			xx += mapSize;
		}
		this.snake[0].setY(yy);
		this.snake[0].setX(xx);
		
		
	}

	private void setMap() {
		int x = mapSize;
		int y = mapSize;
		map = new Rect[SIZE][SIZE];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Rect(x, y, mapSize, mapSize);
				x += mapSize;
			}
			x = mapSize;
			y += mapSize;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setItems();
		// map
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Rect rect = this.map[i][j];
				Rect tmp = new Rect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
				g.setColor(Color.black);
				g.drawRect(tmp.getX(), tmp.getY(), tmp.getWidth(), tmp.getHeight());

			}
		}
		// snake
		for (int i = 0; i < this.size; i++) {
			Rect snake = this.snake[i];
			Rect tmp = new Rect(snake.getX(), snake.getY(), snake.getWidth(), snake.getHeight());
			if (i == 0) {
				g.setColor(Color.red);
				g.fillRect(tmp.getX(), tmp.getY(), tmp.getWidth(), tmp.getHeight());
			} else {
				g.setColor(Color.blue);
			}
			g.drawRect(tmp.getX(), tmp.getY(), tmp.getWidth(), tmp.getHeight());
		}

		repaint();
	}

}

public class Game extends JFrame {

	private SnakePanel panel = new SnakePanel();

	public Game() {
		super("Snake Game");
		setLayout(null);
		setBounds(100, 100, 900, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(panel);

		setVisible(true);
		revalidate();
	}
}
