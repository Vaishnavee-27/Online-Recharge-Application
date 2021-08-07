package Dao;
import java.sql.Date;
import java.text.*;
import java.sql.*;
import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RechargeDao {

	MyConnection m=new MyConnection();
	Connection con=null;
	PreparedStatement ps,ps1=null;
	Increpete_Decrepete in1=new Increpete_Decrepete();
	public int returnbal(String usr)
	{
		con=m.getConnection();

		int oldbal=0;
		try {
			ps1=con.prepareStatement("Select * from registration where username=?");
			ps1.setString(1, usr);
			ResultSet set=ps1.executeQuery();
			if(set.next())
			{
				String bal1=set.getString(4);
				oldbal=Integer.parseInt(bal1);
			}
		}
		catch(Exception e)

		{
			e.printStackTrace();
		}
		return oldbal;
	}
	public int recharge(Recharge r)
	{
		con=m.getConnection();
		int i=0;
		SimpleDateFormat df=new SimpleDateFormat("dd-mmm-yyy");
		Date d=new Date(i);
		String newdate=df.format(d);

		try {
			ps=con.prepareStatement("insert into recharge_transaction values(?,?,?,?,?)");
			ps.setString(1, r.getUsrname());
			ps.setString(2,r.getMobno());
			ps.setString(3, r.getAmt());
			ps.setString(4,r.getOperator());

			ps.setTimestamp(5,new java.sql.Timestamp(System.currentTimeMillis()));

			i=ps.executeUpdate();
			if(i==1)
			{
				System.out.println("done recharge");

			}
			con.close();

		}

		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return i;
	}
	public void updateBal(String usr,String newbal)
	{
		con=m.getConnection();

		int i=0;
		try {
			ps=con.prepareStatement("update registration set balance=? where username=?");
			ps.setString(1,newbal);
			ps.setString(2, usr);
			i=ps.executeUpdate();
			if(i==1)
			{
				System.out.println("balance update");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
