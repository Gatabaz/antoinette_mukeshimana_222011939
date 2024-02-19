package FilmmakerManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Filmmaker {

	 JFrame frame;
	private JTextField fitxf;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField ematxf;
	private JTextField phtxf;
	private JTextField natxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filmmaker window = new Filmmaker();
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
	public Filmmaker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("FILMMAKER     MANAGEMENT    SYSTEM      ");
		frame.setBounds(100, 100, 905, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FILMMAKERS FORM IS HERE");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(83, 3, 677, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel filb = new JLabel("filmmaker_id");
		filb.setFont(new Font("Tahoma", Font.ITALIC, 25));
		filb.setBounds(6, 99, 148, 31);
		frame.getContentPane().add(filb);
		
		JLabel fnlb = new JLabel("firstname");
		fnlb.setFont(new Font("Tahoma", Font.ITALIC, 25));
		fnlb.setBounds(6, 141, 148, 31);
		frame.getContentPane().add(fnlb);
		
		JLabel lnlb = new JLabel("lastname");
		lnlb.setFont(new Font("Tahoma", Font.ITALIC, 25));
		lnlb.setBounds(6, 183, 148, 31);
		frame.getContentPane().add(lnlb);
		
		JLabel emalb = new JLabel("email");
		emalb.setFont(new Font("Tahoma", Font.ITALIC, 25));
		emalb.setBounds(6, 224, 148, 31);
		frame.getContentPane().add(emalb);
		
		JLabel pholb = new JLabel("phone");
		pholb.setFont(new Font("Tahoma", Font.ITALIC, 25));
		pholb.setBounds(6, 264, 148, 31);
		frame.getContentPane().add(pholb);
		
		JLabel nalb = new JLabel("nationality");
		nalb.setFont(new Font("Tahoma", Font.ITALIC, 25));
		nalb.setBounds(6, 309, 148, 31);
		frame.getContentPane().add(nalb);
		
		JButton Insertbtn = new JButton("INSERT");
		Insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm=new Home();
				hm.setVisible(true);
				frame.dispose();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");
					String sql="INSERT INTO filmmaker VALUES(?,?,?,?,?,?)";
					PreparedStatement stm= con.prepareStatement(sql);
					stm.setInt(1, Integer.parseInt(fitxf.getText()));
					stm.setString(2, fntxf.getText());
					stm.setString(3, lntxf.getText());
					stm.setString(4, ematxf.getText());
					stm.setString(5, phtxf.getText());
					stm.setString(6, natxf.getText());
					stm.executeUpdate();
					JOptionPane.showMessageDialog(Insertbtn, "entered!!!!!!!!!!");
					stm.close();
					con.close();
					
				} catch (Exception e2) {
					
				}
			}
		});
		Insertbtn.setForeground(new Color(0, 0, 255));
		Insertbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Insertbtn.setBounds(195, 405, 106, 42);
		frame.getContentPane().add(Insertbtn);
		
		JButton Deletebtn = new JButton("RESET");
		Deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fitxf.setText(null);
				fntxf.setText(null);
				lntxf.setText(null);
				ematxf.setText(null);
				phtxf.setText(null);
				natxf.setText(null);
			}
		});
		Deletebtn.setForeground(new Color(255, 0, 0));
		Deletebtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Deletebtn.setBounds(435, 405, 106, 42);
		frame.getContentPane().add(Deletebtn);
		
		fitxf = new JTextField();
		fitxf.setBounds(208, 101, 333, 25);
		frame.getContentPane().add(fitxf);
		fitxf.setColumns(10);
		
		fntxf = new JTextField();
		fntxf.setColumns(10);
		fntxf.setBounds(208, 143, 333, 25);
		frame.getContentPane().add(fntxf);
		
		lntxf = new JTextField();
		lntxf.setColumns(10);
		lntxf.setBounds(208, 182, 333, 25);
		frame.getContentPane().add(lntxf);
		
		ematxf = new JTextField();
		ematxf.setColumns(10);
		ematxf.setBounds(208, 224, 333, 25);
		frame.getContentPane().add(ematxf);
		
		phtxf = new JTextField();
		phtxf.setColumns(10);
		phtxf.setBounds(208, 266, 333, 25);
		frame.getContentPane().add(phtxf);
		
		natxf = new JTextField();
		natxf.setColumns(10);
		natxf.setBounds(208, 309, 333, 25);
		frame.getContentPane().add(natxf);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); 
					Connection con=DriverManager.getConnection("jdbc:myqsql://localhost:3306/filmmaker_management_system","root","");
				String sql="UPDATE filmmaker SET first_name=?,last_name=?,email=?,phone=?,nationality=? WHERE filmmaker_id=?";
				PreparedStatement st=con.prepareStatement(sql);
				
				st.setString(1, fntxf.getText());
				st.setString(2, lntxf.getText());
				st.setString(3, ematxf.getText());
				st.setString(4, phtxf.getText());
				st.setString(5, natxf.getText());
				st.setInt(6, Integer.parseInt(fitxf.getText()));
				JOptionPane.showMessageDialog(btnUpdate, "updated!!!!!");
				st.executeUpdate();
				st.close();
				con.close();
				
				
				
				
				
				
				
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnUpdate.setForeground(new Color(0, 0, 255));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(319, 405, 106, 42);
		frame.getContentPane().add(btnUpdate);
	}
}
