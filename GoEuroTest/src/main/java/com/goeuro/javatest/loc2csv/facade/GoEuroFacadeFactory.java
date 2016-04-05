package com.goeuro.javatest.loc2csv.facade;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.goeuro.javatest.loc2csv.facadeImpl.GoEuroFileFacadeImpl;
import com.goeuro.javatest.loc2csv.facadeImpl.GoEuroLocationAPIFacadeImpl;

/**
 * Factory pattern implementation for Facade classes
 * 
 * @author rbutti
 */
public class GoEuroFacadeFactory {

    private static GoEuroFacadeFactory factory = new GoEuroFacadeFactory();
    private static Map<Object, Object> facades = new HashMap<Object, Object>();
    private final static Logger logger = Logger.getLogger(GoEuroFacadeFactory.class);

    /**
     * private constructore
     */
    private GoEuroFacadeFactory() {
	super();
    }

    /**
     * @return singleton instance of the facade class
     */
    public static GoEuroFacadeFactory getInstance() {
	return factory;
    }

    /**
     * Initialize the FacadeFactory and register the inital facade classes
     */
    public static void initialize() {

	logger.debug("initialize() | GoEuroFacadeFactory Initialization Started");
	// Registering Facade to write data to a File
	facades.put(GoEuroFileFacade.class, new GoEuroFileFacadeImpl());

	// Registering Facade to retrieve data from a Location API using
	// Spring's RestTemplate
	facades.put(GoEuroLocationAPIFacade.class, new GoEuroLocationAPIFacadeImpl());

	logger.debug("initialize() | GoEuroFacadeFactory Initialization Started");
    }

    /**
     * Method to retrieve the registered facade for a give key
     * 
     * @param key
     *            - Key to retrieve the facade Impl
     * @return An Facade Implementation Object
     */
    public static Object getFacade(Object key) {

	logger.debug("getFacade() | Retriving Facade for key :" + key);
	return facades.get(key);
    }

    /**
     * Method to register a Facade for a given key
     * 
     * @param key
     * @param facade
     *            - Facade Implementation object
     */
    public static void registerFacade(Object key, Object facade) {

	logger.debug("getFacade() | Registering Facade for key :" + key + " value :" + facade);
	facades.put(key, facade);
    }
}
