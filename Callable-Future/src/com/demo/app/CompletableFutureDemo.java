package com.demo.app;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

	public static CompletableFuture<Integer> create(){
		return CompletableFuture.supplyAsync(()->compute());
	}
	public static int compute() {
		System.out.println("Compute from "+Thread.currentThread().getName());
		return 2;
	}
	
	public static void printData(Integer data) {
		System.out.println("data is "+data);
		System.out.println("Print is called by "+Thread.currentThread().getName());
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println("Main "+Thread.currentThread().getName());
		create().thenAccept(data->printData(data));
		
		create().complete(7);
		create().complete(9);
		create().complete(8);
		create().complete(10);

		Thread.sleep(Long.MAX_VALUE);
	}

}
