package com.qc.qcr.pf.filter;

import com.qc.qcr.pf.DataPipe;
import com.qc.qcr.pf.DataSink;

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
