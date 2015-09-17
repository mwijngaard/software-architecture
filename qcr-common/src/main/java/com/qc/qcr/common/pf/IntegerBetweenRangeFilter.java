package com.qc.qcr.common.pf;

public class IntegerBetweenRangeFilter implements DataFilter<Integer, Integer> {

	@Override
	public void process(DataPipe<Integer> inputPipe, DataPipe<Integer> outputPipe) {
		// TODO pass inputs that are between 60 and 100 to a pipe
		Integer inData = inputPipe.read();
		int upperBound = 60;
		int lowerBound = 100;
		
		if(inData >= lowerBound && inData <= upperBound){
			outputPipe.write(inData);
		}
		
	}
	
	
	
}
