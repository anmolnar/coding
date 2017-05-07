import java.io.*;
import java.util.*;

public class RansomNote {
	public static void main(String[] args) throws IOException {
		if (args.length < 2) {
			System.out.println("Usage: ransomNote <text file> <ransom note>");
			return;
		}

		String magazine = args[0];
		String ransomNote = args[1];

		System.out.println("Ransom note: " + ransomNote);	
		System.out.println("Loading: " + magazine);

		int[] karakan = new int[256];
		try (BufferedReader reader = new BufferedReader(new FileReader(magazine))) {
			int ch = reader.read();
			while (ch != -1) {
				karakan[ch]++;
				ch = reader.read();
			}
		}	
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
			return;
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			int kar = ransomNote.charAt(i);
			if (karakan[kar] == 0) {
				System.out.printf("Ransom note cannot be constructed. Not enough '%c' char.", kar);
				return;
			}
			karakan[kar]--;
		}

		System.out.println("OK");
	}
}

