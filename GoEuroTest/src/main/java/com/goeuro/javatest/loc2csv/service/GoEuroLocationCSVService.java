package com.goeuro.javatest.loc2csv.service;

import com.goeuro.javatest.loc2csv.exception.GoEuroApplicationException;

/**
 * A service interface.
 * 
 * @author rbutti
 */
public interface GoEuroLocationCSVService {

    /**
     * Concrete implementation should hold the logic to retrieve data from an
     * Location API and write it to CSV file
     * 
     * @param args
     *            - Commandline parameters passed by the user. Index 0 of the
     *            array contains the city name
     * @throws GoEuroApplicationException
     */
    public void processData(String[] args) throws GoEuroApplicationException;

    /**
     * Concrete implementation should hold the logic to validate if the user has
     * passed the require input data as command line arguments
     * 
     * @param args
     *            - Commandline parameters passed by the user. Index 0 of the
     *            array contains the city name
     * @throws GoEuroApplicationException
     */
    public void validateInput(String[] args);

}
