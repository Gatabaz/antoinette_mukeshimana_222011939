package FilmmakerManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;

public class Project {

	 JFrame frame;
	private JTextField protxf;
	private JTextField titxf;
	private JTextField rdtxf;
	private JTextField pbtxf;
	private JTextField fitxf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project window = new Project();
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
	public Project() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setTitle("PROJECT FORM IN FILMMAKER MANAGEMENT SYSTEM");
		frame.setBounds(100, 100, 896, 623);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME IN PROJECT FORM WITH HERE ");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 11, 687, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel prolb = new JLabel("Project_id");
		prolb.setForeground(new Color(0, 0, 0));
		prolb.setFont(new Font("Tahoma", Font.BOLD, 22));
		prolb.setBounds(0, 76, 206, 31);
		frame.getContentPane().add(prolb);
		
		JLabel tilb = new JLabel("Title");
		tilb.setForeground(new Color(0, 0, 0));
		tilb.setFont(new Font("Tahoma", Font.BOLD, 22));
		tilb.setBounds(4, 122, 206, 31);
		frame.getContentPane().add(tilb);
		
		JLabel rdlb = new JLabel("ReleaseDate");
		rdlb.setForeground(new Color(0, 0, 0));
		rdlb.setFont(new Font("Tahoma", Font.BOLD, 22));
		rdlb.setBounds(9, 176, 206, 31);
		frame.getContentPane().add(rdlb);
		
		JLabel pblb = new JLabel("ProductionBudget");
		pblb.setForeground(new Color(0, 0, 0));
		pblb.setFont(new Font("Tahoma", Font.BOLD, 22));
		pblb.setBounds(9, 230, 206, 31);
		frame.getContentPane().add(pblb);
		
		JLabel actlb = new JLabel("ActorName");
		actlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		actlb.setBounds(-103, 242, 163, 31);
		frame.getContentPane().add(actlb);
		
		JLabel filb = new JLabel("FilmmakerName");
		filb.setForeground(new Color(0, 0, 0));
		filb.setFont(new Font("Tahoma", Font.BOLD, 22));
		filb.setBounds(11, 286, 206, 31);
		frame.getContentPane().add(filb);
		
		JButton Insertbtn = new JButton("INSERT");
		Insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");			
			String sql="INSERT INTO project VALUES(?,?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(protxf.getText()));
			st.setString(2, titxf.getText());
			st.setString(3, rdtxf.getText());
			st.setString(4, pbtxf.getText());
			st.setString(5, fitxf.getText());
			st.executeUpdate();
			JOptionPane.showMessageDialog(Insertbtn, "data saves!!");
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
		Insertbtn.setBounds(738, 75, 120, 37);
		frame.getContentPane().add(Insertbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");		
				java.sql.Statement st=con.createStatement();
				String query="SELECT * FROM project";
				ResultSet rs= st.executeQuery(query);
				ResultSetMetaData rsmd=rs.getMetaData();
				
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int cols=rsmd.getColumnCount();
				String[] colName=new String[cols];
				for(int i=0;i<cols;i++)
					colName[i]=rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				String project_id,title,releaseDate,projectBudget,filmmakerName;
				while(rs.next()) 
				{
					project_id=rs.getString(1);
					title=rs.getString(2);
				releaseDate=rs.getString(3);
					projectBudget=rs.getString(4);
					filmmakerName=rs.getString(5);
					
					String[] row= {project_id,title,releaseDate,projectBudget,filmmakerName};
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
		Viewbtn.setBounds(738, 121, 120, 37);
		frame.getContentPane().add(Viewbtn);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");	
			String sql="UPDATE project SET title=?,release_date=?,project_budget=?,filmmaker_name=? WHERE project_id=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, titxf.getText());
		st.setString(2, rdtxf.getText());
		st.setString(3, pbtxf.getText());
		st.setString(4, fitxf.getText());
		st.setInt(5, Integer.parseInt(protxf.getText()));
		st.executeUpdate();
		JOptionPane.showMessageDialog(Updatebtn, "data changed!!");
		con.close();
		st.close();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		Updatebtn.setBackground(new Color(255, 255, 128));
		Updatebtn.setForeground(Color.BLUE);
		Updatebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Updatebtn.setBounds(738, 175, 120, 37);
		frame.getContentPane().add(Updatebtn);
		
		JButton Deletebtn = new JButton("DELETE");
		Deletebtn.setBackground(new Color(255, 255, 128));
		Deletebtn.setForeground(new Color(255, 0, 0));
		Deletebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Deletebtn.setBounds(738, 229, 120, 37);
		frame.getContentPane().add(Deletebtn);
		
		protxf = new JTextField();
		protxf.setBounds(234, 65, 318, 43);
		frame.getContentPane().add(protxf);
		protxf.setColumns(10);
		
		titxf = new JTextField();
		titxf.setColumns(10);
		titxf.setBounds(234, 115, 318, 45);
		frame.getContentPane().add(titxf);
		
		rdtxf = new JTextField();
		rdtxf.setColumns(10);
		rdtxf.setBounds(234, 174, 318, 45);
		frame.getContentPane().add(rdtxf);
		
		pbtxf = new JTextField();
		pbtxf.setColumns(10);
		pbtxf.setBounds(234, 228, 318, 44);
		frame.getContentPane().add(pbtxf);
		
		fitxf = new JTextField();
		fitxf.setColumns(10);
		fitxf.setBounds(234, 281, 318, 44);
		frame.getContentPane().add(fitxf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 328, 546, 247);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\PC\\Desktop\\250786758334_status_73ff27d4454f4d4588fa411b059a4903.jpg"));
		lblNewLabel_1.setBounds(234, 59, 624, 475);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm=new Home();
				hm.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setForeground(Color.BLUE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBackground(new Color(255, 255, 128));
		btnBack.setBounds(724, 545, 120, 37);
		frame.getContentPane().add(btnBack);
	}
}
