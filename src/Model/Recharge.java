package Model;

import java.util.Date;

public class Recharge {
private String usrname;
private String mobno;
private String amt;
private String operator;
private Date date;

public Recharge(String usrname,String mobno, String amt, String operator, Date date) {
	super();
	this.usrname=usrname;

	this.mobno = mobno;
	this.amt = amt;
	this.operator = operator;
	this.date = date;
	
}
public String getMobno() {
	return mobno;
}
public void setMobno(String mobno) {
	this.mobno = mobno;
}
public String getAmt() {
	return amt;
}
public void setAmt(String amt) {
	this.amt = amt;
}
public String getOperator() {
	return operator;
}
public void setOperator(String operator) {
	this.operator = operator;
}
public Date getDate() {
	
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getUsrname() {
	return usrname;
}
public void setUsrname(String usrname) {
	this.usrname = usrname;
}


}