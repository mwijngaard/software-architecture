package com.qc.qcr.sensor.domain;

import java.util.Date;

public class BloodPressureData extends SensorData<Integer> {
	public BloodPressureData(Integer value) {
		super(SensorDataType.BLOOD_PRESSURE, value, new Date());
	}
}
