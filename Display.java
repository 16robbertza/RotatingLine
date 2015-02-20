import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

import javax.swing.*;


public class Display extends JFrame {

	JFrame frame = new JFrame("Rotating Lines");
	JPanel buttonPanel = new JPanel(new GridBagLayout());
	JPanel linePanel = new JPanel(new BorderLayout());
	LineComponent lineComponent = new LineComponent(frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
	Timer timer = new Timer(100, new ActionListener(){
		public void actionPerformed(ActionEvent e){
			lineComponent.repaint();

			//			Line2D.Double line = new Line2D.Double(
			//					0,0,
			//					frame.getContentPane().getWidth(), frame.getContentPane().getHeight() -50
			//					);
			//			
			//			lineComponent.line = line;
			//			
			//			frame.getContentPane().add(lineComponent);

		}
	});

	public Display(){

		frame.setLayout(new GridBagLayout());
		frame.setSize(500, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);


		buttonPanel.setSize(500 ,50);
		buttonPanel.setBackground(Color.GRAY);
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);


		GridBagConstraints c = new GridBagConstraints();

		c.anchor = GridBagConstraints.CENTER;

		c.insets = new Insets(10, 10, 10, 10);
		JButton start = new JButton("Start");
		c.gridx = 0;
		c.gridy = 0;
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				timer.start();

				Line2D.Double line = new Line2D.Double(
						0,0,
						frame.getContentPane().getWidth(), frame.getContentPane().getHeight() -50
						);

				lineComponent.line = line;

				frame.getContentPane().add(lineComponent);
			}
		});
		buttonPanel.add(start, c);		

		JButton stop = new JButton("Stop");
		c.gridx = 1;
		c.gridy = 0;
		buttonPanel.add(stop, c);
		stop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				timer.stop();
			}
		});

		JSlider speed = new JSlider();
		c.gridx =  2;
		c.gridy = 0;
		buttonPanel.add(speed);


//		Line2D.Double line = new Line2D.Double(
//				0,0,
//				frame.getContentPane().getWidth(), frame.getContentPane().getHeight() -50
//				);
//
//		lineComponent.line = line;
//
//		frame.getContentPane().add(lineComponent);

		frame.setVisible(true);

	}

	public static void main(String[] args) {

		new Display();

		//		Display display = new Display();
		//		
		//		Line2D.Double line = new Line2D.Double(
		//				0,0,
		//				display.frame.getContentPane().getWidth(), display.frame.getContentPane().getHeight() -50
		//				);
		//		
		//		display.lineComponent.line = line;
		//		
		//		display.frame.getContentPane().add(display.lineComponent);
		//		
		//		display.repaint();








	}

}
