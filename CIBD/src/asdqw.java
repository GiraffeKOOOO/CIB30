import java.sql.*;

public class asdqw {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Logic log = new Logic();
		log.setPass("p3");
		log.setUser("test1");
		log.check();
		log.createUser();
		
	}
}
