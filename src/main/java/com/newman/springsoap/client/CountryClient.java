package com.newman.springsoap.client;

import com.newman.springsoap.gen.GetCountryRequest;
import com.newman.springsoap.gen.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CountryClient extends WebServiceGatewaySupport {
    private static final Logger logger = LoggerFactory.getLogger(CountryClient.class);

    public GetCountryResponse getCountry(String country) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        logger.info("Requesting information for " + country);
        WebServiceTemplate wst = new WebServiceTemplate();

        GetCountryResponse response = (GetCountryResponse) wst.marshalSendAndReceive(request);

        return response;
    }
}
