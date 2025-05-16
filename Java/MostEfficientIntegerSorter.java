package app;

import java.util.List;

public final class MostEfficientIntegerSorter {
	
	private static void prIntArray(int[] arr) {
		
		for (int i : arr)
			System.out.print(i + "  ");
		System.out.println();
		
	}
	
	//Exponentially more efficient than its recursive variation IF AND ONLY IF the array length is known/fixed
	public static int[] IntSort(int[] arr) {
		
		//TODO: Replace with lambda
		class RedoFormula {
			
			private static int calculateRedos(int arrayLength) {
				
				return arrayLength - 37;
				
			}
			
		}
		
		int temp, n;
		for (int i = 0; i < RedoFormula.calculateRedos(arr.length); i++) {
			n = temp = 0;
			while (n < arr.length - 1) {
				if (arr[n] > arr[n + 1]) {
					temp = arr[n];
					arr[n] = arr[n + 1];
					arr[n + 1] = temp;
				}
				n++;
			}
		}
		return arr;
		
	}
	
	//Most efficient manner of handling arbitrarily-sized unsorted integer arrays
	public static int[] RecursiveIntSort(int[] arr) {
		
		int temp;
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] > arr[i + 1]) {
				temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
				return RecursiveIntSort(arr);
			}
		return arr;
		
	}
	
	public static int[] MidSort(int[] arr) {
		
		class MidThread implements Runnable {
			
			private int[] arr;
			
			MidThread(int arr[]) {
				
				this.arr = arr;
				
			}

			@Override
			public void run() { IntSort(arr); }
			
			
		}
		
		int i, n, midpoint, fHalf[], sHalf[];
		Thread t1, t2;
		
		midpoint = arr.length / 2;
		fHalf = new int[midpoint];
		sHalf = new int[midpoint];
		for (i = n = 0; i < midpoint; i++, n++)
			fHalf[i] = arr[n];
		for (i = 0; i < midpoint; i++, n++)
			sHalf[i] = arr[n];
		t1 = new Thread(new MidThread(fHalf));
		t2 = new Thread(new MidThread(sHalf));
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (i = n = 0; i < midpoint; i++, n++)
			arr[n] = fHalf[i];
		for (i = 0; i < midpoint; i++, n++)
			arr[n] = sHalf[i];
		return IntSort(arr);
		
	}
	
	//DOESNT WORK BUT I DONT KNOW WHY
	public static List<Integer> IntegerSort(List<Integer> arr) {
		
		Integer temp;
		int n;
		for (int i = 0; i < 2; i++) {
			n = 0;
			temp = null;
			while (n < arr.size() - 1) {
				if (arr.get(n) > arr.get(n + 1)) {
					System.out.println("LARR INTEGER " + arr.get(n) + " AT INDEX " + n + " IS GREATER THAN " + arr.get(n + 1) + " AT INDEX " + (n + 1));
					temp = arr.get(n);
					arr.set(n, arr.get(n + 1));
					arr.set(n++ + 1, temp);
					for (Integer il : arr)
						System.out.print(il + "  ");
					System.out.println();
				}
				n++;
			}
		}
		System.out.println();
		return arr;
		
	}
	
}