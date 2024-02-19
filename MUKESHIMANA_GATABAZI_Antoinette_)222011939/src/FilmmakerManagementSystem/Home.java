package FilmmakerManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 554);
		contentPane = new JPanel();
		setTitle("WELCOM    OUR HOME   PAGE  OF   FILMMAKER   MANAGEMENT   SYSTEM");
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME OUR HOME PAGE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 54));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 0, 787, 59);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("FILMMAKER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filmmaker mk=new Filmmaker();
				mk.frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(5, 78, 234, 59);
		contentPane.add(btnNewButton);
		
		JButton btnActors = new JButton("ACTORS");
		btnActors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			actor act=new actor();
			act.frame.setVisible(true);
			dispose();
				
				
				
			}
		});
		btnActors.setForeground(Color.BLUE);
		btnActors.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnActors.setBounds(5, 148, 234, 59);
		contentPane.add(btnActors);
		
		JButton btnInvestment = new JButton("INVESTMENT");
		btnInvestment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Investment nt= new Investment();
			nt.frame.setVisible(true);
			dispose();
				
				
				
			}
		});
		btnInvestment.setForeground(Color.BLUE);
		btnInvestment.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnInvestment.setBounds(5, 218, 234, 59);
		contentPane.add(btnInvestment);
		
		JButton btnProjects = new JButton("PROJECTS");
		btnProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Project pro=new Project();
				pro.frame.setVisible(true);
				dispose();
			}
		});
		btnProjects.setForeground(Color.BLUE);
		btnProjects.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnProjects.setBounds(5, 292, 234, 59);
		contentPane.add(btnProjects);
		
		JButton btnInvestors = new JButton("INVESTORS");
		btnInvestors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Investors tor=new Investors();
				tor.frame.setVisible(true);
				dispose();
				
			}
		});
		btnInvestors.setForeground(Color.BLUE);
		btnInvestors.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnInvestors.setBounds(5, 359, 234, 59);
		contentPane.add(btnInvestors);
		
		JButton btnContracts = new JButton("CONTRACTS");
		btnContracts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Contract cr= new Contract();
			cr.frame.setVisible(true);
			dispose();
				
			}
		});
		btnContracts.setForeground(Color.BLUE);
		btnContracts.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnContracts.setBounds(5, 429, 234, 59);
		contentPane.add(btnContracts);
	}

}
