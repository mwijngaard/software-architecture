package com.qc.qcr.pf.filter;


import java.util.Map;
import com.qc.qcr.pf.DataFilter;
import com.qc.qcr.pf.DataPipe;
import com.qc.qcr.sensor.domain.BloodPressureData;
import com.qc.qcr.sensor.domain.HeartRateData;
import com.qc.qcr.sensor.domain.SensorData;

public class DataFactoryFilter implements DataFilter<Map<String, Integer>,SensorData<Integer>> {


	public DataFactoryFilter() {
	}

	@Override
	public void process(DataPipe<Map<String, Integer>> inputPipe, DataPipe<SensorData<Integer>> outputPipe) {
		Map<String, Integer> inData = inputPipe.read();
		SensorData<Integer> sd = null;
		
		String inDataKey = (String) inData.keySet().toArray()[0];
		Integer inDataValue = inData.get(inDataKey);
		
		switch (inDataKey) {
		case "Heart Rate":
			sd = new HeartRateData(inDataValue);
			break;
		case "Blood Pressue":
			sd = new BloodPressureData(inDataValue);
			break;
		default:
			break;
		}
		outputPipe.write(sd);
		
		
	}

	

}
