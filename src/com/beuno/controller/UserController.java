package com.beuno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beuno.Dao.ObjectDao;
import com.beuno.Dao.UserDetailsDao;
import com.beuno.bo.Response;
import com.beuno.model.UserDetails;

@RestController
public class UserController {

	@Autowired
	private ObjectDao objectDao;
	
	@Autowired
	private UserDetailsDao userDetailsDao;

	@CrossOrigin
	@RequestMapping(value = "/web/add-user-detail", method = RequestMethod.POST)
	private Response addUserDetails(@RequestBody UserDetails userDetails) {

		Response response = new Response();
		try {
			UserDetails ud = new UserDetails();
			ud.setfName(userDetails.getfName());
			ud.setmName(userDetails.getmName());
			ud.setlName(userDetails.getlName());
			ud.setmNo(userDetails.getmNo());
			ud.setGender(userDetails.getGender());
			ud.setEmailId(userDetails.getEmailId());
			ud.setPassword(userDetails.getPassword());
			ud.setCountry(userDetails.getCountry());
			ud.setArea(userDetails.getArea());

			objectDao.saveObject(ud);
			response.setMessage("Record inserted successfully");
			response.setStatus("200");
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus("500");
			response.setMessage("Couldn't perform the request.");
			response.setResult(e.getMessage());
			return response;
		}

	}
	
	@CrossOrigin
	@RequestMapping(value="/web/get-data", method=RequestMethod.GET)
	private Response getAllData(){
		Response response = new Response();
		try {
			response.setStatus("200");
			response.setMessage("List Of Users");
			List<UserDetails> list = userDetailsDao.getAllUserData();
			response.setResult(list);
			return response;
		} catch (Exception e) {
			response.setStatus("500");
			response.setMessage(e.getMessage());
			return response;
		}
	}

}