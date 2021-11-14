package com.springBootExamples.service;

import com.springBootExamples.controller.BookingController;
import com.springBootExamples.controller.HotelBookRequest;
import com.springBootExamples.event.ReservationCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void publishReservationEvent(HotelBookRequest hotelBookRequest) throws InterruptedException {
        Thread.sleep(5000L);
        applicationEventPublisher.publishEvent(new ReservationCreatedEvent(hotelBookRequest));
    }
}
