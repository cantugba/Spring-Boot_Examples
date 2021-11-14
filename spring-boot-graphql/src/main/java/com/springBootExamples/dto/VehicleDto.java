package com.springBootExamples.dto;

import lombok.Data;

import javax.xml.transform.sax.SAXResult;

@Data
public class VehicleDto {

    private String type;

    private String brandName;

    private String modelCode;

}
