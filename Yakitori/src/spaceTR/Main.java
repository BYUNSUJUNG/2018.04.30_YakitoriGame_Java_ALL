package spaceTR;

import java.awt.EventQueue;

/*
 create :  2018.05.01 ~ 2018.05.07
 * */
public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_App frame = new Login_App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} // main of end
} // class of end