import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("PAINT");
		frame.setSize(800,800);
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
		
		colorMenu.add(lineColor);
		colorMenu.add(backgroundColor);
		
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
		paintPanel.setBounds(0,40,800,800);
		
		//informationPanel
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(null);
		infoPanel.setBounds(0,0,800,40);
		
		//Label
		JLabel toolInfo = new JLabel("TOOLS");
		toolInfo.setBounds(5,5,100,30);
		infoPanel.add(toolInfo);
		
		JLabel stampInfo = new JLabel("STAMPS");
		stampInfo.setBounds(180,5,100,30);
		infoPanel.add(stampInfo);
		
		JLabel textInfo = new JLabel("TEXT");
		textInfo.setBounds(345,5,100,30);
		infoPanel.add(textInfo);
		
		//toolCombo
		String[] toolList = {"PEN","RAINBOW PEN","ERASER","STRAIGHT","TRIANGLE","STAMP","TEXT STAMP"};
		JComboBox tool = new JComboBox(toolList);
		tool.setBounds(50,5,120,30);
		infoPanel.add(tool);
		
		//stampCombo
		String[] stampList = {"SQUARE","TRIANGLE","CIRCLE","STAR"};
		JComboBox stamp = new JComboBox(stampList);
		stamp.setBounds(233,5,100,30);
		infoPanel.add(stamp);
		stamp.setEnabled(false);
		
		//TextField
		JTextField text = new JTextField(10);
		text.setBounds(378,5,150,30);
		infoPanel.add(text);
		text.setEnabled(false);
		
		frame.add(paintPanel);
		frame.add(infoPanel);
		frame.setVisible(true);

		Graphics2D g = (Graphics2D) paintPanel.getGraphics();
		
		MousePaintListener printListener = new MousePaintListener(frame,g,tool,stamp,paintPanel,text);
		paintPanel.addMouseListener(printListener);
		paintPanel.addMouseMotionListener(printListener);
		
		LineWeightListener lineweightListener = new LineWeightListener(g);
		thin.addActionListener(lineweightListener);
		medium.addActionListener(lineweightListener);
		thick.addActionListener(lineweightListener);
		colorMenu.addActionListener(lineweightListener);
		
		SetcolorListener setcolorListener = new SetcolorListener(g,paintPanel);
		lineColor.addActionListener(setcolorListener);
		backgroundColor.addActionListener(setcolorListener);
		
		ToolListener toolListener = new ToolListener(tool,stamp,text);
		tool.addActionListener(toolListener);
		
	}
}