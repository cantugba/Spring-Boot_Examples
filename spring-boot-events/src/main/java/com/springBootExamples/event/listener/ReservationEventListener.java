package com.springBootExamples.event.listener;

import com.springBootExamples.event.ReservationCreatedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class ReservationEventListener {

    @EventListener
    public void reservationEventHandler(ReservationCreatedEvent reservationCreatedEvent)  {

        System.out.println("EventListener-> " + reservationCreatedEvent);
    }

}
