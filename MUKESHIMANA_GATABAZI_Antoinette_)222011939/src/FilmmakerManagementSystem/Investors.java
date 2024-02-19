package FilmmakerManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Investors {

	 JFrame frame;
	private JTextField intxf;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField ematxf;
	private JTextField photxf;
	private JTextField natxf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Investors window = new Investors();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Investors() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("WELCOME      INVESTORS    FORM     FILMMAKER    SYSTEM ");
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 888, 613);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INVESTORS FORM IS HERE");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(60, 4, 706, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel inlb = new JLabel("investor_id");
		inlb.setForeground(new Color(255, 255, 255));
		inlb.setFont(new Font("Tahoma", Font.ITALIC, 24));
		inlb.setBounds(4, 88, 149, 31);
		frame.getContentPane().add(inlb);
		
		JLabel fnlb = new JLabel("firstname");
		fnlb.setForeground(new Color(255, 255, 255));
		fnlb.setFont(new Font("Tahoma", Font.ITALIC, 24));
		fnlb.setBounds(4, 129, 149, 31);
		frame.getContentPane().add(fnlb);
		
		JLabel lnlb = new JLabel("lastname");
		lnlb.setForeground(new Color(255, 255, 255));
		lnlb.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lnlb.setBounds(4, 175, 149, 31);
		frame.getContentPane().add(lnlb);
		
		JLabel emalb = new JLabel("email");
		emalb.setForeground(new Color(255, 255, 255));
		emalb.setFont(new Font("Tahoma", Font.ITALIC, 24));
		emalb.setBounds(4, 217, 149, 31);
		frame.getContentPane().add(emalb);
		
		JLabel pholb = new JLabel("phone");
		pholb.setForeground(new Color(255, 255, 255));
		pholb.setFont(new Font("Tahoma", Font.ITALIC, 24));
		pholb.setBounds(4, 256, 149, 31);
		frame.getContentPane().add(pholb);
		
		JLabel nalb = new JLabel("nationality");
		nalb.setForeground(new Color(255, 255, 255));
		nalb.setFont(new Font("Tahoma", Font.ITALIC, 24));
		nalb.setBounds(4, 299, 149, 31);
		frame.getContentPane().add(nalb);
		
		JButton Insertbtn = new JButton("INSERT");
		Insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");
					String sql="INSERT INTO investors VALUES(?,?,?,?,?,?)";
					PreparedStatement stm=con.prepareStatement(sql);
					stm.setInt(1, Integer.parseInt(intxf.getText()));
					stm.setString(2, fntxf.getText());
					stm.setString(3, lntxf.getText());
					stm.setString(4, ematxf.getText());
					stm.setString(5, photxf.getText());
					stm.setString(6, natxf.getText());
					stm.executeLargeUpdate();
					JOptionPane.showMessageDialog(Insertbtn, "entered !!!!!!!!!");
					stm.close();
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		Insertbtn.setForeground(new Color(0, 0, 255));
		Insertbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Insertbtn.setBounds(53, 364, 112, 36);
		frame.getContentPane().add(Insertbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");
				java.sql.Statement st=con.createStatement();
				String query="SELECT *FROM investors";
				ResultSet  rs= st.executeQuery(query);
				ResultSetMetaData rsmd=rs.getMetaData();
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int cols=rsmd.getColumnCount();
				String[] colName=new String[cols];
				for(int i=0; i<cols;i++)
					colName[i]=rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				String investor_id,first_name,last_name,email,phone,nationality;
				while(rs.next()) {
					investor_id=rs.getString(1);
					first_name=rs.getString(2);
					last_name=rs.getString(3);
					email=rs.getString(4);
					phone=rs.getString(5);
					nationality=rs.getString(6);
					String[] row= {investor_id,first_name,last_name,email,phone,nationality};
					model.addRow(row);
				}
				st.close();
				con.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
				
			
				 
			}
		});
		Viewbtn.setForeground(Color.BLUE);
		Viewbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Viewbtn.setBounds(304, 364, 112, 36);
		frame.getContentPane().add(Viewbtn);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");
					String sql="UPDATE investors SET first_name=?,last_name=?,email=?,phone=?,nationality=? WHERE investor_id=?";
					PreparedStatement stm=con.prepareStatement(sql);
					stm.setString(1, fntxf.getText());
					stm.setString(2, lntxf.getText());
					stm.setString(3, ematxf.getText());
					stm.setString(4, photxf.getText());
					stm.setString(5, natxf.getText());
					stm.setInt(6, Integer.parseInt(intxf.getText()));
					JOptionPane.showMessageDialog(Updatebtn, "updated data!!!!!!");
					stm.executeUpdate();
					stm.close();
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		Updatebtn.setForeground(Color.BLUE);
		Updatebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Updatebtn.setBounds(177, 412, 112, 36);
		frame.getContentPane().add(Updatebtn);
		
		intxf = new JTextField();
		intxf.setBounds(224, 91, 251, 31);
		frame.getContentPane().add(intxf);
		intxf.setColumns(10);
		
		fntxf = new JTextField();
		fntxf.setColumns(10);
		fntxf.setBounds(224, 132, 251, 31);
		frame.getContentPane().add(fntxf);
		
		lntxf = new JTextField();
		lntxf.setColumns(10);
		lntxf.setBounds(224, 176, 251, 31);
		frame.getContentPane().add(lntxf);
		
		ematxf = new JTextField();
		ematxf.setColumns(10);
		ematxf.setBounds(224, 218, 251, 31);
		frame.getContentPane().add(ematxf);
		
		photxf = new JTextField();
		photxf.setColumns(10);
		photxf.setBounds(224, 257, 251, 31);
		frame.getContentPane().add(photxf);
		
		natxf = new JTextField();
		natxf.setColumns(10);
		natxf.setBounds(224, 299, 251, 31);
		frame.getContentPane().add(natxf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(485, 51, 366, 514);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(0, 128, 192));
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Home hm=new Home();
				hm.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setBackground(new Color(255, 255, 128));
		btnBack.setForeground(Color.BLUE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(363, 479, 112, 36);
		frame.getContentPane().add(btnBack);
	}
}
