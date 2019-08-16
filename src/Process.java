import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * the class used to process encryption and decryption,
 * and compare the original text and decrypted text.
 * Finally, print out the text file of encrypted text and decrypted text
 * **/

public class Process {
	
	private FileHandler fileHandler;
	private Encryption encryption;
	private Decryption decryption;
	private MatchChecker matchChecker;
	
	public Process(){}
	
	// main function of the class
	public void run(int keyA, int keyB) throws IOException{
		
		//initial list to store original text, encrypted text and decrypted text
		List<String> originalText = new ArrayList<>();
		List<String> cryptedText = new ArrayList<>();
		List<String> decriptedText = new ArrayList<>();
		
		//initial String to store encrypt and decrypt string
		String cipherText="";
		String decryptText = "";
		
		fileHandler = new FileHandler();
		encryption = new Encryption();
		decryption = new Decryption();
		matchChecker = new MatchChecker();
		
		//read the text from the test file and assign to original text list
		originalText = fileHandler.readFile();
        
		//set key a and key b for encryption process
       	encryption.setKey(keyA, keyB);
       	
       	//For every sting in original text list
       	for(String message:originalText){
       		
       		//for every index of current string
       		for(int i = 0; i < message.length();i++){
       			
               	//encrypt the current character of the string 
       			encryption.encryptMessage(message.charAt(i));
       		}
	        
       		//get the encrypted String
       		cipherText = encryption.getCipherText();
       		
       		//append the encrypt string to encrypted text list
       		cryptedText.add(cipherText);
       		
       		//reset the string value in encryption process
       		encryption.newLine();
       	}
	    
       	//set key a and key b for decryption process
       	decryption.setDecyptKey(keyA, keyB);
       	
       	//For every sting in encrypted text list
       	for(String message:cryptedText){
       		
       		//for every index of current string
       		for(int i = 0; i < message.length();i++){
       			
       			//decrypt the current character of the string   	
       			decryption.decryptMessage(message.charAt(i));
       		}
       		
       		//get the decrypted String
       		decryptText = decryption.getMessage();
       		
       		//append the decrypt string to encrypted text list
       		decriptedText.add(decryptText);
       		
       		//reset the string value in decryption process
       		decryption.newLine();
       	}
	            
       	// complare the text in the original text list and decrypted text list
	    if(matchChecker.isMatch(originalText, decriptedText)){
	    	
	    	//if match, print successful message
	       	System.out.println("Success: Decrypt text is matches to original text.\n");
	    }else{
	    	
	    	//if not match, print failure message
	       	System.out.println("Failure: Decrypt text is not matches to original text.\n");
	    }
	      
	    //write the encrypted text to file EncryptText.txt
		fileHandler.writeFile("EncryptText.txt", cryptedText);
		
		//write the decrypted text to file DecryptText.txt
		fileHandler.writeFile("DecryptText.txt", decriptedText);
        
	}

}
