package com.springBootExamples.controller;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HotelBookRequest {
    private String userId;
    private String hotelId;
}