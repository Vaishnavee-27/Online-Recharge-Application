package Model;

public class Customer {

	private String name;
	private String email;
	private String mobno;
	private String balance;
	private String username;
	private String password;
	public Customer()
	{
		
	}
	public Customer(String name, String email, String mobno, String balance, String username, String password) {
		super();
		this.name = name;
		this.email = email;
		this.mobno = mobno;
		this.balance = balance;
		this.username = username;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
