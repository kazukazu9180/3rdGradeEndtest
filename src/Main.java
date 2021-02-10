import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("PEINT");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		
		//MenuBar
		JMenuBar menubar = new JMenuBar();
		JMenu colorMenu = new JMenu("êFÇÃëIë");
		JMenu weightMenu = new JMenu("ê¸ÇÃëæÇ≥");
		menubar.add(colorMenu);
		menubar.add(weightMenu);
		
		//LineWeight
		JMenuItem thin = new JMenuItem("ç◊Ç¢");
		JMenuItem medium = new JMenuItem("ïÅí ");
		JMenuItem thick = new JMenuItem("ëæÇ¢");
		
		weightMenu.add(thin);
		weightMenu.add(medium);
		weightMenu.add(thick);
		frame.setJMenuBar(menubar);
		
		//PaintPanel
		JPanel paintPanel = new JPanel();
		paintPanel.setBackground(Color.WHITE);
		paintPanel.setLayout(null);
		paintPanel.setBounds(0,40,500,500);
		
		//informationPanel
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(null);
		infoPanel.setBounds(0,0,500,40);
		
		//Label
		JLabel toolInfo = new JLabel("TOOLS");
		toolInfo.setBounds(5,5,60,30);
		infoPanel.add(toolInfo);
		
		
		//toolCombo
		String[] toolList = {"Pen","STRAIGHT","TRIANGLE"};
		JComboBox tool = new JComboBox(toolList);
		tool.setBounds(50,5,80,30);
		infoPanel.add(tool);
		
		frame.add(paintPanel);
		frame.add(infoPanel);
		frame.setVisible(true);

		Graphics2D g = (Graphics2D) frame.getGraphics();
		Mode mode = new Mode();
		
		MousePaintListener printListener = new MousePaintListener(frame,g,tool);
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