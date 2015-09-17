package com.qc.qcr.common.pf;

import java.util.Date;

public class BloodPressureData extends SensorData<Integer> {
	public BloodPressureData(Integer value, Date timestamp) {
		super(SensorDataType.BLOOD_PRESSURE, value, timestamp);
	}
}
