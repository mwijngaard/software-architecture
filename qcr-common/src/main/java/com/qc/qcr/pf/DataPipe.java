package com.qc.qcr.pf;

public interface DataPipe<T> {
	public T read();

	public void write(T data);

	public boolean isClosedForWriting();

	public void closeForWriting();
}
