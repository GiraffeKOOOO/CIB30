import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class qerrf {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		 Connection connection = null;
		 
		 try{
			 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			 connection = DriverManager.getConnection("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					 "root","");
			 
			 Statement st = connection.createStatement();
			 String sql = ("SELECT * FROM staff;");
			 ResultSet rs = st.executeQuery(sql);
			 while(rs.next()) { 
			  String id = rs.getString("staff_ID"); 
			  String str1 = rs.getString("password");
			  
			  System.out.println(id+" "+str1);
			 }
		 }
		 catch(SQLException e){
			 System.out.println(e);
		 }
	}

}
