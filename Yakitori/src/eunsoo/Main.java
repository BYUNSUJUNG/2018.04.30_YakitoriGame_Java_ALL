package eunsoo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame theFrame = new JFrame("∞‘¿”");
		GamePanel thePanel = new GamePanel();
		Thread theThread = new Thread(thePanel);
		
		theFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				theFrame.setVisible(false);
				theFrame.dispose();
			}
		});
		theFrame.setLocation(500, 200);
		theFrame.setResizable(false);
		theFrame.setSize(700, 500);
		theFrame.add(thePanel);
		theThread.start();
		theFrame.setVisible(true);
	}
}
