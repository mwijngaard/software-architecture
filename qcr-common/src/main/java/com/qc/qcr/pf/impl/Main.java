package com.qc.qcr.pf.impl;

import com.qc.qcr.pf.BlockingQueueDataPipe;
import com.qc.qcr.pf.DataPipe;
import com.qc.qcr.pf.impl.filter.BloodPressureFilter;
import com.qc.qcr.pf.impl.filter.ExceptionFilter;
import com.qc.qcr.pf.impl.filter.PrintFilter;
import com.qc.qcr.pf.impl.filter.ServiceFilter;
import com.qc.qcr.pf.impl.model.LogData;

public class Main {

	public static void main(String[] args) {


		DataPipe<LogData<Integer>> pipe1 = new BlockingQueueDataPipe<LogData<Integer>>();
		DataPipe<LogData<Integer>> pipe1a = new BlockingQueueDataPipe<LogData<Integer>>();
		DataPipe<LogData<Integer>> pipe2 = new BlockingQueueDataPipe<LogData<Integer>>();
		DataPipe<LogData<Integer>> pipe3 = new BlockingQueueDataPipe<LogData<Integer>>();
		DataPipe<Integer> pipe4 = new BlockingQueueDataPipe<Integer>();
		
		//Exceptions
		RandomLogGenerator rnd = new RandomLogGenerator(pipe1, pipe1a);
		ServiceFilter serviceFilter = new ServiceFilter(pipe1, pipe2);
		ExceptionFilter expFilter = new ExceptionFilter(pipe2, pipe3);
		PrintFilter<LogData<Integer>> printFilter = new PrintFilter<LogData<Integer>>(pipe3, null);

		//AVG blood pressure
		BloodPressureFilter bpf = new BloodPressureFilter(pipe1a, pipe4);
		
		//Pulse while sleeping
		BloodPressureFilter pws = new BloodPressureFilter(pipe1a, pipe4);
		
		//Pulse while awake
		BloodPressureFilter pwa = new BloodPressureFilter(pipe1a, pipe4);
		
		PrintFilter<Integer> printFilterHealth = new PrintFilter<Integer>(pipe4, null);
		
		
		rnd.start();
		serviceFilter.start();
		expFilter.start();
		printFilter.start();
		
		/* Because there exists no implementation of branching, only one of these 3 may run at any given time */
		//bpf.start();
		//pws.start();
		pwa.start();
		
		
		printFilterHealth.start();
		
		
	}

}
