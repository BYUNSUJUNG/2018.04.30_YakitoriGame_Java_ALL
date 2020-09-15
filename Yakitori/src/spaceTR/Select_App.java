package spaceTR;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import moon.Avoid;
import eunsoo.Main;
import subin.Onigiri_GUI;
import Yakitori.YakitoriTest;

public class Select_App extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Select_App() {
		// 기본구성
		setTitle("선택창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(null);
		
		// 배경화면
		contentPane = new JPanel() {
			ImageIcon i = new ImageIcon(Select_App.class.getResource("/Login_img/select.jpg"));

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 682, 453, null);
			}
		};
		contentPane.setBounds(0, 0, 682, 453);
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		JButton store1 = new JButton("");
		store1.setBounds(51, 51, 190, 174);
		store1.setBackground(Color.white); //클릭 시 배경화면 투명하게
		contentPane.add(store1);
		
		JButton store2 = new JButton("");
		store2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Onigiri_GUI oni = new Onigiri_GUI();
				oni.main(null);
			}
		});
		store2.setIcon(new ImageIcon(Select_App.class.getResource("/Login_img/onigiri.png")));
		store2.setBounds(244, 51, 190, 174);
		store2.setBackground(Color.white); //클릭 시 배경화면 투명하게
		contentPane.add(store2);
		
		JButton store3 = new JButton("");
		store3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Avoid avoid = new Avoid();
				avoid.main(null);
			}
		});
		store3.setIcon(new ImageIcon(Select_App.class.getResource("/Login_img/tako.png")));
		store3.setBounds(438, 51, 190, 174);
		store3.setBackground(Color.white); //클릭 시 배경화면 투명하게
		contentPane.add(store3);
		
		JButton store4 = new JButton("");
		store4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main main = new Main();
				main.main(null);
			}
		});
		store4.setIcon(new ImageIcon(Select_App.class.getResource("/Login_img/ramen.png")));
		store4.setBounds(51, 228, 190, 174);
		store4.setBackground(Color.white); //클릭 시 배경화면 투명하게
		contentPane.add(store4);
		
		JButton store5 = new JButton("");
		store5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				YakitoriTest test  = new YakitoriTest();
				test.main(null);
			}
		});
		store5.setIcon(new ImageIcon(Select_App.class.getResource("/Login_img/kusi.png")));
		store5.setBounds(438, 228, 190, 174);
		store5.setBackground(Color.white); //클릭 시 배경화면 투명하게
		contentPane.add(store5);
	}
}
