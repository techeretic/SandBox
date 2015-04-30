import java.util.concurrent.LinkedBlockingQueue;



//ThreadPool has a non-blocking post method that returns without blocking, 
//and promises to run the passed Runnable at some point in the future.
//
//Implement a class SequentialExecutor that wraps ThreadPool, and also has a non-blocking post method, but 
//guarantees that the Runnables will be run sequentially, in the order they are given.
public class SequentialScheduler {
	/*
	ThreadPool threadPool;
	LinkedBlockingQueue<Runnable> myQueue = new LinkedBlockingQueue<Runnable>();
	private static Worker sWorker;
	
	public void addTask(Runnable r) {
		myQueue.add(r);
	}
	
	public void post() {
		if (worker == null) {
			worker = new Worker
		}
	}

	private static Integer takeFromQueue() {
        if (workerQueue == null) {
            return null;
        }
        try {
            return workerQueue.take();
        } catch (InterruptedException e) {
            Log.e(LOG_TAG, "workerQueue Exception", e);
            return null;
        }
    }
	
	class ThreadPool {
		public void post(Runnable r) {
			new Thread(r).start();
		}
	}

	class Worker extends Thread {
		Runnable mRun;
		
		public Worker() {
			super("SequentialScheduler");
		}

		@Override
		public void run() {
            super.run();
            int count = takeFromQueue();
		}
	}
	*/
}
/*



class SequentialExecutor {
List<Runnable> runnables;
SequentialExecutor(ThreadPool pool) {
 // Fill in
 
}
public void post(Runnable r) {
 // Fill in
 new Thread(r).start();
 
}

public class MyRunnable implements Runnable {

   public static interface RunnableComplete {
         public int done();
   }

   @Override
   public void run() {
       //Do something
   }
}
}
*/