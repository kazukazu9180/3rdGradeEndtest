import java.awt.Graphics;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("ペイント");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		

		JButton redButton = new JButton("RED");
		redButton.setSize(200,28);
		redButton.setLocation(10,10);
		frame.add(redButton);

		JButton blackButton = new JButton("BLACK");
		blackButton.setSize(200,28);
		blackButton.setLocation(230,10);
		frame.add(blackButton);
		
		JButton lineButton = new JButton("LINE");
		lineButton.setSize(200,28);
		lineButton.setLocation(10,40);
		frame.add(lineButton);
		
		JButton triangleButton = new JButton("TRIANGLE");
		triangleButton.setSize(200,28);
		triangleButton.setLocation(230,40);
		frame.add(triangleButton);

		frame.setVisible(true);

		Graphics g = frame.getGraphics();
		Mode mode = new Mode();
		
		MousePaintListener printListener = new MousePaintListener(frame,g,mode);
		frame.addMouseListener(printListener);
		frame.addMouseMotionListener(printListener);
		
		ButtonListener buttonListener = new ButtonListener(g,mode);
		redButton.addActionListener(buttonListener);
		blackButton.addActionListener(buttonListener);
		lineButton.addActionListener(buttonListener);
		triangleButton.addActionListener(buttonListener);
	}
}

class Mode{
	private int mode;
	
	public int getMode() {
		return mode;
	}
	
	public void setMode(int mode) {
		this.mode = mode;
	}
}