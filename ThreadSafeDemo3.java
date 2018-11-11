import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ThreadSafeDemo3 implements Runnable{
	/*private List<String> list;

    public ThreadSafeDemo3(List<String> list){
        this.list = list;
    }*/
    
    private BlockingQueue<String> list;
	
	public ThreadSafeDemo3(BlockingQueue<String> list)
	{
		this.list = list;
	}

    @Override
    public void run() {
        while(true){
            if(list.size()>0){
                list.remove(0);
                System.out.println("É¾³ýÒ»¸öºó³ß´ç£º"+list.size());
            }
        }
    }

}
