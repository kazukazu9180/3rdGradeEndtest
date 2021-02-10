import java.awt.Graphics;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("PEINT");
		frame.setSize(1000,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		
		//MenuBar
		JMenuBar menubar = new JMenuBar();
		JMenu colorMenu = new JMenu("F‚Ì‘I‘ğ");
		JMenu weightMenu = new JMenu("ü‚Ì‘¾‚³");
		menubar.add(colorMenu);
		menubar.add(weightMenu);
		
		//LineWeight
		JMenuItem thin = new JMenuItem("×‚¢");
		JMenuItem medium = new JMenuItem("•’Ê");
		JMenuItem thick = new JMenuItem("‘¾‚¢");
		
		weightMenu.add(thin);
		weightMenu.add(medium);
		weightMenu.add(thick);
		frame.setJMenuBar(menubar);

		frame.setVisible(true);

		Graphics g = frame.getGraphics();
		Mode mode = new Mode();
		
		MousePaintListener printListener = new MousePaintListener(frame,g,mode);
		frame.addMouseListener(printListener);
		frame.addMouseMotionListener(printListener);
		
		ButtonListener buttonListener = new ButtonListener(g,mode);
		thin.addActionListener(buttonListener);
		medium.addActionListener(buttonListener);
		thick.addActionListener(buttonListener);
		colorMenu.addActionListener(buttonListener);
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