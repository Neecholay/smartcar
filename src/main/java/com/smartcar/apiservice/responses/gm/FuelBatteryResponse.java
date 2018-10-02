package com.smartcar.apiservice.responses.gm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A class for containing the Fuel/Battery response from GM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuelBatteryResponse
{
    private String serviceName;
    private int status;
    private FuelBatteryData data;

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public FuelBatteryData getData()
    {
        return data;
    }

    public void setData(FuelBatteryData data)
    {
        this.data = data;
    }
}
