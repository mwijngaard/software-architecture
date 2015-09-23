package com.qc.qcr.pf.impl.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogData<E> {
	LogDataType type;
	Calendar date;
	E value;
	
	@Override
	public String toString(){
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return type.toString() + " - " + format1.format(date.getTime()) + " - " + value.toString();
	}
	public LogDataType getType() {
		return type;
	}
	public void setType(LogDataType type) {
		this.type = type;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public E getValue() {
		return value;
	}
	public void setValue(E value) {
		this.value = value;
	}
}
