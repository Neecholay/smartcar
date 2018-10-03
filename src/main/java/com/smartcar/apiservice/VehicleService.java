package com.smartcar.apiservice;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartcar.apiservice.responses.gm.EngineRequest;
import com.smartcar.apiservice.responses.gm.FuelBatteryResponse;
import com.smartcar.apiservice.responses.smartcar.*;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * A service for hitting GM endpoints and translating the responses into Smartcar responses
 */
@Component
public class VehicleService
{
    final static String GM_BASE_URL = "http://gmapi.azurewebsites.net";
    final static String GM_ENERGY_SERVICE_ENDPOINT = "/getEnergyService";
    final static String GM_VEHICLE_INFO_SERVICE_ENDPOINT = "/getVehicleInfoService";
    final static String GM_SECURITY_SERVICE_ENDPOINT = "/getSecurityStatusService";
    final static String GM_ENGINE_ENDPOINT = "/actionEngineService";

    final static String GM_START_COMMAND = "START_VEHICLE";
    final static String GM_STOP_COMMAND = "STOP_VEHICLE";

    final Logger logger = LoggerFactory.getLogger(VehicleService.class);

    public BatteryResponse getBatteryLevel(final String id) throws IOException, ClassNotFoundException
    {
        String response = getHTTPResponseFromGM(GM_BASE_URL + GM_ENERGY_SERVICE_ENDPOINT, id);
        FuelBatteryResponse gmResponse = new ObjectMapper().readValue(response, FuelBatteryResponse.class);
        return BatteryResponse.fromGmResponse(gmResponse);
    }

    public FuelResponse getFuel(final String id) throws IOException, ClassNotFoundException
    {
        String response = getHTTPResponseFromGM(GM_BASE_URL + GM_ENERGY_SERVICE_ENDPOINT, id);
        FuelBatteryResponse gmResponse = new ObjectMapper().readValue(response, FuelBatteryResponse.class);
        return FuelResponse.fromGmResponse(gmResponse);
    }

    public VehicleInfoResponse getVehicleInfo(final String id) throws Exception
    {
        String response = getHTTPResponseFromGM(GM_BASE_URL + GM_VEHICLE_INFO_SERVICE_ENDPOINT, id);
        com.smartcar.apiservice.responses.gm.VehicleInfoResponse gmResponse =
                new ObjectMapper().readValue(response, com.smartcar.apiservice.responses.gm.VehicleInfoResponse.class);
        return VehicleInfoResponse.fromGmResponse(gmResponse);
    }

    public SecurityResponse getSecurity(final String id) throws Exception
    {
        String response = getHTTPResponseFromGM(GM_BASE_URL + GM_SECURITY_SERVICE_ENDPOINT, id);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        com.smartcar.apiservice.responses.gm.SecurityResponse gmResponse =
                new ObjectMapper().readValue(response, com.smartcar.apiservice.responses.gm.SecurityResponse.class);

        return SecurityResponse.fromGmResponse(gmResponse);
    }

    public EngineResponse affectEngine(final String id, final EngineRequest request) throws IllegalArgumentException, IOException
    {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("id", id);
        requestParams.put("command", determineGMCommand(request.getAction()));
        String response = getHTTPResponseFromGM(GM_BASE_URL + GM_ENGINE_ENDPOINT, requestParams);
        com.smartcar.apiservice.responses.gm.EngineResponse gmResponse = new ObjectMapper().readValue(response, com.smartcar.apiservice.responses.gm.EngineResponse.class);
        return EngineResponse.fromGmResponse(gmResponse);
    }

    private String getHTTPResponseFromGM(String gmApi, Map<String, String> requestParams) throws IOException
    {
        requestParams.put("responseType", "JSON");
        URL url = new URL(gmApi);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes(new ObjectMapper().writeValueAsString(requestParams));
        dataOutputStream.flush();
        dataOutputStream.close();

        connection.connect();

        final InputStream is = connection.getInputStream();
        final String response = IOUtils.toString(is);
        is.close();

        return response;
    }

    private String getHTTPResponseFromGM(String gmApi, String id) throws IOException
    {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("id", id);
        return getHTTPResponseFromGM(gmApi, requestParams);
    }

    private String determineGMCommand(EngineAction action)
    {
        switch (action)
        {
            case START:
                return GM_START_COMMAND;
            case STOP:
                return GM_STOP_COMMAND;
            default:
                throw new IllegalArgumentException(
                        String.format("Cannot convert EngineAction '%s' to GM command", action == null ? "null" : action.name()));
        }
    }
}
