package com.cts.res.service.impl;

import com.cts.res.data.AIOutputContext;
import com.cts.res.data.ReservationFulfillment;
import com.cts.res.mapper.CommonUtils;

public class ReservationServiceImpl implements ReservationService {

	public ReservationFulfillment createReservation() {

		long resNumber = CommonUtils.generateReservationId();
		ReservationFulfillment resv = new ReservationFulfillment();
		
		resv.setSpeech("Reservation created successfully. Your reservation Id is "+resNumber);
		resv.setDisplayText("Reservation #"+resNumber);
		
		final AIOutputContext aiOutputContext = new AIOutputContext();
		aiOutputContext.setName("CarBooking");
		resv.setContextOut(aiOutputContext);
		
		return resv;
	}
}
