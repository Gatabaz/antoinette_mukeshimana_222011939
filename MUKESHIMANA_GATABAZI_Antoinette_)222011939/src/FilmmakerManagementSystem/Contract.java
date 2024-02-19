package FilmmakerManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

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

public class Contract {

	 JFrame frame;
	private JTextField cotxf;
	private JTextField cttxf;
	private JTextField acttxf;
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
					Contract window = new Contract();
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
	public Contract() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setTitle("CONTRACT FORM IN FILMMAKER SYSTEM");
		frame.setBounds(100, 100, 882, 564);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel colb = new JLabel("ContractID");
		colb.setFont(new Font("Tahoma", Font.BOLD, 24));
		colb.setBounds(10, 108, 161, 30);
		frame.getContentPane().add(colb);
		
		JLabel ctlb = new JLabel("ContractText");
		ctlb.setFont(new Font("Tahoma", Font.BOLD, 24));
		ctlb.setBounds(10, 180, 179, 30);
		frame.getContentPane().add(ctlb);
		
		JLabel actlb = new JLabel("ActorName");
		actlb.setFont(new Font("Tahoma", Font.BOLD, 24));
		actlb.setBounds(10, 247, 168, 30);
		frame.getContentPane().add(actlb);
		
		JLabel inlb = new JLabel("InvestorName");
		inlb.setFont(new Font("Tahoma", Font.BOLD, 24));
		inlb.setBounds(10, 294, 179, 30);
		frame.getContentPane().add(inlb);
		
		JLabel prolb = new JLabel("ProjectName");
		prolb.setFont(new Font("Tahoma", Font.BOLD, 24));
		prolb.setBounds(10, 343, 179, 30);
		frame.getContentPane().add(prolb);
		
		JButton Insertbtn = new JButton("INSERT");
		Insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm=new Home();
				hm.setVisible(true);
				frame.dispose();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");	
				String sql=" INSERT INTO contract VALUES(?,?,?,?,?)";
				PreparedStatement st=con.prepareStatement(sql);		
				st.setInt(1, Integer.parseInt(cotxf.getText()));
				st.setString(2, cttxf.getText());
				st.setString(3, acttxf.getText());
				st.setString(4, intxf.getText());
				st.setString(5, protxf.getText());
				st.executeUpdate();
				JOptionPane.showMessageDialog(Insertbtn, "data saved");
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
		Insertbtn.setBounds(130, 404, 120, 45);
		frame.getContentPane().add(Insertbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");	
			java.sql.Statement st=con.createStatement();
			String query="SELECT * FROM contract";
			ResultSet rs= st.executeQuery(query);
			ResultSetMetaData rsmd=rs.getMetaData();
			
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			int cols=rsmd.getColumnCount();
			String[] colName=new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			String ContractID,ContractText,ActorName,InvestorName,ProjectName;
			while(rs.next())
			{
			ContractID=rs.getString(1);
			ContractText=rs.getString(2);
			ActorName=rs.getString(3);
			InvestorName=rs.getString(4);
			ProjectName=rs.getString(5);
			String[]row= {ContractID,ContractText,ActorName,InvestorName,ProjectName};
				
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
		Viewbtn.setBounds(301, 404, 120, 45);
		frame.getContentPane().add(Viewbtn);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");
			String sql="UPDATE contract SET contact_text=?,actor_name=?,investor_name=?,project_name=? WHERE contact_id=?";
			PreparedStatement stm=con.prepareStatement(sql);
		stm.setString(1, cttxf.getText());
		stm.setString(2, acttxf.getText());
		stm.setString(3, intxf.getText());
		stm.setString(4,protxf.getText());
		stm.setInt(5, Integer.parseInt(protxf.getText()));
		stm.executeUpdate();
		JOptionPane.showMessageDialog(Updatebtn, "data changed");
			con.close();
			stm.close();
			
			
			
			
			
			
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}		
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		Updatebtn.setBackground(new Color(255, 255, 128));
		Updatebtn.setForeground(Color.BLUE);
		Updatebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Updatebtn.setBounds(130, 453, 120, 45);
		frame.getContentPane().add(Updatebtn);
		
		JButton Deletebtn = new JButton("DELETE");
		Deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");	
				
				  String sql = "DELETE FROM contract WHERE contact_id=?";
				  int cotxf=Integer.parseInt(JOptionPane.showInputDialog(" Please Enter contact_ID to delete:"));
				  PreparedStatement stm=con.prepareStatement(sql);
				  stm.setInt(1, cotxf);
				  Component Delete;
				JOptionPane.showMessageDialog(Deletebtn, "recorded out!!!!!!!!!!");
				  
				  stm.executeUpdate();
				  stm.close();
				  con.close();	
				
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
				
				
				
			}
		});
		Deletebtn.setBackground(new Color(255, 255, 128));
		Deletebtn.setForeground(new Color(255, 0, 0));
		Deletebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Deletebtn.setBounds(301, 453, 120, 45);
		frame.getContentPane().add(Deletebtn);
		
		cotxf = new JTextField();
		cotxf.setBounds(193, 109, 228, 37);
		frame.getContentPane().add(cotxf);
		cotxf.setColumns(10);
		
		cttxf = new JTextField();
		cttxf.setColumns(10);
		cttxf.setBounds(193, 155, 228, 87);
		frame.getContentPane().add(cttxf);
		
		acttxf = new JTextField();
		acttxf.setColumns(10);
		acttxf.setBounds(193, 243, 228, 37);
		frame.getContentPane().add(acttxf);
		
		intxf = new JTextField();
		intxf.setColumns(10);
		intxf.setBounds(193, 291, 228, 37);
		frame.getContentPane().add(intxf);
		
		protxf = new JTextField();
		protxf.setColumns(10);
		protxf.setBounds(193, 338, 228, 37);
		frame.getContentPane().add(protxf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(441, 106, 417, 392);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("AGREEMENT FORM IS HERE");
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(55, 11, 606, 54);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
