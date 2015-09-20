package com.qc.qcr.pf.filter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.qc.qcr.pf.filter.DataFactoryFilter;
import com.qc.qcr.sensor.domain.HeartRateData;
import com.qc.qcr.sensor.domain.SensorData;

public class SensorDataFilterTest extends AbstractDataFilterTest<Map<String,Integer>, SensorData<Integer>> {

	public SensorDataFilterTest() {
		super(new DataFactoryFilter());
		Map<String,Integer> map = new HashMap<String,Integer>();
		String key = "Heart Rate";
		map.put(key, 10);
		setInputData(Arrays.asList(map));
		setExpectedOutput(Arrays.asList(new HeartRateData(10)));
	}

	
}
