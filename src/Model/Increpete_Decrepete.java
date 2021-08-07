package Model;
import java.util.Base64;

public class Increpete_Decrepete {


	public String getEncodedString(String password)
	{
		return Base64.getEncoder().encodeToString(password.getBytes());
	}

	public String getDecodedString(String encryptedString)
	{
		return new String(Base64.getMimeDecoder().decode(encryptedString));
	}
}