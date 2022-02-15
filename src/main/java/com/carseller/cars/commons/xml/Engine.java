package com.carseller.cars.commons.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Engine {
	@JacksonXmlProperty(localName = "power", isAttribute = true)
	private Integer power;
	@JacksonXmlProperty(localName = "type", isAttribute = true)
	private String type;
}