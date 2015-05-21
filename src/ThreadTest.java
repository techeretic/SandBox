
public class ThreadTest {

	public static void main(String[] args) {
	
		MyThread thread1 = new MyThread(1);
		MyThread thread2 = new MyThread(2);
		MyThread thread3 = new MyThread(3);
		
		while (true) {
			thread1.run();
			thread2.run();
			thread3.run();
		}
	}


	private static class MyThread implements Runnable {
		int data = 0;
		
		public MyThread(int data) {
			this.data = data;
		}
		
		public void run() {
			System.out.print(data + " ");
			try {
				Thread.sleep(1000);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
}
