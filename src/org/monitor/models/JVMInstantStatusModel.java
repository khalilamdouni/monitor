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
	private long classesCount;
	private String jitCompilerName;
	private long jitCompilationTime;
	private long heapUsage;
	private long nonHeapUsage;
	private int unusedObjectNumber;

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

	public long getClassesCount() {
		return classesCount;
	}

	public void setClassesCount(long classesCount) {
		this.classesCount = classesCount;
	}

	public String getJitCompilerName() {
		return jitCompilerName;
	}

	public void setJitCompilerName(String jitCompilerName) {
		this.jitCompilerName = jitCompilerName;
	}

	public long getJitCompilationTime() {
		return jitCompilationTime;
	}

	public void setJitCompilationTime(long jitCompilationTime) {
		this.jitCompilationTime = jitCompilationTime;
	}

	public long getHeapUsage() {
		return heapUsage;
	}

	public void setHeapUsage(long heapUsage) {
		this.heapUsage = heapUsage;
	}

	public long getNonHeapUsage() {
		return nonHeapUsage;
	}

	public void setNonHeapUsage(long nonHeapUsage) {
		this.nonHeapUsage = nonHeapUsage;
	}

	public int getUnusedObjectNumber() {
		return unusedObjectNumber;
	}

	public void setUnusedObjectNumber(int unusedObjectNumber) {
		this.unusedObjectNumber = unusedObjectNumber;
	}

}
