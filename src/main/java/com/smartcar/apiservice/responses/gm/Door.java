package com.smartcar.apiservice.responses.gm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Door
{
    private GMPair location;
    private GMPair locked;

    public GMPair getLocation()
    {
        return location;
    }

    public void setLocation(GMPair location)
    {
        this.location = location;
    }

    public GMPair getLocked()
    {
        return locked;
    }

    public void setLocked(GMPair locked)
    {
        this.locked = locked;
    }
}
