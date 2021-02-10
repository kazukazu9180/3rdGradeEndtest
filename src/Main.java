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
		JMenu colorMenu = new JMenu("色の選択");
		JMenu weightMenu = new JMenu("線の太さ");
		menubar.add(colorMenu);
		menubar.add(weightMenu);
		
		//colorMenu
		JMenuItem lineColor = new JMenuItem("ペン色の設定");
		JMenuItem backgroundColor = new JMenuItem("背景色の設定");
		JMenuItem reset = new JMenuItem("キャンパスをリセット");
		
		colorMenu.add(lineColor);
		colorMenu.add(backgroundColor);
		colorMenu.add(reset);
		
		//LineWeight
		JMenuItem thin = new JMenuItem("細い");
		JMenuItem medium = new JMenuItem("普通");
		JMenuItem thick = new JMenuItem("太い");
		
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
		toolInfo.setBounds(5,5,100,30);
		infoPanel.add(toolInfo);
		
		//toolCombo
		String[] toolList = {"PEN","ERASER","STRAIGHT","TRIANGLE"};
		JComboBox tool = new JComboBox(toolList);
		tool.setBounds(50,5,80,30);
		infoPanel.add(tool);
		
		
		frame.add(paintPanel);
		frame.add(infoPanel);
		frame.setVisible(true);

		Graphics2D g = (Graphics2D) paintPanel.getGraphics();
		
		MousePaintListener printListener = new MousePaintListener(frame,g,tool,paintPanel);
		paintPanel.addMouseListener(printListener);
		paintPanel.addMouseMotionListener(printListener);
		
		ButtonListener buttonListener = new ButtonListener(g);
		thin.addActionListener(buttonListener);
		medium.addActionListener(buttonListener);
		thick.addActionListener(buttonListener);
		colorMenu.addActionListener(buttonListener);
		
		SetcolorListener setcolorListener = new SetcolorListener(g,paintPanel);
		lineColor.addActionListener(setcolorListener);
		backgroundColor.addActionListener(setcolorListener);
		reset.addActionListener(setcolorListener);
		
	}
}