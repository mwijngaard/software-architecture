package com.qc.qcr.common.pf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;

public class ReportFilter extends AbstractActiveFilter<SensorData<Integer>, SensorData<String>> {
	private Queue<BloodPressureData> bloodPressureQueue;
	private Queue<HeartRateData> heartRateQueue;
	//constructor
	public ReportFilter(DataPipe<SensorData<Integer>> inputPipe, DataPipe<SensorData<String>> outputPipe) {
		super(inputPipe, outputPipe);
	}
	
	@Override
	public void process(DataPipe<SensorData<Integer>> inputPipe, DataPipe<SensorData<String>> outputPipe) {
		SensorData<Integer> sensordata;
		do {
			sensordata = inputPipe.read();
			if (sensordata != null) {
				if (sensordata.getType() == SensorDataType.HEART_RATE)
					heartRateQueue.add((HeartRateData)sensordata);
				else if (sensordata.getType() == SensorDataType.BLOOD_PRESSURE)
					bloodPressureQueue.add((BloodPressureData)sensordata);
			}
		} while (sensordata != null);
		BloodPressureData bloodPressure = null;
		HeartRateData heartRate = null;
		Date date = null;
		if (bloodPressureQueue.isEmpty() || heartRateQueue.isEmpty()) {
			SensorData<String> output = new SensorData<String>(SensorDataType.REPORT, "", new Date());
			outputPipe.write(output);
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		final Object[][] table = new String[bloodPressureQueue.size()+1][];
		table[0] = new String[] { "date", "blood pressure", "heart rate" };
		for (int i = 1; i <= bloodPressureQueue.size(); i++) {
			bloodPressure = bloodPressureQueue.remove();
			heartRate = heartRateQueue.remove();
			table[i] = new String[] {
					dateFormat.format(bloodPressure.getTimeStamp()),
					bloodPressure.getValue().toString(),
					heartRate.getValue().toString()
					};
		}
		String finalTable = "";
		for (final Object[] row : table) {
		    finalTable += String.format("%15s%15s%15s\n", row);
		}
		SensorData<String> output = new SensorData<String>(SensorDataType.REPORT, finalTable, new Date());
		outputPipe.write(output);
	}
}
