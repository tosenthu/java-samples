package com.senthu.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Consumer implements Runnable {

	private Lock lockObject = null;
	private List<String> queue = null;

	public Consumer(Lock lockObject, List<String> queue) {
		this.lockObject = lockObject;
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Started");
		int count = -1;
		while (count++ < 5) {
			if (!this.queue.isEmpty()) {
				this.lockObject.lock();
				System.out.println("Consumer : " + Thread.currentThread().getName() + ": Lock Aquired.. ");
				if (!this.queue.isEmpty()) {
					System.out.println("Consumer : " + Thread.currentThread().getName() + ": Popped an element "
							+ this.queue.remove(0));
				}
				this.lockObject.unlock();
				System.out.println("Consumer : " + Thread.currentThread().getName() + ": Lock Released.. ");
			}
			try {
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " Ends");
	}

}

class Producer implements Runnable {

	private Lock lockObject = null;
	private List<String> queue = null;

	public Producer(Lock lockObject, List<String> queue) {
		this.lockObject = lockObject;
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Started");
		for (int i = 0; i < 5; i++) {
			this.lockObject.lock();
			System.out.println("Producer : " + Thread.currentThread().getName() + " Lock Aquired");
			this.queue.add("Producer " + (i + 1));
			System.out.println("Producer : " + Thread.currentThread().getName() + ": Lock Released.. ");
			this.lockObject.unlock();
			try {
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " Ends");
	}
}

public class ProducerConsumer {

	public static void main(String[] args) {
		Lock lockObject = new ReentrantLock();
		List<String> queue = new ArrayList<String>();
		Producer producer = new Producer(lockObject, queue);
		List<Thread> consumerList = new ArrayList<Thread>();
		Thread producerThread = new Thread(producer, "producer-thread");
		producerThread.start();
		for (int i = 0; i < 10; i++) {
			Thread consumerThread = new Thread(new Consumer(lockObject, queue), "consumer-thread-" + (i + 1));
			consumerList.add(consumerThread);
			consumerThread.start();
		}

		for (Thread thread : consumerList) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			producerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main Ends");
	}
}