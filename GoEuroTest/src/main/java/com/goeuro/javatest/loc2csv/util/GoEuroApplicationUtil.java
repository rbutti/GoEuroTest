package com.goeuro.javatest.loc2csv.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;

/**
 * GoEuro Application Utility class
 * 
 * @author rbutti
 */
public class GoEuroApplicationUtil {

    private final static Logger logger = Logger.getLogger(GoEuroApplicationUtil.class);

    /**
     * Private constructor
     */
    private GoEuroApplicationUtil() {
	super();
    }

    /**
     * Construct an Location API URI object for given URI string and cityName
     * 
     * @param uri
     *            - URI of the location API
     * @param cityName
     *            - City name entered as command line argument by the user
     * @return Location API URI
     * @throws URISyntaxException
     */
    public static URI constructLocationAPIURI(String uri, String cityName) throws URISyntaxException {

	logger.debug("constructLocationAPIURI() | Location API URI construction");
	return new URI(uri + cityName);
    }

    /**
     * 
     * Construct the filePath by appending directory path with the file name.
     * The file name will the cityName
     * 
     * @param cityName
     *            - City name entered as command line argument by the user
     * @param outputDir
     *            - Output directory where the file has to be created
     * @return - Absolute File Path
     */
    public static String getAbsoluteFilePath(String cityName, String outputDir) {

	logger.debug("getAbsoluteFilePath() | creating absolute path for output file");
	return outputDir + "\\" + cityName + ".csv";
    }
}
