package Yakitori;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.border.BevelBorder;


public class GUI extends JFrame {

	JLabel progressImg;
	JLabel yakitoriImg;
	
	java.util.Timer timer;  
		
	Yakitori ya = new Yakitori();
	static YakitoriDAO dao = new YakitoriDAO();
	
	Scanner scan = new Scanner(System.in);
	
    int countdown; // 타이머 숫자

	boolean gameStart=false; // true - gameStart
    
    String[] Ingredient = {"select","chicken","vegetable"};
    
    // 재료이미지
    ImageIcon stick= new ImageIcon("img/stick.png");
    ImageIcon chicken= new ImageIcon("img/chicken.png");
    ImageIcon vegetable= new ImageIcon("img/vegetable.png");

    // 야끼토리 이미지
    ImageIcon yakitori_0= new ImageIcon("img/yakitori_0.png");
    ImageIcon yakitori_1= new ImageIcon("img/yakitori_1.png");
    ImageIcon yakitori_2= new ImageIcon("img/yakitori_2.png");
    ImageIcon yakitori_3= new ImageIcon("img/yakitori_3.png");
    ImageIcon yakitori_4= new ImageIcon("img/yakitori_4.png");
    ImageIcon yakitori_5= new ImageIcon("img/yakitori_5.png");
    ImageIcon yakitori_6= new ImageIcon("img/yakitori_6.png");
    ImageIcon yakitori_7= new ImageIcon("img/yakitori_7.png");
    
    // 진행률 이미지
    ImageIcon progress_1= new ImageIcon("img/20%.png");
    ImageIcon progress_2= new ImageIcon("img/40%.png");
    ImageIcon progress_3= new ImageIcon("img/60%.png");
    ImageIcon progress_4= new ImageIcon("img/80%.png");
    ImageIcon progress_5= new ImageIcon("img/100.png");
    
	JLabel yakitori;
    
	boolean isGameStart = false;
	
	private JPanel contentPane;

	
	/**
	 * Launch the application.
	 */

	
	public void yakitoriSelectImg() { // 야끼토리 이미지 출력

		if(ya.yakitoriSelect==0) yakitoriImg.setIcon(yakitori_0);
		else if (ya.yakitoriSelect==1) yakitoriImg.setIcon(yakitori_1);
		else if (ya.yakitoriSelect==2) yakitoriImg.setIcon(yakitori_2);
		else if (ya.yakitoriSelect==3) yakitoriImg.setIcon(yakitori_3);
		else if (ya.yakitoriSelect==4) yakitoriImg.setIcon(yakitori_4);
		else if (ya.yakitoriSelect==5) yakitoriImg.setIcon(yakitori_5);
		else if (ya.yakitoriSelect==6) yakitoriImg.setIcon(yakitori_6);
		else if (ya.yakitoriSelect==7) yakitoriImg.setIcon(yakitori_7);
	}
	
	public void yakitoriProgressImg() { // 진행률 이미지 출력

		if(YakitoriScore.score==1) progressImg.setIcon(progress_1);
		else if (YakitoriScore.score==2) progressImg.setIcon(progress_2);
		else if (YakitoriScore.score==3) progressImg.setIcon(progress_3);
		else if (YakitoriScore.score==4) progressImg.setIcon(progress_4);
		else progressImg.setIcon(progress_5);
	}

   	public static void insertDB_check() { // 데이터베이스 저장
   				
   		YakitoriScore yy = new YakitoriScore(YakitoriScore.id,YakitoriScore.score);
   		
		try {
			dao.insertScore(yy); // 이렇게 하면 데이터 전달을 위한 객체 생성 완료 dto(데이터 전송 객체)의 목적이며 만들어진 형태는 javabeen이다.
		} catch(Exception e) {
			System.out.println("값 저장 실패["+e.getMessage()+"]");
		}   		 		
   	}
 
   	public void replay() { // 게임 다시 시작
   		YakitoriScore.id="";
   		YakitoriScore.score=0;
   		this.setVisible(false);
   		this.setVisible(true);
   	}
   	
   	public void out() { // 게임 종료 
   		YakitoriScore.id="";
   		YakitoriScore.score=0;
   		this.setVisible(false);
   	}
   	
	/**
	 * Create the frame.
	 */
   	
