package com.qc.qcr.pf.impl;


import java.util.Calendar;
import java.util.Random;

import com.qc.qcr.pf.DataPipe;
import com.qc.qcr.pf.impl.model.LogData;
import com.qc.qcr.pf.impl.model.LogDataType;

public class RandomLogGenerator extends Thread {
	private DataPipe<LogData<Integer>> pipe = null;
	private DataPipe<LogData<Integer>> pipe2 = null;
	
	public RandomLogGenerator(DataPipe<LogData<Integer>> _pipe, DataPipe<LogData<Integer>> _pipe2) {
		pipe = _pipe;
		pipe2 = _pipe2;
	}

	
	public void run() {
		Random randomGenerator = new Random();
		//Randomly pick one of the predefined logs and send it to the pipe
		for (int i = 1; i<= 100; i++){
			LogData<Integer> data = new LogData<Integer>();
			data.setDate(Calendar.getInstance());
			int dateDaysMinus = randomGenerator.nextInt(7);
			Calendar cal = data.getDate();
			cal.add(Calendar.DAY_OF_MONTH, -dateDaysMinus);
			cal.set(Calendar.HOUR_OF_DAY, randomGenerator.nextInt(23));
			data.setDate(cal);
			
			data.setType(LogDataType.values()[randomGenerator.nextInt(LogDataType.values().length)]);
			Integer valNum = randomGenerator.nextInt(100);
			
			data.setValue(valNum);
			pipe.write(data);
			pipe2.write(data);

		}
		//Close the pipe
		pipe.closeForWriting();
		pipe2.closeForWriting();
	}
}