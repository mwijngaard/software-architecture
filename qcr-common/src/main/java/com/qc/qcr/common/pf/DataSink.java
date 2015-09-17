package com.qc.qcr.common.pf;

public interface DataSink<T> {
	public void takeFrom(DataPipe<T> pipe);
}
