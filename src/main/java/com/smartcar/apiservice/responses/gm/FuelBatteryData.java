package com.smartcar.apiservice.responses.gm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FuelBatteryData
{
    private GMPair tankLevel;
    private GMPair batteryLevel;

    public GMPair getTankLevel()
    {
        return tankLevel;
    }

    public void setTankLevel(GMPair tankLevel)
    {
        this.tankLevel = tankLevel;
    }

    public GMPair getBatteryLevel()
    {
        return batteryLevel;
    }

    public void setBatteryLevel(GMPair batteryLevel)
    {
        this.batteryLevel = batteryLevel;
    }
}
