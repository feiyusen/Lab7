import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class CatchButtonGameV2 extends JFrame implements ActionListener{
	int tot;
	int a;
	int count = 0;
	JButton[] myButton = new JButton[0xff];
	
	CatchButtonGameV2(int rows, int cols) {
		tot = rows * cols;
		a = (int)(Math.random() * tot);
		
		setLayout(new GridLayout(rows, cols));
		for (int i = 0; i < tot; i++) {
			myButton[i] = new JButton();
			myButton[i].addActionListener(this);
			getContentPane().add(myButton[i]);
		}
		
		myButton[a].setText("我在这儿~");
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("请输入行数、列数，用空格隔开：");
		int rows = in.nextInt();
		int cols = in.nextInt();
		in.close();
		if (rows * cols ==1) {
			System.out.println("more than 1, thx!");
			System.exit(1);
		}
		if (rows * cols > 255) {
			System.out.println("less than 256, thx!");
			System.exit(1);
		}
		
		CatchButtonGameV2 game1 = new CatchButtonGameV2(rows, cols);
		game1.setTitle("来点我呀~");
		game1.setSize(1080 * rows, 50 * cols);
		game1.setVisible(true);
		game1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game1.setLocationRelativeTo(null);   
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int b;
		for (JButton jButton : myButton) {
			if (e.getSource() == jButton) {
				if (!jButton.getText().isEmpty()) {
					jButton.setText("");
					do {
						b = (int)(Math.random() * tot);
					} while (a == b);
					a = b;
					myButton[a].setText("我在这儿~");
				}
			}
				
		}
	}

}
