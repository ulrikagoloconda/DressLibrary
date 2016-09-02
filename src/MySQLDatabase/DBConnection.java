package MySQLDatabase;

import java.io.ByteArrayInputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dresslibrary.client.model.DressInfo;
import com.dresslibrary.client.model.LibraryUser;
import com.google.api.server.spi.auth.common.User;
import com.google.cloud.sql.jdbc.Connection;


public class DBConnection {
	private java.sql.Connection myCon;
	private Statement statment;
	
	
	public void connectToDB() throws ClassNotFoundException, SQLException{
		System.out.println("Detta körs i dbva");
		try{
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/dresslibrary", "root", "Forfattare1");
			statment = myCon.createStatement();
			System.out.println("Detta körs i dbva");

		}catch(Exception e){
			System.out.println("Error i con");
			e.printStackTrace();
		}
	}
	
	public LibraryUser loginQ(String userName, String password) {
		LibraryUser returnUser = new LibraryUser();
	
		try{
			String sql = "SELECT userID, password, email,fName, lName, rate, karma, numberOfDelays FROM userinfo WHERE userNamne=?";
			PreparedStatement ps = myCon.prepareStatement(sql);

			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				int userID = rs.getInt("userID");
				System.out.println("userid " + userID);

				if(userID <= 0){
					returnUser = null;
					System.out.println("Är userID < 0");
					return returnUser;
				}
				String tryPassword = rs.getString("password");
				if(!password.equals(tryPassword)){
					System.out.println("passar inte password " + password);

					returnUser = null; 
					
					return returnUser; 
				} else {
					returnUser.setUserID(rs.getInt("userID"));
					returnUser.setEmail(rs.getString("email"));
					returnUser.setfName(rs.getString("fName"));
					returnUser.setlName(rs.getString("lName"));
					returnUser.setRate(rs.getInt("rate"));
					returnUser.setKarma(rs.getInt("karma"));
					returnUser.setNumberOfDelays(rs.getInt("numberOfDelays"));

				}
		
			}
			return returnUser; 
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return returnUser;
	}
	
 
	public LibraryUser createNewUser(LibraryUser user, String password){
		System.out.println("I create");
		try{
			String sql = "INSERT into userInfo (userNamne, password, email, fName, lName, karma, numberOfDelays) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = myCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			System.out.println("I create " + user.getUserNamne());

			ps.setString(1, user.getUserNamne());
			ps.setString(2, password);
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getfName());
			ps.setString(5, user.getlName());
			ps.setInt(6, user.getKarma());
			ps.setInt(7, user.getNumberOfDelays());
			ps.executeUpdate();
			ResultSet tableKeys = ps.getGeneratedKeys();
			tableKeys.next();
			user.setUserID(tableKeys.getInt(1));
			System.out.println("I create "  + user.getUserID());

			
		}catch(Exception e){
		
			e.printStackTrace();	
		}
		return user; 
		
	}
	
	public void insertIntoDressInfo(DressInfo info){
		try{
			String sql = "INSERT INTO dressImages()";
			PreparedStatement ps = myCon.prepareStatement(sql);
			ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int insertIntoDressImage(ByteArrayInputStream inputStream, String fileName){
		System.out.println("Detta körs i insertimage");
		int i = 0; 

		try{
			String sql = "INSERT INTO dressimage (file, fileName) VALUES (?,?)";
			
			PreparedStatement ps = myCon.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setBinaryStream(1, inputStream);
			ps.setString(2, fileName);
			int x = ps.executeUpdate();
		
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}

	
		
	

}
