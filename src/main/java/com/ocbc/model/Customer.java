package com.ocbc.model;

public class Customer {
	public final static String TYPE_VIP = "VIP";
	public final static String TYPE_NORMAL = "NORMAL";
	public final static String TYPE_QUICK = "QUICK";
	
	
	private String type;
	private long time;
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public long getTime() {
		return time;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
}
