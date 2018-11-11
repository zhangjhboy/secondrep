import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMain {
	public static void main(String[] args) {
        //第一个的演示示例
/*		BlockingQueue<String> list = new ArrayBlockingQueue<String>(1000);
        for(int cnt = 0; cnt < 1000; cnt++){
            list.offer("abc");
        }
        ThreadSafeDemo1 demo1 = new ThreadSafeDemo1(list);
        ThreadSafeDemo1 demo2 = new ThreadSafeDemo1(list);
        Thread thread1 = new Thread(demo1);
        Thread thread2 = new Thread(demo2);
        thread1.start();
        thread2.start();*/

        //第二个的演示示例
        //List<String> list = new ArrayList<String>();
		//BlockingQueue<String> list = new ArrayBlockingQueue<String>(100);
/*        ThreadSafeDemo2 demo1 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo2 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo3 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo4 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo5 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo6 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo7 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo8 = new ThreadSafeDemo2(list);
        ThreadSafeDemo2 demo9 = new ThreadSafeDemo2(list);
        ThreadSafeDemo3 demo10 = new ThreadSafeDemo3(list);
        new Thread(demo1).start();
        new Thread(demo2).start();
        new Thread(demo3).start();
        new Thread(demo4).start();
        new Thread(demo5).start();
        new Thread(demo6).start();
        new Thread(demo7).start();
        new Thread(demo8).start();
        new Thread(demo9).start();
        new Thread(demo10).start();*/
        
        //使用线程池
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(9);
        BlockingQueue<String> list = new ArrayBlockingQueue<String>(100);
        for (int i = 0; i < 9; i++)
        {
        	ThreadSafeDemo2 demo = new ThreadSafeDemo2(list);
        	fixedThreadPool.execute(demo);
        }
        ThreadSafeDemo3 demo10 = new ThreadSafeDemo3(list);
        new Thread(demo10).start();
        fixedThreadPool.shutdown();
    }

}
