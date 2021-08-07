package Model;
import java.util.*;
public class DepositWithdraw {

	private String username;
	private String amount;
	private Date date1;
	private String type;
	public DepositWithdraw(String username, String amount, Date date1, String type) {
		super();
		this.username = username;
		this.amount = amount;
		this.date1 = date1;
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
