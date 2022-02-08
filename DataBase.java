package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class DataBase {
	
	static String url = "jdbc:sqlserver://SHELBY-30102000;databaseName=master";
	static String user= "Ritu";
	static String password = "password";
	
	Connection conn=null;
	PreparedStatement statement=null;
	
	
	
	//Function to send data to our database
	public static void sendData(String e, String n, String Pn, String p) {
			try {
				Connection conn=null;
				PreparedStatement statement=null;
				conn = DriverManager.getConnection(url,user,password);
	
				String sql = "INSERT INTO player_info (Email,PlayerName,Phonenumber,Password)"
						+ " VALUES (?,?,?,?)";
	
				statement = conn.prepareStatement(sql);
				statement.setString(1, e);
				statement.setString(2, n);
				statement.setString(3, Pn);
				statement.setString(4, p);
				
				ResultSet rows = statement.executeQuery();
				rows.close();
				conn.close();
			} catch (SQLException e1) {
				System.out.println(e1);
				
			}
	}
	
}



