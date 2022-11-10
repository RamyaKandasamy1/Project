import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
   public static void main(String[] args) throws Exception {

      // register MySQL thin driver with DriverManager service
      // It is optional for JDBC4.x version
      Class.forName("com.mysql.cj.jdbc.Driver");

      // variables
      final String url = "jdbc:mysql:///capsdb";
      final String user = "root";
      final String password = "root@123";

      // establish the connection
      Connection con = DriverManager.getConnection(url, user, password);
     // PreparedStatement st= con.prepareStatement("Select login_name, login_pwd from login where login_name=? and login_pwd=?");
      PreparedStatement st= con.prepareStatement("Select * from login ");
		//st.setString(1, username);
		//st.setString(2, Password);
		ResultSet rs = st.executeQuery();
		//System.out.println(rs);
		

      // display status message
      if (con == null) {
         System.out.println("JDBC connection is not established");
         return;
      } else
         System.out.println("Congratulations," + 
              " JDBC connection is established successfully.\n");

      // close JDBC connection
      con.close();

   } 
}
