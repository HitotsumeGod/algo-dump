import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AdvancedLCS {

	int sorter(String s1, String s2, int m, int n) {
		
		while (n < s1.length() && m < s2.length()) {
			
			if (s1.charAt(n) == s1.charAt(m)) {
				
				return 1 + sorter(s1, s2, m + 1, n + 1);
				
			}
			sorter(s1, s2, m + 1, n + 1);
			
		}
		return 0;
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		BufferedReader buff = new BufferedReader(new FileReader("strings.txt"));
		String sir = buff.readLine();
		BufferedReader tough = new BufferedReader(new FileReader("strings.txt"));
		String miss = tough.readLine();
		System.out.println(new AdvancedLCS().sorter(sir, miss, 0, 0));
		buff.close();
		tough.close();
		
		
	}

}
