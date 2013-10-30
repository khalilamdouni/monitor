package org.monitor.models;

import java.util.List;

import org.icefaces.ace.model.chart.CartesianSeries;

/**
 * Model to represent the monitoring chart
 * 
 * @author khalil.amdouni
 *
 */
public class JVMStatusModel {

	private List<CartesianSeries> datas;
	private String[] xAxis;

	public List<CartesianSeries> getDatas() {
		return datas;
	}

	public void setDatas(List<CartesianSeries> datas) {
		this.datas = datas;
	}

	public String[] getxAxis() {
		return xAxis;
	}

	public void setxAxis(String[] xAxis) {
		this.xAxis = xAxis;
	}

}
