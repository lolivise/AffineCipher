/**
 * This class is used for decrypting the input char
 * and return the decrypted string
 * **/
public class Decryption {
	
	//the String use for mapping the decrypted alphabet
	private final String alphaUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final String alphaLower = "abcdefghijklmnopqrstuvwxyz";
	
	int keyA;
	int keyB;
	int x;
	String message;
	
	public Decryption(){
		message = "";
	}
	
	// function for decryption process
	public void decryptMessage(char cMsg){
		
		// the indicator for mapping the decryption alphabet
		int newX = -1;
		
		// if the input char is an alphabet
		if(Character.isAlphabetic(cMsg)){
			
			//if the input char is in upper case
			if(Character.isUpperCase(cMsg)){
				x = alphaUpper.indexOf(cMsg);
				//calculate the new location
				newX = (keyA * (x - keyB) % 26);
				
				//insure the new location is between 0 and 25  
				if(newX<0){
					newX+=26;
				}else if(newX>25){
					newX-=26;
				}
				
				// compute the decrypted char with alphaUpper ,
				// and append the decrypted alphabet to the return string
				message = message + alphaUpper.charAt(newX);
				
			}else{
				//if the input char is in lower case
				x = alphaLower.indexOf(cMsg);
				//calculate the new location
				newX = (keyA * (x - keyB) % 26);
				
				//insure the new location is between 0 and 25 
				if(newX<0){
					newX+=26;
				}else if(newX>25){
					newX-=26;
				}
				
				// compute the decrypted char with alphaLower ,
				// and append the decrypted alphabet to the return string
				message = message + alphaLower.charAt(newX);
				
			}
		}else{
			// if the input char is not an alphabet, 
			//skip the decryption process
			message = message + cMsg;
		}
    
		
	}
	
	// calculate the decryption key a, which is multiplicative inverse of key a
	public void setDecyptKey(int a, int b){
		keyB = b;
		
		int flag = 0;
		
		for (int i = 0; i < 26; i++)
        {
            flag = (a * i) % 26;
            if (flag == 1)
            {
            	keyA = i;
            }
        }
	}
	
	//return the decrypted message
	public String getMessage(){
		return message;
	}
	
	// Reset the value of message
	public void newLine(){
		message ="";
	}
}
