package _11_whack_a_mole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class wackAMole implements ActionListener {
	public static void main(String[] args) {
		new wackAMole().createUI();
	
	}
	JFrame frame;
	JPanel panel;
	JButton molebutton = new JButton("Mole");
	static Date timeAtStart = new Date();
	static int molesWhacked;
	void createUI() {
		frame = new JFrame("Wack The Button With Mole To Win!!");
		 panel = new JPanel();
		frame.add(panel);
		int moleloc = new Random().nextInt(24);
		for (int i = 0; i < 24; i++) {
			if (i == moleloc) {
				molebutton.addActionListener(this);
				panel.add(molebutton);

			} else {
				JButton temp = new JButton();
				temp.addActionListener(this);
				panel.add(temp);
			}
		}
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
System.out.println(molesWhacked);
		if (e.getSource() == molebutton) {
			molesWhacked++;
			frame.dispose();
			if(molesWhacked ==10) {
				endGame(timeAtStart,molesWhacked);
			}
		} 
		else {
			speak("u got it wrong");
			frame.dispose();
		}
	
	new wackAMole().createUI();
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
			}
  
	}
	private void endGame(Date timeAtStart, int molesWhacked) { 
	    Date timeAtEnd = new Date();
	    JOptionPane.showMessageDialog(null, "Your whack rate is "
	            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	                  + " moles per second.");
	}
}
