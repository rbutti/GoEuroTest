package com.goeuro.javatest.loc2csv.facade;

import java.util.List;

import com.goeuro.javatest.loc2csv.domain.City;
import com.goeuro.javatest.loc2csv.exception.GoEuroApplicationException;

/**
 * A facade interface for retrieving the data from a location API using Spring's
 * RestTemplate
 * 
 * @author rbutti
 */
public interface GoEuroLocationAPIFacade {

    /**
     * A concrete implementation of this class should have the required logic to
     * initialize a RestTemple for a given input URI and retrieve data from the
     * URI.
     * 
     * @param cityName
     *            - Name of the city passes as command line argument
     * @param uri
     *            - URI of the Location API
     * @return - List of City object containing city details
     * @throws GoEuroApplicationException
     */
    public List<City> retriveCityDetails(String cityName, String uri) throws GoEuroApplicationException;
}
