/**
 * This class is used for encrypting the input char
 * and return the encrypted string
 * **/
public class Encryption {
	
	// Table for processing encryption
	private final String alphaUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final String alphaLower = "abcdefghijklmnopqrstuvwxyz";
	
	int keyA;
	int keyB;
	int x;
	String cipherText;
	
	
	public Encryption(){
		cipherText ="";
	}
	
	// Encrypt the input character and store it in the String cipherText
	public void encryptMessage(char msg){
		
		//if the input character is an alphabet
		if(Character.isAlphabetic(msg)){
			
			//if the input character is uppercase, use String alphaUpper to map the encryption
			if(Character.isUpperCase(msg)){
				x = alphaUpper.indexOf(msg);
				cipherText = cipherText + alphaUpper.charAt(((keyA * x) + keyB) % 26);
				
			}else{
				//if the input character is in lowercase, use String alphaLower to map the encryption
				x = alphaLower.indexOf(msg);
				cipherText = cipherText + alphaLower.charAt(((keyA * x) + keyB) % 26);
				
			}
		}else{
			// if the input character is not an alphabet, skip processing the encryption
			cipherText = cipherText + msg;
		}
		
	} 
	
	// return the encrypted string
	public String getCipherText(){
		return cipherText;
	}
	
	// Set the value of keyA and keyB
	public void setKey(int a, int b){
		keyA = a;
		keyB = b;
	}
	
	// Reset the string value
	public void newLine(){
		cipherText ="";
	}

}
