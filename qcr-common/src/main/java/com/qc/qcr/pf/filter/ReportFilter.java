package com.qc.qcr.pf.filter;

import com.qc.qcr.pf.AbstractActiveFilter;
import com.qc.qcr.pf.DataPipe;

public class ReportFilter extends AbstractActiveFilter<Integer, String> {
	
	//constructor
	public ReportFilter(DataPipe<Integer> inputPipe, DataPipe<String> outputPipe) {
		super(inputPipe, outputPipe);
	}
	
	
	public void process(DataPipe<Integer> inputPipe, DataPipe<String> outputPipe) {

	}
}
