package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.OrderingManagementService;
import controller.ProductManagementService;
import model.Member;
import model.Ordering;
import model.Product;

public class CESale {

	private ProductManagementService pservice = new ProductManagementService();
	private Member loginUser;
	private Product pro;
	private JFrame frame;
	private JTextField txtCoffeeya;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	private JLabel lblNewLabel10;
	private JLabel label_4;
	private JLabel label_1;
	private JLabel label;
	private JButton delrow;

	public String cashcard = "";
	public int totalMoney = 0;
	private ArrayList<String> menuName = new ArrayList<String>();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	OrderingManagementService Oservice = new OrderingManagementService();

	/**
	 * Create the application.
	 * 
	 * @param loginUser
	 * @wbp.parser.entryPoint
	 */
	public CESale(Member loginUser) {
		this.loginUser = loginUser;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 1194, 76);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			// 뒤로가기
			public void mouseClicked(MouseEvent e) {
				CEMain main = new CEMain(loginUser);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(1122, 10, 60, 53);
		panel.add(btnNewButton);

		txtCoffeeya = new JTextField();
		txtCoffeeya.setForeground(Color.WHITE);
		txtCoffeeya.setBackground(Color.DARK_GRAY);
		txtCoffeeya.setFont(new Font("굴림", Font.BOLD, 25));
		txtCoffeeya.setHorizontalAlignment(SwingConstants.CENTER);
		txtCoffeeya.setText("CoffeEya");
		txtCoffeeya.setBounds(12, 10, 270, 53);
		panel.add(txtCoffeeya);
		txtCoffeeya.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(741, 86, 441, 675);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(12, 531, 417, 134);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 5, 5));

		JButton card = new JButton("\uCE74\uB4DC");
		card.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		panel_3.add(card);

		JButton cash = new JButton("\uD604\uAE08");
		cash.addMouseListener(new MouseAdapter() {
			@Override
			// 결제 클릭시 이벤트
			public void mouseClicked(MouseEvent e) {
				cashcard = "현금";
				addorder();
			}
		});
		panel_3.add(cash);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(12, 10, 417, 511);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(12, 10, 393, 162);
		panel_4.add(panel_10);
		panel_10.setLayout(null);

		lblNewLabel10 = new JLabel(totalMoney + " 원");
		lblNewLabel10.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel10.setBounds(200, 22, 167, 43);
		panel_10.add(lblNewLabel10);

		JLabel lblNewLabel = new JLabel("\uCD1D\uB9E4\uCD9C\uC561");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel.setBounds(12, 22, 148, 43);
		panel_10.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uD560\uC778\uAE08\uC561");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(12, 86, 148, 43);
		panel_10.add(lblNewLabel_1);

		label_4 = new JLabel("0 \uC6D0");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("굴림", Font.BOLD, 30));
		label_4.setBounds(200, 86, 167, 43);
		panel_10.add(label_4);

		JPanel panel_11 = new JPanel();
		panel_11.setBounds(12, 183, 391, 128);
		panel_4.add(panel_11);
		panel_11.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("\uBC1B\uC744\uAE08\uC561");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel_2.setBounds(12, 15, 156, 42);
		panel_11.add(lblNewLabel_2);

		// 받을금액
		label_1 = new JLabel("0 \uC6D0");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("굴림", Font.BOLD, 30));
		label_1.setBounds(201, 14, 167, 43);
		panel_11.add(label_1);

		JLabel label_2 = new JLabel("\uC801\uB9BD\uAE08\uC561");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("굴림", Font.BOLD, 24));
		label_2.setBounds(13, 67, 148, 43);
		panel_11.add(label_2);

		// 적립금액
		label = new JLabel("0 \uC6D0");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("굴림", Font.BOLD, 30));
		label.setBounds(201, 67, 167, 43);
		panel_11.add(label);

		// 합계구하기
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 86, 717, 675);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(12, 10, 693, 239);
		panel_2.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(12, 10, 463, 219);
		panel_5.add(panel_6);
		panel_6.setLayout(new CardLayout(0, 0));

		// 주문스크롤
		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane, "name_1462951108600");

		// 컬럼이름 복사, 데이터 복사
		String[] columnNames = { "상품명", "가격", "개수" };
		defaultTableModel = new DefaultTableModel(null, columnNames);
		table = new JTable(defaultTableModel);
		scrollPane.setViewportView(table);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(487, 10, 194, 219);
		panel_5.add(panel_7);
		panel_7.setLayout(null);

		// 주문 삭제버튼
		delrow = new JButton("\uC0AD\uC81C");
		delrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delrow();
			}
		});
		delrow.setBounds(47, 30, 97, 23);
		panel_7.add(delrow);

		// 주문 정보 초기화
		JButton btnNewButton_3 = new JButton("\uCD08\uAE30\uD654");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Row가 0으로 되는 코드, 하지만 초기화 한 번은 가능/두번째부터 오류 발생, 누적 가격도 변화 없음
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setNumRows(0);
				menuName.clear();
				totalMoney = 0;
				lblNewLabel10.setText(totalMoney + " 원");
				label_4.setText(totalMoney / 10 + " 원");
				label_1.setText(totalMoney - (totalMoney / 10) + " 원");
				label.setText(totalMoney / 10 + " 원");
			}
		});
		btnNewButton_3.setBounds(47, 155, 97, 23);
		panel_7.add(btnNewButton_3);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(12, 276, 693, 87);
		panel_2.add(panel_8);
		panel_8.setLayout(new CardLayout(0, 0));

		JPanel panel_9 = new JPanel();
		panel_9.setBounds(12, 373, 693, 292);
		panel_2.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 4, 0, 0));

		// 반복문으로 생성
		ArrayList<Product> list = pservice.productLookup();
		Object[][] data = new Object[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			Product p = list.get(i);
			data[i] = new Object[] { p.getPRO_NAME(), p.getPRO_PRICE() };
		}

		JButton[] JButton10 = new JButton[data.length];
		for (int i = 0; i < data.length; i++) {
			JButton10[i] = new JButton(Arrays.deepToString(data[i]) + "");
			JButton10[i].setPreferredSize(new Dimension(200, 100));
			panel_9.add(JButton10[i]);
		}

		for (int i = 0; i < data.length; i++) {
			final int jnum = i;
			JButton10[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					addrow(jnum, data);
				}
			});
		}
	}

	private void addrow(int jnum, Object[][] data) {
		Object[] row = new Object[3];
		row[0] = data[jnum][0];
		row[1] = data[jnum][1];
		row[2] = 1;
		// ArrayList에 메뉴가 등록되었는지 확인
		int index = menuName.indexOf(data[jnum][0]);

		if (index == -1) {
			menuName.add((String) data[jnum][0]);
			defaultTableModel.addRow(row);
		} else {
			int num = (Integer) defaultTableModel.getValueAt(index, 2);
			defaultTableModel.setValueAt(++num, index, 2);
		}
		totalMoney += (int) row[1];
		lblNewLabel10.setText(totalMoney + " 원");
		label_4.setText(totalMoney / 10 + " 원");
		label_1.setText(totalMoney - (totalMoney / 10) + " 원");
		label.setText(totalMoney / 10 + " 원");
	}

	private void delrow() {
		int row = table.getSelectedRow();
		if (row < 0)
			return;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int valprice = (int) table.getValueAt(row, 1);

		if ((int) model.getValueAt(row, 2) == 1) {
			menuName.remove(row);
			model.removeRow(row);
		} else {
			int num = (Integer) defaultTableModel.getValueAt(row, 2);
			defaultTableModel.setValueAt(--num, row, 2);
		}
		totalMoney -= valprice;
		lblNewLabel10.setText(totalMoney + " 원");
		label_4.setText(totalMoney / 10 + " 원");
		label_1.setText(totalMoney - (totalMoney / 10) + " 원");
		label.setText(totalMoney / 10 + " 원");
	}

	protected void addorder() {
		Date time = new Date(0);
		int row = table.getRowCount();
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		int num = Oservice.OrderingCount();
		String date = format.format(time);
		String pay = cashcard;
		int sum = totalMoney;
		String id = loginUser.getMEM_ID();
		System.out.println(num);

		Ordering o = new Ordering(num, date, pay, sum, id);
		boolean result = Oservice.OrderingJoin(o);
		if (result) {
			JOptionPane.showMessageDialog(frame, "결제 완료");
		} else {
			JOptionPane.showMessageDialog(frame, "결제 오류");
		}
//		for (int i = 0; i < row; i++) {
//			String name = (String) defaultTableModel.getValueAt(i, 0);
//			int price = (int) defaultTableModel.getValueAt(i, 1);
//			int num = (Integer) defaultTableModel.getValueAt(i, 2);
//			
//		}
	}
}
