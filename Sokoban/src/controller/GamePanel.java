package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import models.Alert;
import models.GameFrame;
import models.MyUtil;
import models.Tile;

public class GamePanel extends MyUtil {
	private Tile[][] map = new Tile[9][8];
	private int[][] mapNum = new int[9][8];

	private int pY;
	private int pX;
	private int dir;// 방향 (1up 2down 3right 4left)

	private int cnt; // BoxGoal개수 // point 총 개수 : 7

	public GamePanel() {
		setLayout(null);
		setBounds(0, 0, GameFrame.width, GameFrame.height);
		setBackground(Color.black);

		setMap();
		setFocusable(true);
		addKeyListener(this);
	}

	private void setMap() {
		int x = 0;
		int y = 0;
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				this.map[i][j] = new Tile(x, y, 70, 70);
				if (i == 2 && j == 2) {
					// PLAYER SETTING
					this.map[i][j].setState(Tile.PLAYER);
					pY = i;
					pX = j;
				} else if (i == 2 && j == 1 || i == 3 && j == 5 || i == 4 && j == 1 || i == 5 && j == 4
						|| i == 6 && j == 6 || i == 7 && j == 4) {
					// point setting
					this.map[i][j].setState(Tile.POINT);
				} else if (i == 6 && j == 1 || i == 6 && j > 3 && j <= 6 || i == 4 && j == 4 || i == 3 && j == 4
						|| i == 2 && j == 3) {
					// box setting
					this.map[i][j].setState(Tile.BOX);
				} else if (i == 6 && j == 3) {
					this.map[i][j].setState(Tile.BOXGOAL);
					cnt++;
				} else if (i == 0 && j < this.map[i].length - 1 || i == this.map.length - 1
						|| j == this.map[i].length - 1 || j == 0 || i == 1 && j >= 0 && j <= 2
						|| i == 3 && j >= 0 && j <= 2 || i == 4 && j >= 2 && j < 4 || i == 5 && j == 2
						|| j == 6 && i <= 5) {
					// wall setting
					this.map[i][j].setState(Tile.WALL);
				} else {
					// ground setting
					this.map[i][j].setState(Tile.GROUND);
				}


				this.map[i][j].setFileName(String.format("images/tile%d.png", map[i][j].getState()));
				x += 70;
//				System.out.print(this.map[i][j].getState());
				 this.mapNum[i][j]=this.map[i][j].getState();
			}
//			System.out.println();
			y += 70;
			x = 0;
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_UP) {
			this.dir = 1;
		} else if (e.getKeyCode() == e.VK_DOWN) {
			this.dir = 2;
		} else if (e.getKeyCode() == e.VK_RIGHT) {
			this.dir = 3;
		} else if (e.getKeyCode() == e.VK_LEFT) {
			this.dir = 4;
		}

		move();
	}

	private void move() {
		if(mapNum[pY][pX]==Tile.POINT) {
			map[pY][pX].setState(Tile.POINT); // 있던 자리 변경(포인트그대로)
		}else {
			map[pY][pX].setState(Tile.GROUND); // 있던 자리 변경(혹은 그라운드)
		}
		if (dir == 1 && pY - 1 >= 0) { // 상
			// 상자O벽X > 같이 움직임, 상자O골O > 상자상태바뀜
			if (map[pY - 1][pX].getState() == Tile.BOX || map[pY - 1][pX].getState() == Tile.BOXGOAL) {
				if (map[pY - 2][pX].getState() != Tile.WALL && map[pY - 2][pX].getState() != Tile.BOX) {
					pY -= 1;
					if (map[pY - 1][pX].getState() == Tile.POINT) {
						map[pY - 1][pX].setState(Tile.BOXGOAL);
						if(mapNum[pY - 1][pX]==Tile.POINT) cnt++;
					} else {
						map[pY - 1][pX].setState(Tile.BOX);
					}
				}
			} else if (map[pY - 1][pX].getState() != Tile.WALL) { // 상자없을시
				pY -= 1;
			}
			map[pY][pX].setState(Tile.PLAYER);
		} else if (dir == 2 && pY + 1 < this.map.length) { // 하
			if (map[pY + 1][pX].getState() == Tile.BOX || map[pY + 1][pX].getState() == Tile.BOXGOAL) {
				if (map[pY + 2][pX].getState() != Tile.WALL && map[pY + 2][pX].getState() != Tile.BOX) {
					pY += 1;
					if (map[pY + 1][pX].getState() == Tile.POINT) {
						map[pY + 1][pX].setState(Tile.BOXGOAL);
						if(mapNum[pY + 1][pX]==Tile.POINT) cnt++;
					} else {
						map[pY + 1][pX].setState(Tile.BOX);
					}
				}
			} else if (map[pY + 1][pX].getState() != Tile.WALL) {
				pY += 1;
			}
			map[pY][pX].setState(Tile.PLAYER);
		} else if (dir == 3 && pX + 1 < this.map[0].length) {// 우
			if (map[pY][pX + 1].getState() == Tile.BOX || map[pY][pX + 1].getState() == Tile.BOXGOAL) {
				if (map[pY][pX + 2].getState() != Tile.WALL && map[pY][pX + 2].getState() != Tile.BOX) {
					pX += 1;
					if (map[pY][pX + 1].getState() == Tile.POINT) {
						map[pY][pX + 1].setState(Tile.BOXGOAL);
						if(mapNum[pY][pX+1]==Tile.POINT) cnt++;
					} else {
						map[pY][pX + 1].setState(Tile.BOX);
					}
				}
			} else if (map[pY][pX + 1].getState() != Tile.WALL) {
				pX += 1;
			}
			map[pY][pX].setState(Tile.PLAYER);
		} else if (dir == 4 && pX - 1 >= 0) {// 좌
			if (map[pY][pX - 1].getState() == Tile.BOX || map[pY][pX - 1].getState() == Tile.BOXGOAL) {
				if (map[pY][pX - 2].getState() != Tile.WALL && map[pY][pX - 2].getState() != Tile.BOX && map[pY][pX - 2].getState() != Tile.BOXGOAL) {
					pX -= 1;
					if (map[pY][pX - 1].getState() == Tile.POINT) {
						map[pY][pX - 1].setState(Tile.BOXGOAL);
						if(mapNum[pY][pX - 1]==Tile.POINT) {cnt++;}
						else {cnt--;}
					} else {
						map[pY][pX - 1].setState(Tile.BOX);
					}
				}
			} else if (map[pY][pX - 1].getState() != Tile.WALL) {
				pX -= 1;
			}
			map[pY][pX].setState(Tile.PLAYER);
		}
		
		if (cnt == 7) {
			new Alert();
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// map
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				Tile m = this.map[i][j];
				// 칸에 따라 다른 이미지 배정
				g.drawImage(m.getImage().getImage(), m.getX(), m.getY(), null);
			}
		}

		repaint();
	}

}
