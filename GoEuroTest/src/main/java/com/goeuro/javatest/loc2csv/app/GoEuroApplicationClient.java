package com.goeuro.javatest.loc2csv.app;

import java.util.Date;

import org.apache.log4j.Logger;

import com.goeuro.javatest.loc2csv.exception.GoEuroApplicationException;
import com.goeuro.javatest.loc2csv.service.GoEuroLocationCSVService;
import com.goeuro.javatest.loc2csv.service.impl.GoEuroLocationCSVServiceImpl;

/**
 * Main class for the GoEuro's Java Developer Test. This class validates that
 * the user has passed the required city name as argument to the application and
 * also retrieves the corresponding city details for Location API and inserts
 * the results to a CSV file
 * 
 * @author rbutti
 */
public class GoEuroApplicationClient {

    private final static Logger logger = Logger.getLogger(GoEuroApplicationClient.class);

    private static GoEuroLocationCSVService goEuroLocationCSVService;

    /**
     * Main method for the application.
     * 
     * @param args
     *            - Commandline parameters passed by the user. Index 0 of the
     *            array contains the city name
     * @throws GoEuroApplicationException
     */
    public static void main(String[] args) throws GoEuroApplicationException {

	logger.debug("main() | Application started | Start time " + new Date());

	goEuroLocationCSVService = new GoEuroLocationCSVServiceImpl();

	// validate the input
	goEuroLocationCSVService.validateInput(args);

	// process the input
	goEuroLocationCSVService.processData(args);

	logger.debug("main() | Application Stopped | End time " + new Date());
    }
}
