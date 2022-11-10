package newswing;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.PreparedQuery;
import com.mysql.cj.jdbc.Driver;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Hello extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JLabel lblNewLabel;
	private JLabel label2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hello frame = new Hello();
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
	public Hello() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label1 = new JLabel("Username");
		Label1.setForeground(Color.LIGHT_GRAY);
		Label1.setBackground(Color.BLUE);
		Label1.setFont(new Font("Tahoma", Font.BOLD, 18));
		Label1.setBounds(26, 44, 114, 29);
		contentPane.add(Label1);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(149, 49, 215, 23);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton Button1 = new JButton("Login");
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label2.setText(txtUsername.getText());
				String username = txtUsername.getText();
				String Password = passwordField.getText();
				
				try {		Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      // variables
			      final String url = "jdbc:mysql:///capsdb";
			      final String user = "root";
			      final String password1 = "Rootroot";
			      // establish the connection
			      Connection con;
				try {
					con = DriverManager.getConnection(url, user, password1);
				      // display status message
				      if (con == null) {
				         System.out.println("JDBC connection is not established");
				         return;
				      } else
				         System.out.println("Congratulations," +
				              " JDBC connection is established successfully.\n");
				  	//	PreparedStatement st= con.prepareStatement("Select * from login ");
						PreparedStatement st= con.prepareStatement("Select login_name, login_pwd from login where login_name=? and login_pwd=?");
					     
						st.setString(1, username);
						st.setString(2, Password);
						ResultSet rs = st.executeQuery();
						//System.out.println(rs);
						
			
				      if(rs.next()) {
							System.out.println("Hello  " +username +" !");
							
							
						}
						else
							System.out.println("Wrong password");
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
			
							 
					
				}catch(Exception e1) {
				System.out.println(e1);	
				}
					
				
				
			}
		});
		Button1.setBounds(102, 147, 89, 23);
		contentPane.add(Button1);
		
		JButton Button2 = new JButton("Clear");
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText("");
				label2.setText("");
				
				
			
				
			}
		});
		Button2.setBounds(281, 147, 89, 23);
		contentPane.add(Button2);
		
		label2 = new JLabel("New label");
		label2.setForeground(Color.LIGHT_GRAY);
		label2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label2.setBounds(190, 197, 89, 29);
		contentPane.add(label2);
		
		JButton Button3 = new JButton("Exit");
		Button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Button3.setBounds(335, 11, 89, 23);
		contentPane.add(Button3);
		
		JLabel passwordlabel = new JLabel("Password");
		passwordlabel.setForeground(Color.LIGHT_GRAY);
		passwordlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordlabel.setBounds(26, 90, 114, 14);
		contentPane.add(passwordlabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(149, 87, 215, 20);
		contentPane.add(passwordField);
		
	}
}
