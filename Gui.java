import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.BorderLayout;

// https://docs.oracle.com/javase/tutorial/uiswing/components/button.html
// https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html
// https://docs.oracle.com/javase/tutorial/uiswing/components/label.html

public class Gui
{
	LightController controller;
	JFrame frame;
	JPanel buttonPanel; // Contains lightbulb
	JButton button;
	JLabel lightbulb;
	
    public void connect(LightController controller)
	{
		this.controller = controller;
	}

    public void init()
	{
		// Initialise the frame
		frame = new JFrame("Lightbulb pls");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // Centre the window
		
		// Initialise the button
		button = new JButton("PRESS ME!");
		button.setMnemonic(MouseEvent.MOUSE_CLICKED);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				controller.press();
			}
		});
		
		lightbulb = new JLabel(new ImageIcon("img/off.jpg"));
		
		// Put together such that they're laid out vertically
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
		buttonPanel.add(button);
		
		frame.add(buttonPanel, BorderLayout.EAST);
		frame.add(lightbulb);
		
		frame.pack();
		frame.setVisible(true);
	}

    public void setLightbulb(String s)
	{
		lightbulb.setIcon(new ImageIcon(s));
	}
}
