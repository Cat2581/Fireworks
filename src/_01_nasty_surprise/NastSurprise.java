package _01_nasty_surprise;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastSurprise implements ActionListener {

JFrame frame = new JFrame();	
JPanel panel = new JPanel();	
JButton button = new JButton("trick");	
JButton buttonss = new JButton("or");
JButton buttons = new JButton("treat");	
	
	public static void main(String[] args) {
	
		new NastSurprise().createUI();
		
	}
	 void createUI() {
		 
		frame.add (panel); 
		panel.add(button); 
		panel.add(buttonss);
		panel.add(buttons); 
		
		 
		button .addActionListener(this);
		buttons .addActionListener(this);
		buttonss .addActionListener(this);
		
		frame.pack();
		frame.setVisible(true);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button){
			showPictureFromTheInternet("http://www.pethealthnetwork.com/sites/default/files/what-heck-kitten-season-anyway-156615469.jpg");
		}
		if(e.getSource() == buttons){
			showPictureFromTheInternet("https://i.ytimg.com/vi/RNoHcWE8tbQ/maxresdefault.jpg");
		}
		if(e.getSource() == buttonss){
			showPictureFromTheInternet("https://images7.memedroid.com/images/UPLOADED637/5be9955c0c3e7.jpeg");
		}
	}
	private void showPictureFromTheInternet(String imageUrl) {
	    try {
	        URL url = new URL(imageUrl);
	        Icon icon = new ImageIcon(url);
	        JLabel imageLabel = new JLabel(icon);
	        JFrame frame = new JFrame();
	        frame.add(imageLabel);
	        frame.setVisible(true);
	        frame.pack();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	}
	
}
