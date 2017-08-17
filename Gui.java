import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.*;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicButtonListener;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Font;
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
		// frame.setSize(500, 500);
		
		// Initialise the buttons (stop/go and insert coin)
		// TODO : icons for each button
		ImageIcon lightbulbIcon = new ImageIcon("img/off.jpg");
		button = new JButton("PRESS ME!");
		button.setHorizontalTextPosition(AbstractButton.CENTER);
		button.setVerticalTextPosition(AbstractButton.TOP);
		button.setMnemonic(MouseEvent.MOUSE_CLICKED);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				controller.press();
			}
		});
		button.setEnabled(true);
		
		// Lightbulb here
		lightbulb = new JLabel(lightbulbIcon);
		
		
		// Put together such that they're laid out vertically
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
		buttonPanel.add(button);
		
		frame.add(buttonPanel, BorderLayout.EAST);
		// frame.add(Box.createRigidArea(new Dimension(70, 0)), BorderLayout.CENTER);
		frame.add(lightbulb);
		
		// Do this last, else the buttons won't show
		// (pack must be last)
		frame.pack();
		frame.setVisible(true);
	}

    public void setLightbulb(String s)
	{
		ImageIcon lightbulbIcon = new ImageIcon(s);
		lightbulb.setIcon(lightbulbIcon);
	}
}
