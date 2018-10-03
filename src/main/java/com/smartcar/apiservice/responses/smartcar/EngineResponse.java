package com.smartcar.apiservice.responses.smartcar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EngineResponse
{
    private String status;

    public EngineResponse(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public static EngineResponse fromGmResponse(com.smartcar.apiservice.responses.gm.EngineResponse gmResponse)
    {
        String gmStatus = gmResponse.getActionResult().get("status");

        String status;
        switch (gmStatus)
        {
            case "EXECUTED":
                status = "success";
                break;
            case "FAILED":
                status = "error";
                break;
            default:
                status = "unknown";
                break;
        }

        return new EngineResponse(status);
    }
}
