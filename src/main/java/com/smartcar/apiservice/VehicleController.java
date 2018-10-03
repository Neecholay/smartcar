package com.smartcar.apiservice;

import com.smartcar.apiservice.responses.gm.EngineRequest;
import com.smartcar.apiservice.responses.smartcar.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * An better API for interfacing with APIs provided by GM
 */
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

    /**
     * Returns the battery level as a percentage for the specified vehicle id
     */
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

    /**
     * Returns the fuel level as a percentage for the specified vehicle id
     */
    @GetMapping(value = FUEL, produces = "application/json")
    public FuelResponse getFuel(@PathVariable String id)
    {
        try
        {
            return vehicleService.getFuel(id);
        }
        catch (Exception ex)
        {
            logger.error("Failed to get fuel level id={} errorType={} exceptionMessage={}", id, ex.getClass(), ex.getMessage());
            return new FuelResponse(null);
        }
    }

    /**
     * Returns vehicle info for the specified vehicle id
     */
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

    /**
     * Returns lock status of the doors for the specified vehicle id
     */
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

    /**
     * Changes the engine status to the state specified in the EngineRequest for the specified vehicle id
     */
    @PostMapping(value = ENGINE, produces = "application/json")
    public EngineResponse affectEngine(@PathVariable String id,
                                       @RequestBody EngineRequest request)
    {
        try
        {
            return vehicleService.affectEngine(id, request);
        }
        catch (Exception ex)
        {
            logger.error("Failed to change the engine status id={} errorType={} exceptionMessage={}", id, ex.getClass(), ex.getMessage());
            return new EngineResponse(null);
        }
    }
}
