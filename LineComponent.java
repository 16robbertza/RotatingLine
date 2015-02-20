import java.awt.*;
import java.awt.geom.Line2D;
import java.util.*;

import javax.swing.*;


public class LineComponent extends JComponent {


	Line2D.Double line;
	
	LineComponent(int width, int height) {
		super();
		setPreferredSize(new Dimension(width,height));
		line = new Line2D.Double();
		
	}


	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		Dimension d = getPreferredSize();
		g.setColor(Color.black);
			g.drawLine(
					(int)line.getX1(),
					(int)line.getY1(),
					(int)line.getX2(),
					(int)line.getY2()
					);
		
	}


}


