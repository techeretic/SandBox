import java.io.ObjectInputStream.GetField;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadPlay {

	public static void main(String[] args) {
		ThreadPlay t = new ThreadPlay();
		HashMap<Integer, Worker> threadMap = new HashMap<Integer, ThreadPlay.Worker>();
		BlockingQueue<Runnable> runQueue = new LinkedBlockingQueue<Runnable>();
		for(int i=0;i<10;i++) {
			if (i%2==0) {
				threadMap.put(i, t.new Worker(i));
				threadMap.get(i).start();
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Interrupted Exception - IN MAIN!");
				}
				threadMap.get(i-1).interrupt();
			}
		}

		for(int i=0;i<10;i++) {
			if (i==5) 
				Thread.currentThread().interrupt();
			if (i%2==0) {
				final int index = i;
				runQueue.offer(new Runnable() {
					
					@Override
					public void run() {
						System.out.println("Running Runnable No. : 10" + index);
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							System.out.println("Interrupted Exception - IN RUNNABLE : 10" + index);
						}
					}
				});
				System.out.println("Adding Runnable : 10" + i + " to Queue");
			} else {
				try {
					System.out.println("About to take Runnable : 10" + (i-1));
					runQueue.take().run();
				} catch (InterruptedException e) {
					System.out.println("Interrupted Exception while taking & running from Queue");
				}
			}
		}
	}

	public class Worker extends Thread {
		private int number = 0;
		Worker(int count) {
			super(Integer.toString(count));
			number = count;
		}
		@Override
		public void run() {
			super.run();
			System.out.println("RUNNING Thread : " + number);
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception - For Thread : " + number);
			}
		}
	}
}
