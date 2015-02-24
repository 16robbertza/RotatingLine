import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class LineComponent extends JComponent {

	private JFrame frame;
	double[][] points = new double[2][2];
	private int startStop;
	private Line1 ln;

	private ActionListener rotation = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//System.out.println(lineToString(line));

			ln.rotateOnce(1);
			points = ln.getPoints(frame.getContentPane().getWidth(), frame.getContentPane().getHeight() - 50);
			
			LineComponent.this.repaint();
		}
	};

	private Timer timer = new Timer(100, rotation);

	LineComponent(JFrame frame) {
		super();
		
		this.frame = frame;
		this.startStop = 0;

		points[0][0] = 0;
		points[0][1] = 0;
		points[1][0] = 0;
		points[1][1] = 0;
			
		ln = new Line1(0, points);
		
	}

	public void paintComponent(Graphics g) {
		Line2D.Double line = new Line2D.Double(points[0][0], points[0][1], points[1][0], points[1][1]);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.draw(line);
	}

	
	public static String lineToString(Line2D.Double line) {
		return "(" + line.getX1() + "," + line.getY1() + ")   (" + line.getX2() + "," + line.getY2() + ")";
	}
	
	public void setTimer(boolean on) {
		if (on)
			timer.start();
		else
			timer.stop();
	}

	public int getStartStop() {
		return startStop;
	}

	public void setStartStop(int startStopSwitch) {
		this.startStop = startStopSwitch;
	}

}

