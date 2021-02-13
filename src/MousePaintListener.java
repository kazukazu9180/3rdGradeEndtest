import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

public class MousePaintListener implements MouseInputListener {
	private JFrame frame;
	private Graphics g;
	private JComboBox tool;
	private JComboBox stamp;
	private int count;
	private int x[],y[];
	private Point mpoint = null;
	private Point spoint = null;
	private JPanel panel;
	private Color pen;
	private int[] rgb = {255,0,0};
	private boolean rainbow = false;
	private boolean eraser = false;
	private JTextField text;
	
	public MousePaintListener(JFrame frame,Graphics g,JComboBox tool,JComboBox stamp, JPanel panel,JTextField text) {
		this.frame = frame;
		this.g = (Graphics2D) g;
		this.tool = tool;
		this.stamp = stamp;
		this.panel = panel;
		this.x = new int[3];
		this.y = new int[3];
		this.pen = g.getColor();
		this.text = text;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(tool.getSelectedIndex() == 3) {
			straight(e);
		}else if(tool.getSelectedIndex() == 4) {
			triangle(e);
		}else if(tool.getSelectedIndex() == 5) {
			drawStamp(e);
		}else if(tool.getSelectedIndex() == 6){
			mpoint = e.getPoint();
			
			g.drawString(text.getText(), mpoint.x, mpoint.y);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//System.out.println("MouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//System.out.println("Mouseexited");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println("MousePressed");
		mpoint = null;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println("MouseReleased");
		

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//System.out.println("MouseDragged");
		
		if(tool.getSelectedIndex() == 0) {
			toolCheck();
			
			drawPen(e);
			
		}else if(tool.getSelectedIndex() == 1){
			if(!rainbow) {
				rainbow = true;
				pen = g.getColor();
			}
			
			if(rgb[0] == 255 && rgb[1] != 255 && rgb[2] == 0) {
				rgb[1]++;
				g.setColor(new Color(rgb[0],rgb[1],rgb[2]));
			}else if(rgb[0] != 0 && rgb[0] <= 255 && rgb[1] == 255) {
				rgb[0]--;
				g.setColor(new Color(rgb[0],rgb[1],rgb[2]));
			}else if(rgb[1] == 255 && rgb[2] != 255) {
				rgb[2]++;
				g.setColor(new Color(rgb[0],rgb[1],rgb[2]));
			}else if(rgb[1] != 0 && rgb[1] <= 255 && rgb[2] == 255) {
				rgb[1]--;
				g.setColor(new Color(rgb[0],rgb[1],rgb[2]));
			}else if(rgb[2] == 255 && rgb[0] != 255) {
				rgb[0]++;
				g.setColor(new Color(rgb[0],rgb[1],rgb[2]));
			}else if(rgb[2] != 0 && rgb[2] <= 255 && rgb[0] == 255) {
				rgb[2]--;
				g.setColor(new Color(rgb[0],rgb[1],rgb[2]));
			}
			
			drawPen(e);
			
			
			
		}else if(tool.getSelectedIndex() == 2) {
			if(rainbow && !eraser) {
				rainbow = false;
			}else if(!eraser && !rainbow) {
				eraser = true;
				pen = g.getColor();
			}
			
			Color background = panel.getBackground();
			
			if(background != g.getColor()) {
				pen = g.getColor();
			}
			
			g.setColor(background);
			
			mpoint = e.getPoint();
			g.fillOval(mpoint.x, mpoint.y, 10, 10);
			
		}
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//System.out.println("MouseMoved");

	}
	
	public void toolCheck() {
		if(rainbow) {
			rainbow = false;
			g.setColor(pen);
		}else if(eraser) {
			eraser = false;
			g.setColor(pen);
		}
	}
	
	public void straight(MouseEvent e) {
		toolCheck();
		count++;
		if(count == 1) {
			x[0] = e.getX();
			y[0] = e.getY();
		}else if(count == 2) {
			x[1] = e.getX();
			y[1] = e.getY();
			
			g.drawLine(x[0], y[0], x[1], y[1]);
			count = 0;
		}
	}
	
	public void triangle(MouseEvent e) {
		toolCheck();
		count++;
		if(count == 1) {
			x[0] = e.getX();
			y[0] = e.getY();
		}else if(count == 2) {
			x[1] = e.getX();
			y[1] = e.getY();
		}else if(count == 3) {
			x[2] = e.getX();
			y[2] = e.getY();
			
			g.drawLine(x[0], y[0], x[1], y[1]);
			g.drawLine(x[2], y[2], x[1], y[1]);
			g.drawLine(x[0], y[0], x[2], y[2]);
			count = 0;
		}
	}
	
	public void drawPen(MouseEvent e) {
		if(mpoint != null) {
			spoint = e.getPoint();
			g.drawLine(mpoint.x, mpoint.y, spoint.x, spoint.y);
			
			mpoint.x = spoint.x;
			mpoint.y = spoint.y;
		}
		mpoint = e.getPoint();
	}
	
	public void drawStamp(MouseEvent e) {
		toolCheck();
		if(stamp.getSelectedIndex() == 0) {
			mpoint = e.getPoint();
			
			g.drawLine(mpoint.x-25, mpoint.y-25, mpoint.x+25, mpoint.y-25);
			g.drawLine(mpoint.x-25, mpoint.y-25, mpoint.x-25, mpoint.y+25);
			g.drawLine(mpoint.x-25, mpoint.y+25, mpoint.x+25, mpoint.y+25);
			g.drawLine(mpoint.x+25, mpoint.y-25, mpoint.x+25, mpoint.y+25);
		}else if(stamp.getSelectedIndex() == 1) {
			mpoint = e.getPoint();
			
			g.drawLine(mpoint.x, mpoint.y-25, mpoint.x+25, mpoint.y+25);
			g.drawLine(mpoint.x, mpoint.y-25, mpoint.x-25, mpoint.y+25);
			g.drawLine(mpoint.x-25, mpoint.y+25, mpoint.x+25, mpoint.y+25);
		}else if(stamp.getSelectedIndex() == 2) {
			mpoint = e.getPoint();
			
			g.drawOval(mpoint.x-25, mpoint.y-25, 50, 50);
		}else if(stamp.getSelectedIndex() == 3) {
			mpoint = e.getPoint();
			
			g.drawLine(mpoint.x, mpoint.y-25, mpoint.x+25, mpoint.y+25);
			g.drawLine(mpoint.x, mpoint.y-25, mpoint.x-25, mpoint.y+25);
			g.drawLine(mpoint.x-25, mpoint.y+25, mpoint.x+25, mpoint.y+25);
			g.drawLine(mpoint.x, mpoint.y+37, mpoint.x-25, mpoint.y-8);
			g.drawLine(mpoint.x, mpoint.y+37, mpoint.x+25, mpoint.y-8);
			g.drawLine(mpoint.x-25, mpoint.y-8, mpoint.x+25, mpoint.y-8);
		}
	}

}