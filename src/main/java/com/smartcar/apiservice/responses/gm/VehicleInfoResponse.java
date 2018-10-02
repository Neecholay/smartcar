package com.smartcar.apiservice.responses.gm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleInfoResponse
{
    private String service;
    private String status;
    private VehicleInfoData data;

    public String getService()
    {
        return service;
    }

    public void setService(String service)
    {
        this.service = service;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public VehicleInfoData getData()
    {
        return data;
    }

    public void setData(VehicleInfoData data)
    {
        this.data = data;
    }
}
