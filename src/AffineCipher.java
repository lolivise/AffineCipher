import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Name: Chi-Che Hung
 * Student ID: 18705665
 * 
 * This is the main function of the program, which is able to let user
 * select whether enter key a and key b manually or run all the possible
 * key automatically.
 * **/

public class AffineCipher {
	
	private static KeyVerifier keyVerifier;
	private static Process process;

	public static void main(String[] args) throws IOException {
		
		int a;
		int b = 10;
		String s;
		keyVerifier = new KeyVerifier();
		process = new Process();
		
		Scanner sc = new Scanner(System.in);
		
		// Ask user whether running the testing
		do{
			System.out.println("Do you want to run the test mode?(y/n)");
			s = sc.next().toLowerCase();
		}while((!s.equals("y"))&&(!s.equals("n")));
		
		// if yes, run all the possible key a  
		if(s.equals("y")){
			for(a = 1; a<26; a++){
				System.out.println("for keyA equals to " + a);
				
				// If key a is eligible, process encryption and decryption
				// Otherwise, skip this key
				if(keyVerifier.verify(a)){
					process.run(a, b);
				}
			}
			
		}else{
			// if no, ask user to enter key a and key b
			do{
				System.out.println("Enter the key a: ");
				a = sc.nextInt();
				System.out.println("Enter the key b: ");
				b = sc.nextInt();
			}while(!keyVerifier.verify(a)); // while key a is not eligible, ask user to enter another key a again
			
			// if key a is eligible, process encryption and decryption
			process.run(a, b);
		}
		
		System.out.println("Done"); 

	}

}
