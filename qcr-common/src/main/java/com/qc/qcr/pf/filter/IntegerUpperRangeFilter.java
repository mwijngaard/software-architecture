package com.qc.qcr.pf.filter;

import com.qc.qcr.pf.DataFilter;
import com.qc.qcr.pf.DataPipe;

public class IntegerUpperRangeFilter implements DataFilter<Integer, Integer> {

	@Override
	public void process(DataPipe<Integer> inputPipe, DataPipe<Integer> outputPipe) {
		// TODO pass inputs that are higher 100 to a pipe
		Integer inData = inputPipe.read();
		int lowerBound = 100;
		
		if(inData > lowerBound){
			outputPipe.write(inData);
		}
		
	}
	
	
	
}
