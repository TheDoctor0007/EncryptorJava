import java.util.InputMismatchException;
import java.util.Scanner;


public class Encryption {
	
	static String encrypt(String word, int key) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			char newCh = (char) ('A' + (ch - 'A' + key) % 26);
			key += ch;
			sb.append(newCh);
		}
		String encrWord = sb.toString();
		return encrWord;
	}
	
	static String decrypt(String word, int key) {
		//int shiftBack = -key;
		String temp = encrypt(word, key);
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < temp.length(); i++) {
			char ch = temp.charAt(i);
			char newCh = (char) ('A' + (ch + 'A' - key) % 26);
			key = ch;
			sb2.append(newCh);
		}
		String decrWord = sb2.toString();
		return decrWord;
	}
	
	public static void main(String[] args) {
		//String test1 = encrypt("ARGUMENT", 14);
		//System.out.println(test1);
		//System.out.println(decrypt("ARGUMENT", 14));
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a word or phrase to encrypt: ");
		String word = input.nextLine();
		word = word.replaceAll("\\s", "").toUpperCase();
		System.out.println(word);
		System.out.print("Enter an integer to use for encryption: ");
		int shiftNum = 0;
		try {
			shiftNum = input.nextInt();
		} catch (InputMismatchException ime) {
			System.err.println("Error: The input must be an integer. Please rerun the program.");
			System.exit(0);
		}
		String encrWord = encrypt(word, shiftNum);
		System.out.println("Encrypted: " + encrWord);
		String decrWord = decrypt(word, shiftNum);
		System.out.println("Decrypted: " + decrWord);
	}

}
