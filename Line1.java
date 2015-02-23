import javax.swing.JPanel;
	import java.lang.Math;
	import java.util.ArrayList;

	public class Line1 {



//		private int numSides;
//		private double radius; //round it? Math.round?
		private double drawAngle;
//		private double length;
		private double PI = Math.PI;
		private double [][] points = new double [2][2];
		
		
		public Line1(double drawAngle, double [][] points) {
//			this.length = length;
			this.drawAngle = drawAngle; 
			this.points = points;
		}
		
		public String toString(){
			String s=("Line drawn at an angle of "+ getDrawAngle());
			return s;
		}
		
//		public int getNumSides() {
//			return numSides;
//		}

//		public void setNumSides(int numSides) {
//			this.numSides = numSides;
//		}

//		public double getRadius() {
//			return radius;
//		}
	//
//		public void setRadius(double radius) {
//			this.radius = radius;
//		}

		public double getDrawAngle() {
			return drawAngle;
		}

		public void setDrawAngle(double drawAngle) {
			this.drawAngle = drawAngle;
		}

//		public double getLength() {
//			return length;
//		}
//
//		public void setLength(double length) {
//			this.length = length;
//		}

		public void rotateOnce(int direction){ //clockwise is 0, counter is 1 ????
			if (direction == 0)
				setDrawAngle(getDrawAngle()+0.1); //increment by one degree --this is also going clockwise
			if (direction == 1)
				setDrawAngle(getDrawAngle()-0.1); //should i make a rotate with a while loop or something?
		}
		
		//method to return a 2D double array of points 
		//public 
		public double[][] getPoints(double width, double height){ //double or int?? //this only works for line for now lol
			double[][] points = new double[2][2];
			double screenAngle = Math.atan(height/width);
//			this.setLength(height/Math.sin(screenAngle));//this?
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
			
			
////			if (drawAngle <= screenAngle){
//				points[0][0] = startX + 0.5 * length * Math.cos(getDrawAngle());//x1
//				points[0][1] = startY + 0.5 * length * Math.sin(getDrawAngle());  //y1 //how to deal with negatives later
//				points[1][0] = startX - 0.5 * length * Math.cos(getDrawAngle());
//				points[0][1] = startY - 0.5 * length * Math.sin(getDrawAngle());
//				
//			}
//	 		if (drawAngle > 0 && drawAngle <= screenAngle || drawAngle > 2*PI - screenAngle && drawAngle <= 2*PI){
//	 			points[0][0] = width; //x1
//				points[0][1] = startY - (0.5 * width * Math.tan(drawAngle));  //y1 
//				points[1][0] = 0; //x2
//				points[1][1] = startY + (0.5 * width * Math.tan(drawAngle)); //y2 dont need +180 i think
//				
//	 		}
//	 		
//	 		if (drawAngle > screenAngle && drawAngle <= PI - screenAngle ){
//	 			points[0][0] = startX + (0.5 * height) / Math.tan(drawAngle); //x1
//				points[0][1] = 0;  //y1 
//				points[1][0] = startX -  (0.5 * height) / Math.tan(drawAngle); //x2
//				points[1][1] = height; //y2
//	 		}
//	 		
//	 		if (drawAngle > PI - screenAngle && drawAngle <= PI + screenAngle){
//	 			points[0][0] = 0; //x1
//				points[0][1] = startY + (0.5 * width * Math.tan(drawAngle));  //y1 
//				points[1][0] = width; //x2
//				points[1][1] = startY - (0.5 * width * Math.tan(drawAngle)); //y2
//	 		}
//			
//	 		if (drawAngle > PI + screenAngle && drawAngle <= 2*PI - screenAngle){
//	 			points[0][0] = startX - (0.5 * height) / Math.tan(drawAngle); //x1
//				points[0][1] = height;  //y1 
//				points[1][0] = startX +  (0.5 * height) / Math.tan(drawAngle); //x2
//				points[1][1] = 0; //y2
//	 		}
			
	 		//this.points = points;
	 		return points;
			//receive frame in constructor or receive dimensions of area painted on
			
		}
		
		public void rotate(Line1 line, int direction, double width, double height){
			
			line.rotateOnce(direction);
			line.getPoints(width, height);
			//errr not sure what to do here
			//need to rotate continuously somehow and return the array of points each rotation
		}
		
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
