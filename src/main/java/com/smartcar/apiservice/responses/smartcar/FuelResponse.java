package com.smartcar.apiservice.responses.smartcar;

import com.smartcar.apiservice.responses.gm.FuelBatteryResponse;

public class FuelResponse
{
    private Double percent;

    public FuelResponse()
    {
    }

    public FuelResponse(Double percent)
    {
        this.percent = percent;
    }

    public static FuelResponse fromGmResponse(FuelBatteryResponse gmResponse) throws NumberFormatException, ClassNotFoundException
    {
        Double fuelLevel = Double.valueOf((String) gmResponse.getData().getTankLevel().getValue());
        return new FuelResponse(fuelLevel);
    }

    public Double getPercent()
    {
        return percent;
    }
}
