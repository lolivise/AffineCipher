/**
 * This class is for verifying whether key a is coprime to 26
 * by calculating the greatest common divider between key a and 26.
 * If the greatest common divider is 1, then key a and 26 are coprime
 * **/
public class KeyVerifier {
	
	public KeyVerifier(){
		
	}
	
	//Function for determining whether key a and 26 is coprime
	public boolean verify(int a){
		
		//if greatest gcd is 1 return true
		if(getGCD(a,26) == 1){
			return true;
		}
		
		//otherwise print error message and return false
		System.out.println("Key a is not eligible, please enter another integer for key a.\n");
		return false;
	}
	
	// Recursively calculate Euclidean Algorithm 
    public int getGCD(int a, int b) 
    { 
        // Base Case 
        if (a == 0) { 
            return b;
        } 
        
        //Recursive calculation
        int gcd = getGCD(b % a, a);  
  
        return gcd; 
    }
}
