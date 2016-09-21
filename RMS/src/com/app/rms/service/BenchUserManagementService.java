package com.app.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rms.dao.BenchUserManagementDao;
import com.app.rms.model.UserInfo;

@Service
public class BenchUserManagementService {
	@Autowired
	private BenchUserManagementDao benchusermanagementdao;
	public List<UserInfo> getBenchUserDetails(String id) throws Exception{
		List<UserInfo> userinfo = benchusermanagementdao.getBenchUserDetails(id);
		return userinfo;
	}
}
