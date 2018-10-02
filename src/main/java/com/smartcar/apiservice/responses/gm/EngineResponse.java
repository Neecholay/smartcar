package com.smartcar.apiservice.responses.gm;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EngineResponse
{
    private String service;
    private String status;
    private Map<String, String> actionResult;

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

    public Map<String, String> getActionResult()
    {
        return actionResult;
    }

    public void setActionResult(Map<String, String> actionResult)
    {
        this.actionResult = actionResult;
    }
}
