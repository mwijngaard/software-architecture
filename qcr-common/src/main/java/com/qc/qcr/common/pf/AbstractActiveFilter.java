package com.qc.qcr.common.pf;

public abstract class AbstractActiveFilter<I, O> implements DataFilter<I, O>, Runnable {

	private final DataPipe<I> inputPipe;
	private final DataPipe<O> outputPipe;

	private Thread thread;

	public AbstractActiveFilter(DataPipe<I> inputPipe, DataPipe<O> outputPipe) {
		this.inputPipe = inputPipe;
		this.outputPipe = outputPipe;
	}

	public synchronized void start() {
		if (thread == null) {
			thread = new Thread(this);

			thread.start();
		}
	}

	public synchronized void stop() {
		if(thread!=null){
			thread.interrupt();
			thread = null;
		}
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			process(inputPipe, outputPipe);
		}
	}

}
