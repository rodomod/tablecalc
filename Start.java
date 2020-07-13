import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Start extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btn_sum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
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
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea display = new JTextArea();
		display.setDropMode(DropMode.INSERT);
		display.setBounds(5, 5, 304, 22);
		display.setToolTipText("");
		display.setFont(new Font("Monospaced", Font.PLAIN, 13));
		contentPane.add(display);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 27, 304, 44);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"OWN", "THU"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Double.class, Double.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(99);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(99);
		table.getColumnModel().getColumn(1).setMinWidth(30);
		scrollPane.setViewportView(table);
		
		btn_sum = new JButton("SUM");
		btn_sum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				double own=(double)table.getValueAt(0,0);
				double thu=(double)table.getValueAt(0,1);
			    String res=String.valueOf(own+thu);
			                  display.setText(res);
			}
		});
		btn_sum.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_sum.setBounds(236, 283, 68, 44);
		contentPane.add(btn_sum);
		
		JLabel lblTablecalculator = new JLabel("Java_Table_Calculator\n       OWN + THU ");
		//lblTablecalculator.setIcon(new ImageIcon(Start.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		lblTablecalculator.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablecalculator.setBackground(Color.BLUE);
		lblTablecalculator.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTablecalculator.setBounds(5, 90, 304, 44);
		contentPane.add(lblTablecalculator);
	}
}
