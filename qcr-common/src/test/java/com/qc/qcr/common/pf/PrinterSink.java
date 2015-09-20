package com.qc.qcr.common.pf;

public class PrinterSink implements DataSink<String> {

	public PrinterSink() {
		super();
	}

	@Override
	public void takeFrom(DataPipe<String> pipe) {
		String string = null;
		do {
			string = pipe.read();
			System.out.print(string);
		} while (string != null);
		
	}

}
