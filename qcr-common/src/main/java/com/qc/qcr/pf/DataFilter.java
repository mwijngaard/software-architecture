package com.qc.qcr.pf;

public interface DataFilter<I, O> {
	public void process(DataPipe<I> inputPipe, DataPipe<O> outputPipe);
}
