package uk.sevensixtwo.backend.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.mysql.cj.jdbc.PreparedStatement;

import uk.sevensixtwo.backend.models.project;
import uk.sevensixtwo.backend.util.*;

@Stateless
@Default
public class dbProjectService implements projectService {
	
	@Inject
	private JSONUtil util;
	
	@Inject
	private Database db;
	
	public List<project> getAllProjects(Connection conn) throws SQLException {
		List<project> projectList = new ArrayList<project>();
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement("SELECT * FROM datasheet");
		try {
			ResultSet RS = statement.executeQuery();
			while(RS.next()){
				project pobox = new project();
				
				pobox.setProjectID(RS.getLong("projectID"));
				pobox.setProjectName(RS.getString("projectName"));
				pobox.setProjectURL(RS.getString("projectURL"));
				pobox.setProjectImageURL(RS.getString("projectImageURL"));
				
				projectList.add(pobox);
			}
		} catch (SQLException exx) {
			exx.printStackTrace();
		}

		
		return projectList;
	}
	
	public project getProjectFromID(Connection conn, Long projectID) throws SQLException {
		project pobox = new project();
		PreparedStatement statement = (PreparedStatement)conn.prepareStatement("SELECT * FROM datasheet WHERE projectID ='" + projectID + "';");
		
		try {
			ResultSet RS = statement.executeQuery();
			while(RS.next()){
				pobox.setProjectID(RS.getLong("projectID"));
				pobox.setProjectName(RS.getString("projectName"));
				pobox.setProjectURL(RS.getString("projectURL"));
				pobox.setProjectImageURL(RS.getString("projectImageURL"));
			}
		} catch (SQLException exx) {
			exx.printStackTrace();
		}
		
		return pobox;
	}

	public String listAllProjects() {
		String tmp = "";
		try{
			tmp = util.getJSONForObject(getAllProjects(db.getConnection()));
		}catch(Exception exx){
			exx.printStackTrace();
		}
			
		return tmp;
	}

	public String listProjectByID(Long projectID) {
		String tmp = "";
		try{
			tmp = util.getJSONForObject(getProjectFromID(db.getConnection(), projectID));
		}catch(Exception exx){
			exx.printStackTrace();
		}

		return tmp;
	}

}
