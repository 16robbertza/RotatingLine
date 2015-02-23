import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class LineComponent extends JComponent {

	private JFrame frame;
	private Line2D.Double line;
	double[][] points = new double[2][2];
	double theta;
	private int startStop;

	private ActionListener rotation = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// System.out.println(lineToString(line));

			theta += .1;

			// points = rotate(points);
			points = rotate(points, theta, frame);
			line.setLine(points[0][0], points[0][1], points[1][0], points[1][1]);

			LineComponent.this.repaint();
		}
	};

	private Timer timer = new Timer(100, rotation);

	LineComponent(JFrame frame) {
		super();
		
		this.frame = frame;
		this.theta = 0;
		this.startStop = 0;

		points[0][0] = 0;
		points[0][1] = 0;
		points[1][0] = 0;
		points[1][1] = 0;

		line = new Line2D.Double(points[0][0], points[0][1], points[1][0],
				points[1][1]);

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.draw(line);
	}

	public static double[][] rotate(double[][] points) {
		points[0][0] = 0;
		points[0][1] = 0;
		points[1][0] += 20;
		points[1][1] += 20;

		return points;
	}

	public static double[][] rotate(double[][] points, double theta,
			JFrame frame) {
		//double theta = timeElapsed / 57.3;
		// System.out.println("Theta" + theta);
		double r = 0;
		double a = frame.getWidth();
		// System.out.println("Width" + a);
		double b = frame.getHeight();
		// System.out.println("Height" + b);
		if (a >= b) {
			r = frame.getWidth() / Math.sqrt(2) + 1;
		}
		if (a < b) {
			r = frame.getHeight() / Math.sqrt(2) + 1;
		}
		// System.out.println("Radius" + r);

		points[0][0] = r * Math.cos(theta) + frame.getWidth() / 2;
		points[0][1] = r * Math.sin(theta) + frame.getContentPane().getHeight() / 2 - 25;
		points[1][0] = r * Math.cos(theta + Math.PI) + frame.getWidth() / 2;
		points[1][1] = r * Math.sin(theta + Math.PI)  + frame.getContentPane().getHeight() / 2 - 25;

		return points;
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

