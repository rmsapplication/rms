package com.app.rms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.app.rms.model.UserInfo;
import com.app.rms.model.UserLoginInfo;

/**
 * 
 * @author NT00477646
 * BenchUserManagementDao to fetch the bech user details from DB
 *
 */
@Repository
public class BenchUserManagementDao {
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Value("emp_id")
	private String emp_id;
	@Value("emp_name")
	private String emp_name;
	@Value("primary_skill")
	private String primary_skill;
	
	/**
	 * This method fetches the bench user details from DB
	 * @param id
	 * @return
	 */
	/*public UserInfo getBenchUserDetails(String id){
		UserInfo userinfo = new UserInfo();
		
		userinfo = jdbctemplate.queryForObject("SELECT * from USER_I where emp_id=?", new Object[] { id }, new RowMapper<UserInfo>(){

			@Override
			public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserInfo userinfo = new UserInfo();
				userinfo.setUser_id(rs.getString(emp_id));
				userinfo.setUser_name(rs.getString(emp_name));
				userinfo.setPromary_skill(rs.getString(primary_skill));
				return userinfo;
			}}
			);	
		return userinfo;
	}*/
	
	public List<UserInfo> getBenchUserDetails(String id) throws Exception, SQLException{
		List<UserInfo> listOfUsers = jdbctemplate.query("select * from user_info where emp_id=?", new Object[]{id},  new RowMapper<UserInfo>(){

			@Override
			public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserInfo userinfo = new UserInfo();
				userinfo.setEmpId(rs.getString(emp_id));
				userinfo.setEmpName(rs.getString(emp_name));
				userinfo.setBwStartDate(rs.getDate("bw_start_date"));
				userinfo.setBwAge(rs.getInt("bw_age"));
				userinfo.setPrimarySkill(rs.getString("primary_skill"));
				userinfo.setCurrentStatus(rs.getString("current_status"));
				userinfo.setNoOfIntervAttended(rs.getInt("noofintervattended"));
				userinfo.setNameOfCustomer(rs.getString("nameofcustomer"));
				userinfo.setInterviewStatus(rs.getString("interviewstatus"));
				
				userinfo.setPrevProjCode(rs.getString("prev_proj_code"));
				userinfo.setPresentMgrName(rs.getString("present_mgr_name"));
				userinfo.setAllocationStatus(rs.getString("allocation_status"));
				
				/*userinfo.setUser_id(rs.getString(emp_id));
				userinfo.setUser_name(rs.getString(emp_name));
				userinfo.setPromary_skill(rs.getString(primary_skill));*/
				return userinfo;
			}});
		
		return listOfUsers;
	}
	
	
}
