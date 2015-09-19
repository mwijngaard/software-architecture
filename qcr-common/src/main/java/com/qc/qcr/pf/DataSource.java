package com.qc.qcr.pf;

public interface DataSource<T> {
	public void generateInto(DataPipe<T> output);
}
