import java.io.*;
import java.util.*;

public class RansomNote {
	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.out.println("Usage: ransomNote <text file>");
			return;
		}
	
		System.out.println("Loading: " + args[0]);

		int[] karakan = new int[256];

		try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
			int ch = reader.read();
			while (ch != -1) {
				karakan[ch]++;
				ch = reader.read();
			}
		}	
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + args[0]);
			return;
		}

		System.out.println(Arrays.toString(karakan));
	}
}
