package com.qc.qcr.common.pf;

public interface DataSource<T> {
	public void generateInto(DataPipe<T> output);
}
