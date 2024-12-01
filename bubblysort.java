import java.util.ArrayList;

public class bubblysort {
	
	@SuppressWarnings("unused")
	ArrayList<Integer> sorter(int[] a) {
		
		//core vars
		int leng = 0;
		int temp, tempo, alto;
		for (int i : a) 
			leng++;
		for (int ir = 0; ir < leng; ir++) {
			//ascending swap
			for (int i = 0; i < leng - 1; i++) {
			
				alto = i + 1;
				if (a[i] > a[alto]) {
				
					temp = a[i];
					tempo = a[alto];
					a[i] = tempo;
					a[alto] = temp;
				
				}
			
			}
			//descending swap
			for (int i = leng - 1; i > 0; i--) {
			
				alto = i - 1;
				if (a[i] < a[alto]) {
				
					temp = a[i];
					tempo = a[alto];
					a[i] = tempo;
					a[alto] = temp;
				
				}
			
			}
		}
		//add to ArrayList and return
		ArrayList<Integer> list = new ArrayList<>();
		for (int i : a) 
			list.add(i);
		return list;
		
	}
	
	public static void main(String[] args) {
		
		bubblysort b = new bubblysort();
		int[] arr = new int[] {3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12, 3, 5, 6, 2, 1, 5, 7, 3, 9, 4, 12};
		System.out.println(b.sorter(arr));
		
	}
