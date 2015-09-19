package com.qc.qcr.pf;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDataPipe<T> implements DataPipe<T> {

	private final BlockingQueue<T> dataQueue;
	private boolean isClosed;

	public BlockingQueueDataPipe() {
		dataQueue = new LinkedBlockingQueue<T>();
	}

	@Override
	public T read() {
		T data;

		data = null;

		// Keep trying to read until the queue is either empty or closed
		while (!dataQueue.isEmpty() || !isClosedForWriting()) {
			try {
				data = dataQueue.poll(1000, TimeUnit.MILLISECONDS);

				if (data != null) {
					return data;
				}
			} catch (InterruptedException ex) {
				// TODO: Do something with this later
				return null;
			}
		}

		return data;
	}

	@Override
	public void write(T data) {
		dataQueue.add(data);
	}

	public synchronized boolean isClosedForWriting() {
		return isClosed;
	}

	@Override
	public synchronized void closeForWriting() {
		isClosed = true;
	}

}
