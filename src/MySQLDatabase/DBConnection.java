package MySQLDatabase;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.cloud.sql.jdbc.Connection;

public class DBConnection {
	
	public void connectToDB() throws ClassNotFoundException, SQLException{
		/*try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
		
		try{
			java.sql.Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/dresslibrary", "root", "Forfattare1");
			System.out.println(""+myCon);
		}catch(Exception e){
			System.out.println("Error i con");
			e.printStackTrace();
		}
	}

}
