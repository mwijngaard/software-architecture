package com.qc.qcr.pf.filter;

import com.qc.qcr.pf.DataFilter;
import com.qc.qcr.pf.DataPipe;

public class IntegerLowerRangeFilter implements DataFilter<Integer, Integer> {

	@Override
	public void process(DataPipe<Integer> inputPipe, DataPipe<Integer> outputPipe) {
		// TODO pass inputs that are lower than 6 to a pipe
		Integer inData = inputPipe.read();
		int upperBound = 60;
		
		if(inData < upperBound){
			outputPipe.write(inData);
		}
		
	}
	
	
	
}
