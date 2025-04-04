package sorter;

public class Pilot {
	
	public static void main(String[] args) {

		int iArr[] = {1,10,2,10,2};
		Converter c = (int i) -> i * 2;
		ArrPrinter<Integer> arp = (arr) -> {
			for (Integer i : arr)
				System.out.println(i);
		};
		System.out.println(arp.print(MostEfficientIntegerSorter.IntSort(iArr)));

	}

}
