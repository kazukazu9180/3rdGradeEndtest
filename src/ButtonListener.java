import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonListener implements ActionListener {
	private Graphics g;
	private Mode mode;
	
	public ButtonListener(Graphics g,Mode mode) {
		this.g = g;
		this.mode = mode;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();

		if(b.getText().compareTo("RED") == 0) {
			g.setColor(new Color(255,0,0));
		}else if(b.getText().compareTo("BLACK") == 0){
			g.setColor(new Color(0,0,0));
		}else if(b.getText().compareTo("LINE") == 0) {
			mode.setMode(1);
		}else if(b.getText().compareTo("TRIANGLE") == 0) {
			mode.setMode(2);
		}
	}

}