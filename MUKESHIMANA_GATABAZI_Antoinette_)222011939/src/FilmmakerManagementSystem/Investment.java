package FilmmakerManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;

public class Investment {

	JFrame frame;
	private JTextField invetxf;
	private JTextField inatxf;
	private JTextField intxf;
	private JTextField protxf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Investment window = new Investment();
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
	public Investment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("INVESTMENT FORM FROM FILMAKER SYSTEM");
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 899, 590);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INVESTMENT FORM IN FILMMAKER SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 765, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel invelb = new JLabel("Invest_id");
		invelb.setFont(new Font("Tahoma", Font.BOLD, 18));
		invelb.setBounds(10, 85, 200, 34);
		frame.getContentPane().add(invelb);
		
		JLabel inalb = new JLabel("Investment_amount");
		inalb.setFont(new Font("Tahoma", Font.BOLD, 18));
		inalb.setBounds(10, 146, 200, 34);
		frame.getContentPane().add(inalb);
		
		JLabel inlb = new JLabel("InvestorName");
		inlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		inlb.setBounds(10, 207, 200, 34);
		frame.getContentPane().add(inlb);
		
		JLabel prolb = new JLabel("ProjectName");
		prolb.setFont(new Font("Tahoma", Font.BOLD, 18));
		prolb.setBounds(10, 275, 206, 34);
		frame.getContentPane().add(prolb);
		
		JButton Insertbtn = new JButton("INSERT");
		Insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm= new Home();
				hm.setVisible(true);
				frame.dispose();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");
					String sql=" INSERT INTO investment VALUES(?,?,?,?)";
					PreparedStatement st=con.prepareStatement(sql);
					st.setInt(1, Integer.parseInt(invetxf.getText()));
					st.setString(2, inatxf.getText());
					st.setString(3, intxf.getText());
					st.setString(4, protxf.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(Insertbtn, "Data saved!!");
					con.close();
					st.close();
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		Insertbtn.setBackground(new Color(255, 255, 128));
		Insertbtn.setForeground(new Color(0, 0, 255));
		Insertbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Insertbtn.setBounds(663, 98, 117, 40);
		frame.getContentPane().add(Insertbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");	
				java.sql.Statement st=con.createStatement();
				String query="SELECT * FROM investment";
				ResultSet rs= st.executeQuery(query);
				ResultSetMetaData rsmd=rs.getMetaData();
				
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int cols=rsmd.getColumnCount();
				String[] colName=new String[cols];
				for(int i=0;i<cols;i++)
					colName[i]=rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				String Invest_id,InvestmentAmount,InvestorName,ProjectnName;
				while(rs.next()) 
				{
				Invest_id=rs.getString(1);
				InvestmentAmount=rs.getString(2);
				InvestorName=rs.getString(3);
				ProjectnName=rs.getString(4);
				String[]row= {Invest_id,InvestmentAmount,InvestorName,ProjectnName};
				model.addRow(row);	
					
					
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		Viewbtn.setBackground(new Color(255, 255, 128));
		Viewbtn.setForeground(Color.BLUE);
		Viewbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Viewbtn.setBounds(663, 145, 117, 40);
		frame.getContentPane().add(Viewbtn);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.setBackground(new Color(255, 255, 128));
		Updatebtn.setForeground(Color.BLUE);
		Updatebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Updatebtn.setBounds(663, 196, 117, 40);
		frame.getContentPane().add(Updatebtn);
		
		JButton Deletebtn = new JButton("DELETE");
		Deletebtn.setBackground(new Color(255, 255, 128));
		Deletebtn.setForeground(new Color(255, 0, 0));
		Deletebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Deletebtn.setBounds(663, 247, 117, 40);
		frame.getContentPane().add(Deletebtn);
		
		invetxf = new JTextField();
		invetxf.setBounds(243, 84, 206, 40);
		frame.getContentPane().add(invetxf);
		invetxf.setColumns(10);
		
		inatxf = new JTextField();
		inatxf.setColumns(10);
		inatxf.setBounds(243, 147, 206, 40);
		frame.getContentPane().add(inatxf);
		
		intxf = new JTextField();
		intxf.setColumns(10);
		intxf.setBounds(243, 208, 206, 40);
		frame.getContentPane().add(intxf);
		
		protxf = new JTextField();
		protxf.setColumns(10);
		protxf.setBounds(243, 272, 206, 40);
		frame.getContentPane().add(protxf);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");	
					
					String sql="SELECT * FROM investment WHERE invest_id=?";
					PreparedStatement st=con.prepareStatement(sql);
					st.setString(1, invetxf.getText());
					ResultSet rs=st.executeQuery();
					if(rs.next()==false) 
				{
						JOptionPane.showMessageDialog(btnNewButton, "please enter your id");
					}
					else {
						inatxf.setText(rs.getString(2));
						intxf.setText(rs.getString(3));
						protxf.setText(rs.getString(4));
					}
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(470, 88, 127, 46);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 323, 831, 219);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		scrollPane.setViewportView(table);
	}
}
