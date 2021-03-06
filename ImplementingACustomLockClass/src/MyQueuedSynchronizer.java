import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;


public class MyQueuedSynchronizer extends AbstractQueuedSynchronizer {

	private static final long serialVersionUID = 1L;
	private AtomicInteger state;
	
	public MyQueuedSynchronizer(){
		state = new AtomicInteger(0);
	}
	
	@Override
	protected boolean tryAcquire(int arg){
		return state.compareAndSet(0, 1);
	}
	
	@Override
	protected boolean tryRelease(int arg) {
		return state.compareAndSet(1, 0);
	}
}
