package com.qc.qcr.common.pf;

public class BloodPressureData extends DataObject {
	static String TYPE = "bloodpressure";
	private Integer value;
	private Integer timestamp;
	
	public BloodPressureData(Integer value, Integer timestamp) {
		super(BloodPressureData.TYPE);
		this.setValue(value);
		this.setTimestamp(timestamp);
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	private void setValue(Integer value) {
		this.value = value;
	}
	
	public Integer getTimestamp() {
		return timestamp;
	}
	private void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

}
