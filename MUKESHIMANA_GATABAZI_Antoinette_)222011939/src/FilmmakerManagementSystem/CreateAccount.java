package FilmmakerManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CreateAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField usertxf;
	private JTextField passtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 694);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		setTitle("WELCOME    OUR   HOME PAGE");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE ACCOUNT");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 55));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 810, 48);
		contentPane.add(lblNewLabel);
		
		JButton signupbtn = new JButton("SIGNUP");
		signupbtn.setBackground(new Color(128, 255, 128));
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");
					String sql="INSERT INTO signup(first_name,last_name,user_name,password) VALUES(?,?,?,?)";
					PreparedStatement st=con.prepareStatement(sql);
					st.setString(1, fntxf.getText());
					st.setString(2, lntxf.getText());
					st.setString(3, usertxf.getText());
					st.setString(4, passtxf.getText());
					JOptionPane.showMessageDialog(signupbtn, "data saved!!");
					st.executeUpdate()
;
					con.close();
					st.close();
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				
				
				Login log=new Login();
				log.setVisible(true);
				dispose();
				
			}
		});
		signupbtn.setForeground(new Color(0, 128, 255));
		signupbtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		signupbtn.setBounds(73, 558, 161, 59);
		contentPane.add(signupbtn);
		
		JLabel fnlb = new JLabel("FirstName");
		fnlb.setForeground(new Color(255, 255, 255));
		fnlb.setFont(new Font("Tahoma", Font.ITALIC, 45));
		fnlb.setHorizontalAlignment(SwingConstants.CENTER);
		fnlb.setBounds(10, 122, 245, 48);
		contentPane.add(fnlb);
		
		fntxf = new JTextField();
		fntxf.setBounds(20, 187, 410, 48);
		contentPane.add(fntxf);
		fntxf.setColumns(10);
		
		JLabel lnlb = new JLabel("LastName");
		lnlb.setForeground(new Color(255, 255, 255));
		lnlb.setHorizontalAlignment(SwingConstants.CENTER);
		lnlb.setFont(new Font("Tahoma", Font.ITALIC, 45));
		lnlb.setBounds(10, 238, 245, 48);
		contentPane.add(lnlb);
		
		lntxf = new JTextField();
		lntxf.setColumns(10);
		lntxf.setBounds(20, 293, 410, 48);
		contentPane.add(lntxf);
		
		JLabel userlb = new JLabel("UserName");
		userlb.setForeground(new Color(255, 255, 255));
		userlb.setHorizontalAlignment(SwingConstants.CENTER);
		userlb.setFont(new Font("Tahoma", Font.ITALIC, 45));
		userlb.setBounds(10, 335, 245, 48);
		contentPane.add(userlb);
		
		usertxf = new JTextField();
		usertxf.setColumns(10);
		usertxf.setBounds(20, 390, 410, 48);
		contentPane.add(usertxf);
		
		JLabel passlb = new JLabel("PassWord");
		passlb.setForeground(new Color(255, 255, 255));
		passlb.setHorizontalAlignment(SwingConstants.CENTER);
		passlb.setFont(new Font("Tahoma", Font.ITALIC, 45));
		passlb.setBounds(10, 434, 245, 48);
		contentPane.add(passlb);
		
		passtxf = new JTextField();
		passtxf.setColumns(10);
		passtxf.setBounds(20, 488, 410, 48);
		contentPane.add(passtxf);
		
		JButton Cancelbtn = new JButton("Cancel");
		Cancelbtn.setBackground(new Color(128, 255, 128));
		Cancelbtn.setForeground(new Color(0, 128, 255));
		Cancelbtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		Cancelbtn.setBounds(244, 558, 161, 59);
		contentPane.add(Cancelbtn);
	}
}
