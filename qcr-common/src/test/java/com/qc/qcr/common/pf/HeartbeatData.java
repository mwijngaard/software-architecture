package com.qc.qcr.common.pf;

public class HeartbeatData extends DataObject {
	static String TYPE = "heartbeat";
	private Integer value;
	private Integer timestamp;
	
	public HeartbeatData(Integer value, Integer timestamp) {
		super(HeartbeatData.TYPE);
		this.setValue(value);
		this.setTimestamp(timestamp);
	}

	public Integer getValue() {
		return value;
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
