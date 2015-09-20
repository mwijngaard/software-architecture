package com.qc.qcr.pf;

public interface DataSink<T> {
	public void takeFrom(DataPipe<T> pipe);
}
