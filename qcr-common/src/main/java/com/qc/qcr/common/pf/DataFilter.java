package com.qc.qcr.common.pf;

public interface DataFilter<I, O> {
	public void process(DataPipe<I> inputPipe, DataPipe<O> outputPipe);
}
