package com.smartcar.apiservice.responses.gm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityData
{
    private Doors doors;

    public Doors getDoors()
    {
        return doors;
    }

    public void setDoors(Doors doors)
    {
        this.doors = doors;
    }
}
