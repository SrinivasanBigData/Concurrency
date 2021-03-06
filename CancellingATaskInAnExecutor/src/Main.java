import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Main {

	
	public static void main(String[] args) {
	
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		
		Task task = new Task();
		
		System.out.println("Main: Executing the task");
		
		Future<String> result = executor.submit(task);
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main: Cancelling the task");
		result.cancel(true);
		
		System.out.println("Main: Cancelled: " + result.isCancelled());
		System.out.println("Main: Done: " + result.isDone());
		
		executor.shutdown();
		
		System.out.println("Main: The executor has finished");

	}

}
