package subin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CounterThread extends Thread {
	private JLabel lblCounter;

	public CounterThread(JLabel lbl) {
		lblCounter = lbl;
	}

	public void run() {
		int cnt = 30;// 이거 0보다 큰 경우 돌아라
		while (cnt >= 0) {
			lblCounter.setText(String.valueOf(cnt));// cnt가 int값이라서 String값을 받아오기 위해 이렇게 썼다
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;//일치하면 전부 빠져나가야하기 때문에 return
			}
			cnt--;
		}
		
	}
}
