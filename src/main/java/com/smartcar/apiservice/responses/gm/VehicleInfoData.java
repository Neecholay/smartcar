package com.smartcar.apiservice.responses.gm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleInfoData
{
    private GMPair vin;
    private GMPair color;
    private GMPair fourDoorSedan;
    private GMPair twoDoorCoupe;
    private GMPair driveTrain;

    public GMPair getVin()
    {
        return vin;
    }

    public void setVin(GMPair vin)
    {
        this.vin = vin;
    }

    public GMPair getColor()
    {
        return color;
    }

    public void setColor(GMPair color)
    {
        this.color = color;
    }

    public GMPair getFourDoorSedan()
    {
        return fourDoorSedan;
    }

    public void setFourDoorSedan(GMPair fourDoorSedan)
    {
        this.fourDoorSedan = fourDoorSedan;
    }

    public GMPair getTwoDoorCoupe()
    {
        return twoDoorCoupe;
    }

    public void setTwoDoorCoupe(GMPair twoDoorCoupe)
    {
        this.twoDoorCoupe = twoDoorCoupe;
    }

    public GMPair getDriveTrain()
    {
        return driveTrain;
    }

    public void setDriveTrain(GMPair driveTrain)
    {
        this.driveTrain = driveTrain;
    }
}
