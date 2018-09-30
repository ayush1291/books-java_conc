package com.chap7;

public class InterruptStatis {

	// If thread is not blocked, interrupt is of no good
	//isInterrupted method clears the interrupted status - eiither throw exception or set the flaag again, blocking methods are also interrupted using this

	public static void main(String[] args) throws InterruptedException {

		Thread th = new Thread(new MyRun());
		th.start();

		Thread.sleep(1);
		// Setting interrupt
		th.interrupt();

	}

	static class MyRun implements Runnable {

		@Override
		public void run() {

			for (int i = 0; i < 100000000; i++) {
				if (!Thread.interrupted()) {
					// If I have a blocking queue here, that will also respond to interruption
					System.out.println("Running");
				} else {
					System.out.println("Is interrupted");
					break;
				}
			}

		}
	}

}
