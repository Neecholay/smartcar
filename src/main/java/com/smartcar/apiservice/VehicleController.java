package com.smartcar.apiservice;

import com.smartcar.apiservice.responses.gm.EngineRequest;
import com.smartcar.apiservice.responses.smartcar.*;
import org.apache.catalina.Engine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehicles/")
public class VehicleController
{
    private final String BATTERY_LEVEL = "{id}/battery";
    private final String VEHICLE_INFO = "{id}";
    private final String SECURITY = "{id}/doors";
    private final String FUEL = "{id}/fuel";
    private final String ENGINE = "{id}/engine";


    private Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = BATTERY_LEVEL, produces = "application/json")
    public BatteryResponse getBatteryLevel(@PathVariable String id) throws Exception
    {
        try
        {
            return vehicleService.getBatteryLevel(id);
        }
        catch (Exception ex)
        {
            logger.error("Failed to get battery level id={} errorType={} exceptionMessage={}", id, ex.getClass(), ex.getMessage());
            return new BatteryResponse(null);
        }
    }

    @GetMapping(value = FUEL, produces = "application/json")
    public FuelResponse getFuel(@PathVariable String id)
    {
        try
        {
            return vehicleService.getFuel(id);
        }
        catch (Exception ex)
        {
            logger.error("Failed to get fuel info id={} errorType={} exceptionMessage={}", id, ex.getClass(), ex.getMessage());
            return new FuelResponse(null);
        }
    }

    @GetMapping(value = VEHICLE_INFO, produces = "application/json")
    public VehicleInfoResponse getVehicleInfo(@PathVariable String id)
    {
        try
        {
            return vehicleService.getVehicleInfo(id);
        }
        catch (Exception ex)
        {
            logger.error("Failed to get vehicle info id={} errorType={} exceptionMessage={}", id, ex.getClass(), ex.getMessage());
            return new VehicleInfoResponse(null, null, null, null);
        }
    }

    @GetMapping(value = SECURITY, produces = "application/json")
    public SecurityResponse getSecurity(@PathVariable String id)
    {
        try
        {
            return vehicleService.getSecurity(id);
        }
        catch (Exception ex)
        {
            logger.error("Failed to get door security info id={} errorType={} exceptionMessage={}", id, ex.getClass(), ex.getMessage());
            return new SecurityResponse(null);
        }
    }

    @PostMapping(value = ENGINE, produces = "application/json")
    public EngineReponse affectEngine(@PathVariable String id,
                                      @RequestBody EngineRequest request)
    {
        try
        {
            return vehicleService.affectEngine(id, request);
        }
        catch (Exception ex)
        {
            logger.error("Failed to get door security info id={} errorType={} exceptionMessage={}", id, ex.getClass(), ex.getMessage());
            return new EngineReponse(null);
        }
    }
}