	public GUI() {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 676, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(521, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
		);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("\uC57C\uB07C\uD1A0\uB9AC\uB97C \uB9CC\uB4E4\uC5B4\uC8FC\uC138\uC694");
		lblNewJgoodiesLabel.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		
		JPanel panel_5 = new JPanel(){ ImageIcon i = new ImageIcon("img/stick.png");
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, -20, 400, 200, this);
		} 
	    }; 
	    panel_5.setBounds(0, 0, 800, 200); 
		
		
		JLabel time = DefaultComponentFactory.getInstance().createLabel("30");
		time.setFont(new Font("휴먼모음T", Font.BOLD, 30));
       
		yakitoriImg = new JLabel();
		yakitoriImg.setSize(100, 100);
		yakitoriImg.setForeground(Color.RED);

		JButton btnNewButton = new JButton("START");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		
		btnNewButton.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {
				
				gameStart=true;

				ya.ingredient();
				yakitoriSelectImg();
			
				countdown = 30; //게임 시간 초기화
			    isGameStart = true;   //게임 시작을 알림				

			    timer = new Timer();
			    	timer.schedule(new TimerTask() {
			    
			     @Override
				     public void run() {
					      if (isGameStart) {    
						       
						       countdown--; //1초씩 카운트
						       				       
						       if(countdown< 0)  {
							        timer.cancel();
							        isGameStart = false;
							        Yakitori.idInput();
									insertDB_check();																	
						       }
						       time.setText("" + countdown);     
					      }
				     }
			    }, 0, 1000);
			}
		});

		JLabel label = DefaultComponentFactory.getInstance().createTitle("\uC218\uC815\uB178\uC57C\uB07C\uD1A0\uB9AC\uBBF8\uC138");
		label.setFont(new Font("휴먼모음T", Font.ITALIC, 15));
		label.setBackground(Color.ORANGE);
		
		JLabel label_1 = DefaultComponentFactory.getInstance().createLabel("\uC8FC\uBB38 \uBA54\uB274");
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(33)
									.addComponent(time, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
									.addGap(60))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewJgoodiesLabel)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(yakitoriImg, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addGap(60))))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 677, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_1)
							.addGap(39))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(23, Short.MAX_VALUE)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
							.addComponent(lblNewJgoodiesLabel)
							.addGap(18))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(yakitoriImg, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(time, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel first = new JLabel();
		first.setSize(100, 100);
		first.setForeground(Color.RED);
		
		JLabel second = new JLabel();
		second.setSize(100, 100);
		second.setForeground(Color.RED);
		
		JLabel third  = new JLabel();
		third.setSize(100, 100);
		third.setForeground(Color.RED);
	
		
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(first, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(second, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(third, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(165, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addComponent(third, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
							.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
								.addComponent(second, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
								.addComponent(first, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
							.addContainerGap())))
		);
		panel_5.setLayout(gl_panel_5);
											
											JPanel panel_1 = new JPanel();
											panel_1.setBackground(Color.YELLOW);
											tabbedPane.addTab("Cooking", null, panel_1, null);
											
											JButton make = new JButton("makeButton");
											make.setBackground(Color.WHITE);
											make.setForeground(Color.BLACK);
											make.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {

													if(gameStart==true) { // 타이머 실행 후 게임 play
													
														ya.cooking();

														yakitoriProgressImg();
														
														ya.ingredient();
														yakitoriSelectImg();													
														
													} else {
														System.out.println("타이머를 눌려 게임을 시작해주세요!!");
													}
												}
											});
											
											JComboBox comboBox = new JComboBox(Ingredient);
											comboBox.setBackground(Color.WHITE);
											comboBox.setForeground(Color.BLACK);
											comboBox.addItemListener(new ItemListener() {
												public void itemStateChanged(ItemEvent e) {
													if(gameStart==true) {
														
														 if(comboBox.getSelectedItem().equals("chicken")) {
																first.setIcon(chicken);
																ya.firstNum=0;
															} else if (comboBox.getSelectedItem().equals("vegetable")) {
																first.setIcon(vegetable);
																ya.firstNum=1;
															}
														
													} else {
														System.out.println("타이머를 눌려 게임을 시작해주세요!!");
													}
												}
											});
											
													comboBox.setForeground(Color.RED);
													
													JComboBox comboBox_1 = new JComboBox(Ingredient);
													comboBox_1.setBackground(Color.WHITE);
													comboBox_1.setForeground(Color.BLACK);
													comboBox_1.addItemListener(new ItemListener() {
														public void itemStateChanged(ItemEvent e) {

															if(gameStart==true) { // 타이머 실행 후 게임 play
																
																if(comboBox_1.getSelectedItem().equals("chicken")) {
																	second.setIcon(chicken);
																	ya.secondNum=0;
																} else if (comboBox_1.getSelectedItem().equals("vegetable")) {
																	second.setIcon(vegetable);
																	ya.secondNum=1;
																}
																
															} else {
																System.out.println("타이머를 눌려 게임을 시작해주세요!!");
															}											
														}
													});
													comboBox_1.setForeground(new Color(255, 0, 0));
													
													JComboBox comboBox_2 = new JComboBox(Ingredient);
													comboBox_2.setBackground(Color.WHITE);
													comboBox_2.setForeground(Color.BLACK);
													comboBox_2.addItemListener(new ItemListener() {
														public void itemStateChanged(ItemEvent e) {
															
															
															if(gameStart==true) { // 타이머 실행 후 게임 play
																
																if(comboBox_2.getSelectedItem().equals("chicken")) {
																	third.setIcon(chicken);
																	ya.thirdNum=0;
																} else if (comboBox_2.getSelectedItem().equals("vegetable")) {
																	third.setIcon(vegetable);
																	ya.thirdNum=1;
																}
																
															} else {
																System.out.println("타이머를 눌려 게임을 시작해주세요!!");
															}


														}
													});
													
														comboBox_2.setForeground(Color.RED);
														
														JLabel lblPro = DefaultComponentFactory.getInstance().createLabel("ProgressRate ");
														lblPro.setFont(new Font("휴먼둥근헤드라인", Font.BOLD | Font.ITALIC, 20));
														
														progressImg = DefaultComponentFactory.getInstance().createLabel("");
														progressImg.setSize(100, 100);
														progressImg.setForeground(Color.RED);
														
														
														GroupLayout gl_panel_1 = new GroupLayout(panel_1);
														gl_panel_1.setHorizontalGroup(
															gl_panel_1.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panel_1.createSequentialGroup()
																	.addContainerGap()
																	.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																	.addGap(18)
																	.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																	.addPreferredGap(ComponentPlacement.UNRELATED)
																	.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																	.addGap(18)
																	.addComponent(make)
																	.addGap(51)
																	.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(progressImg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(lblPro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																	.addGap(37))
														);
														gl_panel_1.setVerticalGroup(
															gl_panel_1.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panel_1.createSequentialGroup()
																	.addGap(23)
																	.addComponent(lblPro)
																	.addPreferredGap(ComponentPlacement.RELATED)
																	.addComponent(progressImg, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
																	.addContainerGap())
																.addGroup(gl_panel_1.createSequentialGroup()
																	.addGap(41)
																	.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
																		.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
																		.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
																		.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
																		.addComponent(make, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
																	.addContainerGap(31, Short.MAX_VALUE))
														);
														panel_1.setLayout(gl_panel_1);
											
											JPanel panel_2 = new JPanel();
											panel_2.setBackground(Color.LIGHT_GRAY);
											tabbedPane.addTab("Not Cooking", null, panel_2, null);
											
											JButton replay = new JButton("REPLAY");
											replay.setBackground(Color.WHITE);
											replay.setForeground(Color.BLACK);
											replay.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent arg0) {
													replay();
												}
											});
											
											JButton out = new JButton("OUT");
											out.setBackground(Color.WHITE);
											out.setForeground(Color.BLACK);
											out.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent arg0) {
													out();
												}
											});
											GroupLayout gl_panel_2 = new GroupLayout(panel_2);
											gl_panel_2.setHorizontalGroup(
												gl_panel_2.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_panel_2.createSequentialGroup()
														.addGap(126)
														.addComponent(replay, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
														.addGap(35)
														.addComponent(out, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
														.addContainerGap(161, Short.MAX_VALUE))
											);
											gl_panel_2.setVerticalGroup(
												gl_panel_2.createParallelGroup(Alignment.TRAILING)
													.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
														.addGap(49)
														.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
															.addComponent(out, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
															.addComponent(replay, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
														.addContainerGap(68, Short.MAX_VALUE))
											);
											panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
