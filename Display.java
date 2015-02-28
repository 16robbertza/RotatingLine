import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Amy Liu and Andrew Robbertz - Period 5 - Last Updated 2/28/15
 * 
 * public Class Display is used to create the visible window used show a rotating line. 
 */
public class Display extends JFrame {

	
	/*
	 * Constructor fore creating Display objects.
	 * Creates a JFrame, sets it to be 500X550 pixels, and resizable. 
	 * 
	 * Creates a LineComponent object to be able to be painted on to the Display. 
	 * 
	 * Creates a button at the top of the Display that can start and stop the rotation of the LineComponent.
	 *  Upon the first click, the line will start to rotate, and on the second it will stop rotating. 
	 *  
	 */
	public Display() {

		JFrame frame = new JFrame("Rotating Lines");
		frame.setLayout(new BorderLayout());
		frame.setSize(500, 550);
		frame.setMinimumSize(new Dimension(500, 550));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);

		LineComponent lineComponent = new LineComponent(frame);
		frame.getContentPane().add(lineComponent, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.setSize(500, 50);
		buttonPanel.setBackground(Color.GRAY);
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);

		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(10, 10, 10, 10);

		JButton start = new JButton("Start / Stop");
		c.gridx = 0;
		c.gridy = 0;
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lineComponent.getRotate()) {
					lineComponent.setRotate(true);
				} else {
					lineComponent.setRotate(false);
				};
			}
		});
		buttonPanel.add(start, c);

		frame.setVisible(true);

	}

	//Main method to call constructor for Display. 
	public static void main(String[] args) {

		new Display();

	}

}