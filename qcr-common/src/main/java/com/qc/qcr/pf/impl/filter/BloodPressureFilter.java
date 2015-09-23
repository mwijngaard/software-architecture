package com.qc.qcr.pf.impl.filter;

import com.qc.qcr.pf.AbstractActiveFilter;
import com.qc.qcr.pf.DataPipe;
import com.qc.qcr.pf.impl.model.LogData;
import com.qc.qcr.pf.impl.model.LogDataType;

public class BloodPressureFilter extends AbstractActiveFilter<LogData<Integer>, Integer> {

	Integer sum = 0;
	Integer count = 0;
	
	public BloodPressureFilter(DataPipe<LogData<Integer>> inputPipe, DataPipe<Integer> outputPipe) {
		super(inputPipe, outputPipe);
	}

	@Override
	public void process(DataPipe<LogData<Integer>> inputPipe, DataPipe<Integer> outputPipe) {
		LogData<Integer> inData = inputPipe.read();
		if(inData == null) {
			if(count==0){
				outputPipe.write(0);
			}
			else{
				outputPipe.write(sum/count);
			}
			outputPipe.closeForWriting();
			stop();
		}
		else if(inData.getType() == LogDataType.BLOOD_PRESSURE) {
			sum += inData.getValue();
			count++;
		}
	}

}
