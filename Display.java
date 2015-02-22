import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import javax.swing.*;

/*
 * So, I got the line to rotate and stuff, but I haven't done any extra stuff. 
 * I don't think well really have time. 
 * You can just take the rotate() method if you want, but I can change my stuff too if you've done it a better way. 
 * All I would have to do is just change the parameters. 
 * 
 * Best of luck, 
 * Andrew
 */
public class Display extends JFrame {

	private JFrame frame = new JFrame("Rotating Lines");

	public Display() {

		frame.setLayout(new BorderLayout());
		frame.setSize(500, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

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
				if (lineComponent.getStartStop() == 0) {
					lineComponent.setStartStop(1);
					lineComponent.setTimer(true);
				} else {
					lineComponent.setStartStop(0);
					lineComponent.setTimer(false);
				}
				;
			}
		});
		buttonPanel.add(start, c);

		frame.setVisible(true);

	}

	public static void main(String[] args) {

		new Display();

	}

}
