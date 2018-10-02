package com.smartcar.apiservice.responses.gm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityResponse
{
    private String service;
    private String status;
    private SecurityData data;

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

    public SecurityData getData()
    {
        return data;
    }

    public void setData(SecurityData data)
    {
        this.data = data;
    }
}
