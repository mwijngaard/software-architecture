package com.qc.qcr.pf.impl.filter;

import com.qc.qcr.pf.AbstractActiveFilter;
import com.qc.qcr.pf.DataPipe;
import com.qc.qcr.pf.impl.model.LogData;

public class PrintFilter<E> extends AbstractActiveFilter<E, Void> {

	public PrintFilter(DataPipe<E> inputPipe, DataPipe<Void> outputPipe) {
		super(inputPipe, outputPipe);
	}

	@Override
	public void process(DataPipe<E> inputPipe, DataPipe<Void> outputPipe) {
		E a = null;
		while((a = inputPipe.read()) != null){
			System.out.println(a.toString());
		}
		stop();
	}

}
