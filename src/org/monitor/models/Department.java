package org.monitor.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * JPA entity representing the organization department
 * 
 * @author khalil.amdouni
 * 
 */
@Entity
@Table(name = "IS_DEPARTMENT")
public class Department extends AbstractModel {

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private List<Application> applications;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

}
