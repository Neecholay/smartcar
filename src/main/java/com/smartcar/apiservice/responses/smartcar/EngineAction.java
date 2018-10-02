package com.smartcar.apiservice.responses.smartcar;


public enum EngineAction
{
    START,
    STOP;

    public static EngineAction getFromString(String actionString)
    {
        for (EngineAction action : EngineAction.values())
        {
            if (action.name().equalsIgnoreCase(actionString))
            {
                return action;
            }
        }

        throw new IllegalArgumentException("Cannot find enum for actionString " + actionString);
    }
}
