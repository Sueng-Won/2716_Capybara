

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ex2 extends JFrame implements KeyListener{
	String sol = null;
	String[] images = {"up.PNG", "left.PNG", "down.PNG", "right.PNG"};
	JTextField[] l_name = new JTextField[8];
	 JPanel jp;
	 int count = 0;

	public static void main(String[] args) {
			new Ex2();
	}
	
	public Ex2(){
		
		setSize(500,300);
		setTitle("미니게임1");
		
		jp =  new JPanel();
		jp.setLayout(new GridLayout(2,4,10,10));
			
		int num=0;
		int ranNum = 0;
		String str = "";
		while(num<8){
			ranNum = (int)(Math.random()*4);
			str += ranNum+"";
//			jp.add(l_name[num] = new JLabel(new ImageIcon(images[ranNum])));
			jp.add(l_name[num] = new JTextField(ranNum+""));
			System.out.println(l_name[num]);
			l_name[num].addKeyListener(this);
			num++;
		}
		sol = str;

		add(jp);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

			char solNum = sol.charAt(count);
			switch(e.getKeyCode()){
			case KeyEvent.VK_UP :
				System.out.println(sol);
				if(solNum=='0'){
					l_name[count].setText("정답");
					count++;
				}
				break;
			case KeyEvent.VK_LEFT :
				if(solNum=='1'){
					l_name[count].setText("정답");
					count++;
				}
				break;
			case KeyEvent.VK_DOWN :
				if(solNum=='2'){
					l_name[count].setText("정답");
					count++;
				}
				break;
			case KeyEvent.VK_RIGHT :
				if(solNum=='3'){
					l_name[count].setText("정답");
					count++;
				}
				break;
			default : System.out.println("방향키를 입력하세요.");
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
