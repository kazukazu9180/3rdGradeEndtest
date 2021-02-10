import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

public class MousePaintListener implements MouseInputListener {
	private JFrame frame;
	private Graphics g;
	private int count;
	private int x[],y[];
	private Mode mode;
	private int x1,y1,x2,y2;
	private Point mpoint = null;
	private Point spoint = null;

	public MousePaintListener(JFrame f,Graphics g,Mode mode) {
		this.frame = frame;
		this.g = (Graphics2D) g;
		this.mode = mode;
		this.x = new int[3];
		this.y = new int[3];
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(mode.getMode()==1) {
			count++;
			if(count == 1) {
				x[0] = e.getX();
				y[0] = e.getY();
			}else if(count == 2) {
				x[1] = e.getX();
				y[1] = e.getY();
				
				g.drawLine(x[0], y[0], x[1], y[1]);
				count = 0;
				mode.setMode(0);
			}
		}else if(mode.getMode()==2) {
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
				mode.setMode(0);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("MouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouseexited");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("MousePressed");
		mpoint = null;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("MouseReleased");
		

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("MouseDragged");
		
		if(mpoint != null) {
			spoint = e.getPoint();
			g.drawLine(mpoint.x, mpoint.y, spoint.x, spoint.y);
			
			mpoint.x = spoint.x;
			mpoint.y = spoint.y;
		}
		mpoint = e.getPoint();
		
		
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("MouseMoved");

	}

}