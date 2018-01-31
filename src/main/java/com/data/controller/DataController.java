package com.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.bo.BaseResponse;
import com.data.impl.DataService;

@Controller
@RequestMapping(value = "/retrieve")
public class DataController {

	@Autowired
	DataService dataService;
	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse getData() {
		return dataService.retrieveData();
	}
	
	@RequestMapping(value = "/dataPost", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse getDataFromPostReq() {
		return dataService.retrieveData();
	}

}
