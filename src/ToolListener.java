import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ToolListener implements ActionListener{
	private JComboBox tool;
	private JComboBox stamp;
	private JTextField text;
	
	
	public ToolListener(JComboBox tool, JComboBox stamp, JTextField text) {
		this.tool = tool;
		this.stamp = stamp;
		this.text = text;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(tool.getSelectedIndex() == 5) {
			stamp.setEnabled(true);
		}else {
			stamp.setEnabled(false);
		}
		
		if(tool.getSelectedIndex() == 6) {
			text.setEnabled(true);
		}else {
			text.setEnabled(false);
		}
		
	}

}
