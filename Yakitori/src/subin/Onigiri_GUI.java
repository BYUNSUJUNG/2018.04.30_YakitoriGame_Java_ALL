package subin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Onigiri_GUI extends JFrame {
	private JPanel contentPane;
	private JButton button_start;
	private JButton button_exit;
	private JLabel label_contdown;
	private JPanel panel;
	private Thread cntThread;
	private JPanel panel_sub;
	private JButton button_rice;
	private JLabel label_space1;

	int cnt = 1;
	int tc1 = 0;
	int tc2 = 0;
	int tc3 = 0;

	
	private JLabel label_space2;
	private JLabel label_guestCnt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Onigiri_GUI frame = new Onigiri_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public Onigiri_GUI() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
			}
		});
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel = new JPanel();

		label_contdown = new JLabel();
		label_contdown.setBounds(23, 10, 51, 45);
		label_contdown.setBackground(Color.YELLOW);
		label_contdown.setFont(new Font("Serif", Font.PLAIN, 32));
		label_contdown.setText("30");
		cntThread = new CounterThread(label_contdown);// execute this method as a new thread
		cntThread.start();
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.PREFERRED_SIZE, 674, GroupLayout.PREFERRED_SIZE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE));

		panel_sub = new JPanel();
		panel_sub.setBounds(12, 10, 650, 431);
		panel_sub.setOpaque(false);
		button_rice = new JButton("");
		button_rice.setBounds(334, 10, 94, 86);
		button_rice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon iic = new ImageIcon(getClass().getResource("/tutoring/밥(도마용)1.png"));// 이미지 변경
				label_space1.setIcon(iic);
				tc1 = 0;
			}
		});
		button_rice.setContentAreaFilled(false);// 버튼 뒤에 배경 없애줌

		button_rice.setIcon(new ImageIcon(Onigiri_GUI.class.getResource("/tutoring/\uBC253.png")));

		JButton button_gim = new JButton("");
		button_gim.setBounds(551, 10, 87, 86);
		button_gim.setIcon(new ImageIcon(Onigiri_GUI.class.getResource("/tutoring/\uAE402.png")));
		button_gim.setBackground(Color.BLACK);

		button_gim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 김 이벤트
				ImageIcon iic = new ImageIcon(getClass().getResource("/tutoring/주먹밥_1.png"));// 이미지 변경
				label_space1.setIcon(iic);

				ImageIcon iic2 = new ImageIcon(getClass().getResource("/tutoring/blank1.png"));
				label_space2.setIcon(iic2);
				tc3 = 2;
				
			}
		});

		JButton button_anchovy = new JButton("");
		button_anchovy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon iic = new ImageIcon(getClass().getResource("/tutoring/멸치2.png"));
				label_space2.setIcon(iic);
				tc2 = 1;
			}
		});
		button_anchovy.setBounds(446, 10, 87, 86);
		button_anchovy.setContentAreaFilled(false);
		
		button_anchovy.setIcon(new ImageIcon(Onigiri_GUI.class.getResource("/tutoring/\uBA78\uCE581.png")));

		label_space1 = new JLabel("");
		label_space1.setBounds(161, 145, 212, 190);

		JLabel label_order = new JLabel("\uC8FC\uBB38 : ");
		label_order.setBounds(528, 102, 52, 28);
		label_order.setFont(new Font("경기천년제목V Bold", Font.PLAIN, 18));

		JLabel label_orderName = new JLabel("\uBA78\uCE58");
		label_orderName.setBounds(587, 105, 51, 23);
		label_orderName.setFont(new Font("경기천년제목 Bold", Font.PLAIN, 18));

		JLabel label_guest = new JLabel("\uC190\uB2D8 \uC218");
		label_guest.setBounds(36, 332, 67, 35);
		label_guest.setFont(new Font("HY엽서L", Font.PLAIN, 20));

		label_guestCnt = new JLabel("0");
		label_guestCnt.setBounds(53, 373, 50, 39);

		label_guestCnt.setFont(new Font("HY엽서L", Font.PLAIN, 23));

		label_space2 = new JLabel("");
		label_space2.setBounds(352, 158, 142, 136);

		JButton button_finish = new JButton("\uC644\uC131");
		button_finish.setBackground(Color.LIGHT_GRAY);
		button_finish.setBounds(244, 10, 78, 29);
		button_finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				// 완성버튼
				ImageIcon iic = new ImageIcon(getClass().getResource("/tutoring/blank1.png"));
				label_space2.setIcon(iic);
				label_space1.setIcon(iic);
				for (int i = 1; i <= 4; i++) {
					if (tc1 == 0 && tc2 == 1 && tc3 == 2) {
							label_guestCnt.setText("" + cnt++);
							tc1 = 0;
							tc2 = 0;
							tc3 = 0;
						} else {
							
							tc1 = 0;
							tc2 = 0;
							tc3 = 0;
						}
					}
			}
		});
		button_finish.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 18));
		panel.setLayout(null);
		panel.add(label_contdown);
		panel.add(panel_sub);
		panel_sub.setLayout(null);
		panel_sub.add(label_order);
		panel_sub.add(label_orderName);
		panel_sub.add(label_guestCnt);
		panel_sub.add(label_guest);
		panel_sub.add(label_space1);
		panel_sub.add(button_finish);
		panel_sub.add(button_rice);
		panel_sub.add(button_anchovy);
		panel_sub.add(button_gim);
		panel_sub.add(label_space2);

		JLabel label_background = new JLabel("");
		label_background.setIcon(new ImageIcon(Onigiri_GUI.class.getResource("/tutoring/kicken.jpg")));
		label_background.setBounds(0, 0, 674, 451);
		panel.add(label_background);
		contentPane.setLayout(gl_contentPane);
	}
}
