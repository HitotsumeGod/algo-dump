public class binarysort {
	
	int searcher(int[] arr, int max, int min, int t) {
		
		int mid = (max + min) / 2;
		if (arr[mid] == t)
				return mid;
		if (t > arr[mid])
			return searcher(arr, max, min = mid, t);
		if (t < arr[mid])
			return searcher(arr, max = mid, min, t);
		return 666;
		
	}
	
	public static void main(String[] args) {
		
		binarysort b = new binarysort();
		int[] i = new int[] {1,2,3,4,5,6,7,8};
		int max = 8;
		int min = 1;
		System.out.println(b.searcher(i, max, min, 8));
		
	}

}
