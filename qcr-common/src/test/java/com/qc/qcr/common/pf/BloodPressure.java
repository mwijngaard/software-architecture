package com.qc.qcr.common.pf;

public class BloodPressure extends DataObject {
	static String TYPE = "bloodpressure";
	private Integer value;
	private Integer timestamp;
	
	public BloodPressure(Integer value, Integer timestamp) {
		super(BloodPressure.TYPE);
		this.setValue(value);
		this.setTimestamp(timestamp);
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public Integer getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

}
