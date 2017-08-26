package com.cts.res.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.res.data.ReservationFulfillment;
import com.cts.res.service.impl.ReservationServiceImpl;

@Controller
@RequestMapping(value = "/reservation")
public class ReservationController {

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	@ResponseBody
	public ReservationFulfillment getCreateReservation() {
		ReservationServiceImpl reservationImpl = new ReservationServiceImpl();
		return reservationImpl.createReservation();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ReservationFulfillment postCreateReservation() {
		ReservationServiceImpl reservationImpl = new ReservationServiceImpl();
		return reservationImpl.createReservation();
	}

}
