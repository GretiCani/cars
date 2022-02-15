package com.carseller.cars.commons.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Wheels {
    @JacksonXmlProperty(localName = "size", isAttribute = true)
    private String size;
    @JacksonXmlProperty(localName = "type", isAttribute = true)
    private String type;
}
