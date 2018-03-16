
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ex2 extends JFrame implements KeyListener {
	String sol = null;
	String[] images = { "up.PNG", "left.PNG", "down.PNG", "right.PNG" };
	JLabel[] l_name = new JLabel[15];
	static Ex2 ex2 = new Ex2();
	JPanel jp;
	static int count = 0;
	static int count2 = 1;

	public static void main(String[] args) {
		ex2.run();
	}

	public void run() {

		setSize(700, 400);
		setTitle("미니게임1");

		jp = new JPanel();
		jp.setLayout(new GridLayout(3, 5, 10, 10));

		int num = 0;
		int ranNum = 0;
		String str = "";
		while (num < 15) {
			ranNum = (int) (Math.random() * 4);
			str += ranNum + "";
			jp.add(l_name[num] = new JLabel(new ImageIcon(images[ranNum])));
			l_name[num].addKeyListener(this);
			num++;
		}
		sol = str;

		add(jp);
		setVisible(true);
		for (int i = 0; i < l_name.length; i++) {
			l_name[i].requestFocus();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		char solNum = sol.charAt(count);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:

			if (solNum == '0') {
				l_name[count].setIcon(new ImageIcon("tiger.PNG"));
				count++;
				if (count >= 15) {
					JOptionPane.showMessageDialog(null, "남은 횟수는 "+(3-count2)+"회 입니다.");
					count = 0;
					count2++;
					run();
				}
				if(count2 >=4){
					JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
					System.exit(0);
				}
			}

			break;
		case KeyEvent.VK_LEFT:

			if (solNum == '1') {
				l_name[count].setIcon(new ImageIcon("tiger.PNG"));
				count++;
				if (count >= 15) {
					JOptionPane.showMessageDialog(null, "남은 횟수는 "+(3-count2)+"회 입니다.");
					count = 0;
					count2++;
					run();
				}
				if(count2 >=4){
					JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
					System.exit(0);
				}
			}

			break;
		case KeyEvent.VK_DOWN:

			if (solNum == '2') {
				l_name[count].setIcon(new ImageIcon("tiger.PNG"));
				count++;
				if (count >= 15) {
					JOptionPane.showMessageDialog(null, "남은 횟수는 "+(3-count2)+"회 입니다.");
					count = 0;
					count2++;
					run();
				}
				if(count2 >=4){
					JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
					System.exit(0);
				}
			}

			break;
		case KeyEvent.VK_RIGHT:

			if (solNum == '3') {
				l_name[count].setIcon(new ImageIcon("tiger.PNG"));
				count++;
			}
			if (count >= 15) {
				JOptionPane.showMessageDialog(null, "남은 횟수는 "+(3-count2)+"회 입니다.");
				count = 0;
				count2++;
				run();
			}
			if(count2 >=4){
				JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
				System.exit(0);
			}

			break;
		default:
			System.out.println("방향키를 입력하세요.");
		}

		System.out.println("키 입력 완료");

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
