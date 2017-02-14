package com.ecloudtime.model;

public class Timestamp {
	private int seconds;

	private int nanos;

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getSeconds() {
		return this.seconds;
	}

	public void setNanos(int nanos) {
		this.nanos = nanos;
	}

	public int getNanos() {
		return this.nanos;
	}

}