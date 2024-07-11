package com.practice;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task implements Runnable {
	private final int taskId;

	public Task(int taskId) {
		this.taskId = taskId;
	}

	@Override
	public void run() {
		System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000); // Simulate some work
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task " + taskId + " is completed");
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			Runnable task = new Task(i);
			executor.submit(task);
		}
		executor.shutdown();
	}
}
