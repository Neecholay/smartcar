package com.smartcar.apiservice.responses.gm;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartcar.apiservice.responses.smartcar.EngineAction;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EngineRequest
{
    private EngineAction action;

    @JsonCreator
    public EngineRequest(@JsonProperty(value = "action") String actionString)
    {
        this.action = EngineAction.getFromString(actionString);
    }

    public EngineAction getAction()
    {
        return action;
    }
}
