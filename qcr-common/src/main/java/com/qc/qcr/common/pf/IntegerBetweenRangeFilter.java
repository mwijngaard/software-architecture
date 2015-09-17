package com.qc.qcr.common.pf;

public class IntegerBetweenRangeFilter implements DataFilter<Integer, Integer> {

	private final int lowerBound;
	private final int upperBound;

	public IntegerBetweenRangeFilter(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	@Override
	public void process(DataPipe<Integer> inputPipe, DataPipe<Integer> outputPipe) {
		// TODO pass inputs that are between 60 and 100 to a pipe
		Integer inData = inputPipe.read();

		// Check whether the data is (equal or greater than lowerBound) and
		// (equal or lower than upperBound)
		if (inData >= lowerBound && inData <= upperBound) {
			outputPipe.write(inData);
		}
	}

}
