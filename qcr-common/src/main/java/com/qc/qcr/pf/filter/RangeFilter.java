package com.qc.qcr.pf.filter;

import com.qc.qcr.pf.DataFilter;
import com.qc.qcr.pf.DataPipe;
import com.qc.qcr.sensor.domain.SensorData;

public class RangeFilter implements DataFilter<SensorData<Integer>, SensorData<Integer>> {

	private final int lowerBound;
	private final int upperBound;

	public RangeFilter(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	@Override
	public void process(DataPipe<SensorData<Integer>> inputPipe, DataPipe<SensorData<Integer>> outputPipe) {
		
		SensorData<Integer> inData = inputPipe.read();
		if(lowerBound == -1){
			if (inData.getValue() < upperBound) {
				outputPipe.write(inData);
			}
		}else if(upperBound == -1){
			if (inData.getValue() > lowerBound) {
				outputPipe.write(inData);
			}
		}else{
			if (inData.getValue() >= lowerBound && inData.getValue() <= upperBound) {
				outputPipe.write(inData);
			}
		}
		
	}
	

}
