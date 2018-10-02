package com.smartcar.apiservice.responses.smartcar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smartcar.apiservice.responses.gm.EngineResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EngineReponse
{
    private String status;

    public EngineReponse(String status)
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

    public static EngineReponse fromGmResponse(EngineResponse gmResponse)
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

        return new EngineReponse(status);
    }
}
