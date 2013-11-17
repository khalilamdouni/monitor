package org.monitor.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = 6472123587881028131L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TS_CREATE")
	private Date tsCreate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TS_UPDATE")
	private Date tsUpdate;

	@PrePersist
	protected void onCreate() {
		tsUpdate = tsCreate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		tsUpdate = new Date();
	}
}
