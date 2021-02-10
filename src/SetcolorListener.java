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
		this.backgroundColor = null;	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem m = (JMenuItem)e.getSource();

		if(m.getText().compareTo("�y���F�̐ݒ�") == 0) {
			Color penColor = JColorChooser.showDialog(null, "�y���F��I��", g.getColor());
			g.setColor(penColor);
		}else if(m.getText().compareTo("�w�i�F�̐ݒ�") == 0){
			backgroundColor = JColorChooser.showDialog(null, "�w�i�F��I��", g.getColor());
			panel.setBackground(backgroundColor);
			//g.setColor(backgroundColor);
		}else if(m.getText().compareTo("�L�����p�X�����Z�b�g") == 0) {
			if(backgroundColor == null) {
				panel.setBackground(Color.WHITE);
			}else {
				panel.setBackground(backgroundColor);
			}
		}
		
	}	

}
