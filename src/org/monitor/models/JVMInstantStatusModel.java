package org.monitor.models;

/**
 * Model to represent the instant status of the JVM
 * 
 * @author khalil.amdouni
 * 
 */
public class JVMInstantStatusModel {

	private String time;
	private double memory;
	private long processNumber;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getMemory() {
		return memory;
	}

	public void setMemory(double memory) {
		this.memory = memory;
	}

	public long getProcessNumber() {
		return processNumber;
	}

	public void setProcessNumber(long processNumber) {
		this.processNumber = processNumber;
	}

}
