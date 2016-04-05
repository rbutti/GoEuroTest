package com.goeuro.javatest.loc2csv.facadeImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.beanio.BeanIOConfigurationException;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import com.goeuro.javatest.loc2csv.constant.GoEuroApplicationConstant;
import com.goeuro.javatest.loc2csv.domain.City;
import com.goeuro.javatest.loc2csv.exception.GoEuroApplicationException;
import com.goeuro.javatest.loc2csv.facade.GoEuroFileFacade;
import com.goeuro.javatest.loc2csv.util.GoEuroApplicationUtil;

/**
 * A Facade Implementation of the GoEuroFileFacade interface. This class has
 * necessary logic for writing the data to a file using BeanIO framework
 * 
 * @author rbutti
 */
public class GoEuroFileFacadeImpl implements GoEuroFileFacade {

    private final static Logger logger = Logger.getLogger(GoEuroFileFacadeImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.goeuro.javatest.loc2csv.facade.GoEuroFileFacade#writeCityDetailsToFile
     * (java.util.List, java.lang.String, java.lang.String)
     */
    public void writeCityDetailsToFile(List<City> cityDetails, String cityName, String outputDir) throws GoEuroApplicationException {

	logger.debug("writeCityDetailsToFile() | Writing City Details to File Started | cityName : " + cityName + " No of Records : "
		+ cityDetails.size());
	BeanWriter writer = null;

	try {
	    // filePath where the file has to created
	    String filePath = GoEuroApplicationUtil.getAbsoluteFilePath(cityName, outputDir);

	    // Initialize the BeanIO reader
	    StreamFactory factory = StreamFactory.newInstance();
	    factory.load(this.getClass().getClassLoader().getResourceAsStream(GoEuroApplicationConstant.CITY_BEANIO_MAPPING_XML));
	    writer = factory.createWriter("city", new File(filePath));

	    // Write data to the file
	    for (City city : cityDetails) {
		writer.write(city);
	    }

	    logger.info("writeCityDetailsToFile() | Writing City Details SUCCESSFUL | cityName : " + cityName + " No of Records : "
		    + cityDetails.size() + " Output file path  :" + filePath + " Records :" + cityDetails);

	} catch (BeanIOConfigurationException e) {
	    logger.error(" writeCityDetailsToFile() | CRITICAL ERROR : BeanIO couldnt be Initialized", e);
	    throw new GoEuroApplicationException(e, "CRITICAL ERROR : BeanIO couldnt be Initialized");
	} catch (IOException e) {
	    logger.error(" writeCityDetailsToFile() | CRITICAL ERROR : Error while opening the output file for write operation", e);
	    throw new GoEuroApplicationException(e, "CRITICAL ERROR : Error while opening the output file for write operation");
	} finally {

	    // close the resources
	    if (writer != null) {
		writer.close();
	    }
	}
	logger.debug("writeCityDetailsToFile() | Writing City Details to File Ended | cityName : " + cityName + " No of Records : "
		+ cityDetails.size());
    }

}
