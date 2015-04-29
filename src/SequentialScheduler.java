

//ThreadPool has a non-blocking post method that returns without blocking, 
//and promises to run the passed Runnable at some point in the future.
//
//Implement a class SequentialExecutor that wraps ThreadPool, and also has a non-blocking post method, but 
//guarantees that the Runnables will be run sequentially, in the order they are given.
public class SequentialScheduler {

}
/*
class ThreadPool {
public void post(Runnable r);
}


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