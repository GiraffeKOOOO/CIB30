  import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logic {
	
	private String user, pass, query,clockIn,clockOut;
	private Connection connection;
	
	public Logic() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		 connection = DriverManager.getConnection("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				 "root","");
	}
	
	public void setUser(String user){
		this.user = user;
	}
	
	public void setPass(String pass){
		this.pass = pass;
	}
	
	public String getTime(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	public boolean check() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		boolean found = false;
		 try{
			 Statement st = connection.createStatement();
			 String sql = ("SELECT * FROM staff;");
			 ResultSet rs = st.executeQuery(sql);
			 
			 while(rs.next()) { 
			  String id = rs.getString("staff_ID"); 
			  String str1 = rs.getString("password");
			  
			  	if(id.equals(user) && str1.equals(pass)){
			  		found = true;
			  		break;
			  	}
			 }
		 }
		 catch(SQLException e){
			 System.out.println(e);
		 }
		 
		 return found;
	}
	
	public void clockIn() throws SQLException{
		clockIn = getTime();
	}
	
	public void clockOut() throws SQLException{
		clockOut = getTime();
		query = " INSERT into timesheet (staff_ID, Clock_In,Clock_Out)"
		        + " values (?,?,?)";
		
		PreparedStatement preparedStmt = connection.prepareStatement(query);
	      preparedStmt.setString (1, user);
	      preparedStmt.setString (2, clockIn);
	      preparedStmt.setString (3, clockOut);
	      
	      preparedStmt.execute();
	}
	
	public void createUser() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		if(!check()){
			query = " INSERT into staff (staff_ID, password)"
			        + " values (?, ?)";
			
			PreparedStatement preparedStmt = connection.prepareStatement(query);
		      preparedStmt.setString (1, user);
		      preparedStmt.setString (2, pass);
		      
		      preparedStmt.execute();
		}
	}
}