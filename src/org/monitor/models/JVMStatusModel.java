package org.monitor.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.icefaces.ace.model.chart.CartesianSeries;

/**
 * Model to represent the monitoring chart
 * 
 * @author khalil.amdouni
 *
 */
public class JVMStatusModel implements Serializable {

	private static final long serialVersionUID = -1233344375679584590L;
	private List<CartesianSeries> processDatas = new ArrayList<CartesianSeries>();
	private List<CartesianSeries> heapUsageDatas = new ArrayList<CartesianSeries>();
	private List<CartesianSeries> nonHeapUsageDatas = new ArrayList<CartesianSeries>();
	private List<CartesianSeries> classCountDatas = new ArrayList<CartesianSeries>();

	private List<String> xAxis = new ArrayList<String>();
	private long processNumber;

	public List<CartesianSeries> getProcessDatas() {
		return processDatas;
	}

	public void setProcessDatas(List<CartesianSeries> processDatas) {
		this.processDatas = processDatas;
	}

	public List<CartesianSeries> getHeapUsageDatas() {
		return heapUsageDatas;
	}

	public void setHeapUsageDatas(List<CartesianSeries> heapUsageDatas) {
		this.heapUsageDatas = heapUsageDatas;
	}

	public List<CartesianSeries> getNonHeapUsageDatas() {
		return nonHeapUsageDatas;
	}

	public void setNonHeapUsageDatas(List<CartesianSeries> nonHeapUsageDatas) {
		this.nonHeapUsageDatas = nonHeapUsageDatas;
	}

	public List<CartesianSeries> getClassCountDatas() {
		return classCountDatas;
	}

	public void setClassCountDatas(List<CartesianSeries> classCountDatas) {
		this.classCountDatas = classCountDatas;
	}

	public List<String> getxAxis() {
		return xAxis;
	}

	public void setxAxis(List<String> xAxis) {
		this.xAxis = xAxis;
	}

	public long getProcessNumber() {
		return processNumber;
	}

	public void setProcessNumber(long processNumber) {
		this.processNumber = processNumber;
	}

}
