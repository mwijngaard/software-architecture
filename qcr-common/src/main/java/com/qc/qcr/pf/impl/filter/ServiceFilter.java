package com.qc.qcr.pf.impl.filter;

import com.qc.qcr.pf.AbstractActiveFilter;
import com.qc.qcr.pf.DataPipe;
import com.qc.qcr.pf.impl.model.LogData;
import com.qc.qcr.pf.impl.model.LogDataType;

public class ServiceFilter extends AbstractActiveFilter<LogData<Integer>, LogData<Integer>> {

	public ServiceFilter(DataPipe<LogData<Integer>> inputPipe, DataPipe<LogData<Integer>> outputPipe) {
		super(inputPipe, outputPipe);
	}

	@Override
	public void process(DataPipe<LogData<Integer>> inputPipe, DataPipe<LogData<Integer>> outputPipe) {
		LogData<Integer> inData = inputPipe.read();
		if(inData == null) {
			outputPipe.closeForWriting();
			stop();
		}
		else if(inData.getType() == LogDataType.EXCEPTION || inData.getType() == LogDataType.VERBOSE || inData.getType() == LogDataType.WARNING) {
			outputPipe.write(inData);
		}
	}

}
