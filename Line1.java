	import javax.swing.JPanel;
	import java.lang.Math;
	import java.util.ArrayList;
	
	
/*Amy Liu and Andrew Robbertz -  Period 5 - Last update: 2/28/15
 * 
 * This is Line class that represents lines that will be drawn at different angles on a screen.
 * (It's called Line1 because there's another class called Line from the Shapes project)
 * 
 * It has private data drawAngle (the angle in radians that the line will be drawn at), and 
 * the 2D array points (the array of x and y values of the endpoints of the line).
 * 
 * It contains a method getPoints to calculate the endpoints of the line, and a method rotateOnce 
 * that increases the drawAngle by 0.1 radians. 
 * 
 * It also contains a constructor, getters and setters for the drawAngle, and a toString. 
 * 
 */

	public class Line1 {

		private double drawAngle;
		private double [][] points = new double [2][2];
		
		/* Method: 
		 * Constructor for a Line1 object 
		 * 
		 * Parameters:
		 * double drawAngle = the angle (in radians) that the line will be drawn at
		 * double [][] points = array containing the endpoints of the line 
		 * format: |x1, y1|
		 *         |x2, y2|
		 * 
		 */
		public Line1(double drawAngle, double [][] points) {
			this.drawAngle = drawAngle; 
			this.points = points;
		}
		
		
		/* Method: toString for Line objects
		 * 
		 * Returns: a String representation of the Line object
		 */
		public String toString(){
			String s=("Line drawn at an angle of "+ getDrawAngle());
			return s;
		}

		
		/* Method: Getter for drawAngle
		 * 
		 * Returns: the drawAngle
		 */
		public double getDrawAngle() {
			return drawAngle;
		}

		
		/* Method: Setter for drawAngle
		 * 
		 * Parameter: the new drawAngle
		 */
		public void setDrawAngle(double drawAngle) {
			this.drawAngle = drawAngle;
		}
		
		
		/* Method: Rotates the line by changing the drawAngle by 0.1 radians
		 * 
		 * Parameter: 
		 * int direction = the direction the line will rotate in 
		 * (0 is clockwise, 1 is counterclockwise)
		 * 
		 */
		public void rotateOnce(int direction){ 
			if (direction == 0)
				setDrawAngle(getDrawAngle()+0.1);
			if (direction == 1)
				setDrawAngle(getDrawAngle()-0.1); 
		}
		
	
		/* Method: Calculates the endpoints of the line to be drawn on the screen 
		 * based on the drawAngle
		 *  
		 * Parameters:
		 * double width = width of the content pane that the line will be painted on
		 * double height = height of the content pane that the line will be painted on
		 * 
		 * Returns:
		 * 2D array of doubles containing the endpoints of the line in the format
		 *  
		 * |x1, y1|
		 * |x2, y2|
		 */
		public double[][] getPoints(double width, double height){ 
			double[][] points = new double[2][2];
			double startX = width/2;
			double startY = height/2;
	 		double drawAngle = getDrawAngle(); 
	 		double r = 0;
	 		
	 		if (width >=  height ) {
				r = width  / Math.sqrt(2) + 1;
			}
			if (width  < height) {
				r = height / Math.sqrt(2) + 1;
			}
	 		
	 		points[0][0] = r * Math.cos(drawAngle) + startX;
			points[0][1] = r * Math.sin(drawAngle) + startY;
			points[1][0] = r * Math.cos(drawAngle + Math.PI) + startX;
			points[1][1] = r * Math.sin(drawAngle + Math.PI)  + startY;
			

	 		return points;
			
		}
		

		//main method 
		public static void main(String[] args) {
//			Line1 a = new Line1(0);
//			Line1 b = new Line1(2);
			
//			System.out.println(a.toString());
//			System.out.println(b.toString());
//			
//			b.rotateOnce(1);
//			
//			System.out.println(b.toString());


		}

	}
