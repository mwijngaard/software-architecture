package com.qc.qcr.pf.impl.filter;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

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
		else if(inData.getType() == LogDataType.BLOOD_PRESSURE && daysBetween(inData.getDate(), Calendar.getInstance()) <= 7) {
			sum += inData.getValue();
			count++;
		}
	}
	
	public static long daysBetween(Calendar startDate, Calendar endDate) {
	    long end = endDate.getTimeInMillis();
	    long start = startDate.getTimeInMillis();
	    return TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
	}

}
