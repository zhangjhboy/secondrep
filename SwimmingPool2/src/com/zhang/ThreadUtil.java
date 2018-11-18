package com.zhang;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadUtil {
	public static List<Object> runCheckCallable(List<Callable<Object>> threadList, boolean bl) throws InterruptedException, ExecutionException
	{
		List<Object> returnValue = new ArrayList<Object>();
		FutureTask<Object> futureTask1 = new FutureTask<Object>(threadList.get(0));
		FutureTask<Object> futureTask2 = new FutureTask<Object>(threadList.get(1));
		FutureTask<Object> futureTask3 = new FutureTask<Object>(threadList.get(2));
		FutureTask<Object> futureTask4 = new FutureTask<Object>(threadList.get(3));
		FutureTask<Object> futureTask5 = new FutureTask<Object>(threadList.get(4));
		FutureTask<Object> futureTask6 = new FutureTask<Object>(threadList.get(5));
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(6);
		fixedThreadPool.execute(futureTask1);
		fixedThreadPool.execute(futureTask2);
		fixedThreadPool.execute(futureTask3);
		fixedThreadPool.execute(futureTask4);
		fixedThreadPool.execute(futureTask5);
		fixedThreadPool.execute(futureTask6);
		returnValue.add(futureTask1.get());
		returnValue.add(futureTask2.get());
		returnValue.add(futureTask3.get());
		returnValue.add(futureTask4.get());
		returnValue.add(futureTask5.get());
		returnValue.add(futureTask6.get());
		fixedThreadPool.shutdown();
		return returnValue;
	}

}
