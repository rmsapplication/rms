package com.app.rms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.app.rms.model.UserInfo;
import com.app.rms.model.UserLoginInfo;

@Repository
public class UserLoginDao {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public boolean isUserManager(String id) throws Exception, SQLException{
		int count = jdbctemplate.queryForObject("select count(1) from manager_info where mgr_id=?", new Object[]{id}, Integer.class);
		if(count>0){
			return true;
		}
		return false;
	}
	
	public List<UserInfo> getUserInfo() throws Exception, SQLException{
		List<UserInfo> listOfUsers = jdbctemplate.query("select * from user_info", new RowMapper<UserInfo>(){

			@Override
			public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserInfo userinfo = new UserInfo();
				userinfo.setEmpId(rs.getString("emp_id"));
				userinfo.setEmpName(rs.getString("emp_name"));
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
