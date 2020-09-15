package Yakitori;

import java.awt.EventQueue;

public class YakitoriTest {

	public static void main(String[] args) {
		
		Yakitori ya = new Yakitori();	//Yakitori

		EventQueue.invokeLater(new Runnable() { //GUI 
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
