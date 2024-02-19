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

public class actor {

	 JFrame frame;
	private JTextField acttxf;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField ematxf;
	private JTextField photxf;
	private JTextField latxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					actor window = new actor();
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
	public actor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 695, 619);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACTOR");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(128, 0, 364, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel actlb = new JLabel("actor_id");
		actlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		actlb.setBounds(10, 73, 138, 29);
		frame.getContentPane().add(actlb);
		
		JLabel fnlb = new JLabel("firstname");
		fnlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		fnlb.setBounds(10, 125, 138, 29);
		frame.getContentPane().add(fnlb);
		
		JLabel lnlb = new JLabel("lastname");
		lnlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		lnlb.setBounds(10, 182, 138, 29);
		frame.getContentPane().add(lnlb);
		
		JLabel emalb = new JLabel("email");
		emalb.setFont(new Font("Tahoma", Font.BOLD, 16));
		emalb.setBounds(10, 235, 138, 29);
		frame.getContentPane().add(emalb);
		
		JLabel pholb = new JLabel("phone");
		pholb.setFont(new Font("Tahoma", Font.BOLD, 16));
		pholb.setBounds(10, 292, 138, 29);
		frame.getContentPane().add(pholb);
		
		JLabel lalb = new JLabel("language");
		lalb.setFont(new Font("Tahoma", Font.BOLD, 16));
		lalb.setBounds(10, 341, 138, 29);
		frame.getContentPane().add(lalb);
		
		JButton Insertbtn = new JButton("INSERT");
		Insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm=new Home();
				hm.setVisible(true);
				frame.dispose();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");
				String query="INSERT INTO actor VALUES(?,?,?,?,?,?)";
				PreparedStatement stm=con.prepareStatement(query);
				stm.setInt(1, Integer.parseInt(acttxf.getText()));
				stm.setString(2, fntxf.getText());
				stm.setString(3, lntxf.getText());
				stm.setString(4, ematxf.getText());
				stm.setString(5, photxf.getText());
				stm.setString(6, latxf.getText());
				stm.executeUpdate();
				JOptionPane.showMessageDialog(Insertbtn, "successfully!!!");
				stm.close();
				con.close();

				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		});
		Insertbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Insertbtn.setForeground(new Color(0, 0, 255));
		Insertbtn.setBounds(193, 457, 108, 38);
		frame.getContentPane().add(Insertbtn);
		
		acttxf = new JTextField();
		acttxf.setBounds(205, 79, 303, 29);
		frame.getContentPane().add(acttxf);
		acttxf.setColumns(10);
		
		fntxf = new JTextField();
		fntxf.setColumns(10);
		fntxf.setBounds(205, 131, 303, 29);
		frame.getContentPane().add(fntxf);
		
		lntxf = new JTextField();
		lntxf.setColumns(10);
		lntxf.setBounds(205, 182, 303, 29);
		frame.getContentPane().add(lntxf);
		
		ematxf = new JTextField();
		ematxf.setColumns(10);
		ematxf.setBounds(205, 235, 303, 29);
		frame.getContentPane().add(ematxf);
		
		photxf = new JTextField();
		photxf.setColumns(10);
		photxf.setBounds(205, 292, 303, 29);
		frame.getContentPane().add(photxf);
		
		latxf = new JTextField();
		latxf.setColumns(10);
		latxf.setBounds(205, 347, 303, 29);
		frame.getContentPane().add(latxf);
		
		JButton Delete = new JButton("DELETE");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/filmmaker_management_system","root","");
					  String sql = "DELETE FROM actor WHERE actor_id=?";
					  int acttxf=Integer.parseInt(JOptionPane.showInputDialog("Enter Actor ID to delete:"));
					  PreparedStatement stm=con.prepareStatement(sql);
					  stm.setInt(1,acttxf);
					  JOptionPane.showMessageDialog(Delete, "recorded out!!!!!!!!!!");
					  
					  stm.executeUpdate();
					  stm.close();
					  con.close();
				} catch (Exception e2) {
					
				}
			}
		});
		Delete.setForeground(new Color(255, 0, 0));
		Delete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Delete.setBounds(358, 457, 115, 38);
		frame.getContentPane().add(Delete);
	}
}
