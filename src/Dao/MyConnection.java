package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	public Connection getConnection(){
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			//step2- connection to database
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String uname="System";
			String pass="3840";
			//step2-connection to database
			con=DriverManager.getConnection(url,uname,pass);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return con;
	}
}

