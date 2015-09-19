package com.qc.qcr.sensor.domain;

import java.util.Date;

public class BloodPressureData extends SensorData<Integer> {
	public BloodPressureData(Integer value, Date timestamp) {
		super(SensorDataType.BLOOD_PRESSURE, value, timestamp);
	}
}
