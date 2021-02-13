import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LineWeightListener implements ActionListener {
	private Graphics2D g;
	
	public LineWeightListener(Graphics2D g) {
		this.g = g;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem m = (JMenuItem)e.getSource();

		if(m.getText().compareTo("細い") == 0) {
			lineWeight(1);
		}else if(m.getText().compareTo("太い") == 0){
			lineWeight(6);
		}else if(m.getText().compareTo("普通") == 0) {
			lineWeight(3);
		}
	}
	
	public void lineWeight(int n) {
		g.setStroke(new BasicStroke(n));
	}

}