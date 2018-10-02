package com.smartcar.apiservice.responses.smartcar;


import com.smartcar.apiservice.responses.gm.FuelBatteryResponse;

public class BatteryResponse
{
    private Double percent;

    public BatteryResponse()
    {
    }

    public BatteryResponse(Double percent)
    {
        this.percent = percent;
    }

    public static BatteryResponse fromGmResponse(FuelBatteryResponse gmResponse) throws NumberFormatException, ClassNotFoundException
    {
        Double batteryLevel = Double.valueOf((String) gmResponse.getData().getBatteryLevel().getValue());
        return new BatteryResponse(batteryLevel);
    }

    public Double getPercent()
    {
        return percent;
    }
}
