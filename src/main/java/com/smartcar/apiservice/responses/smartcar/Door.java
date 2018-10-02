package com.smartcar.apiservice.responses.smartcar;

public class Door
{
    private String location;
    private Boolean locked;

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Boolean getLocked()
    {
        return locked;
    }

    public void setLocked(Boolean locked)
    {
        this.locked = locked;
    }
}
