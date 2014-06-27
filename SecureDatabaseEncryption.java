import java.util.Random;

/*
 * Class that implements the secure database password encryption functions
 * 
 * @author Naho Kitade
 */
public class SecureDatabaseEncryption{
	
	/*
	 * Creates a new random string of length between 6 to 12 characters of random ASCII characters.
	 * This is going to be stored in the database as a new 'key' column for each user at the creation 
	 * of the account.
	 * 
	 * @return a new random string of length between 6 to 12 characters of random ASCII characters.
	 */
	public static String newRandomString(){
		StringBuffer toReturn = new StringBuffer();			// string buffer since we will be concatinating a lot
		int randomStringLength;
		Random charIndex = new Random();
		
		// decide what length the random string should be. Creates a number between 6 - 12 inclusive. 
		// Code from:
		// "Generating Random Integers in a Range with Java." - Stack Overflow. N.p., 17 June 2012. Web. 27 June 2014.
		randomStringLength = 6 + (int)(Math.random() * ((12 - 6) + 1));
		
		// a string of all numbers, alphabets and puctuation in ASCII
		String characters = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!\"#$%&'()*+,-./:;<=?@[]^`{}|~";
		
		// select a random character from above string and concatinate randomStringLength times
		for(int i = 0; i < randomStringLength; i++){
	    toReturn.append(characters.charAt(charIndex.nextInt(characters.length())));
		}
		return toReturn.toString();
	}
	
	/*
	 * hashes the input concatenated with the random character string made from newRandomString
	 * stored in the third column.
	 * 
	 * @return the int that is the hash code of the two contatenated strings.
	 */
	public static int makeHashEncryption(String input, String randomChar){
		// concatenate the strings and return the hashed result.
		input += randomChar;
		return input.hashCode();
	}
	
	/*
	 * The main program that demonstrates all the functions created in
	 * this class. 
	 */
	public static void main(String args[]){
		String randomString;
		String input = "abcd";
		for(int i = 0; i < 20; i++){
			randomString = newRandomString();
			System.out.print(randomString + "   ");
			System.out.println(makeHashEncryption(input, randomString));
		}
	}
	
}