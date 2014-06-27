import java.util.Random;

public class SecureDatabaseEncryption{
	
	public static String newRandomString(){
		StringBuffer toReturn = new StringBuffer();
		int randomStringLength;
		Random charIndex = new Random();
		randomStringLength = 6 + (int)(Math.random() * ((12 - 6) + 1));
		String characters = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!\"#$%&'()*+,-./:;<=?@[]^`{}|~";
		for(int i = 0; i < randomStringLength; i++){
	    toReturn.append(characters.charAt(charIndex.nextInt(characters.length())));
		}
		return toReturn.toString();
	}
	
	public static int makeHashEncryption(String input, String randomChar){
		input += randomChar;
		return input.hashCode();
	}
	
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