package Dao;
import java.util.*;
import Model.*;
import java.sql.*;
public class RegisterDao {

	MyConnection m=new MyConnection();
	Connection con=null;
	PreparedStatement ps=null;
	Increpete_Decrepete in1=new Increpete_Decrepete();

	
	public int create(Customer r)
	{
		con=m.getConnection();
		String pass=r.getPassword();
		String pass1=in1.getEncodedString(pass);
		int i=0;
		try {	
			
			ps=con.prepareStatement("insert into Registration values(?,?,?,?,?,?)");
			ps.setString(1, r.getName());
			ps.setString(2, r.getEmail());
			ps.setString(3, r.getMobno());
			ps.setString(4, r.getBalance());
			ps.setString(5, r.getUsername());
			ps.setString(6, pass1);
			i = ps.executeUpdate();
			if (i>0) {
				System.out.println("register successfully!");
				return i;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public int validateUser(Logins l)
	{
		int j=0;
		con=m.getConnection();
		String pass=l.getPassword();
		String pass1=in1.getEncodedString(pass);
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from Registration where username=? and password=?");
			ps.setString(1,l.getUsername());
			ps.setString(2,pass1);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("login successfully");
				j=1;
			}
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return j;
	}
	public int checkuser(Customer r)
	{
		con=m.getConnection();
		int b=0;
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from Registration where username=? and password=?");
			ps.setString(1,r.getUsername());
			ps.setString(2,r.getPassword());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("check user successfully");
				b=1;
			}
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return b;
	}
	
}
