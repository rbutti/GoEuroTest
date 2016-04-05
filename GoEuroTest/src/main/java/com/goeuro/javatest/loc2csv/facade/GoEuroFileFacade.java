package com.goeuro.javatest.loc2csv.facade;

import java.util.List;

import com.goeuro.javatest.loc2csv.domain.City;
import com.goeuro.javatest.loc2csv.exception.GoEuroApplicationException;

/**
 * A facade interface for writing the data to a file using BeanIO framework
 * 
 * @author rbutti
 */
public interface GoEuroFileFacade {

    /**
     * A concrete implementation of this class should have the required logic to
     * initialize the BeanIO writer using the mapping file and write the
     * cityDetails to the file
     * 
     * @param cityDetails
     *            - City details retrieved from location API
     * @param cityName
     *            - City name passed as commandline argument by the user
     * @param outputDir
     *            - Output dir where the file need to be created
     * @throws GoEuroApplicationException
     */
    public void writeCityDetailsToFile(List<City> cityDetails, String cityName, String outputDir) throws GoEuroApplicationException;
}
