package view;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.CustomerManagementService;
import model.Customer;
import model.Member;
import java.awt.Font;

public class CECusModDel {

	CustomerManagementService service = new CustomerManagementService();

	private JFrame frame;
	private Member loginUser;
	private JTextField textField_1;
	private JTextField textField;
	private JPanel panel_2;
	private JPanel panel;
	private JPanel panel_1;

	/**
	 * Create the application.
	 */
	public CECusModDel(Member loginUser) {
		this.loginUser = loginUser;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 150, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String imgPath = this.getClass().getResource(".").getPath() + "..//..//CoffeEyaIMG//setCoffee.jpg";
		ImageIcon icon = new ImageIcon(imgPath);

		panel_2 = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, panel_2.getWidth(), panel_2.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_2.setBounds(0, 0, 1184, 761);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
				JButton btnNewButton = new JButton("\uB3CC\uC544\uAC00\uAE30");
				btnNewButton.setBounds(844, 350, 100, 100);
				panel_2.add(btnNewButton);
				
						String imgPath1 = this.getClass().getResource(".").getPath() + "..//..//CoffeEyaIMG//textInput.png";
						ImageIcon icon1 = new ImageIcon(imgPath1);

						panel = new JPanel() {
							@Override
							protected void paintComponent(Graphics g) {
								g.drawImage(icon1.getImage(), 0, 0, panel.getWidth(), panel.getHeight(), null);
								setOpaque(false);
								super.paintComponent(g);
							}
						};
						panel.setBounds(231, 237, 569, 100);
						panel_2.add(panel);
						panel.setLayout(null);
						
								textField = new JTextField();
								textField.setHorizontalAlignment(SwingConstants.CENTER);
								textField.setBounds(124, 31, 288, 40);
								panel.add(textField);
								textField.setColumns(10);
								
										JLabel lblNewLabel = new JLabel("\uC0AD\uC81C\uD560 \uC544\uC774\uB514");
										lblNewLabel.setFont(new Font("Yoon® 대한", Font.PLAIN, 17));
										lblNewLabel.setBounds(12, 24, 100, 53);
										lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
										panel.add(lblNewLabel);
										
												JButton button = new JButton("\uC0AD\uC81C");
												button.setFont(new Font("Yoon® 대한", Font.PLAIN, 15));
												button.setBounds(449, 27, 100, 47);
												button.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseClicked(MouseEvent e) {
														int infoId = Integer.parseInt(textField.getText());
														Customer c = new Customer(infoId);
														boolean result = service.customerDelete(c);

														if (result) {
															JOptionPane.showMessageDialog(frame, "삭제 성공");
															frame.dispose(); // 화면 종료
														} else {
															JOptionPane.showMessageDialog(frame, "삭제 실패");
														}
													}
												});
												panel.add(button);
												
												String imgPath2 = this.getClass().getResource(".").getPath() + "..//..//CoffeEyaIMG//textInput.png";
												ImageIcon icon2 = new ImageIcon(imgPath2);

														panel_1 = new JPanel(){
															@Override
															protected void paintComponent(Graphics g) {
																g.drawImage(icon2.getImage(), 0, 0, panel_1.getWidth(), panel_1.getHeight(), null);
																setOpaque(false);
																super.paintComponent(g);
															}
														};
														panel_1.setBounds(231, 432, 569, 81);
														panel_2.add(panel_1);
														panel_1.setLayout(null);
														
																textField_1 = new JTextField();
																textField_1.setHorizontalAlignment(SwingConstants.CENTER);
																textField_1.setBounds(122, 20, 289, 42);
																panel_1.add(textField_1);
																textField_1.setColumns(10);
																
																		JLabel lblNewLabel_1 = new JLabel("\uC218\uC815\uD560 \uC544\uC774\uB514");
																		lblNewLabel_1.setFont(new Font("Yoon® 대한", Font.PLAIN, 17));
																		lblNewLabel_1.setBounds(12, 9, 97, 61);
																		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
																		panel_1.add(lblNewLabel_1);
																		panel_1.add(textField_1);
																		
																				JButton button_1 = new JButton("\uC218\uC815");
																				button_1.setFont(new Font("Yoon® 대한", Font.PLAIN, 15));
																				button_1.setBounds(452, 15, 91, 51);
																				button_1.addMouseListener(new MouseAdapter() {
																					@Override
																					public void mouseClicked(MouseEvent arg0) {
																						int CUS_NUMBER = Integer.parseInt(textField.getText());

																						Customer c = new Customer(CUS_NUMBER);
																						Customer selectUser = service.getInfoCustomer(c);
																						if (selectUser == null) {
																							JOptionPane.showMessageDialog(frame, "해당 아이디가 존재하지 않습니다.");
																						} else {
																							JOptionPane.showMessageDialog(frame, "수정화면으로 넘어갑니다.");
																							CECusModify cusModify = new CECusModify(selectUser);
																							frame.dispose();
																						}

																					}
																				});
																				panel_1.add(button_1);
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame.dispose();
					}
				});

		textField_1 = new JTextField();
		textField_1.setColumns(10);
	}
}
