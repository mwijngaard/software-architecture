package com.qc.qcr.common.pf;

public class ReportFilter extends AbstractActiveFilter<Integer, String> {
	
	//constructor
	public ReportFilter(DataPipe<Integer> inputPipe, DataPipe<String> outputPipe) {
		super(inputPipe, outputPipe);
	}
	
	
	public void process(DataPipe<Integer> inputPipe, DataPipe<String> outputPipe) {

	}
}
