import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import javax.swing.*;
import javax.swing.Timer;

/* 
 * Amy Liu and Andrew Robbertz - Period 5 - Last Updated 2/28/15
 * 
 * Class LineComponent used to paint 2D lines. 
 * 
 * Private Data:
 * JFrame frame: the frame that the line is to be painted on. 
 * double[] points: the two endpoints of the line, so that they may be accessed in the paintComponent(). 
 * boolean rotate: determines whether or not to rotate the line when updating it on the screen.
 * Line1 ln: the line object that is created, so that the endpoints of the line can be manipulated, and rotated. 
 * Timer timer: used to repaint the line on the display every tenth of a second. 
 */
public class LineComponent extends JComponent {

	private JFrame frame;
	private double[][] points = new double[2][2];
	private boolean rotate;
	private Line1 ln;

	private Timer timer = new Timer(100, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(rotate) ln.rotateOnce(0);			
			points = ln.getPoints(frame.getContentPane().getWidth(), frame.getContentPane().getHeight() - 50);
			LineComponent.this.repaint();
		}
	});

	/*
	 * Constructor for creating LineComnponent objects.
	 * 
	 * Parameters:
	 * Jframe frame: the frame that the line is to be painted on. 
	 * 
	 * Initializes the endpoints to be (0, 0) and (0, 0).
	 * Initializes boolean rotate to false, so they user has to start the rotation of the line.
	 * Initializes Line1 ln to a new Line1 using frame, and a drawAngle of 0. 
	 * Starts the timer to repaint and update the line. 
	 * 
	 */
	LineComponent(JFrame frame) {
		super();
		
		this.frame = frame;
		this.rotate = false;

		points[0][0] = 0;
		points[0][1] = 0;
		points[1][0] = 0;
		points[1][1] = 0;
			
		ln = new Line1(0, points);
		
		timer.start();
		
	}

	/*
	 * Method used to paint the line onto the ContentPane. 
	 * paints the line given the endpoins. 
	 * Sets the stroke to 3 and the color to be Color.BLACK.
	 * 
	 * Parameters: 
	 * Graphics g 
	 * 
	 */
	public void paintComponent(Graphics g) {
		Line2D.Double line = new Line2D.Double(points[0][0], points[0][1], points[1][0], points[1][1]);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.draw(line);
	}

	/*
	 * Getter for private boolean rotate.
	 * 
	 * Returns: 
	 * boolean rotate: whether the line is rotating or not. 
	 */
	public boolean getRotate() {
		return rotate;
	}

	/*
	 * Setter for private boolean rotate. 
	 * 
	 * Parameters:
	 * boolean rotate: true if you wish to have the line rotate, false if not. 
	 */
	public void setRotate(boolean rotate) {
		this.rotate = rotate;
	}
	
}

