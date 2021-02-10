import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class SetcolorListener implements ActionListener{
	private Graphics2D g;
	private JPanel panel;
	private Color backgroundColor;
	
	public SetcolorListener(Graphics2D g, JPanel panel) {
		this.g = g;
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem m = (JMenuItem)e.getSource();

		if(m.getText().compareTo("ペン色の設定") == 0) {
			Color penColor = JColorChooser.showDialog(null, "ペン色を選択", g.getColor());
			g.setColor(penColor);
		}else if(m.getText().compareTo("背景色の設定") == 0){
			backgroundColor = JColorChooser.showDialog(null, "背景色を選択", g.getColor());
			panel.setBackground(backgroundColor);
			//g.setColor(backgroundColor);
		}
		
	}	

}
