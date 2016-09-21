package com.app.rms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.rms.model.UserInfo;
import com.app.rms.model.UserLoginInfo;
import com.app.rms.service.UserLoginService;

/**
 * 
 * @author NT477646
 *
 */
@RestController
@RequestMapping("/rms")
public class UserLoginController {
	
	@Autowired
	private UserLoginService userLoginService;
	
	/**
	 * getting the users list based on login id
	 * @param userlogininfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getUserInfo", method = {RequestMethod.POST,RequestMethod.GET},produces ="application/json", consumes ="application/json" )
	public ResponseEntity<List<UserInfo>> startLogin(@RequestBody UserLoginInfo userlogininfo) throws Exception{
		List<UserInfo> listOfUsers = userLoginService.getUserInfo(userlogininfo.getEmpId());
		return new ResponseEntity<List<UserInfo>>(listOfUsers, HttpStatus.OK);
	}
		
}
