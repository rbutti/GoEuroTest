package com.goeuro.javatest.loc2csv.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.goeuro.javatest.loc2csv.constant.GoEuroApplicationConstant;
import com.goeuro.javatest.loc2csv.domain.City;
import com.goeuro.javatest.loc2csv.exception.GoEuroApplicationException;
import com.goeuro.javatest.loc2csv.facade.GoEuroFacadeFactory;
import com.goeuro.javatest.loc2csv.facade.GoEuroFileFacade;
import com.goeuro.javatest.loc2csv.facade.GoEuroLocationAPIFacade;
import com.goeuro.javatest.loc2csv.service.GoEuroLocationCSVService;

/**
 * A concrete implementation class of GoEuroLocationCSVService.This class holds
 * the business logic to retrieve city details from Location API for a given
 * city name and also to write the results to an CSV file
 * 
 * @author rbutti
 * 
 */
public class GoEuroLocationCSVServiceImpl implements GoEuroLocationCSVService {

    private static Properties properties = new Properties();
    private final static Logger logger = Logger.getLogger(GoEuroLocationCSVServiceImpl.class);

    private GoEuroFileFacade goEuroFileFacade;
    private GoEuroLocationAPIFacade goEuroLocationAPIFacade;

    static {
	try {
	    logger.debug("Resource Initialization Started ");

	    // load Properties from properties file
	    properties.load(GoEuroLocationCSVServiceImpl.class.getClassLoader().getResourceAsStream(
		    GoEuroApplicationConstant.GOEURO_APPLICATION_LOC2CSV_PROPERTIES));

	    // Initialize the facade factory
	    GoEuroFacadeFactory.initialize();
	} catch (FileNotFoundException e) {
	    logger.error(" FileNotFoundException Occured while initializing the Properties", e);
	    throw new ExceptionInInitializerError(e);
	} catch (IOException e) {
	    logger.error(" IOException Occured while initializing the Properties", e);
	    throw new ExceptionInInitializerError(e);
	}
	logger.debug("Resource Initialization Ended ");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.goeuro.javatest.loc2csv.service.GoEuroLocationCSVService#processData
     * (java.lang.String[])
     */
    public void processData(String[] inputData) throws GoEuroApplicationException {

	// Initialize the Facade classes
	goEuroFileFacade = (GoEuroFileFacade) GoEuroFacadeFactory.getFacade(GoEuroFileFacade.class);
	goEuroLocationAPIFacade = (GoEuroLocationAPIFacade) GoEuroFacadeFactory.getFacade(GoEuroLocationAPIFacade.class);

	// retrieve city name
	String cityName = inputData[0];

	logger.debug("processData() | Processing data Started | cityName : " + cityName);

	// Step 1: use GoEuroLocationAPIFacade to retrieve the city details from
	// Location API
	logger.debug("processData() | Retriving city details Started | cityName : " + cityName);
	List<City> cityDetails = goEuroLocationAPIFacade.retriveCityDetails(cityName, properties
		.getProperty(GoEuroApplicationConstant.GOEURO_LOCATION_API_URL));
	logger.debug("processData() | Retriving city details Ended | cityName : " + cityName + " No of Records : " + cityDetails.size());

	// Step 2: use GoEuroFileFacade to write the data to an csv file using
	// BeanIO framework
	logger.debug("processData() | Writing records to file Started | cityName : " + cityName);
	goEuroFileFacade.writeCityDetailsToFile(cityDetails, cityName, properties.getProperty(GoEuroApplicationConstant.GOEURO_CSV_OUTPUT_DIRECTORY));
	logger.debug("processData() |  Writing records to file Ended | cityName : " + cityName);

	logger.debug("processData() | Processing data Ended | cityName : " + cityName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.goeuro.javatest.loc2csv.service.GoEuroLocationCSVService#validateInput
     * (java.lang.String[])
     */
    public void validateInput(String[] inputData) {

	// If the inputData is null or the user has not entered city name then
	// throw an error and stop further execution
	logger.debug("validateInput() | Validating input Started | Input Data : " + inputData);
	if (inputData == null || inputData.length != 1) {
	    logger.error("validateInput() | CRITICAL ERROR : Expected CITY Name as input argument. \nUSAGE : java -jar GoEuroTest.jar \"CITY_NAME\"");
	    throw new IllegalArgumentException(
		    "CRITICAL ERROR : Expected CITY Name as input argument. \nUSAGE : java -jar GoEuroTest.jar \"CITY_NAME\"");
	}

	logger.debug("validateInput() | Validating input Ended | Input Data : " + inputData);
    }
}
