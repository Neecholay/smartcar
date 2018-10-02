package com.smartcar.apiservice.responses.gm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Doors
{
    private String type;

    @JsonProperty("values")
    private Door[] doorArray;

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Door[] getDoorArray()
    {
        return doorArray;
    }

    public void setDoorArray(Door[] doorArray)
    {
        this.doorArray = doorArray;
    }
}
