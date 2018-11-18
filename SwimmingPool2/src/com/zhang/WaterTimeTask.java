package com.zhang;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class WaterTimeTask extends TimerTask{
	@Override
    public void run() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
        InputThread thread1 = new InputThread(queue);
        InputThread thread2 = new InputThread(queue);
        InputThread thread3 = new InputThread(queue);
        OutputThread thread4 = new OutputThread(queue);
        OutputThread thread5 = new OutputThread(queue);
        OutputThread thread6 = new OutputThread(queue);
        List<Callable<Object>> threadList = new ArrayList<>(6);
        threadList.add(thread1);
        threadList.add(thread2);
        threadList.add(thread3);
        threadList.add(thread4);
        threadList.add(thread5);
        threadList.add(thread6);
        List<Object> returnValue = null;
        try {
            returnValue = ThreadUtil.runCheckCallable(threadList,true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Ó¾³ØÒÑ¾­×¢Âú");
        System.out.println(returnValue.get(0));
        System.out.println(returnValue.get(1));
        System.out.println(returnValue.get(2));
        System.out.println(returnValue.get(3));
        System.out.println(returnValue.get(4));
        System.out.println(returnValue.get(5));
    }

}
