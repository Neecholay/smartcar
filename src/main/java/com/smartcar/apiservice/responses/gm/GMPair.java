package com.smartcar.apiservice.responses.gm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GMPair
{
    private String type;
    private Object value;

    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }
}
