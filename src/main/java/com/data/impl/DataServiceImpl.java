package com.data.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.bo.BaseResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public BaseResponse retrieveData() {

		BaseResponse bR = new BaseResponse();
		try {
			String file = getClass().getClassLoader().getResource("data/employee.json").getFile();
			bR = objectMapper.readValue(new FileInputStream(file), BaseResponse.class);
			// bR.setEmployee(employee);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bR;
	}
}
