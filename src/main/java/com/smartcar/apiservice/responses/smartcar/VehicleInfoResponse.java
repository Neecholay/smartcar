package com.smartcar.apiservice.responses.smartcar;


public class VehicleInfoResponse
{
    private String vin;
    private String color;
    private Integer doorCount;
    private String driveTrain;

    public VehicleInfoResponse()
    {
    }

    public VehicleInfoResponse(String vin, String color, Integer doorCount, String driveTrain)
    {
        this.vin = vin;
        this.color = color;
        this.doorCount = doorCount;
        this.driveTrain = driveTrain;
    }

    public static VehicleInfoResponse fromGmResponse(com.smartcar.apiservice.responses.gm.VehicleInfoResponse gmResponse) throws Exception
    {
        VehicleInfoResponse response = new VehicleInfoResponse();
        response.setVin((String) gmResponse.getData().getVin().getValue());
        response.setColor((String) gmResponse.getData().getColor().getValue());
        response.setDriveTrain((String) gmResponse.getData().getDriveTrain().getValue());

        Boolean twoDoors = Boolean.valueOf((String) gmResponse.getData().getTwoDoorCoupe().getValue());
        Boolean fourDoors = Boolean.valueOf((String) gmResponse.getData().getFourDoorSedan().getValue());
        if (twoDoors == fourDoors)
        {
            throw new Exception(String.format("Cannot determine number of doors twoDoor=%b fourDoor=%b", twoDoors, fourDoors));
        }

        int doorCount = twoDoors ? 2 : 4;
        response.setDoorCount(doorCount);

        return response;
    }

    public String getVin()
    {
        return vin;
    }

    public void setVin(String vin)
    {
        this.vin = vin;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public Integer getDoorCount()
    {
        return doorCount;
    }

    public void setDoorCount(Integer doorCount)
    {
        this.doorCount = doorCount;
    }

    public String getDriveTrain()
    {
        return driveTrain;
    }

    public void setDriveTrain(String driveTrain)
    {
        this.driveTrain = driveTrain;
    }
}
