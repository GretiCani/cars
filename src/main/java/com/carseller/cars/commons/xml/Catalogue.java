package com.carseller.cars.commons.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class Catalogue {
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "MODEL")
	private List<Model> modelDTOS;
}