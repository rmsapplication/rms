package com.app.rms.controller;
import java.util.List;

/**
 * 
 * @author NT00477646
 * UserController for bench users
 *	
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.rms.model.UserInfo;
import com.app.rms.service.BenchUserManagementService;

/**
 * 
 * @author NT477646
 *
 */
@RestController
@RequestMapping("/rms")
public class BenchUserManagementController {
	@Autowired
	private BenchUserManagementService benchuserservice;
	
	/**
	 * Getting bench user details of specific employee_id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getBenchUserInfo/{user_id}", method = RequestMethod.GET,produces ="application/json")
	    public ResponseEntity<List<UserInfo>> getBenchUserDetails(@PathVariable("user_id") String id) throws Exception{
		List<UserInfo> listusers = benchuserservice.getBenchUserDetails(id);
	        return new ResponseEntity<List<UserInfo>>(listusers, HttpStatus.OK);
	    }
}
