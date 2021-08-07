package Dao;
import java.util.*;
import Model.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
public class TransactionDao {

	MyConnection m=new MyConnection();
	Connection con=null;
	PreparedStatement ps,ps1=null;
	Increpete_Decrepete in1=new Increpete_Decrepete();

	public int deposit(String usrname,String amt)
	{
		con=m.getConnection();
		int i=0;
		SimpleDateFormat df=new SimpleDateFormat("dd-mmm-yyy");
		Date d=new Date(i);
		String newdate=df.format(d);
		String type="Deposit";

		try {
			ps=con.prepareStatement("insert into  withdraw_deposit values(?,?,?,?)");
			ps.setString(1,usrname);
			ps.setString(2, amt);

			ps.setTimestamp(3,new java.sql.Timestamp(System.currentTimeMillis()));
			ps.setString(4,type);

			i=ps.executeUpdate();
			if(i==1)
			{
				ps1=con.prepareStatement("Select * from registration where username=?");
				ps1.setString(1,usrname);
				ResultSet set=ps1.executeQuery();
				if(set.next())
				{
					String balance=set.getString(4);

					int bal1=Integer.parseInt(balance);
					String bal=amt;
					int bal2=Integer.parseInt(bal);
					int bal3=bal1+bal2;
					String bal4=Integer.toString(bal3);
					ps=con.prepareStatement("update registration set balance=? where username=?");
					ps.setString(1,bal4);
					ps.setString(2, usrname);
					i=ps.executeUpdate();
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return i;
	}
	public int withdraw(String usrname,String amt)
	{
		con=m.getConnection();
		int i=0;
		SimpleDateFormat df=new SimpleDateFormat("dd-mmm-yyy");
		Date d=new Date(i);
		String newdate=df.format(d);
		String type="Withdraw";

		try {
			ps=con.prepareStatement("insert into  withdraw_deposit values(?,?,?,?)");
			ps.setString(1,usrname);
			ps.setString(2, amt);

			ps.setTimestamp(3,new java.sql.Timestamp(System.currentTimeMillis()));
			ps.setString(4,type);

			i=ps.executeUpdate();
			if(i==1)
			{
				ps1=con.prepareStatement("Select * from registration where username=?");
				ps1.setString(1,usrname);
				ResultSet set=ps1.executeQuery();
				if(set.next())
				{
					String balance=set.getString(4);
					int bal1=Integer.parseInt(balance);
					String bal=amt;
					int bal2=Integer.parseInt(bal);
					int bal3=bal1-bal2;
					String bal4=Integer.toString(bal3);
					ps=con.prepareStatement("update registration set balance=? where username=?");
					ps.setString(1,bal4);
					ps.setString(2, usrname);
					i=ps.executeUpdate();
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		return i;
	}
	public List<Recharge> rhistory(String usrname)
	{
		con=m.getConnection();
		int i=0;
		
		List<Recharge> ls=new LinkedList<Recharge>();
		try {
			
			ps=con.prepareStatement("select * from  recharge_transaction where username=?");
			ps.setString(1,usrname);
			
			
			 ResultSet set=ps.executeQuery();
			while(set.next())
			{
				Recharge r=new Recharge(set.getString(1),set.getString(2),set.getString(3),set.getString(4),set.getDate(5)) ;
				System.out.println(set.getString(1)+"123");
				ls.add(r);
			}
		} catch (SQLException e1) {
				e1.printStackTrace();
		}
		return ls;
	}
	
	public List<DepositWithdraw> rechHistory(String usrname)
	{
		con=m.getConnection();
		int i=0;
		
		List<DepositWithdraw> ls1=new LinkedList<DepositWithdraw>();
		try {
			
			ps=con.prepareStatement("select * from   withdraw_deposit where username=?");
			ps.setString(1,usrname);
			
			
			 ResultSet set=ps.executeQuery();
			while(set.next())
			{
				DepositWithdraw r=new DepositWithdraw(set.getString(1),set.getString(2),set.getDate(3),set.getString(4)) ;
				System.out.println(set.getString(1)+"123");
				ls1.add(r);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		
		return ls1;
	}
	
}
