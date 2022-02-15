package com.carseller.cars.commons.xml;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class Model {
    @JacksonXmlProperty(localName = "name",isAttribute = true)
    private String name;
    @JacksonXmlProperty(localName = "line",isAttribute = true)
    private String line;
    @JacksonXmlProperty(localName = "from",isAttribute = true)
    private Integer from;
    @JacksonXmlProperty(localName = "to",isAttribute = true)
    private Integer to;
    @JacksonXmlProperty(localName = "type",isAttribute = true)
    private String type;
    @JacksonXmlProperty(localName = "ENGINE")
    private Engine engineDTO;
    @JacksonXmlProperty(localName = "WHEELS")
    private Wheels wheelsDTO;
    @JsonInclude(value = Include.NON_ABSENT)
    @JacksonXmlProperty(localName = "SUBMODELS")
    private List<Model> submodels;
}
