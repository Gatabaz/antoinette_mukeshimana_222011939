package FilmmakerManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usetxf;
	private JTextField passtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN FORM IS HERE");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 54));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(108, 0, 598, 66);
		contentPane.add(lblNewLabel);
		
		JLabel userlb = new JLabel("UserName");
		userlb.setFont(new Font("Tahoma", Font.ITALIC, 60));
		userlb.setHorizontalAlignment(SwingConstants.CENTER);
		userlb.setBounds(261, 94, 331, 75);
		contentPane.add(userlb);
		
		usetxf = new JTextField();
		usetxf.setBounds(108, 180, 624, 50);
		contentPane.add(usetxf);
		usetxf.setColumns(10);
		
		JLabel passlb = new JLabel("PassWord");
		passlb.setHorizontalAlignment(SwingConstants.CENTER);
		passlb.setFont(new Font("Tahoma", Font.ITALIC, 60));
		passlb.setBounds(261, 245, 331, 75);
		contentPane.add(passlb);
		
		passtxf = new JTextField();
		passtxf.setColumns(10);
		passtxf.setBounds(108, 331, 624, 50);
		contentPane.add(passtxf);
		
		JButton loginbtn = new JButton("Log IN");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm= new Home();
				hm.setVisible(true);
				dispose();
			}
		});
		loginbtn.setForeground(new Color(0, 128, 255));
		loginbtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		loginbtn.setBounds(273, 443, 147, 55);
		contentPane.add(loginbtn);
		
		JButton Cancelbtn = new JButton("Cancel");
		Cancelbtn.setForeground(new Color(0, 128, 255));
		Cancelbtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		Cancelbtn.setBounds(464, 443, 147, 55);
		contentPane.add(Cancelbtn);
	}

}
