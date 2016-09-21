package com.app.rms.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rms.dao.BenchUserManagementDao;
import com.app.rms.dao.UserLoginDao;
import com.app.rms.model.UserInfo;

@Service
public class UserLoginService {
	
	@Autowired
	private UserLoginDao userLoginDao;
	
	@Autowired
	private BenchUserManagementDao benchusermanagementdao;
	
	public boolean isUserManager(String id) throws Exception, SQLException{
		return userLoginDao.isUserManager(id);
	}
	
	public List<UserInfo> getUserInfo(String user_id) throws Exception, SQLException{
		boolean isUserManager = isUserManager(user_id);
		List<UserInfo> listOfUsers = new ArrayList<UserInfo>();
		if(isUserManager){
			listOfUsers = userLoginDao.getUserInfo();
		}
		else{
			listOfUsers = benchusermanagementdao.getBenchUserDetails(user_id);
		}
		return listOfUsers;
		
	}
}
