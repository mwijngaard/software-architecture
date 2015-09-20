package com.qc.qcr.sensor.domain;

import java.util.Date;

public class HeartRateData extends SensorData<Integer> {
	public HeartRateData(Integer value) {
		super(SensorDataType.HEART_RATE, value, new Date());
	}
}