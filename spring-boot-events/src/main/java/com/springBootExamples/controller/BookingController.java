package com.springBootExamples.controller;

import com.springBootExamples.service.ReservationService;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.sax.SAXResult;

@RestController
@RequestMapping("/book")
public class BookingController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public void bookHotel(@RequestBody HotelBookRequest hotelBookRequest) {
        reservationService.publishReservationEvent(hotelBookRequest);
        System.out.println("User request is in progress" + hotelBookRequest);
    }

}
