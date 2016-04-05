package com.goeuro.javatest.loc2csv.facadeImpl;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.goeuro.javatest.loc2csv.domain.City;
import com.goeuro.javatest.loc2csv.exception.GoEuroApplicationException;
import com.goeuro.javatest.loc2csv.facade.GoEuroLocationAPIFacade;
import com.goeuro.javatest.loc2csv.util.GoEuroApplicationUtil;

/**
 * A Facade Implementation of the GoEuroLocationAPIFacade interface. This class
 * has necessary logic for retrieving the data from a location API using
 * Spring's RestTemplate
 * 
 * @author rbutti
 */
public class GoEuroLocationAPIFacadeImpl implements GoEuroLocationAPIFacade {

    private final static Logger logger = Logger.getLogger(GoEuroLocationAPIFacadeImpl.class);
    private RestTemplate restTemplate;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.goeuro.javatest.loc2csv.facade.GoEuroLocationAPIFacade#retriveCityDetails
     * (java.lang.String, java.lang.String)
     */
    public List<City> retriveCityDetails(String cityName, String uri) throws GoEuroApplicationException {

	logger.debug("retriveCityDetails() | Retriving City Details Started | cityName : " + cityName);
	List<City> cityDetails = null;
	try {
	    restTemplate = new RestTemplate();

	    // Add the Jackson Message converter to map the JSON to domain
	    // object
	    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
	    messageConverters.add(new MappingJacksonHttpMessageConverter());

	    // Add the message converters to the restTemplate
	    restTemplate.setMessageConverters(messageConverters);

	    // Retrieve the data from Location API,Map the data to a list of
	    // City objects
	    cityDetails = Arrays.asList(restTemplate.getForObject(GoEuroApplicationUtil.constructLocationAPIURI(uri, cityName),
		    City[].class));

	    logger.info("retriveCityDetails() | Retriving City Details SUCCESSFUL | cityName : " + cityName + " No of Records : "
		    + cityDetails.size() + " Records :" + cityDetails);

	} catch (RestClientException e) {
	    logger.error(" retriveCityDetails() | CRITICAL ERROR : RestClient Exception occured while retrieving city details from Location API", e);
	    throw new GoEuroApplicationException(e, "CRITICAL ERROR : RestClient Exception occured while retrieving city details from Location API");
	} catch (URISyntaxException e) {
	    logger.error(" retriveCityDetails() | CRITICAL ERROR : Error while constructing URI for the API endpoint :" + uri + " and city name :"
		    + cityName, e);
	    throw new GoEuroApplicationException(e, "CRITICAL ERROR : Error while constructing URI for the API endpoint :" + uri + " and city name :"
		    + cityName);
	}
	logger.debug("retriveCityDetails() | Retriving City Details Ended | cityName : " + cityName);

	// return the retrieved data
	return cityDetails;
    }
}
