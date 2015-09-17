package com.qc.qcr.common.pf;

public class IntegerToStringFilter implements DataFilter<Integer, String> {
	@Override
	public void process(DataPipe<Integer> inputPipe, DataPipe<String> outputPipe) {
		outputPipe.write(inputPipe.read().toString());
	}
}
