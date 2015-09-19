package com.qc.qcr.sensor.domain;

import java.util.Date;

public abstract class SensorData<T> {
	private final SensorDataType type;
	private final T value;
	private final Date timestamp;

	public SensorData(SensorDataType type, T value, Date timestamp) {
		this.type = type;
		this.value = value;
		this.timestamp = timestamp;
	}

	public T getValue() {
		return value;
	}

	public Date getTimeStamp() {
		return timestamp;
	}

	public SensorDataType getType() {
		return type;
	}
}
