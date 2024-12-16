public class pretty {

	public static void main(String[] args) {
		
			Thread t = new Thread(new threader());
			t.start();

	}

}
class threader implements Runnable {

	public void run() {
	
	for (int i = 0; i < 20; i++) {

			try {
				Thread.sleep(200);
				if (i % 2 == 0) {

					System.out.print("|");
				
				} else {

					System.out.print("/");

				}
			} catch (InterruptedException e) {

				e.printStackTrace();
			
			}
			System.out.print("\b");
		}
	
	}

}
