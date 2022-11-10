import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;

public class HelloFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloFrame frame = new HelloFrame();
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
	public HelloFrame() {
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.isMaximumSizeSet();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 283, 679, 329);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton loginButton = new JButton("Login");
		loginButton.setIcon(new ImageIcon("C:\\Users\\ramz8\\Pictures\\Saved Pictures\\login.png"));
		loginButton.setBounds(150, 213, 137, 75);
		panel.add(loginButton);
		loginButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=textField.getText();
				String password=passwordField.getText();
				// It is optional for JDBC4.x version
			      try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			      // variables
			      final String url = "jdbc:mysql:///capsdb";
			      final String user = "root";
			      final String password1 = "root@123";

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
					st.setString(2, password);
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
				}
			     
			      // close JDBC connection
			     // con.close();

			}
		});
		
		JButton btnNewB = new JButton("CLEAR");
		btnNewB.setIcon(new ImageIcon("C:\\Users\\ramz8\\Pictures\\Saved Pictures\\clear.png"));
		btnNewB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");				
				passwordField.setText("");		
				
			}
		});
		btnNewB.setBounds(332, 213, 137, 75);
		panel.add(btnNewB);
		btnNewB.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		
		JLabel userLabel = new JLabel("UserName");
		userLabel.setBounds(139, 65, 137, 26);
		panel.add(userLabel);
		userLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		
		JLabel pwdLabel = new JLabel("Password");
		pwdLabel.setBounds(139, 122, 137, 26);
		panel.add(pwdLabel);
		pwdLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		
		textField = new JTextField();
		textField.setBounds(263, 71, 234, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(263, 122, 234, 26);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setBounds(0, 0, 669, 336);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 689, 283);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ramz8\\Pictures\\Saved Pictures\\ERJ.png"));
		lblNewLabel_2.setBounds(532, 198, 135, 75);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ramz8\\Pictures\\Saved Pictures\\Shop.png"));
		lblNewLabel.setBounds(-22, -69, 689, 342);
		panel_1.add(lblNewLabel);
	}
}
