package com.qc.qcr.pf.filter;

import com.qc.qcr.pf.DataFilter;
import com.qc.qcr.pf.DataPipe;

public class IntegerToStringFilter implements DataFilter<Integer, String> {
	@Override
	public void process(DataPipe<Integer> inputPipe, DataPipe<String> outputPipe) {
		outputPipe.write(inputPipe.read().toString());
	}
}
