package uk.sevensixtwo.backend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="datasheet", schema="ProjectWork")
public class project implements Serializable{
	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name="projectID")
    private Long projectID;
    
    @Column(name="projectName")
    private String projectName;
    
    @Column(name="projectURL")
    private String projectURL;
    
    @Column(name="projectImageURL")
    private String projectImageURL;	
	
	public project(){}
    public project(Long projectID, String projectName, String projectURL, String projectImageURL) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.projectURL = projectURL;
		this.projectImageURL = projectImageURL;
	}

	public Long getProjectID() {
		return projectID;
	}

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectURL() {
		return projectURL;
	}

	public void setProjectURL(String projectURL) {
		this.projectURL = projectURL;
	}

	public String getProjectImageURL() {
		return projectImageURL;
	}

	public void setProjectImageURL(String projectImageURL) {
		this.projectImageURL = projectImageURL;
	}
}
