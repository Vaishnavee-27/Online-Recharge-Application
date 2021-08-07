package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import Model.Customer;
import Model.Increpete_Decrepete;

public class ProfileDao {
	MyConnection m=new MyConnection();
	Connection con=null;
	PreparedStatement ps=null;
	Increpete_Decrepete in1=new Increpete_Decrepete();

	public List<Customer> getUser(String uname)
	{
		
		con=m.getConnection();
		List<Customer> lst=new LinkedList<>();
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from Registration where username=?");
			ps.setString(1,uname);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{		
				String pass=rs.getString(6);
				String pass1=in1.getDecodedString(pass);
				Customer s=new Customer(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),pass1);
				lst.add(s);
			}
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return lst;
	}
	public int UpdateProfile(Customer s,String usr)
	{
		int i=0;
		con=m.getConnection();
		String pass=s.getPassword();
		String pass1=in1.getEncodedString(pass);	
		try
		{
			PreparedStatement ps=con.prepareStatement("update Registration set name=?,email=?,mobile_no=?,balance=?,password=? where username=?");
			ps.setString(1,s.getName());
			ps.setString(2,s.getEmail());
			ps.setString(3,s.getMobno());
			ps.setString(4,s.getBalance());
			ps.setString(5,pass1);
			ps.setString(6,usr);
			i=ps.executeUpdate();
			if(i>0)
			{		
				System.out.println("get updated");
				i=1;
			}
			else
			{
				System.out.println("error");
			}
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return i;
	}
}
