public class LCS {
	
	int sorter(String s1, String s2, int m, int n) {
		
		while (n < s1.length() && m < s2.length()) {
			
			if (s1.charAt(n) == s1.charAt(m)) {
				
				return 1 + sorter(s1, s2, m + 1, n + 1);
				
			}
			sorter(s1, s2, m + 1, n + 1);
			
		}
		return 0;
		
	}
	
	public static void main(String[] args) {
		
		new LCS();
		
	}
	
	public LCS() {
		
		System.out.println(sorter("ABC", "ABCDEER", 0, 0));
		
	}

}
