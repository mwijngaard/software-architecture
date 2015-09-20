package com.qc.qcr.pf;

public abstract class AbstractActiveDataSource<T> implements DataSource<T>, Runnable {

	private final DataPipe<T> outputPipe;

	private Thread thread;

	public AbstractActiveDataSource(DataPipe<T> outputPipe) {
		this.outputPipe = outputPipe;
	}

	public synchronized void start() {
		if (thread == null) {
			thread = new Thread(this);

			thread.start();
		}
	}

	public synchronized void stop() {
		if (thread != null) {
			thread.interrupt();
			thread = null;
		}
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			generateInto(outputPipe);
		}
	}
}
