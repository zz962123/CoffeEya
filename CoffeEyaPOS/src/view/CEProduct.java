package view;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;

import model.Detail;
import model.Member;
import model.OrderingDAO;
import model.Product;
import model.ProductDAO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ProductManagementService;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.Color;

public class CEProduct {

	ProductManagementService service = new ProductManagementService();

	private JFrame frame;
	private Member loginUser;
	private JPanel panel;
	private JScrollPane scrollPane;

	private JTable table;
	private JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_3;

	/**
	 * Create the application.
	 */
	public CEProduct(Member loginUser) {
		this.loginUser = loginUser;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.setResizable(false);
		frame.setBounds(150, 150, 684, 589);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		String imgPath3 = this.getClass().getResource(".").getPath() + "..//..//CoffeEyaIMG//bback.png";
		ImageIcon icon3 = new ImageIcon(imgPath3);
		
		panel_3 = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(icon3.getImage(), 0, 0, panel_3.getWidth(), panel_3.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CEMain main = new CEMain(loginUser);
				frame.dispose();
			}
		});
		panel_3.setBounds(560, 22, 78, 78);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);


		panel = new JPanel();
		panel.setBounds(12, 10, 512, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 512, 350);
		panel.add(scrollPane);

		productAll();

		panel_1 = new JPanel();
		panel_1.setBounds(12, 411, 512, 136);
		panel_1.setBackground(new Color(255, 0, 0, 0));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		String imgPath = this.getClass().getResource(".").getPath() + "..//..//CoffeEyaIMG//p_number.png";
		ImageIcon icon = new ImageIcon(imgPath);

		lblNewLabel = new JLabel("") {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, lblNewLabel.getWidth(), lblNewLabel.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_1.add(lblNewLabel);

		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);

		String imgPath1 = this.getClass().getResource(".").getPath() + "..//..//CoffeEyaIMG//p_name.png";
		ImageIcon icon1 = new ImageIcon(imgPath1);

		lblNewLabel_1 = new JLabel("") {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(icon1.getImage(), 0, 0, lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_1.add(lblNewLabel_1);

		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		String imgPath2 = this.getClass().getResource(".").getPath() + "..//..//CoffeEyaIMG//p_price.png";
		ImageIcon icon2 = new ImageIcon(imgPath2);

		lblNewLabel_2 = new JLabel("") {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(icon2.getImage(), 0, 0, lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_1.add(lblNewLabel_2);

		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(546, 131, 100, 417);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 50, 0));

		btnNewButton_1 = new JButton("\uCD94\uAC00");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int infoPNum = Integer.parseInt(textField.getText());
				String infoPName = textField_1.getText();
				int infoPPrice = Integer.parseInt(textField_2.getText());

				Product p = new Product();
				p.setPRO_NUM(infoPNum);
				p.setPRO_NAME(infoPName);
				p.setPRO_PRICE(infoPPrice);

				boolean result = service.productJoin(p);
				if (result) {
					JOptionPane.showMessageDialog(frame, "상품 추가 성공");
					productAll();
				} else {
					JOptionPane.showMessageDialog(frame, "상품 추가 실패");
				}

			}
		});

		JButton btnNewButton_4 = new JButton("\uCD08\uAE30\uD654");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				productAll();
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		panel_2.add(btnNewButton_4);
		panel_2.add(btnNewButton_1);

		btnNewButton_2 = new JButton("\uC218\uC815");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int infoPNum = Integer.parseInt(textField.getText());
				String infoPName = textField_1.getText();
				int infoPPrice = Integer.parseInt(textField_2.getText());

				Product p = new Product();
				p.setPRO_NUM(infoPNum);
				p.setPRO_NAME(infoPName);
				p.setPRO_PRICE(infoPPrice);

				boolean result = service.productModify(p);
				if (result == false) {
					JOptionPane.showMessageDialog(frame, "해당 상품이 존재하지 않습니다.");
				} else {
					JOptionPane.showMessageDialog(frame, "수정 완료");
					productAll();
				}
			}
		});
		panel_2.add(btnNewButton_2);

		btnNewButton_3 = new JButton("\uC0AD\uC81C");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int infoPNum = Integer.parseInt(textField.getText());
				Product p = new Product();
				p.setPRO_NUM(infoPNum);

				boolean result = service.productDelete(p);

				if (result) {
					JOptionPane.showMessageDialog(frame, "삭제 성공");
					productAll();
				} else {
					JOptionPane.showMessageDialog(frame, "삭제 실패");
				}
			}
		});
		panel_2.add(btnNewButton_3);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 370, 160, 21);
		frame.getContentPane().add(comboBox);

	}

	private void productAll() {
		String[] columnNames = { "상품 번호", "상품 이름", "상품 가격" };
		ArrayList<Product> list = service.productLookup();
		Object[][] data = new Object[list.size()][3];
		Product p = new Product();
		for (int i = 0; i < list.size(); i++) {
			p = list.get(i);
			int PRO_NUM = p.getPRO_NUM();
			String PRO_NAME = p.getPRO_NAME();
			int PRO_PRICE = p.getPRO_PRICE();
			data[i] = new Object[] { PRO_NUM, PRO_NAME, PRO_PRICE };
		}
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();

		// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// 정렬할 테이블의 ColumnModel을 가져옴
		TableColumnModel tcmSchedule = table.getColumnModel();

		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				textField.setText((int) table.getValueAt(index, 0) + "");
				textField_1.setText((String) table.getValueAt(index, 1));
				textField_2.setText((int) table.getValueAt(index, 2) + "");
			}
		});
		scrollPane.setViewportView(table);
	}
}
