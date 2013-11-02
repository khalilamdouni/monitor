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
	private List<CartesianSeries> datas = new ArrayList<CartesianSeries>();
	private List<String> xAxis = new ArrayList<String>();
	private long processNumber;
	
	public List<CartesianSeries> getDatas() {
		return datas;
	}

	public void setDatas(List<CartesianSeries> datas) {
		this.datas = datas;
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
