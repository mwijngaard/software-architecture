package com.qc.qcr.common.pf;

public interface DataPipe<T> {
	public T read();

	public void write(T data);
}
