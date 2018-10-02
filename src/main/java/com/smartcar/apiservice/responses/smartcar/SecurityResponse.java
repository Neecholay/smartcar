package com.smartcar.apiservice.responses.smartcar;


public class SecurityResponse
{
    Door[] doors;

    public SecurityResponse(Door[] doors)
    {
        this.doors = doors;
    }

    public static SecurityResponse fromGmResponse(com.smartcar.apiservice.responses.gm.SecurityResponse gmResponse) throws ClassNotFoundException
    {
        com.smartcar.apiservice.responses.gm.Door[] gmDoors =
                (com.smartcar.apiservice.responses.gm.Door[]) gmResponse.getData().getDoors().getDoorArray();

        Door[] doors = new Door[gmDoors.length];
        for (int i = 0; i < gmDoors.length; i++)
        {
            Door door = new Door();
            door.setLocation((String) gmDoors[i].getLocation().getValue());
            door.setLocked(Boolean.valueOf((String) gmDoors[i].getLocked().getValue()));
            doors[i] = door;
        }
        return new SecurityResponse(doors);
    }

    public Door[] getDoors()
    {
        return doors;
    }

    public void setDoors(Door[] doors)
    {
        this.doors = doors;
    }
}
